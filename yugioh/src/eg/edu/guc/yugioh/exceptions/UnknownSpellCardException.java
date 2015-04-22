package eg.edu.guc.yugioh.exceptions;

public class UnknownSpellCardException extends UnexpectedFormatException {

	String unknownSpell;
	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}

	public UnknownSpellCardException(String srcFile, int srcLine) {
		super(srcFile, srcLine);
	}
	
	public UnknownSpellCardException(String srcFile, int srcLine, String unknownSpell) {
		super(srcFile, srcLine);
		this.unknownSpell = unknownSpell;
	}
}
