package exercicio.utils;

import exercicio.exception.FahrenheitException;

public class Utils {
	
	public static final double ZERO_ABSOLUTO = -459.67;
	
	/**
	 * @param valor a ser passado como argumento é em Fahrenheit;
	 * @return o valor de celsius;
	 * Se valor for abaixo de zero absoluto ira lançar esta exceção
	 * @throws FahrenheitException
	 */
	public static double toCelsius(double valor) throws FahrenheitException {
		if (valor < ZERO_ABSOLUTO) {
			throw new FahrenheitException();
		}
		return 5*(valor-32)/9;
	}

}
