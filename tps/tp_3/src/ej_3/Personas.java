package ej_3;

import java.util.ArrayList;
import java.util.Iterator;

import previous.Persona;

public class Personas implements Iterable<Persona> {

	private ArrayList<Persona> personas;

	public Personas() {
		this.personas = new ArrayList<Persona>();
	}

	public int size() {
		return this.personas.size();
	}

	public void add(Persona persona) {
		this.personas.add(persona);
	}

	public Persona get(int index) {
		return this.personas.get(index);
	}

	@Override
	public Iterator<Persona> iterator() {
		return this.personas.iterator();
	}

	@Override
	public String toString() {
		String message = "";
		for (Persona persona : this.personas) {
			message += persona.toString() + "\n";
		}

		return message;
	}

	public String toEnumeratedString() {
		int index = 0;
		String message = "";
		for (Persona persona : this.personas) {
			message += index++ + ". " + persona.toString() + "\n";
		}

		return message;
	}
}
