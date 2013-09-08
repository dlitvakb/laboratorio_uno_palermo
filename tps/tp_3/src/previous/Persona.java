package previous;

public abstract class Persona {
	private String nombre;

	public Persona(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String caminarHasta(String lugar) {
		return this.getNombre() + " camina hasta " + lugar;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
}
