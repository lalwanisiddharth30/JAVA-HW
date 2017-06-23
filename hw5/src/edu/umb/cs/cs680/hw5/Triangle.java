/**
 * 
 */
package edu.umb.cs.cs680.hw5;

import java.awt.Point;
import java.util.ArrayList;

public class Triangle implements Polygon {

	private ArrayList<Point> triangleCoordinates;
	private Point a,b,c;
	
	// Take the triangle coordinates
	public Triangle(Point a, Point b, Point c){
		this.a = a;
		this.b = b;
		this.c = c;
		
		triangleCoordinates = new ArrayList<Point>();
		triangleCoordinates.add(a);
		triangleCoordinates.add(b);
		triangleCoordinates.add(c);
		
	}

	/* (non-Javadoc)
	 * @see encapsulation.Polygon#getArea()
	 */
	@Override
	public double getArea() {
		
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
		
		// return 0.0 if any of the side of triangle is ZERO
		return area;
	}
	
	/* (non-Javadoc)
	 * @see encapsulation.Polygon#getPoints()
	 */
	@Override
	public ArrayList<Point> getPoints() {
		return triangleCoordinates;
	}

}
