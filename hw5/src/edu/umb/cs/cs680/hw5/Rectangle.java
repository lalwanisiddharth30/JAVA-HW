/**
 * 
 */
package edu.umb.cs.cs680.hw5;

import java.awt.Point;
import java.util.ArrayList;

public class Rectangle implements Polygon {

	private ArrayList<Point> rectangleCoordinates;
	private Point a,b,c,d;
	
	public Rectangle(Point a, Point b, Point c, Point d){
		
		rectangleCoordinates = new ArrayList<Point>(); 
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		
		rectangleCoordinates.add(a);
		rectangleCoordinates.add(b);
		rectangleCoordinates.add(c);
		rectangleCoordinates.add(d);
	}
	
	/* (non-Javadoc)
	 * @see encapsulation.Polygon#getPoints()
	 */
	@Override
	public ArrayList<Point> getPoints() {
		return rectangleCoordinates;
	}

	/* (non-Javadoc)
	 * @see encapsulation.Polygon#getArea()
	 */
	@Override
	public double getArea() {
				
		// Calculate the sides of rectangle using distance formula
		double ab, bc, cd, da;
		
		ab = Math.abs(Math.sqrt(Math.pow((b.getX()-a.getX()),2) + Math.pow((b.getY()-a.getY()), 2)));
		bc = Math.abs(Math.sqrt(Math.pow((c.getX()-b.getX()),2) + Math.pow((c.getY()-b.getY()), 2)));
		cd = Math.abs(Math.sqrt(Math.pow((d.getX()-c.getX()),2) + Math.pow((d.getY()-c.getY()), 2)));
		da = Math.abs(Math.sqrt(Math.pow((a.getX()-d.getX()),2) + Math.pow((a.getY()-d.getY()), 2)));
		
		// Check if rect have equal and opposite sides
		double area = ab==cd && bc==da ? ab*bc : 0.0;
		
		area  = (double)Math.round(area * 100d) / 100d ; // trim the decimal value
		
		// returns 0.0 if the sides opposite to each other are not equal
		return area;
	}

}
