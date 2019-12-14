package de.leitung.lobby.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SkyWarsCloud {
	public static BungeeServer bs = BungeeServer.addServer("SkyWars-01", "claymc.net", 5000, 10);
	public static void setCloud(Player p){
		Inventory inv = Bukkit.createInventory(null, 36, "§e§lSkyWars");
		ItemStack ia = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		
		ItemStack SkyWars1 = new ItemStack(Material.STAINED_CLAY, 1, (short)5);
		ItemMeta sm1 = SkyWars1.getItemMeta();
		sm1.setDisplayName("Server Status: §a" + bs.getMotd());
		SkyWars1.setItemMeta(sm1);
		inv.setItem(0, ia);
		inv.setItem(1, ia);
		inv.setItem(2, ia);
		inv.setItem(3, ia);
		inv.setItem(4, ia);
		inv.setItem(5, ia);
		inv.setItem(6, ia);
		inv.setItem(7, ia);
		inv.setItem(8, ia);
		inv.setItem(9, ia);
		inv.setItem(10, SkyWars1);
		inv.setItem(17, ia);
		inv.setItem(18, ia);
		inv.setItem(26, ia);
		inv.setItem(27, ia);
		inv.setItem(28, ia);
		inv.setItem(29, ia);
		inv.setItem(30, ia);
		inv.setItem(31, ia);
		inv.setItem(32, ia);
		inv.setItem(33, ia);
		inv.setItem(34, ia);
		inv.setItem(35, ia);

		p.openInventory(inv);
	}
}
