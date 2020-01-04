package exception;


public class LoanException extends ATMException {
	public LoanException(String message){
		super("LoanException:"+message);
	}
}
