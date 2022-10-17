package classes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CalculadoraService {
	
	private static final String PARAMETRO_OPERACAO = "operacao";

	public double adicionar(final double parcela1, final double parcela2) {
		return parcela1 + parcela2;
	}

	public double subtrair(final double minuendo, final double subtraendo) {
		return minuendo - subtraendo;
	}

	public double dividir(final double dividendo, final double divisor) {
		return dividendo / divisor;
	}

	public String multiplicar(final double multiplicador) {
		String result = null;
		for(int i = 1; i <= 10; i++) {
			Double resultado = i * multiplicador;
			result = i + " x " + multiplicador + " = " + resultado.toString();
		}
		
		return result;

	}
	
	public String getParametroOperacao(final HttpServletRequest req, final Map<String, String> erros) {
		String operacao = null;
		try {
		   operacao = req.getParameter(PARAMETRO_OPERACAO);
			
		} catch (IllegalArgumentException ex) {
			erros.put("Operação", "Operação inválida");
		}
		
		return operacao;
		
	}

}
