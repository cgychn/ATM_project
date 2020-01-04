package exception;

public class ATMException extends Exception {
	
	private String message;

    //¹¹Ôìº¯Êý
    public ATMException(String message){
        super(message);
        this.message = message;
    }
    
}
