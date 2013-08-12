package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ej_2.CajaVelocidades;
import ej_2.TipoRelacion;
import ej_3.Motor;
import ej_4.Auto;

public class TestAuto {

	@Test
	public void test() {
		Auto auto_1 = new Auto(new Motor("Toyota", 4200, 1.6),
				new CajaVelocidades(5, new TipoRelacion()), 4, false);

		assertEquals(
				"Este auto tiene un Motor Toyota 4200hp de 1.6, una Caja de Velocidades de 5 marchas, tiene 4 puertas y no tiene aire acondicionado",
				auto_1.toString());

		Auto auto_2 = new Auto(new Motor("Ford", 3600, 1.4),
				new CajaVelocidades(4, new TipoRelacion()), 5, true);

		assertEquals(
				"Este auto tiene un Motor Ford 3600hp de 1.4, una Caja de Velocidades de 4 marchas, tiene 5 puertas y tiene aire acondicionado",
				auto_2.toString());
	}
}