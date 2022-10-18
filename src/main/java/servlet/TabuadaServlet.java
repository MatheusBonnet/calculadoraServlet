package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

	private void processar(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		if(req.getParameter(PARAMETRO_NUM_1) == null) {
			for(int i = 1; i <= 10; i++) {
				out.print(calculadoraService.multiplicar(i));
			}
		} else {
			String[] list = req.getParameter(PARAMETRO_NUM_1).split(";");
			for(String num : list) {
				out.print(calculadoraService.multiplicar(Integer.parseInt(num)));
			}
			
		}
		
	}
	

}
