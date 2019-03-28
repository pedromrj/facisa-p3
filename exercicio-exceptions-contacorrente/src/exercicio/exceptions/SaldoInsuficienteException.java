package exercicio.exceptions;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException(float saldo) {
		super("Saldo insuficiente, vc possui " + saldo);
	}

	

}
