package io.github.omegasystems.game.main;

import io.github.omegasystems.game.Utility.FileManager;
import io.github.omegasystems.game.Utility.Scheduler;
import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.core.Game;

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
