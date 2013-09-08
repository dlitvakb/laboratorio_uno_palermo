package ej_1;

public class Auto {
	private String patente;

	public Auto(String patente) {
		this.setPatente(patente);
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String toString() {
		return this.getPatente();
	}

	public String abrirPuerta() {
		return this.realizarAccion("abri—", "la puerta");
	}

	public String cerrarPuerta() {
		return this.realizarAccion("cerr—", "la puerta");
	}

	public String encenderMotor() {
		return this.realizarAccion("encendi—", "el motor");
	}

	protected String realizarAccion(String accion, String parte) {
		return "Se " + accion + " " + parte + " del auto " + this.getPatente();
	}

	public String apagarMotor() {
		return this.realizarAccion("apag—", "el motor");
	}
}
