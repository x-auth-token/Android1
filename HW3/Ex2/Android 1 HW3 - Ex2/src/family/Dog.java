package family;

import java.util.Vector;

import javax.xml.bind.Marshaller.Listener;

import common.Listeners;
import common.Pet;

public class Dog extends Subject implements Pet {
	
	private boolean haveWalked;

	public Dog(String name) {
		super(name);
		haveWalked = false;
		
	}

	@Override
	public void lifeCycle() throws InterruptedException {
		super.lifeCycle();
	}

	private boolean isHaveWalked() {
		return haveWalked;
	}
	
	private void setHaveWalked(boolean haveWalked) {
		this.haveWalked = haveWalked;
	}
	
	@Override
	protected void notifyListeners() {
		setHaveWalked(false);
		super.notifyListeners();
		
		
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
 