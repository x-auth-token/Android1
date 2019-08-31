package matrices;

import java.util.Random;
import java.util.Vector;


public class SquareMatrix implements Runnable {
	private Vector<Vector<Integer>> elements;
	private int dimension;
	private final int MAX_INT = 11;
	
	public SquareMatrix(int dimension) {
		elements = new Vector<Vector<Integer>>();
		this.dimension = dimension;
		//populateMatrix(dimension);
		
	}
	
	public Integer getElementAt(int row, int col)
	{
		return elements.get(row).get(col);
	}
	
	public void setElementAt(int row, int col, Integer value) {
		elements.get(row).set(col, value);
	}
	private Integer getRandomInteger() {
		return new Random().nextInt(MAX_INT);
	}
	
	public void populateMatrix() {
		for (int i = 0; i < dimension; i++) {
			Vector<Integer> row = new Vector<Integer>();
			for (int j = 0; j < dimension; j++) {
				row.add(getRandomInteger());
			}
			elements.add(row);
		}
	}
	
	public Vector<Vector<Integer>> getElements() {
		
		return this.elements;
	}
	
	public SquareMatrix multiply(SquareMatrix m) {
		
		SquareMatrix sMatrix = new SquareMatrix(dimension);
		
		for (int i = 0; i < dimension; i++) {
			
			Vector<Integer> row = new Vector<Integer>();
			
			for (int j = 0; j < dimension; j++) {
				int sum = 0;
				for (int k = 0; k < dimension; k++) {
					sum += this.getElementAt(i, k) * m.getElementAt(k, j);
					
				}
				
				row.add(sum);
				
			}
			
			sMatrix.getElements().add(row);
			
	
		}
		
		return sMatrix;
	}

	public void print() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(getElementAt(i, j));
				if (j + 1 < dimension) {
					System.out.print(" ");
				}
			}
			
			System.out.println("");
			
		}
	}

	@Override
	public void run() {
		populateMatrix();
		
	}
	
	
}
