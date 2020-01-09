package io.github.omegasystems.game.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import io.github.omegasystems.game.Utility.FileManager;
import io.github.omegasystems.game.Utility.Scheduler;
import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.Utility.Vector2Df;
import io.github.omegasystems.game.entity.EntityHandler;
import io.github.omegasystems.game.entity.Player;
import io.github.omegasystems.game.gui.GUIHandler;
import io.github.omegasystems.game.gui.inventory.Inventory;
import io.github.omegasystems.game.gui.inventory.InventoryHandler;
import io.github.omegasystems.game.gui.inventory.Ressource;
import io.github.omegasystems.game.main.MainClass;
import io.github.omegasystems.game.tiles.TileHandler;
import io.github.omegasystems.game.tiles.TileRegistry;
import io.github.omegasystems.game.world.World;

public class Game {
	
	
	private World mainWorld;
	
	private Player player;
	
	public JFrame frame;
	
	private int currentFps;
	private int fpsCount;	
	
	public static int targetFPS = 60;
	
	public static BufferedImage playerImage;
	
	public Game(String title, Vector2D size) {
		playerImage = FileManager.getImage(FileManager.entityRessourceFile, "Barrel.png");
		initGame();
		initFrame(title, size);	
	}
	
	private void initFrame(String title, Vector2D size) {
		frame = new JFrame(title);
		MainGamePanel mainGamePanel = new MainGamePanel();
		mainGamePanel.setDoubleBuffered(true);
		mainGamePanel.setOpaque(true);
		mainGamePanel.setFocusable(true);
		mainGamePanel.requestFocusInWindow();
		frame.add(mainGamePanel);
		//InputMapping.registerKeys(mainGamePanel);
		new ActionsHandler(mainGamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(FileManager.getImage(FileManager.entityRessourceFile, "Barrel.png"));
		frame.setSize(size.x, size.y);
	}
	
	private void initGame() {
		Ressource.loadRessources();
		GUIHandler.init();
		TileRegistry.registerTemplates();
		
		InventoryHandler.setDrawnInventory(new Inventory(4, 7, "Ibims, eins Inventar!"), new Vector2Df(0, 0));
		
		mainWorld = new World(21);
		player = new Player(new Vector2Df(0, 0), 100, "Ibims", mainWorld);
		Tickable.createTickingThread(50);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void render(Graphics2D g2d) {
		int screenWidth = frame.getWidth();
		int screenHeight = frame.getHeight();
		mainWorld.setCamOffset(new Vector2Df(player.getPosition().x-(screenWidth/2/MainClass.TILESIZE), player.getPosition().y-(screenHeight/2/MainClass.TILESIZE)));
		//TODO: Berechnung Offset mit screenDimension not working properly
		float offsetX =  (mainWorld.getCamOffsetX()*MainClass.TILESIZE) % MainClass.TILESIZE-screenWidth%(MainClass.TILESIZE/2);
		float offsetY = (mainWorld.getCamOffsetY()*MainClass.TILESIZE) % MainClass.TILESIZE-screenHeight%(MainClass.TILESIZE/2);
		
		g2d.translate(-offsetX, -offsetY);
		g2d.setColor(Color.WHITE);
		
		TileHandler.renderBG(g2d, screenWidth, screenHeight, mainWorld);
		EntityHandler.renderEntities(g2d, screenWidth, screenHeight, mainWorld);
		TileHandler.renderFG(g2d, screenWidth, screenHeight, mainWorld);

		g2d.translate(offsetX, offsetY);
		
		GUIHandler.render(g2d, screenWidth, screenHeight);
		
		g2d.drawString("FPS: " + currentFps + ", Target FPS: " + targetFPS, 20, 20);
		g2d.drawString("OffsetX: "+offsetX+", OffsetY: "+offsetY, 20, 40);
		fpsCount++;
	}
	
	private void createRenderingTask() {
		Scheduler.runTaskRepeatingFast(new Runnable() {
			
			private long lasttime;
			private int delay = 1000000000/targetFPS;
			
			@Override
			public void run() {
				if(targetFPS>0) {
					delay = 1000000000/targetFPS;
				} else {
					delay=0;
				}
				if(lasttime+delay<System.nanoTime()) {
					currentFps = (int) (1000000000/(System.nanoTime()-lasttime));
					frame.repaint();
					lasttime = System.nanoTime();
				}				
			}
		}, 10, 50);
		Scheduler.runTaskRepeating(new Runnable() {
			
			@Override
			public void run() {
				currentFps = fpsCount;
				fpsCount=0;
			}
		}, 10, 1000);
	}
	
	public void makeVisible() {
		frame.setVisible(true);
		frame.requestFocus();
		
		createRenderingTask();
	}
	
}
