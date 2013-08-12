package ej_4;

import ej_2.CajaVelocidades;
import ej_3.Motor;

public class Auto {
	private Motor motor;
	private CajaVelocidades cajaVelocidades;
	private int cantidadPuertas;
	private boolean tieneAireAcondicionado;

	public Auto(Motor motor, CajaVelocidades cajaVelocidades,
			int cantidadPuertas, boolean tieneAireAcondicionado) {
		this.setMotor(motor);
		this.setCajaVelocidades(cajaVelocidades);
		this.setCantidadPuertas(cantidadPuertas);
		this.setTieneAireAcondicionado(tieneAireAcondicionado);

	}

	public Motor getMotor() {
		return this.motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public CajaVelocidades getCajaVelocidades() {
		return this.cajaVelocidades;
	}

	public void setCajaVelocidades(CajaVelocidades cajaVelocidades) {
		this.cajaVelocidades = cajaVelocidades;
	}

	public int getCantidadPuertas() {
		return this.cantidadPuertas;
	}

	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public boolean isTieneAireAcondicionado() {
		return this.tieneAireAcondicionado;
	}

	public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

	@Override
	public String toString() {
		return "Este auto tiene un " + this.motor.toString() + ", una "
				+ this.cajaVelocidades.toString() + ", tiene "
				+ this.getCantidadPuertas() + " puertas y "
				+ (this.isTieneAireAcondicionado() ? "" : "no ")
				+ "tiene aire acondicionado";
	}
}
