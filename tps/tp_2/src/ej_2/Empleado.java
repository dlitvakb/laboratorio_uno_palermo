package ej_2;

import ej_1.Persona;

public class Empleado extends Persona {

	private static final double DIAS_LABORALES_CONTABILIZABLES_PARA_VACACIONES = 6.0;
	private String legajo;
	private double sueldo;
	private int diasTrabajados;

	public Empleado(String nombre, long dni, String legajo, double sueldo,
			int diasTrabajados) {
		super(nombre, dni);
		this.setDiasTrabajados(diasTrabajados);
		this.setLegajo(legajo);
		this.setSueldo(sueldo);
	}

	public String getLegajo() {
		return this.legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getDiasTrabajados() {
		return this.diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public void incrementarSueldo(double cantidad) {
		this.setSueldo(this.getSueldo() + cantidad);
	}

	public double calcularVacaciones() {
		return this.getDiasTrabajados()
				/ DIAS_LABORALES_CONTABILIZABLES_PARA_VACACIONES;
	}

	@Override
	public String toString() {
		return super.toString() + ", Legajo: " + this.getLegajo() + ", tiene "
				+ this.calcularVacaciones() + " dias de vacaciones y gana $"
				+ this.getSueldo();
	}
}
