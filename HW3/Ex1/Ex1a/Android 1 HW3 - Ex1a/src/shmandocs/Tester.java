package shmandocs;

import java.util.Vector;

import common.Task;

public class Tester extends TeamMember implements Runnable {
	
	
	
	public Tester(Vector<Task> tasksPool, String name) {
		super(tasksPool, name);
		// TODO Auto-generated constructor stub
	}
	
	private void testProgram() throws InterruptedException {
		Thread.sleep(getRandomWorkingTime());;
	}
	
	@Override
	public synchronized void processTask(Task t) throws InterruptedException {
		super.processTask(t);
		testProgram();
		t.setState(Task.AFTER_TESTING_STATE);
	}

	/*
	 * @Override public void run() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
