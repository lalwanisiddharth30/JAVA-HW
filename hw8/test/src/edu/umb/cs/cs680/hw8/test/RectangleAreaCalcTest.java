package src.edu.umb.cs.cs680.hw8.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.hw8.Polygon;
import edu.umb.cs.cs680.hw8.RectangleAreaCalc;;

public class RectangleAreaCalcTest {

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
