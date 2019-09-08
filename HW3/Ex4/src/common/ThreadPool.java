package common;

import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private LinkedBlockingQueue taskQueue = null;
    private Vector<PoolWorker> threads = new Vector<PoolWorker>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThread){
        taskQueue = new LinkedBlockingQueue(noOfThread);

        for(int i=0; i<noOfThread; i++){
            threads.add(new PoolWorker(taskQueue));
        }
        for(PoolWorker thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void shutdown(){
        this.isStopped = true;
        for(PoolWorker thread : threads){
           thread.doStop();
        }
    }

}
