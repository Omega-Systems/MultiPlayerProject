package io.github.omegasystems.game.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import io.github.omegasystems.game.entity.Player;
import io.github.omegasystems.game.gui.inventory.BlockItemStack;
import io.github.omegasystems.game.main.MainClass;
import io.github.omegasystems.game.tiles.Tile;
import io.github.omegasystems.game.tiles.TileClickEvent;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent event) {
		Player player = MainClass.getGame().getPlayer();
		//TODO: TilePos Berechnung
		Tile tile = player.getTileStandingOn();
		if(tile.hasForeground()) {
			tile.getForeGroundTile().onClick(new TileClickEvent(player, event.getButton()));
		} else if (player.getItemInHand() instanceof BlockItemStack) {
			System.out.println("Debug1");
			tile.setFGTile(((BlockItemStack)player.getItemInHand()).getNewForeGroundTile(tile.getPos()));
			if(player.getItemInHand().getAmount()<2) {
				player.setItemInHand(null);
			} else {
				player.getItemInHand().setAmount(player.getItemInHand().getAmount()-1);
			}
		}
		if(player.getItemInHand()!=null) {
			if(player.getItemInHand() instanceof BlockItemStack) {
				System.out.println("Debug1");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	public MouseInput(JComponent component) {
		component.addMouseListener(this);
	}
	
}
