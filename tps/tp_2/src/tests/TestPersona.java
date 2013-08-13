package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ej_1.Persona;

public class TestPersona {

	@Test
	public void test() {
		assertEquals("Pepe Zarasa, DNI: 12312312", new Persona("Pepe Zarasa",
				12312312).toString());
	}

}
