package io.github.omegasystems.game.tiles;

import java.awt.Graphics2D;

import io.github.omegasystems.game.main.MainClass;
import io.github.omegasystems.game.world.World;

public class TileHandler {
	
	public static void renderBG(Graphics2D g2d, int frameSizeX, int frameSizeY, World world) {

		for(int x = -1; x<=frameSizeX/MainClass.TILESIZE+1; x++) {
			for(int y = -1; y<=frameSizeY/MainClass.TILESIZE+1; y++) {
				Tile tile = world.getTile(world.getTileOffsetX()+x, world.getTileOffsetY()+y);
				g2d.drawImage(tile.getBackgroundImage(), null, x*MainClass.TILESIZE, y*MainClass.TILESIZE);
				if(tile.hasForeground()&&!tile.getForeGroundTile().isinFrontOfEntities()) {
					g2d.drawImage(tile.getForeGroundTile().getTexture(), null, x*MainClass.TILESIZE, y*MainClass.TILESIZE);
				}
			}
		}
	}
	
	public static void renderFG(Graphics2D g2d, int frameSizeX, int frameSizeY, World world) {

		for(int x = -1; x<=frameSizeX/MainClass.TILESIZE+1; x++) {
			for(int y = -1; y<=frameSizeY/MainClass.TILESIZE+1; y++) {
				Tile tile = world.getTile(world.getTileOffsetX()+x, world.getTileOffsetY()+y);
				if(tile.hasForeground()&&tile.getForeGroundTile().isinFrontOfEntities()) {
					g2d.drawImage(tile.getForeGroundTile().getTexture(), null, x*MainClass.TILESIZE, (y+1)*MainClass.TILESIZE-tile.getForeGroundTile().getTexture().getHeight());
				}
			}
		}
	}
}
