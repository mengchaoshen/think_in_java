package com.smc.thread;

import java.util.concurrent.Callable;

import com.smc.Generator;

public class FibonacciSum implements Generator<Integer>, Callable<Integer> {

	private int count;
	private final int n;

	public FibonacciSum(int n) {
		this.n = n;
	}

	@Override
	public Integer call() throws Exception {

		Integer sum = 0;
		for (int i = 0; i < n; i++) {
			sum += next();
		}

		return sum;
	}

	private int fib(int count) {

		if (count < 2) {
			return 1;
		}
		return fib(count - 1) + fib(count - 2);

	}

	@Override
	public Integer next() {
		return fib(count++);
	}

}
