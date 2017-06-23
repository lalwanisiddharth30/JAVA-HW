package src.edu.umb.cs.cs680;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.CheckingAccount;
import edu.umb.cs.cs680.InsufficientFundsException;
import edu.umb.cs.cs680.SavingsAccount;


public class CheckingAcountTest {

	/**
	 * Test method for {@link edu.umb.cs.cs680.CheckingAccount#withdraw(float)}.
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testWithdraw() throws InsufficientFundsException {
		SavingsAccount account1 = new SavingsAccount();

		// Add some amount to Saving so it can be charged and no Exception is
		// thrown
		account1.deposit(100);

		// Create a checking account
		CheckingAccount newChecking = new CheckingAccount(account1);

		// if a withdrawn of amount larger than available is made on checking
		// account, a penalty of 50 is charged
		// So, we make a withdraw on empty checking, it should reflect -50.0
		newChecking.withdraw(50);

		// Test
		assertThat(newChecking.getBalance(), is(-50.0f));
	}

	/**
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testWithdraw2() throws InsufficientFundsException {

		SavingsAccount account1 = new SavingsAccount();

		// Add some amount to Saving so it can be charged and no Exception is
		// thrown
		account1.deposit(100);

		// Create a checking account
		CheckingAccount newChecking = new CheckingAccount(account1);

		// Add some money
		newChecking.deposit(100);

		// Test for normal execution, withdraw less amount than available.
		newChecking.withdraw(50);

		// Test
		assertThat(newChecking.getBalance(), is(50.0f));
	}

	/**
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testWithdraw3() throws InsufficientFundsException {

		SavingsAccount account1 = new SavingsAccount();

		// Add some amount to Saving so it can be charged and no Exception is
		// thrown
		account1.deposit(100);

		// Create a checking account
		CheckingAccount newChecking = new CheckingAccount(account1);

		// Add some money
		newChecking.deposit(20);

		// Test another condition, withdraw more money than available but
		// not greater than savings + checking.
		newChecking.withdraw(50);

		// Test
		assertThat(newChecking.getBalance(), is(-50.0f));
		assertThat(account1.getBalance(), is(70.0f));
	}

	/**
	 * Test method for
	 * {@link edu.umb.cs.cs680.CheckingAccount#CheckingAccount(edu.umb.cs.cs680.SavingsAccount)}
	 * .
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testCheckingAccount() throws InsufficientFundsException {
		SavingsAccount account = new SavingsAccount();

		CheckingAccount cAccount = new CheckingAccount(account);

		// Deposit 1000 in savings. Let Checking account be empty
		account.deposit(1000);

		// Withdraw 50 on checking account. It should charge 50 on Savings.
		cAccount.withdraw(50);

		// assertThat. if passes means that savingsAccount object that was
		// charged was the one we passed here. This completes the test for
		// CheckingAccount constructor
		assertThat(account.getBalance(), is(950.0f));

	}

	/**
	 * Test method for checkingException
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test(expected = InsufficientFundsException.class)
	public final void testException() throws InsufficientFundsException {
		SavingsAccount account1 = new SavingsAccount();

		// Create a checking account
		CheckingAccount newChecking = new CheckingAccount(account1);

		// if a withdrawn of amount larger than available is made on checking
		// account, a penalty of 50 is charged
		// So, we make a withdraw on empty checking and savings account, it
		// should throw an exception
		newChecking.withdraw(50);
	}

}
