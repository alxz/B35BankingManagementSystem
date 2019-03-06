package bus;

public class NegativeOrNullException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String message = 
			"RAISE Exception ... Negative Or Null number exception";
	
	public NegativeOrNullException()
	{
		super(message);
	}
	public NegativeOrNullException(String msg)
	{
		super(msg);
	}

}
