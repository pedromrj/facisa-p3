package br.com.unifacisa.p3.arraylistObject;

import br.com.unifacisa.p3.arraylistObject.excecao.TypeException;

/**
 * implementação do ArrayList;
 * 
 * @author Pedro
 *
 */
public class ArrayList {

	private static final int TAMANHO_INICIAL = 3;

	private Object[] array = new Object[TAMANHO_INICIAL];
	private int tamanho = 0;

	/**
	 * Metodo usado para aumentar o tamanho do array;
	 * 
	 * @return void
	 */
	private void aumentarTamanho() {
		Object[] aux = new Object[TAMANHO_INICIAL + array.length];
		for (int i = 0; i < tamanho; i++) {
			aux[i] = array[i];
		}
		array = aux;
	}

	/**
	 * Usado para adicionar objetos no array;
	 * 
	 * @param obj<T>
	 * 
	 * @return void
	 */
	public void add(Object obj) {
		if (tamanho == array.length) {
			aumentarTamanho();
		}
		if (validType(obj)) {
			if (obj != null) {
				array[tamanho] = obj;
				tamanho++;
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new TypeException();
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
	public void set(int index, Object obj) {
		if (index > tamanho) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (obj == null) {
			throw new NullPointerException();
		}

		if (validType(obj)) {
			if (tamanho == array.length) {
				aumentarTamanho();
			}
			for (int i = tamanho - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = obj;
			tamanho++;
		} else {
			throw new TypeException();
		}
	}

	/**
	 * Remove o objeto o indice desejado;
	 * 
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
	 * Remover objeto apartir de um objeto igual, Necessario implementar metodo
	 * Equals;
	 * 
	 * @return void;
	 * @param Objeto
	 */
	public void remover(Object obj) {

		if (obj == null) {
			throw new NullPointerException();
		}

		if (validType(obj)) {
			for (int i = 0; i < tamanho; i++) {
				if (array[i].equals(obj)) {
					array[i] = null;
					for (int j = i; j < tamanho - 1; j++) {
						array[j] = array[j + 1];
					}
				}
			}
			tamanho--;
		} else {
			throw new TypeException();
		}
	}

	/**
	 * Metodo usado para obter o valor do indice;
	 * 
	 * @param index
	 * @return Objeto
	 */
	public Object get(int index) {
		if (index > tamanho) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array[index];
	}

	/**
	 * Metodo para verificar a tipagem do object
	 * 
	 * @param obj
	 * @return
	 */
	private boolean validType(Object obj) {
		boolean valid = false;
		if (tamanho == 0) {
			valid = true;
		}
		if (tamanho > 0) {
			if (obj.getClass().getName().equals(array[tamanho - 1].getClass().getName())) {
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * Metodo usado para saber qual o tamanho do array;
	 * 
	 * @return valor inteiro;
	 */
	public int size() {
		return this.tamanho;
	}

	/**
	 * Saber se o array esta vazio ou possui objetos
	 * 
	 * @return True -> vazio
	 */
	public boolean isEmpty() {
		return tamanho == 0;
	}

	/**
	 * Metodo usado para saber que o objeto existe no array. necessario
	 * implementação do equals;
	 * 
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
		if (obj == null) {
			throw new NullPointerException();
		}

		boolean contains = false;
		if (validType(obj)) {
			for (int i = 0; i < tamanho; i++) {
				if (obj.equals(array[i])) {
					contains = true;
				}
			}
		} else {
			throw new TypeException();
		}
		return contains;
	}

	/**
	 * Metodo usado pra saber qual o index do obj passado como argumento. necessario
	 * implementação do equals
	 * 
	 * @return
	 */
	public int indexOf(Object obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (validType(obj)) {
			int index = -1;
			for (int i = 0; i < array.length; i++) {
				if (obj.equals(array[i])) {
					index = i;
				}
			}
			return index;
		} else {
			throw new RuntimeException();
		}
	}

	/**
	 * Metodo usado retorna a ultima ocorrencia do ultimo objeto;
	 * 
	 * @return
	 */
	public int lastIndexOf(Object obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		int ultima = -1;
		if (validType(obj)) {
			for (int i = 0; i < tamanho; i++) {
				if (obj.equals(array[i])) {
					ultima = i;
				}
			}
		} else {
			throw new TypeException();
		}
		return ultima;
	}

}
