package edu.umb.cs.cs680.hw9;

public class Car {
	
	private int price;
	private int year;
	private float mileage;
	
	/**
	 * @param price
	 * @param year
	 * @param mileage
	 */
	public Car(int price, int year, float mileage) {
		super();
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the mileage
	 */
	public float getMileage() {
		return mileage;
	}

}
