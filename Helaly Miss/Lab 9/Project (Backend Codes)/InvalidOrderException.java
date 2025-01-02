package med.lib;

public class InvalidOrderException extends Exception{
	public InvalidOrderException(String orderId) {
		super(orderId+" is not a valid event id.");
	
		}
}
