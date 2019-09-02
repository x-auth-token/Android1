package ex6and7;

import java.io.Serializable;

public class Polygon extends Shape implements Serializable {
	Point[] points;
	
	public Polygon() {
		
	}
	
	public void addPoint(Point p) {
		points[0] = p; 
	}
	
	@Override
	protected boolean contains(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean intersect(Rectangular rect) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
