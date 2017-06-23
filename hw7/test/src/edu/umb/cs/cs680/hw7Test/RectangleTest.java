package src.edu.umb.cs.cs680.hw7Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.hw7.*;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleTest {

	@Test
	public final void testRectangle() {
		// Constructor sets Points in ArrayList
		Rectangle rect = new Rectangle(new Point(20, 22), new Point(17, 12), new Point(4, 6), new Point(7, 16));

		// call getPoints
		ArrayList<Point> actualPoints = rect.getPoints();

		// Array of points passed
		ArrayList<Point> toTestPoints = new ArrayList<Point>();
		toTestPoints.add(new Point(20, 22));
		toTestPoints.add(new Point(17, 12));
		toTestPoints.add(new Point(4, 6));
		toTestPoints.add(new Point(7, 16));

		// Test
		assertEquals(actualPoints, toTestPoints);
	}

	@Test
	public final void testGetPoints() {

		// Constructor sets Points in ArrayList
		Rectangle rect = new Rectangle(new Point(20, 22), new Point(17, 12), new Point(4, 6), new Point(7, 16));

		// call getPoints
		ArrayList<Point> actualPoints = rect.getPoints();

		// Array of points passed
		ArrayList<Point> toTestPoints = new ArrayList<Point>();
		toTestPoints.add(new Point(20, 22));
		toTestPoints.add(new Point(17, 12));
		toTestPoints.add(new Point(4, 6));
		toTestPoints.add(new Point(7, 16));

		// Test
		assertEquals(actualPoints, toTestPoints);

	}

	@Test
	public final void testGetArea() {
		Rectangle rect = new Rectangle(new Point(20, 22), new Point(17, 12), new Point(4, 6), new Point(7, 16));

		// Call getArea()
		double actualArea = rect.getArea();

		// area to be calculated
		double toBeCalcArea = 149.48;

		// test
		assertThat(actualArea, is(toBeCalcArea));
	}

}
