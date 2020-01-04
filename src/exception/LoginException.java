package exception;


public class LoginException extends ATMException {
	public LoginException(String message){
		super("LoginException:"+message);
	}
}
