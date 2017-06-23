package edu.umb.cs.cs680.hw8;

import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {

		// Get the points to calculate area
		Point a = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		
		// Apply same method as in hw2
		float ab, bc, ca;
		ab = (float) Math.sqrt(Math.pow((b.getX()-a.getX()),2) + Math.pow((b.getY()-a.getY()), 2));
		bc = (float) Math.sqrt(Math.pow((c.getX()-b.getX()),2) + Math.pow((c.getY()-b.getY()), 2));
		ca = (float) Math.sqrt(Math.pow((a.getX()-c.getX()),2) + Math.pow((a.getY()-c.getY()), 2));
		
		// Using Heron's formula to calculate the area of Triangle
		double s = (ab+bc+ca)/2;
		
		// check if any side is 0
		double area =  ab==0||bc==0||ca==0 ?  0.0 : Math.abs(Math.sqrt(s*(s-ab)*(s-bc)*(s-ca)));
		
		// trim the area
		area = (double)Math.round(area * 100d) / 100d ;
		
		System.out.println("Area for given Triangle is: " + area);
		
		// return 0.0 if any of the side of triangle is ZERO
		return (float) area;
	}

}
