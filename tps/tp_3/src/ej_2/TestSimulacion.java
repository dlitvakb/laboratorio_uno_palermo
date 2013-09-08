package ej_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ej_1.Auto;
import ej_1.Empleado;

public class TestSimulacion {

	@Test
	public void test() {
		Empleado empleado = new Empleado("Jose");
		Auto auto = new Auto("AAA 123");

		empleado.setAuto(auto);

		assertEquals("Jose sale del trabajo", empleado.salirTrabajo());
		assertEquals("Jose camina hasta el auto AAA 123",
				empleado.caminarHasta("el auto " + empleado.getAuto()));

		assertEquals("Se abri— la puerta del auto AAA 123",
				empleado.abrirPuerta());

		assertEquals("Jose se subio al auto AAA 123", empleado.subirAuto());

		assertEquals("Se cerr— la puerta del auto AAA 123",
				empleado.cerrarPuerta());
		assertEquals("Se encendi— el motor del auto AAA 123",
				empleado.encenderMotor());

		assertEquals("Jose manej— hasta su casa",
				empleado.manejarHasta("su casa"));

		assertEquals("Se apag— el motor del auto AAA 123",
				empleado.apagarMotor());
		assertEquals("Se abri— la puerta del auto AAA 123",
				empleado.abrirPuerta());

		assertEquals("Jose se baj— del auto AAA 123", empleado.bajarAuto());

		assertEquals("Se cerr— la puerta del auto AAA 123",
				empleado.cerrarPuerta());

		assertEquals("Jose se fue a su casa a descansar", empleado.descansar());
	}
}
