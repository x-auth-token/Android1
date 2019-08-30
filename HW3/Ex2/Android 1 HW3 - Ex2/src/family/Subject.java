package family;

import java.util.Random;
import java.util.Vector;

import common.Listeners;
import common.Pet;



public abstract class Subject implements Pet, Runnable {
	
	Vector<Listeners> listeners = new Vector<Listeners>();
	String name;
	private boolean hungry;
	private boolean treated;
	private final int MAX_SLEEP_TIME = 8000;
	
	public Subject (String name) {
		this.name = name;
		hungry = true;
		treated = false;
	}
	
	public void addLlistener(Listeners listener) {
		listeners.add(listener);
	}

	public void removeListener(Listeners listener) {
		listeners.remove(listener);
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
	
	public void setThreated(boolean treated) {
		this.treated = treated;
	}
	public String getName() {
		return name;
	}
	
	private int getRandomSleepTime() {
		return new Random().nextInt(MAX_SLEEP_TIME);
	}
	
	protected void getSleep() throws InterruptedException {
		Thread.sleep(getRandomSleepTime());
	}
	
	protected void notifyListeners() {
		
	}
	
	@Override
	public void lifeCycle() throws InterruptedException {
		while(true) {
			if (!isHungry()) {
				setHungry(true);
				setThreated(false);
			}
			getSleep();
			notifyListeners();
		}
		
		
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				lifeCycle();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
}
