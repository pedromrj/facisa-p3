package br.com.unifacisa.p3.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.unifacisa.p3.ArrayList;

class ArrayListTest {

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
	void testAdd() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Test 1");
		lista.add("Test 2");
		lista.add("Test 3");
		lista.add("Test 4");
		Assert.assertTrue(lista.get(0).equals("Test 1"));
		Assert.assertTrue(lista.get(3).equals("Test 4"));
	}

	@Test
	void testAdicionarValorNull() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(NullPointerException.class, () -> {
			lista.add(null);
		});
	}

	@Test
	void testContagemDeTamanho() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}
		assertEquals(100, lista.size());
	}

	@Test
	void testAumentoArray() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			lista.add("Test " + i);
		}
		assertEquals("Test 30", lista.get(30));
	}

	@Test
	void testAddPorIndex() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			lista.add("Test " + i);
		}

		lista.set(25, "Test 51");
		assertTrue(lista.get(25).equals("Test 51"));
	}

	@Test
	void testAddPorIndexNull() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(NullPointerException.class, () -> {
			lista.set(0, null);
		});
	}

	@Test
	void testAddIndexMaiorTamanho() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.set(10, "Test 1");
		});
	}

	@Test
	void testRemoverObj() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		lista.remover("Test 20");

		assertTrue(lista.get(20).equals("Test 21"));

	}

	@Test
	void testDiminuirTamanho() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		lista.remover("Test 2");

		assertEquals(9, lista.size());
	}

	@Test
	void testRemoverNull() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		assertThrows(NullPointerException.class, () -> {
			lista.remover(null);
		});
	}

	@Test
	void testValorIndexNegativo() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.get(-3);
		});

	}

	@Test
	void testValorNegativoIndex() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.set(-4, "Test 1");
		});
	}

	@Test
	void testEstaVazia() {
		ArrayList<String> lista = new ArrayList<String>();

		assertTrue(lista.isEmpty());
	}

	@Test
	void testPossuiAlgumaCoisa() {
		ArrayList<String> lista = new ArrayList<String>();

		lista.add("Test 1");
		assertFalse(lista.isEmpty());
	}

	@Test
	void testRemoverPorIndex() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Test 1");

		assertEquals(1, lista.size());

		lista.remover(0);

		assertEquals(0, lista.size());
	}

	@Test
	void testRemoverPorIndexMaior() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.remover(7);
		});

	}

	@Test
	void testRemoverPorIndexNegativo() {
		ArrayList<String> lista = new ArrayList<String>();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.remover(-7);
		});

	}

	@Test
	void testContemArray() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		assertTrue(lista.contains("Test 15"));
	}

	@Test
	void testContemNull() {
		ArrayList<String> lista = new ArrayList<String>();
		assertThrows(NullPointerException.class, () -> {
			lista.contains(null);
		});
	}

	@Test
	void testIndexOf() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 1");
		assertEquals(1, index);
	}

	@Test
	void testIndexOfFail() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 12");
		assertEquals(-1, index);
	}

	@Test
	void testIndexOfObjNull() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 1");
		assertEquals(1, index);
	}

	@Test
	void testAddAll() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		ArrayList<String> aux = new ArrayList<String>();

		for (int i = 10; i < 15; i++) {
			aux.add("Test " + i);
		}

		lista.addAll(aux);

		assertEquals(15, lista.size());

	}
	
	@Test
	void testAddAllNull() {
		ArrayList<String> lista = new ArrayList<String>();
		
		assertThrows(NullPointerException.class , () -> {
			lista.addAll(null);
		});
	}
	
	@Test
	void testExcluirTodoArray() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		assertEquals(10, lista.size());
		
		lista.clear();
		
		assertEquals(0, lista.size());
		
	}
	
	@Test
	void testClone() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			lista.add("Test " + i);
		}
		boolean dif = false;
		ArrayList<String> aux = lista.clone();
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(aux.get(i))) {
				dif = true;
			} else {
				dif = false;
				break;
			}
		}
		
		assertTrue(dif);
		
	}
	
	@Test
	void testUltimaOcorrenciaArray() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertEquals(10, lista.lastIndexOf("Test 8"));
		
	}
	
	@Test
	void testUltimaOcorrenciaArrayNull() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertThrows(NullPointerException.class , () -> {
			lista.lastIndexOf(null);
		});
		
	}
	
	@Test
	void testUltimaOcorrenciaNãoExiste() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertEquals(-1, lista.lastIndexOf("Test 10"));
		
	}
	
	@Test
	void testTextArray() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		assertTrue(lista.toString().equals("[Test 0, Test 1, Test 2, Test 3, Test 4, Test 5, Test 6, Test 7, Test 8, Test 9]"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testSemTipo() {
		@SuppressWarnings("rawtypes")
		ArrayList lista = new ArrayList();
		lista.add("Test 1");
		lista.add(1);
		
		assertEquals(2, lista.size());
		
		lista.add(1.5);
		
		assertEquals(1.5, lista.get(2));
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testContainsDifTipo() {
		@SuppressWarnings("rawtypes")
		ArrayList lista = new ArrayList();
		
		lista.add("Test 1");
		lista.add(1);
		assertEquals(1, lista.get(1));
		
		lista.add(1.5);
		
		assertTrue(lista.contains(1.5));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testAddPorIndexDifTipo() {
		@SuppressWarnings("rawtypes")
		ArrayList lista = new ArrayList();
		
		lista.add("Test 1");
		lista.add(1);
		assertEquals(1, lista.get(1));
		
		lista.add(1.5);
		
		lista.set(1, 2);
		
		assertEquals(2, lista.get(1));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testRemoveObjDifTipo() {
		@SuppressWarnings("rawtypes")
		ArrayList lista = new ArrayList();
		
		lista.add("Test 1");
		lista.add(1);
		assertEquals(1, lista.get(1));
		
		lista.add(1.5);
		
		lista.remover("Test 1");
		
		assertEquals(2, lista.size());
		
		assertEquals(1, lista.get(0));
	}
	
	@Test
	void testObterValorIndexNegativo() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test" + i);
		}
		
		assertThrows(ArrayIndexOutOfBoundsException.class , () -> {
			lista.get(-1);
		});
	}
	
	@Test
	void testObterValorPorIndex() {
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		assertTrue("Test 1".equals(lista.get(1)));
	}
	
}
