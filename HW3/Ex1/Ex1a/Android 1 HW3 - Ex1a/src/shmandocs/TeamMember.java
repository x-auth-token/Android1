package shmandocs;

import java.util.Random;
import java.util.Vector;

import common.Task;

public abstract class TeamMember implements Runnable {
	private String name;
	private Vector<Task> tasksPool;
	private final int MAX_WORKING_TIME = 30000;


	public TeamMember() {

	}

	public TeamMember(String name) {
		this.name = name;
	}

	public TeamMember(Vector<Task> tasksPool, String name) {
		this.name = name;
		this.tasksPool = tasksPool;
		
	}
	

	public synchronized void processTask(Task t) throws InterruptedException {
		System.out.println(this.getClass().getSimpleName() + " " + getName() + " took task " + t.getId());
	}

	public synchronized String getClassName() {
		return this.getClass().getSimpleName();
	}

	// Get task from task pool and process it
	public synchronized void tasksProcessor() throws InterruptedException {
		if (!tasksPool.isEmpty()) {
				Task task = tasksPool.lastElement();
				tasksPool.remove(task);
				
				processTask(task);
				System.out.println("Task " + task.getId()  + " is completed with status " 
						+ task.getStateMsg() + " by " + this.getClassName() + " " + getName());

		}
	
	}
	
	protected int getRandomWorkingTime() {
		return new Random().nextInt(MAX_WORKING_TIME);
	}
	
	public synchronized String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public synchronized Vector<Task> getTasksPool() {
		return tasksPool;
	}

	public void setTasksPool(Vector<Task> tasksPool) {
		this.tasksPool = tasksPool;
	}

	@Override
	public void run() {
		try {
			tasksProcessor();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
