package util;

public class BufferedUIOutput extends UIOutput {

	private int bufferSize;
	private int currentBuffer = 0;
	private StringBuilder sb;

	public BufferedUIOutput(int bufferSize) {
		this.bufferSize = bufferSize;
		this.sb = new StringBuilder();
	}

	@Override
	public void writeLine(String text) {
		this.currentBuffer += 1;
		this.sb.append(text + "\n");

		if (this.bufferSize == this.currentBuffer) {
			this.printOutput();
			this.flush();
		}
	}

	@Override
	protected String getText() {
		return this.sb.toString();
	}

	private void flush() {
		this.currentBuffer = 0;
		this.sb = new StringBuilder();
	}
}
