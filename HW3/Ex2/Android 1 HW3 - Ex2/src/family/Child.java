package family;

import java.awt.Event;

import common.Listeners;


public class Child extends FamilyMember implements Listeners {
	

	
	public Child (String name) {
		super(name);
	}
	
	@Override
	public synchronized void care(Subject subj, NEEDS need) {
		
		if (need == NEEDS.WALK)
			///if (!((Dog) subj).isHaveWalked()) {
				((Dog) subj).setHaveWalked(true);
				//((Dog)subj).setThreated(true);
				System.out.println(getName() + " walked with " + subj.getName());
		
		
		
	}	

}
