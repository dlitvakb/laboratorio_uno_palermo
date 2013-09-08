package ej_3;

import java.util.ArrayList;
import java.util.Iterator;

import ej_1.Auto;

public class Autos implements Iterable<Auto> {

	private ArrayList<Auto> autos = new ArrayList<Auto>();

	@Override
	public Iterator<Auto> iterator() {
		return this.autos.iterator();
	}

	public int size() {
		return this.autos.size();
	}

	public void add(Auto auto) {
		this.autos.add(auto);
	}

	public Auto get(int index) {
		return this.autos.get(index);
	}

	@Override
	public String toString() {
		String message = "";
		for (Auto auto : this.autos) {
			message += auto.toString() + "\n";
		}

		return message;
	}

	public String toEnumeratedString() {
		int index = 0;
		String message = "";
		for (Auto auto : this.autos) {
			message += index++ + ". " + auto.toString() + "\n";
		}

		return message;
	}
}
