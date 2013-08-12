package ej_3;

public class Motor {
	private String marca;
	private int hp;
	private double cilindrada;

	public Motor(String marca, int hp, double cilindrada) {
		this.setMarca(marca);
		this.setHp(hp);
		this.setCilindrada(cilindrada);
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getCilindrada() {
		return this.cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Motor " + this.getMarca() + " " + this.getHp() + "hp de "
				+ this.getCilindrada();
	}
}
