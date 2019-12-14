package de.souppvp.onevsonemanager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.inventivetalent.bossbar.BossBarAPI;

import de.souppvp.data.ItemCreator;

public class OneVSOneLobby {

	public static void setOneVSOneInventory(Player p){
		BossBarAPI.removeBar(p);
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		p.getInventory().setItem(0, ItemCreator.CreateItemwhitMaterial(Material.DIAMOND_SWORD, 0, 1, "§eGegner herausfordern §7[§aALPHA§7]", null));
		p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 8, 1, "§dWarteschlange §7» [Aus]", null));
		p.getInventory().setItem(8, ItemCreator.CreateItemwhitMaterial(Material.BARRIER, 0, 1, "§c1vs1 Verlassen", null));
		p.updateInventory();
	}
}
