package util;

import javax.swing.JOptionPane;

public class UIOutput implements OutputInterface {

	private String text;

	protected void printOutput() {
		JOptionPane.showMessageDialog(null, this.getText());
	}

	protected String getText() {
		return this.text;
	}

	@Override
	public void writeLine(String text) {
		this.text = text;
		this.printOutput();
	}
}
