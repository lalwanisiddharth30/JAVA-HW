package edu.umb.cs.cs680.hw8;

import java.util.*;
import java.awt.Point;

public class Polygon {

	private ArrayList<Point> points;
	private AreaCalculator calculator;
	
	/**
	 * @param points
	 * @param calculator
	 */
	public Polygon(ArrayList<Point> points, AreaCalculator calculator) {
		this.points = points;
		this.calculator = calculator;
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
	public AreaCalculator getCalculator() {
		return calculator;
	}
	
	public void setCalculator(AreaCalculator calculator) {
		this.calculator = calculator;
	}
	
	public void addPoint(Point point){
		this.points.add(point);
	}
	
	public float getArea(){
		return calculator.getArea(points);
	}
}
