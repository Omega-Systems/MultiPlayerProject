package me.maddin.game.main;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Scheduler;
import me.maddin.game.Utility.Vector2D;
import me.maddin.game.Utility.Vector2Df;
import me.maddin.game.core.ActionsHandler;
import me.maddin.game.core.Tickable;
import me.maddin.game.entity.EntityHandler;
import me.maddin.game.entity.Player;
import me.maddin.game.tiles.TileHandler;
import me.maddin.game.world.World;

public class Game {
	
	
	private World mainWorld;
	
	private Player player;
	
	public JFrame frame;
	
	private int currentFps;
	private int fpsCount;
	
	public static int targetFPS = 60;
	
	public Game(String title, Vector2D size) {
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
		TileHandler.init();
		mainWorld = new World();
		player = new Player(new Vector2Df(0, 0), 100, "Ibims", 0);
		Tickable.createTickingThread(50);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void render(Graphics2D g2d) {
		int screenWidth = frame.getWidth();
		int screenHeight = frame.getHeight();
		mainWorld.setCamOffset(new Vector2Df(player.getPosition().x-(screenWidth/2/MainClass.TILESIZE), player.getPosition().y-(screenHeight/2/MainClass.TILESIZE)));
		g2d.translate(-32, -32);
		TileHandler.render(g2d, screenWidth, screenHeight, mainWorld);
		EntityHandler.renderEntities(g2d, screenWidth, screenHeight, mainWorld);
		g2d.translate(32, 32);
		g2d.drawString("FPS: " + currentFps + ", Target FPS: " + targetFPS, 20, 20);
	}
	
	private void createRenderingTask() {
		Scheduler.runTaskRepeatingFast(new Runnable() {
			
			private long lasttime;
			private int delay = 1000000000/targetFPS;
			
			@Override
			public void run() {
				if(lasttime+delay<System.nanoTime()) {
					delay = 1000000000/targetFPS;
					currentFps = (int) (1000000000/(System.nanoTime()-lasttime));
					frame.repaint();
					lasttime = System.nanoTime();
					fpsCount++;
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
