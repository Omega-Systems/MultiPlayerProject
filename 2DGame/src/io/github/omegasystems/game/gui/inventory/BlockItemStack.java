package io.github.omegasystems.game.gui.inventory;

import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.tiles.ForeGroundTile;
import io.github.omegasystems.game.tiles.ForeGroundTileTemplate;

public class BlockItemStack extends ItemStack{

	private ForeGroundTileTemplate template;
	
	public BlockItemStack(Ressource ressource, int amount, ForeGroundTileTemplate foreGroundTileTemplate) {
		super(ressource, amount);
		this.template = foreGroundTileTemplate;
	}

	public ForeGroundTile getNewForeGroundTile(Vector2D pos) {
		return template.getNewForeGroundTile(pos);
	}
}
