package com.smc.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DaemonThreadPoolExector extends ThreadPoolExecutor{

	public DaemonThreadPoolExector() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(),
				new DaemonThreadFactory());
	}

}
