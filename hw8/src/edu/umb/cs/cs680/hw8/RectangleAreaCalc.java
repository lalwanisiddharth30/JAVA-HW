package edu.umb.cs.cs680.hw8;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {

		// Get the points to calculate area
		Point a = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		Point d = points.get(3);

		// Apply same method as in hw2
		// Calculate the sides of rectangle using distance formula
		double ab, bc, cd, da;

		ab = Math.abs(Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2)));
		bc = Math.abs(Math.sqrt(Math.pow((c.getX() - b.getX()), 2) + Math.pow((c.getY() - b.getY()), 2)));
		cd = Math.abs(Math.sqrt(Math.pow((d.getX() - c.getX()), 2) + Math.pow((d.getY() - c.getY()), 2)));
		da = Math.abs(Math.sqrt(Math.pow((a.getX() - d.getX()), 2) + Math.pow((a.getY() - d.getY()), 2)));

		// Check if rect have equal and opposite sides
		double area = ab == cd && bc == da ? ab * bc : 0.0;

		area = (double) Math.round(area * 100d) / 100d; // trim the decimal
														// value
		System.out.println("Area for given Rectangle is: " + area);

		// returns 0.0 if the sides opposite to each other are not equal
		return (float)area;
	}

}
