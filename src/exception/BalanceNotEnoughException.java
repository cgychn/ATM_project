package exception;


public class BalanceNotEnoughException extends ATMException {
	public BalanceNotEnoughException(String message){
		super("BalanceNotEnoughException:"+message);
	}
}
