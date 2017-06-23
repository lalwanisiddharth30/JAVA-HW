package edu.umb.cs.cs680.unittest;

public class Calculator {

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public float multiply(float x, float y){
		return x*y;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public float divide(float x, float y){
		if(y == 0){
			throw new IllegalArgumentException("divide by zero");
		}
		return x/y;
	}
	
	public static void main(String args[]){
		Calculator calc = new Calculator();
		System.out.println("Printing 2.5*8.2 = " + calc.multiply(2.5f, 8.2f));
	}
}
