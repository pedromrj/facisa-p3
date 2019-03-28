package exercicio.teste;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio.exception.FahrenheitException;
import exercicio.utils.Utils;

class UtilsTest {

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
	void valorFahrenheitNegativo() {
		Assertions.assertThrows(FahrenheitException.class, () -> {
			Utils.toCelsius(-500.00);
		});
	}
	
	@Test
	void valorCelsius() throws FahrenheitException {
		double temp = Utils.toCelsius(41);
		Assertions.assertEquals(5, temp);
	}

}
