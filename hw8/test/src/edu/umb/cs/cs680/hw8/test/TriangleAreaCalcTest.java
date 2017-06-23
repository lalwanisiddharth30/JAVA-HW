package src.edu.umb.cs.cs680.hw8.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.hw8.TriangleAreaCalc;

public class TriangleAreaCalcTest {

	@Test
	public final void testGetArea() {
		// Create an ArrayList
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(20,13));
		points.add(new Point(11,13));
		points.add(new Point(11,11));
		
		TriangleAreaCalc areaCalc = new TriangleAreaCalc();
		
		float areaShouldBe = 9.0f;
		
		float actualArea = areaCalc.getArea(points);
		
		assertThat(areaShouldBe, is(actualArea));
	}

}
