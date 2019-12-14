package de.Niclas.EarlyHG;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class JoinKit {

	public static void getItems(Player p){
		p.getInventory().clear();
		
		ItemStack ih = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta ihmeta = ih.getItemMeta();
		ihmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		ih.setItemMeta(ihmeta);
		ItemStack iha = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta ihmetaa = iha.getItemMeta();
		ihmetaa.addEnchant(Enchantment.DURABILITY, 1, true);
		iha.setItemMeta(ihmetaa);
		ItemStack ihq = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemMeta ihmetaq = ihq.getItemMeta();
		ihq.setItemMeta(ihmetaq);
		ItemStack ihe = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta ihmetae = ihe.getItemMeta();
		ihmetae.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		ihe.setItemMeta(ihmetae);
		ItemStack ihe1 = new ItemStack(Material.WOOD_AXE);
		ItemMeta ihmetae1 = ihe1.getItemMeta();
		ihmetae1.addEnchant(Enchantment.DURABILITY, 3, true);
		ihe1.setItemMeta(ihmetae1);
		
		p.getInventory().setHelmet(ih);
		p.getInventory().setChestplate(iha);
		p.getInventory().setLeggings(ihq);
		p.getInventory().setBoots(ihe);

		p.getInventory().setItem(0, ihe1);

		
	}
}
