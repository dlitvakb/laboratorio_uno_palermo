package ej_1;

public class Persona {
	private String nombre;
	private long dni;

	public Persona(String nombre, long dni) {
		this.setNombre(nombre);
		this.setDni(dni);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return this.dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", DNI: " + this.getDni();
	}
}
