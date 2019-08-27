package family;

import common.Listeners;

public abstract class FamilyMember implements Listeners {
	
	private String name;
	
	public FamilyMember(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

}
