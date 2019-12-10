package me.maddin.game.core;

import java.util.ArrayList;

import me.maddin.game.Utility.Scheduler;

public interface Tickable {

	static ArrayList<Tickable> registeredTickables = new ArrayList<Tickable>();
	
	public static void registerTickable(Tickable tickable) {
		if(!registeredTickables.contains(tickable)) {
			registeredTickables.add(tickable);
		}
	}
	
	public static void unregisterTickable(Tickable tickable) {
		if(registeredTickables.contains(tickable)) {
			registeredTickables.remove(tickable);
		}
	}
	
	public static void createTickingThread(int tps) {
		Scheduler.runTaskRepeating(new Runnable() {
			private long lasttime = 0;
			private long delay = 1000/tps;
			
			@Override
			public void run() {
				if(lasttime+delay<System.currentTimeMillis()) {
					float deltaT = ((float)(System.currentTimeMillis()-lasttime))/1000f;
					lasttime = System.currentTimeMillis();
					for(Tickable tickable : registeredTickables) {
						tickable.tick(deltaT);
					}
				}
			}
		}, 10, 10);
	}
	
	public void tick(float deltaT);
	
}
