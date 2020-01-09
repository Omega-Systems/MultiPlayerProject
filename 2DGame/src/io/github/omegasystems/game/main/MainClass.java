package me.maddin.game.main;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Scheduler;
import me.maddin.game.Utility.Vector2D;

public class MainClass {

	private static Game game;
	
	public static final int TILESIZE = 64;
	
	public static void main(String[] args) {
		FileManager.init();
		Scheduler.init(10);
		
		game = new Game("2D Game", new Vector2D(400, 400));
		game.makeVisible();
	}

	public static Game getGame() {
		return game;
	}
}
