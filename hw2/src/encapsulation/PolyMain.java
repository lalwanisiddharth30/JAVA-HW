/**
 * 
 */
package encapsulation;

import java.awt.Point;
import java.util.*;

public class PolyMain {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Polygon> triangles = new ArrayList<Polygon>();
		
		// output Triangles
		System.out.println("Priting Triangles; for area 0.0 see Triangle.getArea();\n");	
		triangles.add( new Triangle(new Point(20,13), new Point(11,13), new Point(11,11)));
		triangles.add( new Triangle( new Point(5,9), new Point(4,12), new Point(2,8) ));
		
		Iterator<Polygon> polyTri = triangles.iterator();	
		
		while( polyTri.hasNext() ){
			Polygon tri = (Polygon) polyTri.next();	
			System.out.println( "AREA: " + tri.getArea() + " and Points: " + tri.getPoints());
		}
		
		ArrayList<Polygon> rectangles = new ArrayList<Polygon>();

		// output Rectangles
		System.out.println("\nPriting Rectangles; for area 0.0 see Rectangle.getArea(); \n");
		rectangles.add( new Rectangle ( new Point(20,22), new Point(17,12),  new Point(4,6), new Point(7,16) ));
		rectangles.add( new Rectangle ( new Point(7,8), new Point(12,13), new Point(1,2), new Point(6,7) ));
		
		Iterator<Polygon> polyRectangle = rectangles.iterator();
		
		while( polyRectangle.hasNext() ){
			Polygon rect = polyRectangle.next();
			System.out.println( "AREA: " + rect.getArea() + " and Points: " + rect.getPoints() );
		}
	}

}
