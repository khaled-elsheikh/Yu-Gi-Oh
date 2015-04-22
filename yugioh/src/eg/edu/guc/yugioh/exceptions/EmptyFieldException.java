package eg.edu.guc.yugioh.exceptions;

public class EmptyFieldException extends UnexpectedFormatException {
	int sourceField;
	
	public EmptyFieldException(String srcFile, int srcLine) {
		super(srcFile, srcLine);
	}
	
	public EmptyFieldException(String srcFile, int srcLine, int srcField) {
		super(srcFile, srcLine);
		this.sourceField = srcField;
	}

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}
}
