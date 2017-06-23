package src.edu.umb.cs.cs680.hw9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import edu.umb.cs.cs680.hw9.Car;
import edu.umb.cs.cs680.hw9.PriceComparator;

public class PriceTest {

	@Test
	public final void test() {
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

		System.out.println("Prices before Comparator: ");

		for(int i = 0; i < cars.size(); i++){
			System.out.println(cars.get(i).getPrice());
		}
		
		// Mileage comparator should result in {car2, car4, car1, car3}
		ArrayList<Car> newCars = new ArrayList<>();
		newCars.add(car2);
		newCars.add(car4);
		newCars.add(car1);
		newCars.add(car3);


		
		PriceComparator price = new PriceComparator();

		Collections.sort(cars, price);
		
		System.out.println("Prices after Comparator: ");

		for(int i = 0; i < cars.size(); i++){
			System.out.println(cars.get(i).getPrice());
		}
		
		assertEquals(cars, newCars);

	}

}
