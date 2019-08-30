package family;

import java.awt.Event;

import common.Listeners;

public abstract class FamilyMember implements Listeners {
	
	private String name;
	
	public FamilyMember(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void care(Subject subj) {
		if (!(subj.isTreated())) {
			subj.setHungry(false);
			System.out.println(getName() + " fed " + subj.getName());
			if (subj instanceof Cat) {
				subj.setThreated(true);
			}
				
		}
		
	}
	
	@Override
	public void listen(Event evt) {
		
		
	}
	

}
