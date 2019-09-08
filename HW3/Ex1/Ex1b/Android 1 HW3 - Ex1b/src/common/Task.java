package common;

public class Task {
	public static final int NEW_STATE = 0;
	public static final int AFTER_DEVELOPMENT_STATE = 1;
	public static final int AFTER_TESTING_STATE = 2;
	public static final int AFTER_RESEARCH_STATE = 3;
	
	private int id;
	private int state;
	
	public Task(int id) {
		this.id = id;
		state = NEW_STATE;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	
	public String getStateMsg() {
		switch(state) {
		case 0:
			return "NEW";
		case 1:
			return "DEVELOPED";
		case 2:
			return "TESTED";
		case 3:
			return "RESEARCHED";
		default:
			return "UNKNOWN STATE";
		}
	}
}
