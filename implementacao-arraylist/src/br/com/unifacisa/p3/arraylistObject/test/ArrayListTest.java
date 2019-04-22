package br.com.unifacisa.p3.arraylistObject.test;

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

import br.com.unifacisa.p3.arraylistObject.ArrayList;
import br.com.unifacisa.p3.arraylistObject.excecao.TypeException;

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
		ArrayList lista = new ArrayList();
		lista.add("Test 1");
		lista.add("Test 2");
		lista.add("Test 3");
		lista.add("Test 4");
		Assert.assertTrue(lista.get(0).equals("Test 1"));
		Assert.assertTrue(lista.get(3).equals("Test 4"));
	}

	@Test
	void testAdicionarValorNull() {
		ArrayList lista = new ArrayList();

		assertThrows(NullPointerException.class, () -> {
			lista.add(null);
		});
	}

	@Test
	void testAdicionarTiposDiferentes() {
		ArrayList lista = new ArrayList();

		lista.add("Test 1");

		assertThrows(TypeException.class, () -> {
			lista.add(1);
		});

	}

	@Test
	void testAddPorIndex() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 50; i++) {
			lista.add("Test " + i);
		}

		lista.set(25, "Test 51");
		assertTrue(lista.get(25).equals("Test 51"));
	}

	@Test
	void testAddPorIndexNull() {
		ArrayList lista = new ArrayList();

		assertThrows(NullPointerException.class, () -> {
			lista.set(0, null);
		});
	}

	@Test
	void testAddIndexMaiorTamanho() {
		ArrayList lista = new ArrayList();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.set(10, "Test 1");
		});
	}

	@Test
	void testValorNegativoIndex() {
		ArrayList lista = new ArrayList();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.set(-4, "Test 1");
		});
	}

	@Test
	void testAddIndexTypeDif() {
		ArrayList lista = new ArrayList();

		lista.add("Test 1");
		assertThrows(TypeException.class, () -> {
			lista.set(1, 10);
		});
	}

	@Test
	void testAumentoArray() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 50; i++) {
			lista.add("Test " + i);
		}
		assertEquals("Test 30", lista.get(30));
	}

	@Test
	void testContagemDeTamanho() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}
		assertEquals(100, lista.size());
	}

	@Test
	void testContemArray() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		assertTrue(lista.contains("Test 15"));
	}

	@Test
	void testContemArrayTypeDif() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		assertThrows(TypeException.class, () -> {
			lista.contains(1);
		});
	}

	@Test
	void testContemNull() {
		ArrayList lista = new ArrayList();
		assertThrows(NullPointerException.class, () -> {
			lista.contains(null);
		});
	}

	@Test
	void testDiminuirTamanho() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		lista.remover("Test 2");

		assertEquals(9, lista.size());
	}

	@Test
	void testEstaVazia() {
		ArrayList lista = new ArrayList();

		assertTrue(lista.isEmpty());
	}

	@Test
	void testIndexOf() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 1");
		assertEquals(1, index);
	}

	@Test
	void testIndexOfFail() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 12");
		assertEquals(-1, index);
	}

	@Test
	void testIndexOfObjNull() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		int index = lista.indexOf("Test 1");
		assertEquals(1, index);
	}

	@Test
	void testPossuiAlgumaCoisa() {
		ArrayList lista = new ArrayList();

		lista.add("Test 1");
		assertFalse(lista.isEmpty());
	}

	@Test
	void testRemoverNull() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}

		assertThrows(NullPointerException.class, () -> {
			lista.remover(null);
		});
	}

	@Test
	void testRemoverObj() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		lista.remover("Test 20");

		assertTrue(lista.get(20).equals("Test 21"));

	}

	@Test
	void testRemoverObjTypeDif() {
		ArrayList lista = new ArrayList();
		for (int i = 0; i < 100; i++) {
			lista.add("Test " + i);
		}

		assertThrows(TypeException.class, () -> {
			lista.remover(1.5);
		});

	}
	
	@Test
	void testRemoverPorIndex() {
		ArrayList lista = new ArrayList();
		lista.add("Test 1");

		assertEquals(1, lista.size());

		lista.remover(0);

		assertEquals(0, lista.size());
	}
	
	@Test
	void testRemoverPorIndexMaior() {
		ArrayList lista = new ArrayList();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.remover(7);
		});

	}
	
	@Test
	void testRemoverPorIndexNegativo() {
		ArrayList lista = new ArrayList();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.remover(-7);
		});

	}
	
	@Test
	void testValorIndexNegativo() {
		ArrayList lista = new ArrayList();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			lista.get(-3);
		});

	}
	
	@Test
	void testUltimaOcorrenciaArray() {
		ArrayList lista = new ArrayList();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertEquals(10, lista.lastIndexOf("Test 8"));
		
	}
	
	@Test
	void testUltimaOcorrenciaArrayNull() {
		ArrayList lista = new ArrayList();
		
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
		ArrayList lista = new ArrayList();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertEquals(-1, lista.lastIndexOf("Test 10"));
		
	}
	
	@Test
	void testUltimaOcorrenciaNãoExisteTypeDif() {
		ArrayList lista = new ArrayList();
		
		for (int i = 0; i < 10; i++) {
			lista.add("Test " + i);
		}
		
		lista.add("Test " + 8);
		
		assertThrows(TypeException.class, () -> {
			lista.lastIndexOf(1);
		});
	}
	

}
