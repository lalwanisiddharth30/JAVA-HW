package src.edu.umb.cs.cs680.hw7_2Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.hw7_2.*;


public class SavingsAccountTest {

	/**
	 * Test method for {@link edu.umb.cs.cs680.SavingsAccount#withdraw(float)}.
	 * @throws InsufficientFundsException 
	 */
	@Test
	public final void testWithdraw() throws InsufficientFundsException {
		
		// Create an account 
		SavingsAccount saving = new SavingsAccount();
		
		// Deposit some money, say 50
		saving.deposit(50);
		
		// now withdraw 20, should leave the account with 30
		saving.withdraw(20);
		
		// Test if 30 is left or not
		assertThat(saving.getBalance(), is(30.0f));
		
	}
	
	/**
	 * @throws InsufficientFundsException 
	 * 
	 */
	@Test(expected=InsufficientFundsException.class)
	public final void testWithdraw2() throws InsufficientFundsException {
		
		// Create an account 
		SavingsAccount saving = new SavingsAccount();
		
		// test if it throws exception 
		saving.withdraw(60);
	}

}
