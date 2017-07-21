package com.damonx.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LockExample {
	int count = 0;

	private void increment() {
		count = count + 1;
	}

	public void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));

		ExecutorExample.shutdown(executor);

		System.out.println(count); // 9965
	}

	public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i->{
        	new LockExample().execute();
        });
	}

}
