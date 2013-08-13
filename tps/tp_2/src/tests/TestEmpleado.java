package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ej_2.Empleado;

public class TestEmpleado {

	@Test
	public void test() {
		assertEquals(
				"Jose Lalo, DNI: 43212312, Legajo: L123, tiene 2.0 dias de vacaciones y gana $4000.0",
				new Empleado("Jose Lalo", 43212312, "L123", 4000, 12)
						.toString());
	}
}
