package src.edu.umb.cs.cs680.unittest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import edu.umb.cs.cs680.unittest.Calculator;

public class CalculatorTest {

	@Test
	public final void multiply3by4() {
		Calculator calc = new Calculator();
		float returned = calc.multiply(3, 4);
		float actual = 12;
		assertThat(actual, is(returned));
	}

	@Test
	public final void divide3by2() {
		Calculator calc = new Calculator();
		float returned = calc.divide(3, 2);
		float actual = 1.5f;
		assertThat(actual, is(returned));
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public final void divide5by0(){
		Calculator calc = new Calculator();
		calc.divide(5, 0);
	}
	
	@Test
	public final void divide2_5by8_2() {
		Calculator calc = new Calculator();
		float returned = calc.multiply(2.5f, 8.2f);
		float actual = 20.5f;
		assertThat(actual, is(returned));
	}
	
	@Test
	public final void divide8_2by2_5() {
		Calculator calc = new Calculator();
		float returned = calc.divide(8.2f, 2.5f);
		float actual = 3.28f;
		assertThat(actual, is(returned));
	}


}
