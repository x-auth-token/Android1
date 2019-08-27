package common;

public class Food {
	private int amount;
	private static final int portion = 1;
	
	public Food(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public synchronized void getPortion() {
		this.amount = amount - portion;
	}
	
}
