package edu.umb.cs.cs680;

public class CheckingAccount extends Account {

	private SavingsAccount savingAccount;

	/**
	 * 
	 */
	public CheckingAccount(SavingsAccount account) {
		super();
		this.savingAccount = account;
	}

	@Override
	public float withdraw(float withdraw) throws InsufficientFundsException {

		if (this.getBalance() > withdraw) {
			this.balance -= withdraw;
			return this.balance;
		} else if (savingAccount.getBalance() + this.getBalance() >= withdraw) {
			float bal = withdraw - this.balance; // check the difference
			this.balance -= withdraw - bal;
			savingAccount.balance -= bal; // charge the difference to saving
			balance -= 50.0; // charge a penalty of $50
			return balance;
		} else {
			throw new InsufficientFundsException("Insufficient funds");
		}
	}
}
