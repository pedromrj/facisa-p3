package exercicio;


import exercicio.entidades.ContaCorrente;
import exercicio.exceptions.SaldoInsuficienteException;

public class Main {
	
	public static void main(String[] args) {
		
		ContaCorrente conta = new ContaCorrente(900,400);
		
		try {
			conta.depositar(100);
			
			conta.setValorLimite(1000);
			
			conta.sacar(1500);
			System.out.println(conta.getSaldo());
			
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
