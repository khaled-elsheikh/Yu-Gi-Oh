package eg.edu.guc.yugioh.exceptions;

public class UnexpectedFormatException extends Exception {
	String sourceFile;
	int sourceLine;
	public UnexpectedFormatException(String srcFile, int srcLine) {
		super();
		this.sourceFile = srcFile;
		this.sourceLine = srcLine;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public int getSourceLine() {
		return sourceLine;
	}
	public void setSourceLine(int sourceLine) {
		this.sourceLine = sourceLine;
	}
}
