package bridgefighter.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Inventorys {

	public static void getPlayerNormalInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, ItemCreator.createItem(Material.DIAMOND_SWORD, 1, 0, "§eHerausfordern §8[§aLinksklick§8]", "§7Fordere einen Gegner zum Kampf heraus!"));
		p.getInventory().setItem(7, ItemCreator.createItemWithID(137, 1, 0, "§3§lEinstellungen", "§7Stelle grundlegende Einstellungen um!"));
		p.getInventory().setItem(8, ItemCreator.createItem(Material.SLIME_BALL, 1, 0, "§cRunde verlassen", "§7Verlasse die Runde!"));
		
		p.updateInventory();
	}
}
