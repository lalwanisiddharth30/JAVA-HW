package edu.umb.cs.cs680;

public class SavingsAccount extends Account {
	
	@Override
	public float withdraw(float withdraw) throws InsufficientFundsException {
		//super.deposit(20.f);
		if(this.getBalance() - withdraw <= 0){
			throw new InsufficientFundsException("Insufficient Funds");
		}
		balance -= withdraw;
		return balance;
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		
		// This method is just for test
		// Create a SavingsAccount 
		SavingsAccount account = new SavingsAccount();
		
		// Put some money in it.
		account.deposit(1000);
		
		// Display to user.
		System.out.println("Created a new Account and deposited: balance from getBalance--> " + account.getBalance());
	}
}
