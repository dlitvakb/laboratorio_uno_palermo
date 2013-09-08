package ej_1;

public interface ManejaVehiculo {
	void setAuto(Auto auto);

	Auto getAuto();

	String subirAuto();

	String bajarAuto();

	String manejarHasta(String hasta);

	String abrirPuerta();

	String cerrarPuerta();

	String encenderMotor();

	String apagarMotor();
}
