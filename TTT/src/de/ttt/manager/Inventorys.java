package de.ttt.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Inventorys {

	public static void getLobbyItems(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, ItemCreator.CreateItem(Material.NETHER_STAR, 1, 0, "§ePässe", "§7Wähle Pässe aus!"));
		p.getInventory().setItem(8, ItemCreator.CreateItem(Material.SLIME_BALL, 1, 0, "§cRunde verlassen", "§7Verlasse die Runde"));
		p.updateInventory();
	}
}
