package edu.umb.cs.cs680;

public class InsufficientFundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2806522058324949661L;

	/**
	 * @param message
	 */
	public InsufficientFundsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println("*******\n"+message+"\n*******\n");
	}
}
