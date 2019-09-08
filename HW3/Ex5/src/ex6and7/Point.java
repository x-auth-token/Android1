package ex6and7;

public class Point {
	int x;
	int y;
	
	public Point() {};
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int calculateDistance(Point b) {
		return (int) Math.sqrt(Math.pow((b.getX() - this.getX()), 2) + Math.pow((b.getY() - this.getY()), 2) );
	}
	
	@Override
	public boolean equals(Object obj) {
		if (((Point) obj).getX() == this.getX() || ((Point) obj).getY() == this.getY()) {
			return true;
		}
		
		return false;
	}
	
}
