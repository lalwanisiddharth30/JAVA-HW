package src.edu.umb.cs.cs680.hw7Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.hw7.*;

public class TriangleTest {

	@Test
	public final void testTriangle() {

		// creating a triangle
		Point a = new Point(20, 13);
		Point b = new Point(11, 13);
		Point c = new Point(11, 11);

		Triangle tri = new Triangle(a, b, c);

		ArrayList<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		points.add(c);

		ArrayList<Point> fromTriangle = new ArrayList<>();

		fromTriangle = tri.getPoints(); // should return arrayList with same
										// points

		// Test
		assertEquals(points, fromTriangle);
	}

	@Test
	public final void testGetArea() {
		// creating a triangle
		Point a = new Point(20, 13);
		Point b = new Point(11, 13);
		Point c = new Point(11, 11);

		Triangle tri = new Triangle(a, b, c);
		
		double fromTriangle = tri.getArea();
		
		double shouldBe = 9.0f;
		
		// test
		assertThat(fromTriangle, is(shouldBe));
	}

	@Test
	public final void testGetPoints() {
		
		/*
		 * Same as testing constructor
		 */
		
		// creating a triangle
		Point a = new Point(20, 13);
		Point b = new Point(11, 13);
		Point c = new Point(11, 11);

		Triangle tri = new Triangle(a, b, c);

		ArrayList<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		points.add(c);

		ArrayList<Point> fromTriangle = new ArrayList<>();

		fromTriangle = tri.getPoints(); // should return arrayList with same
										// points

		// Test
		assertEquals(points, fromTriangle);
	}

}
