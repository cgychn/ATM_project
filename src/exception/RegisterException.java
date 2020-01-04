package exception;


public class RegisterException extends ATMException {

	public RegisterException(String message){
		super("RegisterException:"+message);
	}
}
