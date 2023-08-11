package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.AplMain;

public class AplMainTest {
	private static int contador = 0;

	@BeforeAll
	public static void saludoInicio() {
		System.out.println("Iniciando todas las pruebas unitarias...");
	}

	@AfterAll
	public static void saludoFinal() {
		System.out.println("Se han ejecutado " + contador + " tests...");
	}

	@BeforeEach
	public void saludoAntesDe() {
		System.out.println("Iniciando el test " + contador + "...");
	}

	@AfterEach
	public void saludoDespuesDe() {
		System.out.println("Finalizando el test " + (contador - 1) + "...");
	}

	@Test
	public void testeoSuma() {
		AplMain aplmain = new AplMain();
		int res = aplmain.suma(5, 4);
		contador++;
		assertEquals(9, res);
	}

	@Test
	public void testeoSumaErrada() {
		AplMain aplmain = new AplMain();
		int res = aplmain.suma(2, 12);
		contador++;
		assertEquals(13, res);

	}

}
