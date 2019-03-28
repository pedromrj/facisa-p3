package exercicio.entidades;

import exercicio.exceptions.SaldoInsuficienteException;

public class ContaCorrente {

	private float limite;

	private float saldo;

	private float valorLimite;

	/**
	 * Construtor para instanciar o objetos com todos os atributos;
	 * 
	 * @param limite      disponivel na conta;
	 * @param saldo       disponivel na conta;
	 * @param valorLimite disponivel pelo banco;
	 */

	public ContaCorrente(float limite, float saldo, float valorLimite) {
		super();
		this.limite = limite;
		this.saldo = saldo;
		this.valorLimite = valorLimite;
	}

	/**
	 * Construtor para instanciar o objeto sem o atributo valorLimite;
	 * 
	 * @param limite disponivel na conta
	 * @param saldo  disponivel na conta
	 */
	public ContaCorrente(float limite, float saldo) {
		this.limite = limite;
		this.saldo = saldo;
	}

	/**
	 * Metodo para sacar dinheiro do usuario;
	 * 
	 * @param valor
	 * @throws Exception
	 * @throws SaldoInsuficienteException
	 */
	public void sacar(float valor) throws Exception, SaldoInsuficienteException {
		if (valor > saldo) {
			throw new SaldoInsuficienteException(saldo);
		}
		if (valor < 0) {
			throw new Exception("Este valor é negativo, impossivel realizar esta operação: " + valor);
		}
	}

	/**
	 * Metodo usado para atribuir valor a conta do usuario;
	 * 
	 * @param valor
	 * @throws Exception
	 */
	public void depositar(float valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Este valor é negativo, impossivel realizar esta operação: " + valor);
		}
		saldo += valor;
	}

	/**
	 * Metodo usado para ajustar o valor do atributo valorLimite;
	 * 
	 * @param valor
	 * @throws Exception
	 */
	public void setValorLimite(float valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Este valor é negativo, impossivel realizar esta operação: " + valor);
		}
		valorLimite = valor;
	}

	/**
	 * Metodo usado para acessar os atributos limite
	 * 
	 * @return o limite
	 */
	public float getLimite() {
		return limite;
	}

	/**
	 * Metodo usado para ajustar os atributos limite
	 * 
	 * @param limite ajuda o valor no limite
	 */
	public void setLimite(float limite) {
		this.limite = limite;
	}

	/**
	 * Metodo usado para acessar os atributos saldo
	 * 
	 * @return o saldo
	 */
	public float getSaldo() {
		return saldo;
	}

	/**
	 * Metodo usado para ajustar os atributos saldo
	 * 
	 * @param saldo ajuda o valor no saldo
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	/**
	 * Metodo usado para acessar os atributos valorLimite
	 * 
	 * @return o valorLimite
	 */
	public float getValorLimite() {
		return valorLimite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContaCorrente [limite=" + limite + ", saldo=" + saldo + ", valorLimite=" + valorLimite + "]";
	}

}
