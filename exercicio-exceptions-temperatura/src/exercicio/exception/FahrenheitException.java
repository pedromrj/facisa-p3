package exercicio.exception;

public class FahrenheitException extends TemperatureException {
	private static final long serialVersionUID = 1L;
	
	public FahrenheitException() {
		super("Erro: Valor Abaixo de Zero Absoluto!!");
	}

}
