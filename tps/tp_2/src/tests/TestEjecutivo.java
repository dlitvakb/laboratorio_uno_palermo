package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ej_3.Ejecutivo;

public class TestEjecutivo {

	@Test
	public void test() {
		assertEquals(
				"Roberto Perez, DNI: 54321 de 50 a–os de edad, tiene 6.0 dias de vacaciones",
				new Ejecutivo("Roberto Perez", 54321, 50, 576).toString());
	}

}
