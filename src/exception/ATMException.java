package exception;

public class ATMException extends Exception {
	
	private String message;

    //���캯��
    public ATMException(String message){
        super(message);
        this.message = message;
    }
    
}
