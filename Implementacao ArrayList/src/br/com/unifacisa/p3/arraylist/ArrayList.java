package br.com.unifacisa.p3.arraylistGenerics;

import java.util.Arrays;

/**
 * Implementação da classe ArrayList
 * @author Pedro
 * @param <T>
 */
public class ArrayList<T> {
	/**
	 * Constante para definir o tamanho inicial do array;
	 */
	public static final int TAMANHO_INICIAL = 3;

	private T[] array;
	private int tamanho;

	/**
	 * Metodo construtor para instanciar um objeto;
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		array = (T[]) new Object[TAMANHO_INICIAL];
	}

	/**
	 * Metodo usado para saber qual o tamanho do array;
	 * @return valor inteiro;
	 */
	public int size() {
		return this.tamanho;
	}

	/**
	 * Metodo usado para aumentar o tamanho do array;
	 * @return void
	 */
	private void aumentarTamanho() {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[TAMANHO_INICIAL + array.length];
		for (int i = 0; i < tamanho; i++) {
			aux[i] = array[i];
		}
		array = aux;
	}
	
	/**
	 * Saber se o array esta vazio ou possui objetos
	 * @return True -> vazio
	 */
	public boolean isEmpty() {
		return tamanho == 0;
	}

	/**
	 * Usado para adicionar objetos no array;
	 * @param obj<T>
	 * 
	 * @return void
	 */
	public void add(T obj) {
		if (tamanho == array.length) {
			aumentarTamanho();
		}
		if (obj != null) {
			array[tamanho] = obj;
			tamanho++;
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Adiciona um objeto no index desejado;
	 * 
	 * @param index
	 * @param obj
	 * 
	 * @return void
	 */
	public void set(int index, T obj) {
		if (index > tamanho) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (obj == null) {
			throw new NullPointerException();
		}

		if (tamanho == array.length) {
			aumentarTamanho();
		}
		for (int i = tamanho - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = obj;
		tamanho++;

	}

	/**
	 * Remove o objeto o indice desejado;
	 * @param index
	 * 
	 * @return void
	 */
	public void remover(int index) {
		if (index > tamanho) {
			throw new ArrayIndexOutOfBoundsException();
		}
		array[index] = null;
		for (int i = index; i < tamanho; i++) {
			array[i] = array[i + 1];
		}
		tamanho--;
	}

	/**
	 * Remover objeto apartir de um objeto igual, Necessario implementar metodo Equals;
	 * @return void;
	 * @param Objeto
	 */
	public void remover(T obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < tamanho; i++) {
			if (array[i].equals(obj)) {
				array[i] = null;
				for (int j = i; j < tamanho - 1; j++) {
					array[j] = array[j + 1];
				}
			}
		}
		tamanho--;
	}

	/**
	 * Metodo usado para obter o valor do indice;
	 * @param index
	 * @return Objeto
	 */
	public T get(int index) {
		if (index > tamanho) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array[index];
	}

	/**
	 * toString em formato de textos;
	 */
	@Override
	public String toString() {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[tamanho];
		for (int i = 0; i < tamanho; i++) {
			aux[i] = array[i];
		}
		return Arrays.toString(aux);
	}
	
	/**
	 * Metodo usado para saber que o objeto existe no array. necessario implementação do equals;
	 * @param obj
	 * @return
	 */
	public boolean contains(T obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		
		boolean contains = false;
		for (int i = 0; i < tamanho; i++) {
			if(obj.equals(array[i])) {
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * Metodo usado pra saber qual o index do obj passado como argumento. necessario implementação do equals
	 * @return
	 */
	public int indexOf(T obj) {
		if(obj == null) {
			throw new NullPointerException();
		}
		
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (obj.equals(array[i])) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Metodo usado para adicionar uma lista de objetos a este array;
	 * @param array
	 */
	public void addAll(ArrayList<T> array) {
		if (array == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < array.size(); i++) {
			add(array.get(i));
		}
	}
	
	/**
	 * Metodo usado para apagar todo o array;
	 */
	public void clear() {
		for (int i = 0; i < tamanho; i++) {
			array[i] = null;
		}
		tamanho = 0;
	}
	
	/**
	 * Metodo usado para obter um copia do ArrayList;
	 * @return retorna um array com objeto do ArrayList;
	 */
	public ArrayList<T> clone() {
		ArrayList<T> aux = new ArrayList<T>();
		for (int i = 0; i < tamanho; i++) {
			aux.add(array[i]);;
		}
		return aux;
	}
	
	/**
	 * Metodo usado retorna a ultima ocorrencia do ultimo objeto;
	 * @return
	 */
	public int lastIndexOf(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		
		int ultima = -1;
		for (int i = 0; i < tamanho; i++) {
			if (t.equals(array[i])) {
				ultima = i;
			}
		}
		return ultima;
	}
	
}
