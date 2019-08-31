package family;

import java.util.Random;
import java.util.Vector;

import common.Listeners;
import common.Listeners.NEEDS;
import common.Pet;

public abstract class Subject implements Pet, Runnable {

	private Vector<Listeners> listeners; // = new Vector<Listeners>();
	private String name;
	private boolean hungry;
	private boolean treated;
	private final int MAX_SLEEP_TIME = 8000;

	public Subject(String name) {
		this.name = name;
		hungry = true;
		treated = false;
		listeners = new Vector<Listeners>();
	}

	public void addListener(Listeners listener) {
		listeners.add(listener);
	}

	public void removeListener(Listeners listener) {

		listeners.remove(listener);

	}

	public boolean isHungry() {
		return this.hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public boolean isTreated() {
		return this.treated;
	}

	public void setThreated(boolean treated) {
		this.treated = treated;
	}

	public String getName() {
		return this.name;
	}

	private int getRandomSleepTime() {
		return new Random().nextInt(MAX_SLEEP_TIME);
	}

	protected void getSleep() throws InterruptedException {
		Thread.sleep(getRandomSleepTime());
	}

	protected synchronized void notifyListeners(NEEDS need) {
		for (Listeners listener : listeners) {
			listener.care(this, need);
		}

	}

	@Override
	public synchronized void lifeCycle() throws InterruptedException {
		while (true) {
			getSleep();
			setThreated(false);
			setHungry(true);
			notifyListeners(NEEDS.FOOD);

		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				lifeCycle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
