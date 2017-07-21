package com.damonx.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(()->{
        	while(true){
        		String threadName = Thread.currentThread().getName();
        		System.out.println("Hello " + threadName);
                TimeUnit.SECONDS.sleep(2);        		
        	}
        });
        
        shutdown(executor);

	}

	public static void shutdown(ExecutorService executor) {
		try {
            //System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                //System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            //System.out.println("shutdown finished");
        }
	}
}
