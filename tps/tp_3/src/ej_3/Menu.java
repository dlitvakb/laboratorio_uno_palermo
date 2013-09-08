package ej_3;

import javax.swing.JOptionPane;

import previous.Persona;
import util.BufferedUIOutput;
import ej_1.Auto;
import ej_1.Ejecutivo;
import ej_1.Empleado;
import ej_1.ManejaVehiculo;
import ej_2.Simulador;

public class Menu {
	public static void main(String[] args) {
		try {
			Personas personas = new Personas();
			Autos autos = new Autos();
			boolean continuar = true;
			while (continuar) {
				try {
					int option = Integer
							.parseInt(jInput("Elegi una opcion:\n\t1. Crear Empleado\n\t2. Crear Ejecutivo\n\t3. Ver Listado\n\t4. Crear Auto\n\t5. Asignar Auto\n\t6. Simular\n\t99. Salir"));
					switch (option) {
					case 1:
						personas.add(crearEmpleado());
						break;
					case 2:
						personas.add(crearEjecutivo());
						break;
					case 3:
						listarPersonas(personas);
						break;
					case 4:
						autos.add(crearAuto(personas, autos));
						break;
					case 5:
						asignarAuto(personas, autos);
						break;
					case 6:
						simular(personas);
						break;
					case 99:
						continuar = false;
						break;
					}
				} catch (RuntimeException e) {
					jOutput(e.getMessage());
				}
			}
		} catch (Exception e) {
			// No pasa naranja... cerraron una ventanita
		}
	}

	private static void simular(Personas personas) {
		int personaASimular = Integer
				.parseInt(jInput(personas.toEnumeratedString()
						+ "\n\nIngrese el numero de persona con quien desea realizar la simulacion"));

		Persona persona = personas.get(personaASimular);
		ManejaVehiculo manejador = (ManejaVehiculo) persona;

		if (manejador.getAuto() == null) {
			throw new RuntimeException("Esta persona no posee auto");
		}

		Simulador.simular(new BufferedUIOutput(12), persona);
	}

	private static void asignarAuto(Personas personas, Autos autos) {
		int persona = Integer.parseInt(jInput(personas.toEnumeratedString()
				+ "\n\nIngrese el numero de persona"));
		int auto = Integer.parseInt(jInput(autos.toEnumeratedString()
				+ "\n\nIngrese el numero de auto"));

		((ManejaVehiculo) personas.get(persona)).setAuto(autos.get(auto));
	}

	private static Auto crearAuto(Personas personas, Autos autos) {
		if (personas.size() == autos.size()) {
			throw new RuntimeException("Ya cumple con el limite de autos");
		}
		return new Auto(getPatente());
	}

	private static String getPatente() {
		return jInput("Ingrese la patente");
	}

	private static Persona crearEjecutivo() {
		return new Ejecutivo(getNombre());
	}

	private static Persona crearEmpleado() {
		return new Empleado(getNombre());
	}

	private static String getNombre() {
		return jInput("Ingrese el nombre");
	}

	public static void listarPersonas(Personas personas) {
		jOutput(personas.toString());
	}

	public static void jOutput(String displayText) {
		JOptionPane.showMessageDialog(null, displayText);
	}

	public static String jInput(String displayText) {
		return JOptionPane.showInputDialog(displayText);
	}

}
