package io.github.omegasystems.game.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JComponent;

public class InputMapping {

	public static final int moveRight = 0;
	public static final int moveLeft = 1;
	public static final int moveUp = 2;
	public static final int moveDown = 3;
	public static final int pickUp = 4;
	
	private static HashMap<Integer, Integer> keyMappings;
	public static HashMap<Integer, Boolean> actionMappings;
	
	
	public static void registerKeys(JComponent jComponent) {
		keyMappings = new HashMap<Integer, Integer>();
		actionMappings = new HashMap<Integer, Boolean>();
		
		keyMappings.put(KeyEvent.VK_W, moveUp);
		keyMappings.put(KeyEvent.VK_S, moveDown);
		keyMappings.put(KeyEvent.VK_D, moveRight);
		keyMappings.put(KeyEvent.VK_A, moveLeft);
		
		jComponent.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent event) {
				try {
					actionMappings.put(keyMappings.get(event.getKeyCode()), false);
					System.out.println("Key released");
				} catch (Exception e) {}
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				try {
					actionMappings.put(keyMappings.get(event.getKeyCode()), true);
				} catch (Exception e) {}
			}
		});
	}
	
	public static boolean get(int actionCode) {
		try {
			return actionMappings.get(actionCode);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
