package me.maddin.game.main;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.core.CoreHandler;

public class MainClass {

	public static void main(String[] args) {
		FileManager.load();
		
		CoreHandler.init(16, 9);
	}

}
