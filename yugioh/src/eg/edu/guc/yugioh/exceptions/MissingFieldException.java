package eg.edu.guc.yugioh.exceptions;

public class MissingFieldException extends UnexpectedFormatException{

	public MissingFieldException(String srcFile, int srcLine) {
		super(srcFile, srcLine);
	}
}