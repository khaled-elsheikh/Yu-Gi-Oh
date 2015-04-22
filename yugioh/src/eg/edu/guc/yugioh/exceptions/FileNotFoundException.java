package eg.edu.guc.yugioh.exceptions;

import java.io.IOException;

public class FileNotFoundException extends IOException {
	public FileNotFoundException(){
		super();
	}
	public FileNotFoundException(String s){
		super(s);
	}
	
}
