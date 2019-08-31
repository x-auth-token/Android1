package common;



import family.Subject;

public interface Listeners {
	
	public enum NEEDS {
		FOOD,
		WALK
	}
	public void care(Subject subj, NEEDS need);
	
}
