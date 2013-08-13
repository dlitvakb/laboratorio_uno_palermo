package ej_3;

import ej_1.Persona;

public class Ejecutivo extends Persona {

	private static final double DIAS_DE_VACACIONES_POR_DIA_LABORAL = 1.5;
	private static final double DIAS_LABORALES_CONTABILIZABLES_PARA_VACACIONES = 6.0;
	private static final double HORAS_DIA = 24.0;
	private int edad;
	private int horasTrabajo;

	public Ejecutivo(String nombre, long dni, int edad, int horasTrabajo) {
		super(nombre, dni);
		this.setEdad(edad);
		this.setHorasTrabajo(horasTrabajo);
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getHorasTrabajo() {
		return this.horasTrabajo;
	}

	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public void disminuirHorasDeTrabajo(int cantidad) {
		this.setHorasTrabajo(this.getHorasTrabajo() - cantidad);
	}

	public double calcularVacaciones() {
		return this.getHorasTrabajo() / HORAS_DIA
				/ DIAS_LABORALES_CONTABILIZABLES_PARA_VACACIONES
				* DIAS_DE_VACACIONES_POR_DIA_LABORAL;
	}

	@Override
	public String toString() {
		return super.toString() + " de " + this.getEdad()
				+ " a–os de edad, tiene " + this.calcularVacaciones()
				+ " dias de vacaciones";
	}
}
