package shmandocs;

import java.util.Vector;

import common.Task;

public class Researcher extends TeamMember implements Runnable {
	
	
	
	public Researcher(Vector<Task> tasksPool, String name) {
		super(tasksPool, name);
		// TODO Auto-generated constructor stub
	}
	

	private synchronized void doResearch() throws InterruptedException {
		Thread.sleep(getRandomWorkingTime());
	}
	
	

	@Override
	public synchronized void processTask(Task t) throws InterruptedException {
		super.processTask(t);
		
		doResearch();
		t.setState(Task.AFTER_RESEARCH_STATE);
	}

	
	/*
	 * @Override public void run() { for (Task t : getTasksPool()) { try {
	 * System.out.println(this.getClass().getSimpleName() + " " + getName() +
	 * " took task " + t.getId()); processTask(t); } catch (InterruptedException e)
	 * { // TODO Auto-generated e.printStackTrace(); } }
	 * 
	 * }
	 */
	 

}
