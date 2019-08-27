package family;

import java.util.Random;
import java.util.Vector;

import common.Pet;



public abstract class Subject implements Pet, Runnable {
	
	Vector<FamilyMember> listeners = new Vector<FamilyMember>();
	String name;
	private boolean hungry;
	private boolean treated;
	private final int MAX_SLEEP_TIME = 8000;
	
	public Subject (String name) {
		this.name = name;
		hungry = true;
		treated = false;
	}
	
	public void addLlistener(FamilyMember fm) {
		listeners.add(fm);
	}

	public void removeListener(FamilyMember fm) {
		listeners.remove(fm);
	}
	
	public boolean isHungry() {
		return hungry;
	}
	
	
	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public boolean isTreated() {
		return treated;
	}
	
	public String getName() {
		return name;
	}
	
	private int getRandomSleepTime() {
		return new Random().nextInt(MAX_SLEEP_TIME);
	}
	
	private void getSleep() throws InterruptedException {
		Thread.sleep(getRandomSleepTime());
	}
	
	protected void notifyListeners() {
		
	}
	
	@Override
	public void lifeCycle() throws InterruptedException {
		while(true) {
			if (!isHungry()) {
				setHungry(true);
			}
			getSleep();
			notifyListeners();
		}
		
		
	}

	
	
	
	
	
}
