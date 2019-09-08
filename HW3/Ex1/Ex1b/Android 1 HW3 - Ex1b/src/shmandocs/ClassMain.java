package shmandocs;


import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.Task;

public class ClassMain {

	public static void main(String[] args) {
		int maxTasks = 5;
		Vector<Task> task_pool = new Vector<Task>();
		Vector<Task> doneTasks = new Vector<Task>();
		ExecutorService executor = Executors.newFixedThreadPool(maxTasks);
		
		TeamLeader tl = new TeamLeader(task_pool, maxTasks);
		

		TeamMember[] team = new TeamMember[5];
		team[0] = new Programmer(task_pool, doneTasks, "John");
		team[1] = new Programmer(task_pool, doneTasks, "Jane");
		team[2] = new Tester(task_pool, doneTasks, "Kate");
		team[3] = new Tester(task_pool, doneTasks, "Dave");
		team[4] = new Researcher(task_pool, doneTasks, "Guy");

		
		while (!executor.isShutdown()) {
		
			for (TeamMember tm : team) {
				executor.execute(tl);
				executor.execute(tm);

			}
			
		}
		
		
		
		executor.shutdown();
		
	}
	
}
