package ex6and7;

import java.io.Serializable;

public class Polygon implements Shape, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5918603921310237405L;
	Point[] points;
	
	public Polygon() {
		
	}
	
	public Polygon(int numberOfPoints) {
		points = new Point[numberOfPoints];
	}
	
	public void addPoint(Point point) {
		for (Point p : points) {
			if (p == null) {
				p = point;
			}
		}
	}
	
	
	public int getPerimeter() {
		int perimeter = 0;
		
		if (points.length != 0) {
			
		}
		return perimeter;
	}
	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersect(Rectangular rect) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
