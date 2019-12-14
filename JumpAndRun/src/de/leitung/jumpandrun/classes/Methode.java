package de.leitung.jumpandrun.classes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Methode {

	public static void setStartItem(Player p){
	p.getInventory().clear();
	p.getInventory().setHelmet(null);
	p.getInventory().setChestplate(null);
	p.getInventory().setLeggings(null);
	p.getInventory().setBoots(null);
	ItemStack i = new ItemStack(Material.PAPER);
	ItemMeta im = i.getItemMeta();
	im.setDisplayName("§6JumpAndRun-Liste");
	im.addEnchant(Enchantment.DURABILITY, 1, true);
	i.setItemMeta(im);
	}
}
