package com.smc.thread;

import java.util.Arrays;

import com.smc.Generator;

public class Fibonacci implements Generator<Integer>, Runnable {

	private int count;
	private final int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	private int fib(int count) {
		if (count < 2) {
			return 1;
		}
		return fib(count - 2) + fib(count - 1);
	}

	@Override
	public void run() {

		Integer[] sequence = new Integer[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = next();
		}
		System.out.println("Seq of " + n + ":" + Arrays.toString(sequence));
	}

	@Override
	public Integer next() {
		return fib(count++);
	}

}

