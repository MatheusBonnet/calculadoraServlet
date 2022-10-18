package classes;

public class CalculadoraService {
	
	private Integer NUMERO_MAXIMO = 10;

	public String multiplicar(Integer multiplicador) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("---------------------------------------");
		stringBuilder.append("Calculadora do Numero -> " + multiplicador );
		stringBuilder.append("\n");
		for(int i = 1; i <= this.NUMERO_MAXIMO; i++) {
			stringBuilder.append(multiplicador + " x " + i + " = " + i * multiplicador);
			stringBuilder.append("\n");
		}
		
		return  stringBuilder.toString();
		

	}

}
