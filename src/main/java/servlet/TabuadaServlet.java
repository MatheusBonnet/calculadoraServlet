package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.CalculadoraService;

@WebServlet(name = "TabuadaServlet", urlPatterns = { "/tabuada" })
public class TabuadaServlet extends HttpServlet {


	private static final String PARAMETRO_NUM_1 = "num1";

	private static final long serialVersionUID = 1L;
	
	static CalculadoraService calculadoraService = new CalculadoraService();

	@Override
	public final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		processar(req, resp);
	}

	@Override
	public final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		processar(req, resp);
	}

	private void processar(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		Map<String, String> erros = new HashMap<String, String>();
		
		Double num1 = getParametroDouble(req, PARAMETRO_NUM_1, "Número 1", erros);
		String operacao = calculadoraService.getParametroOperacao(req, erros);
			
		if (erros.isEmpty()) {
			out.print(calculadoraService.multiplicar(num1));
			out.print("\n");
		} else {
			out.print(erros);
		}
		
	}

	private Double getParametroDouble(final HttpServletRequest req, final String nome, final String campo,
			final Map<String, String> erros) {
		String numStr = req.getParameter(nome);
		if (numStr == null || numStr.isEmpty()) {
			erros.put(campo, "Número requerido!");
			return null;
		}
		Double num = null;
		try {
			num = Double.parseDouble(numStr);
		} catch (NumberFormatException nfe) {
			erros.put(campo, "Número inválido!");
		}
		return num;
	}
	

}
