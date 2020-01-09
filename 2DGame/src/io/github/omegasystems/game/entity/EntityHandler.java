package io.github.omegasystems.game.entity;

import java.awt.Graphics2D;

import io.github.omegasystems.game.main.MainClass;
import io.github.omegasystems.game.world.World;

public class EntityHandler {
	
	public static void renderEntities(Graphics2D g2d, int frameSizeX, int frameSizeY, World world) {		
		for(Entity entity : world.getRegisteredEntities()) {
			int entityOffsetX = (int)((entity.getPosition().x-world.getTileOffsetX())*MainClass.TILESIZE);
			int entityOffsetY = (int)((entity.getPosition().y-world.getTileOffsetY())*MainClass.TILESIZE);
			g2d.drawImage(entity.getImage(), null, entityOffsetX, entityOffsetY);
			if(entity.nameVisible()) {
				g2d.drawString(entity.getCustomName(), entityOffsetX+(entity.getCustomName().length()*3), entityOffsetY-10);
			}
				
		}
	}	
}