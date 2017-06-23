package edu.umb.cs.cs680;

public abstract class Account {
	protected float balance = 0.0f;

	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	
	/**
	 * @param deposit
	 * @return
	 */
	public float deposit(float deposit){
		balance += deposit;
		return balance;
	}
	
	/**
	 * @param withdraw
	 * @return
	 * @throws InsufficientFundsException
	 */
	public abstract float withdraw(float withdraw) throws InsufficientFundsException;

}
