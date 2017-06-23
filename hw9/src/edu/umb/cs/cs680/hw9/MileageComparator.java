package edu.umb.cs.cs680.hw9;

import java.util.Comparator;


public class MileageComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return (int) (o2.getMileage() - o1.getMileage());
	}

}
