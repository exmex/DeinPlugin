package de.spigotplugins.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inv {

	public static void getPlayerStandart(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(createItemStack(Material.IRON_HELMET, 1, 0, "§aHelm"));
		p.getInventory().setChestplate(createItemStack(Material.IRON_CHESTPLATE, 1, 0, "§aBrustpanzer"));
		p.getInventory().setLeggings(createItemStack(Material.IRON_LEGGINGS, 1, 0, "§aHose"));
		p.getInventory().setBoots(createItemStack(Material.IRON_BOOTS, 1, 0, "§aSchuhe"));
		p.getInventory().setItem(0, createItemStack(Material.STONE_SWORD, 1, 0, "§aSchwert"));
		p.getInventory().setItem(1, createItemStack(Material.FISHING_ROD, 1, 0, "§aAngel"));
		p.getInventory().setItem(2, createItemStack(Material.BOW, 1, 0, "§aBow"));
		ItemStack in = new ItemStack(Material.ARROW, 3);
		p.getInventory().setItem(8, in);
		p.setHealth(20);
		p.setFoodLevel(20);
	}
	public static ItemStack createItemStack(Material m, int anzahl, int shortid, String DM){
		ItemStack i = new ItemStack(m, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DM);
		i.setItemMeta(im);
		return i;
	}
}
