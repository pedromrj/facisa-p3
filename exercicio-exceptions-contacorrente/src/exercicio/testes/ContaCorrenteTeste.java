package exercicio.testes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio.entidades.ContaCorrente;
import exercicio.exceptions.SaldoInsuficienteException;

class ContaCorrenteTeste {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void valorNegativoSacar() {
		ContaCorrente conta = new ContaCorrente(1000, 500);

		Assertions.assertThrows(Exception.class, () -> {
			conta.sacar(-1);
		});
	}

	@Test
	void valorInsuficiente() {
		ContaCorrente conta = new ContaCorrente(1000, 500);

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			conta.sacar(600);
		});

	}

	@Test
	void depositarValorNegativo() {
		ContaCorrente conta = new ContaCorrente(1000, 500);

		Assertions.assertThrows(Exception.class, () -> {
			conta.depositar(-1);
		});
	}
	
	@Test
	void depositarValor() throws Exception {
		ContaCorrente conta = new ContaCorrente(1000, 500);
			conta.depositar(150);
		Assertions.assertEquals(650, conta.getSaldo());
	}
	
	@Test
	void ajustarValorLimiteNegativo() {
		ContaCorrente conta = new ContaCorrente(1000, 500);

		Assertions.assertThrows(Exception.class, () -> {
			conta.setValorLimite(-1);
		});
	}

}
