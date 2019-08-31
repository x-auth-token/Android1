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
	
	@Override
	public synchronized void care(Subject subj, NEEDS need) {
		if (need == NEEDS.FOOD) {
			subj.setHungry(false);
			
			System.out.println(this.getName() + " fed " + subj.getName());
			
			subj.setThreated(true);
			
				
		}
		
	}

	

}
