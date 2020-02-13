package pj4.ErrorHandling;

public class ManualException extends Exception {
	public ManualException(){
		super("this is the original cause");
	}
}