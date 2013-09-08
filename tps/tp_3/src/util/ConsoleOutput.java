package util;

public class ConsoleOutput implements OutputInterface {

	@Override
	public void writeLine(String text) {
		System.out.println(text);
	}

	public void printOutput() {
	}

}
