package me.maddin.game.Utility;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {

	private static ScheduledExecutorService scheduler;
	
	public static void init(int threads) {
		scheduler = Executors.newScheduledThreadPool(threads);
	}
	
	public static void runTaskLater(Runnable runnable, long delay) {
		scheduler.schedule(runnable, delay, TimeUnit.MILLISECONDS);
	}
	
	public static void runTaskRepeating(Runnable runnable, long initialdelay, long periodicaldelay) {
		
		scheduler.scheduleWithFixedDelay(runnable, initialdelay, periodicaldelay, TimeUnit.MILLISECONDS);
	}
	
	public static void stop() {
		scheduler.shutdownNow();
	}
}
