package src.edu.umb.cs.cs680.hw9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import edu.umb.cs.cs680.hw9.Car;
import edu.umb.cs.cs680.hw9.YearComparator;

public class YearTest {

	@Test
	public final void testCompare() {
		// Create cars
		Car car1 = new Car(20000, 2012, 12);
		Car car2 = new Car(2500, 2007, 25);
		Car car3 = new Car(38000, 2016, 17);
		Car car4 = new Car(4000, 2010, 19);

		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);

		System.out.println("Years before Comparator: ");

		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).getYear());
		}

		// Mileage comparator should result in {car3, car1, car4, car2}
		ArrayList<Car> newCars = new ArrayList<>();
		newCars.add(car3);
		newCars.add(car1);
		newCars.add(car4);
		newCars.add(car2);

		YearComparator years = new YearComparator();

		Collections.sort(cars, years);

		System.out.println("Years after Comparator: ");

		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).getYear());
		}

		assertEquals(cars, newCars);

	}

}
