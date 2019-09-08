package shmandocs;


import java.util.Vector;

import common.Task;

public class Programmer extends TeamMember implements Runnable {
	
	

	public Programmer(Vector<Task> tasksPool, String name) {
		super(tasksPool, name);

	}
	
	public Programmer(Vector<Task> tasksPool, Vector<Task> doneTasks, String name) {
		super(tasksPool, doneTasks, name);

	}
	

	private synchronized void writeProgram() throws InterruptedException {
		Thread.sleep(getRandomWorkingTime());
	}

	@Override
	public synchronized void processTask(Task t) throws InterruptedException {
		super.processTask(t);
		writeProgram();
		t.setState(Task.AFTER_DEVELOPMENT_STATE);
	}

	

}