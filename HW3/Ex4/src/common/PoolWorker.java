package common;

import java.util.concurrent.LinkedBlockingQueue;

public class PoolWorker extends Thread {
	private LinkedBlockingQueue taskQueue = new LinkedBlockingQueue();
    private boolean isStopped = false;

    public PoolWorker(LinkedBlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable task = (Runnable) taskQueue.poll();
                task.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}

