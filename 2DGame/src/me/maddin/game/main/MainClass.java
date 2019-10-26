package me.maddin.game.main;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Scheduler;
import me.maddin.game.core.CoreHandler;

public class MainClass {

	public static void main(String[] args) {
		FileManager.load();
		Scheduler.init(10);
		
		CoreHandler.init(16, 9);
	}

}
