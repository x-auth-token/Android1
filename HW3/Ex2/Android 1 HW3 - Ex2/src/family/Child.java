package family;

import java.awt.Event;

import common.Listeners;


public class Child extends FamilyMember implements Listeners {
	

	
	public Child (String name) {
		super(name);
	}
	
	@Override
	public void care(Subject subj) {
		super.care(subj);
		if (subj instanceof Dog) {
			if (!((Dog) subj).isHaveWalked()) {
				takeAWalk((Dog)subj);
				System.out.println(getName() + " walked with " + subj.getName());
			}
		}
		
	}
	
	private void takeAWalk(Dog dog) {
		dog.setHaveWalked(true);
	}

	
	

}
