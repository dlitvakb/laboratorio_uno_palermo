package ej_2;

import previous.Persona;
import util.BufferedUIOutput;
import util.ConsoleOutput;
import util.OutputInterface;
import util.UIOutput;
import ej_1.Auto;
import ej_1.Empleado;
import ej_1.ManejaVehiculo;
import ej_1.Trabajador;

public class Simulador {
	public static void simular(OutputInterface out, Persona persona) {
		Trabajador trabajador = (Trabajador) persona;
		ManejaVehiculo manejador = (ManejaVehiculo) persona;

		out.writeLine(trabajador.salirTrabajo());
		out.writeLine(persona.caminarHasta("el auto " + manejador.getAuto()));
		out.writeLine(manejador.abrirPuerta());
		out.writeLine(manejador.subirAuto());
		out.writeLine(manejador.cerrarPuerta());
		out.writeLine(manejador.encenderMotor());
		out.writeLine(manejador.manejarHasta("su casa"));
		out.writeLine(manejador.apagarMotor());
		out.writeLine(manejador.abrirPuerta());
		out.writeLine(manejador.bajarAuto());
		out.writeLine(manejador.cerrarPuerta());
		out.writeLine(trabajador.descansar());
	}

	public static void main(String[] args) {
		Empleado empleado = new Empleado("Pepe");
		Auto auto = new Auto("ABC 456");

		empleado.setAuto(auto);

		// Por Consola
		OutputInterface out = new ConsoleOutput();
		simular(out, empleado);

		// Por UI - Unbuffered
		OutputInterface out_gui = new UIOutput();
		simular(out_gui, empleado);

		// Por UI - Buffered
		OutputInterface out_gui_buffered = new BufferedUIOutput(12);
		simular(out_gui_buffered, empleado);
	}
}
