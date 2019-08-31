package shmandocs;

import java.util.Vector;


import common.Task;

public class TeamLeader implements Runnable {

	private Vector<Task> tasksPool;
	private int maxTaskPoolSize;
	private int taskID = 0;

	public TeamLeader(Vector<Task> tasksPool, int poolSize) {
		this.tasksPool = tasksPool;
		maxTaskPoolSize = poolSize;

	}

	private synchronized Task createTask(int id) throws InterruptedException {
		Thread.sleep(500);
		return new Task(id);
	}

	public synchronized void taskScheduler() throws InterruptedException {
		
		if (!(tasksPool.size() == maxTaskPoolSize)) {
			
		tasksPool.add(createTask(taskID));
		
		System.out.println("A new task number " + taskID + " is created. Pool size is " + tasksPool.size());
		taskID++;
		}
		
		
	
	}

	@Override
	public void run() {
		try {

			taskScheduler();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
