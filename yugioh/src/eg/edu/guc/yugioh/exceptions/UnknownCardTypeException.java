package eg.edu.guc.yugioh.exceptions;

public class UnknownCardTypeException extends UnexpectedFormatException {

	String unknownType;
	public UnknownCardTypeException(String srcFile, int srcLine) {
		super(srcFile, srcLine);
	}
	
	public UnknownCardTypeException(String srcFile, int srcLine, String unknownType) {
		super(srcFile, srcLine);
		this.unknownType = unknownType;
	}

	public String getUnknownType() {
		return unknownType;
	}

	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}
}
