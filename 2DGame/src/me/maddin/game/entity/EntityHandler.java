package me.maddin.game.entity;

import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Scheduler;
import me.maddin.game.Utility.Vector2D;
import me.maddin.game.core.CoreHandler;

public class EntityHandler {
	
	private static File entityRessourceFile;
	
	private static ArrayList<Entity> registeredEntities;
	
	private static ArrayList<Entity> movingEntities;
	
	public static void init() {
		registeredEntities = new ArrayList<Entity>();
		movingEntities = new ArrayList<Entity>();
		
		entityRessourceFile = FileManager.createDirectory(CoreHandler.ressourceFile, "entities");
		
		Scheduler.runTaskRepeating(new Runnable() {
			
			@Override
			public void run() {
				for(Entity entity : movingEntities) {
					entity.setPosition(entity.getPosition().clone().add(entity.getVelocity().clone().multiply(0.01f)));
					entity.setVelocity(entity.getVelocity().clone().multiply(0.99f));
				}
			}
		}, 10, 10);
	}
	
	public static void registerMovingEntity(Entity entity) {
		if(!registeredEntities.contains(entity)) {
			registeredEntities.add(entity);
		}
		if(!movingEntities.contains(entity)) {
			movingEntities.add(entity);
		}
	}
	
	public static void registerEntity(Entity entity) {
		if(!registeredEntities.contains(entity)) {
			registeredEntities.add(entity);
		}
	} 
	
	public static void unregisterEntity(Entity entity) {
		if(registeredEntities.contains(entity)) {
			registeredEntities.remove(entity);
		}
	}
	
	public static void drawEnitites(Graphics2D g2d) {
		Vector2D tilesize = CoreHandler.getFrameSize();
		tilesize.divide(CoreHandler.getTileMapSize());
		Vector2D  entitySize = CoreHandler.getFrameSize();
		entitySize.divide(CoreHandler.getTileMapSize());
		entitySize.divide(4, 4);
		entitySize.multiply(3, 3);
		
		for(Entity entity : registeredEntities) {
				/*
				Image image = (BufferedImage) entity.getImage();
				double locationX = image.getWidth(null) / 2;
				double locationY = image.getHeight(null) / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(entity.getRoatation(), locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter((BufferedImage) entity.getImage(), null), (int) entity.getPosition().x*tilesize.x, (int) entity.getPosition().y*tilesize.y, tilesize.x, tilesize.y, null);
				*/
				
				g2d.drawImage(entity.getImage(), (int)((entity.getPosition().x+CoreHandler.getCamOffset().x)*tilesize.x), (int) ((entity.getPosition().y+CoreHandler.getCamOffset().y)*tilesize.y), entitySize.x, entitySize.y, null);
		}
	}
	
	public static File getEnitityRessourceFile() {
		return entityRessourceFile;
	}
	
}
