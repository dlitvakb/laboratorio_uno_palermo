package ej_1;

public class Rueda {
	private float radio;
	private String color;
	private Material material;

	public Rueda(float radio, String color, Material material) {
		this.setRadio(radio);
		this.setColor(color);
		this.setMaterial(material);
	}

	public Material getMaterial() {
		return this.material;
	}

	public String getColor() {
		return this.color;
	}

	public float getRadio() {
		return this.radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
