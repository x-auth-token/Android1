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
			for (int i = 0; i < points.length; i++) {
				if ((i + 1) == points.length) {
					perimeter +=  points[i].calculateDistance(points[0]);
				} else {
					perimeter += points[i].calculateDistance(points[i + 1]);
				}
			}
		}
		return perimeter;
	}
	@Override
	public boolean contains(Point point) {
		for (Point p : points) {
			if (p.equals(point)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean intersect(Rectangular rect) {
		for (Point p : points) {
			if (p.equals(rect.getBottomLeft()) || p.equals(rect.getTopRight())) {
				return true;
			}
		}
		return false;
	}
	
	
}
