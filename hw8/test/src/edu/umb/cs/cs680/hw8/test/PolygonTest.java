package src.edu.umb.cs.cs680.hw8.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.hw8.*;

public class PolygonTest {

	@Test
	public final void testPolygon() {

		// Test if this sets ArrayList and AreaCalc Object

		// Test with rectangle area calculator

		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(10, 5));

		RectangleAreaCalc rectArea = new RectangleAreaCalc();

		Polygon rectPoly = new Polygon(points, rectArea);

		AreaCalculator area = rectPoly.getCalculator();

		AreaCalculator shouldBe = rectArea;

		assertThat(area, is(shouldBe));

		assertEquals(points, rectPoly.getPoints());

		// Test with triangle area calculator

		ArrayList<Point> points1 = new ArrayList<>();
		points1.add(new Point(6, 8));

		TriangleAreaCalc triArea = new TriangleAreaCalc();

		Polygon triPoly = new Polygon(points1, triArea);

		AreaCalculator areaTri = triPoly.getCalculator();

		AreaCalculator shouldBeTri = triArea;

		assertThat(areaTri, is(shouldBeTri));

		assertEquals(points1, triPoly.getPoints());

	}

	@Test
	public final void testGetPoints() {

		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(10, 5));

		RectangleAreaCalc rectArea = new RectangleAreaCalc();

		Polygon rectPoly = new Polygon(points, rectArea);

		assertThat(points, is(rectPoly.getPoints()));
	}

	@Test
	public final void testSetPoints() {

		// Test with an array list and see if constructor sets it
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(10, 5));

		RectangleAreaCalc rectArea = new RectangleAreaCalc();

		Polygon rectPoly = new Polygon(points, rectArea);

		assertThat(points, is(rectPoly.getPoints()));

		// Create new arrayList and use setPoints and check to see if sets the
		// new one or not
		ArrayList<Point> pointsChanged = new ArrayList<>();
		pointsChanged.add(new Point(8, 5));

		rectPoly.setPoints(pointsChanged);

		assertEquals(pointsChanged, rectPoly.getPoints());
	}

	@Test
	public final void testGetCalculator() {

		ArrayList<Point> points1 = new ArrayList<>();
		points1.add(new Point(6, 8));

		TriangleAreaCalc triArea = new TriangleAreaCalc();

		Polygon triPoly = new Polygon(points1, triArea);

		AreaCalculator areaTri = triPoly.getCalculator(); // Calling Get
															// calculator

		AreaCalculator shouldBeTri = triArea;

		assertThat(areaTri, is(shouldBeTri));

	}

	@Test
	public final void testSetCalculator() {

		// Create a calculator for triangle and then change it to rectangle to
		// test the set areaCalculator method
		ArrayList<Point> points1 = new ArrayList<>();
		points1.add(new Point(6, 8));

		TriangleAreaCalc triArea = new TriangleAreaCalc();

		Polygon triPoly = new Polygon(points1, triArea);

		AreaCalculator areaTri = triPoly.getCalculator();

		AreaCalculator shouldBeTri = triArea;

		assertThat(areaTri, is(shouldBeTri));

		// create rectangle area calculator
		RectangleAreaCalc rectArea = new RectangleAreaCalc();

		AreaCalculator rectAr = rectArea;
		triPoly.setCalculator(rectArea);

		assertThat(rectAr, is(triPoly.getCalculator()));

	}

	@Test
	public final void testAddPoint() {

		ArrayList<Point> points1 = new ArrayList<>();
		points1.add(new Point(6, 8));

		TriangleAreaCalc triArea = new TriangleAreaCalc();

		Polygon triPoly = new Polygon(points1, triArea);

		assertThat(points1, is(triPoly.getPoints()));

		// add a point and check again, if the test passes, the new point was
		// added
		Point p = new Point(2, 5);

		points1.add(p);
		triPoly.addPoint(p);

		assertThat(points1, is(triPoly.getPoints()));

	}

	@Test
	public final void testGetArea() {
		// Create an ArrayList
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(20, 22));
		points.add(new Point(17, 12));
		points.add(new Point(4, 6));
		points.add(new Point(7, 16));

		RectangleAreaCalc areaCalc = new RectangleAreaCalc();

		Polygon rectArea = new Polygon(points, areaCalc);

		float areaShouldBe = 149.48f;

		float actualArea = rectArea.getArea();

		assertThat(areaShouldBe, is(actualArea));
	}

}
