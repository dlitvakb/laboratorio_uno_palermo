package ej_2;

public class CajaVelocidades {
	private int cantidadMarchas;
	private TipoRelacion tipoRelacion;

	public CajaVelocidades(int cantidadMarchas, TipoRelacion tipoRelacion) {
		this.setCantidadMarchas(cantidadMarchas);
		this.setTipoRelacion(tipoRelacion);
	}

	public TipoRelacion getTipoRelacion() {
		return this.tipoRelacion;
	}

	public void setTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public int getCantidadMarchas() {
		return this.cantidadMarchas;
	}

	public void setCantidadMarchas(int cantidadMarchas) {
		this.cantidadMarchas = cantidadMarchas;
	}

	@Override
	public String toString() {
		return "Caja de Velocidades de " + this.getCantidadMarchas()
				+ " marchas";
	}
}
