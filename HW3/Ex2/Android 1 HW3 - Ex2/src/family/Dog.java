package family;

import java.util.Vector;

import javax.xml.bind.Marshaller.Listener;

import common.Listeners;
import common.Listeners.NEEDS;
import common.Pet;

public class Dog extends Subject implements Pet {

	private boolean haveWalked;

	public Dog(String name) {
		super(name);
		haveWalked = false;

	}

	@Override
	public synchronized void lifeCycle() throws InterruptedException {
		while (true) {
			setHaveWalked(false);
			/*
			 * setHungry(true); setThreated(false); notifyListeners(NEEDS.FOOD);
			 */
			super.lifeCycle();
			getSleep();
			notifyListeners(NEEDS.WALK);
			
		}

	}
	
	

	public synchronized boolean isHaveWalked() {
		return haveWalked;
	}

	public void setHaveWalked(boolean haveWalked) {
		this.haveWalked = haveWalked;
	}
}
