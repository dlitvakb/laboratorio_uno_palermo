package ej_1;

import previous.Persona;

public class Ejecutivo extends Persona implements ManejaVehiculo, Trabajador {

	public Ejecutivo(String nombre) {
		super(nombre);
	}

	private Auto auto;

	@Override
	public String salirTrabajo() {
		return this.getNombre() + " sale del trabajo";
	}

	@Override
	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	@Override
	public Auto getAuto() {
		return this.auto;
	}

	@Override
	public String subirAuto() {
		return this.getNombre() + " se subio al auto " + this.getAuto();
	}

	@Override
	public String bajarAuto() {
		return this.getNombre() + " se baj— del auto " + this.getAuto();
	}

	@Override
	public String manejarHasta(String hasta) {
		return this.getNombre() + " manej— hasta " + hasta;
	}

	@Override
	public String descansar() {
		return this.getNombre() + " se fue a su casa a descansar";

	}

	@Override
	public String abrirPuerta() {
		return this.getAuto().abrirPuerta();
	}

	@Override
	public String cerrarPuerta() {
		return this.getAuto().cerrarPuerta();
	}

	@Override
	public String encenderMotor() {
		return this.getAuto().encenderMotor();
	}

	@Override
	public String apagarMotor() {
		return this.getAuto().apagarMotor();
	}
}
