package de.jumpit.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Items {

	public static void setLobbyItems(Player p){
		p.getInventory().setItem(3, Build.build(Material.COMPASS, 1, 0, "§6Auswahl", "§7Wähle aus was du tun möchtest"));
		p.getInventory().setItem(5, Build.build(Material.GOLD_INGOT, 1, 0, "§6Shop", "§7Schalte dir neue Sachen frei"));
	}
}
