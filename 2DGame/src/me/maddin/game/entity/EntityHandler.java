package me.maddin.game.entity;

import java.awt.Graphics2D;

import me.maddin.game.main.MainClass;
import me.maddin.game.main.World;

public class EntityHandler {
	
	public static void renderEntities(Graphics2D g2d, int frameSizeX, int frameSizeY, World world) {
		float offsetX =  world.getCamOffsetX()*MainClass.TILESIZE;
		float offsetY = world.getCamOffsetY()*MainClass.TILESIZE;
		
		g2d.translate(-offsetX, -offsetY);
		
		for(Entity entity : world.getRegisteredEntities()) {
			int entityOffsetX = (int)(entity.getPosition().x*MainClass.TILESIZE);
			int entityOffsetY = (int)(entity.getPosition().y*MainClass.TILESIZE);
			g2d.drawImage(entity.getImage(), null, entityOffsetX, entityOffsetY);
			if(entity.nameVisible()) {
				g2d.drawString(entity.getCustomName(), entityOffsetX+(entity.getCustomName().length()*3), entityOffsetY-10);
			}
				
		}
		g2d.translate(offsetX, offsetY);
	}	
}