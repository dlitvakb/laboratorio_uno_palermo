package ej_4;

import javax.swing.JOptionPane;

import ej_1.Persona;
import ej_2.Empleado;
import ej_3.Ejecutivo;

public class Menu {
	public static void main(String[] args) {
		try {
			Personas personas = new Personas();
			boolean continuar = true;
			while (personas.size() < 10 && continuar) {
				int option = Integer
						.parseInt(jInput("Elegi una opcion:\n\t1. Crear Empleado\n\t2. Crear Ejecutivo\n\t3. Ver Listado\n\t4. Salir"));
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
					continuar = false;
					break;
				}
			}
		} catch (Exception e) {
			// No pasa naranja... cerraron una ventanita
		}
	}

	public static void listarPersonas(Personas personas) {
		JOptionPane.showMessageDialog(null, personas.toString());
	}

	public static String jInput(String displayText) {
		return JOptionPane.showInputDialog(displayText);
	}

	private static String getNombre() {
		return jInput("Ingrese el nombre");
	}

	private static long getDNI() {
		return Long.parseLong(jInput("Ingrese el DNI"));
	}

	private static Persona crearEjecutivo() {
		return new Ejecutivo(getNombre(), getDNI(), getEdad(),
				getHorasTrabajo());
	}

	private static int getHorasTrabajo() {
		return Integer
				.parseInt(jInput("Ingrese la cantidad de horas trabajadas"));
	}

	private static int getEdad() {
		return Integer.parseInt(jInput("Ingrese la edad"));
	}

	private static Persona crearEmpleado() {
		return new Empleado(getNombre(), getDNI(), getLegajo(), getSueldo(),
				getDiasTrabajados());
	}

	private static int getDiasTrabajados() {
		return Integer
				.parseInt(jInput("Ingrese la cantidad de dias trabajados"));

	}

	private static double getSueldo() {
		return Double.parseDouble(jInput("Ingrese el sueldo"));

	}

	private static String getLegajo() {
		return jInput("Ingrese el Legajo");
	}
}
