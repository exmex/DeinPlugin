package de.codeexception.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {

	  public static ItemStack create(Material mat,String name,int amount) {
	    ItemStack i = new ItemStack(mat, amount);
	    ItemMeta m = i.getItemMeta();
	    m.setDisplayName(name);
	    i.setItemMeta(m);
	    return i;
	  }
	  public static ItemStack get(Material mat, int amount) {
		  ItemStack item = new ItemStack(mat, amount);
		  ItemMeta meta = item.getItemMeta();
		  meta.spigot().setUnbreakable(true);
		  item.setItemMeta(meta);
		  return item;
	  }
	  public static ItemStack ench(Enchantment e,int level,Material mat,String name) {
		    ItemStack i = new ItemStack(mat, 1);
		    ItemMeta m = i.getItemMeta();
		    m.setDisplayName(name);
		    i.setItemMeta(m);
		    i.addUnsafeEnchantment(e, level);
		    return i;
	  }
	  public static void getItems(Player p) {
		  Inventory i = p.getInventory();
		  i.clear();
		  i.setItem(0, get(Material.IRON_SWORD, 1));
		  i.setItem(1, get(Material.FISHING_ROD, 1));
		  i.setItem(2, get(Material.BOW, 1));
		  i.setItem(3, new ItemStack(Material.ARROW, 16));
		  p.getInventory().setHelmet(get(Material.CHAINMAIL_HELMET, 1));
		  p.getInventory().setChestplate(get(Material.IRON_CHESTPLATE, 1));
		  p.getInventory().setLeggings(get(Material.IRON_LEGGINGS, 1));
		  p.getInventory().setBoots(get(Material.CHAINMAIL_BOOTS, 1));
	  }
	  public static void getLobbyItems(Player p) {
		  Inventory i = p.getInventory();
		  i.setItem(8, create(Material.GLOWSTONE_DUST, "§7zurück zur §aLobby ", 1));
		  p.getInventory().setHelmet(get(Material.LEATHER_HELMET, 1));
		  p.getInventory().setChestplate(get(Material.LEATHER_CHESTPLATE, 1));
		  p.getInventory().setLeggings(get(Material.LEATHER_LEGGINGS, 1));
		  p.getInventory().setBoots(get(Material.LEATHER_BOOTS, 1));
	  }
}
