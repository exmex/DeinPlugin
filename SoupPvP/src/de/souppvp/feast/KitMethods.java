package de.souppvp.feast;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;

public class KitMethods {

	
	
	public static void setAnfänger(Player p){
		p.getInventory().clear();
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = Suppe.getItemMeta();
		sm.setDisplayName("§3Suppe");
		Suppe.setItemMeta(sm);
		
		ItemStack schwert = new ItemStack(Material.IRON_SWORD);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack b = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack bb = new ItemStack(Material.IRON_BOOTS);
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(b);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(bb);
		p.getInventory().setItem(0, schwert);
		for(int i = 1 ; i < 36 ; i++){
			p.getInventory().setItem(i, Suppe);
		}
		
		FeastData.removeFormAllKits(p);
		Data.FeastNoKit.remove(p);
		Data.FeastJoin.add(p);
		FeastData.ANFÄNGER_KIT.add(p);
		
	}
	public static void setBogen(Player p){
		p.getInventory().clear();
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = Suppe.getItemMeta();
		sm.setDisplayName("§3Suppe");
		Suppe.setItemMeta(sm);
		
		ItemStack schwert = new ItemStack(Material.STONE_SWORD);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack b = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack bb = new ItemStack(Material.IRON_BOOTS);
		ItemStack bogen = new ItemStack(Material.BOW);
		ItemStack pfeil = new ItemStack(Material.ARROW, 16);
		
		p.getInventory().setItem(0, schwert);
		p.getInventory().setItem(1, bogen);
		p.getInventory().setItem(35, pfeil);
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(b);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(bb);
		p.getInventory().setItem(0, schwert);
		for(int i = 2 ; i < 35 ; i++){
			p.getInventory().setItem(i, Suppe);
		}
		
		
		
		FeastData.removeFormAllKits(p);
		Data.FeastNoKit.remove(p);
		Data.FeastJoin.add(p);
		FeastData.BOGENSCHÜTZE_KIT.add(p);
	}
	public static void setKangaroo(Player p){
		p.getInventory().clear();
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = Suppe.getItemMeta();
		sm.setDisplayName("§3Suppe");
		Suppe.setItemMeta(sm);
		
		ItemStack schwert = new ItemStack(Material.IRON_SWORD);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack b = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack bb = new ItemStack(Material.IRON_BOOTS);
		ItemStack bogen = new ItemStack(Material.FIREWORK);
		ItemMeta bm = bogen.getItemMeta();
		bm.setDisplayName("§eKangaroo §7» §f§lKLICK");
		bogen.setItemMeta(bm);
		
		p.getInventory().setItem(0, schwert);
		p.getInventory().setItem(1, bogen);
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(b);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(bb);
		p.getInventory().setItem(0, schwert);
		for(int i = 2 ; i < 36 ; i++){
			p.getInventory().setItem(i, Suppe);
		}

		FeastData.removeFormAllKits(p);
		Data.FeastNoKit.remove(p);
		Data.FeastJoin.add(p);
		FeastData.KANGAROO_KIT.add(p);
	}
	public static void setSuppenmeister(Player p){
		p.getInventory().clear();
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = Suppe.getItemMeta();
		sm.setDisplayName("§3Suppe");
		Suppe.setItemMeta(sm);
		
		ItemStack schwert = new ItemStack(Material.IRON_SWORD);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack b = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack bb = new ItemStack(Material.IRON_BOOTS);
		ItemStack bogen = new ItemStack(Material.LEATHER);
		ItemMeta bm = bogen.getItemMeta();
		bm.setDisplayName("§eSuppen §7» §f§lKLICK");
		bogen.setItemMeta(bm);
		
		p.getInventory().setItem(0, schwert);
		p.getInventory().setItem(1, bogen);
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(b);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(bb);
		p.getInventory().setItem(0, schwert);
		for(int i = 2 ; i < 36 ; i++){
			p.getInventory().setItem(i, Suppe);
		}

		FeastData.removeFormAllKits(p);
		Data.FeastNoKit.remove(p);
		Data.FeastJoin.add(p);
		FeastData.SUPPENMEISTER_KIT.add(p);
	}
	public static void setAxt(Player p){
		p.getInventory().clear();
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = Suppe.getItemMeta();
		sm.setDisplayName("§3Suppe");
		Suppe.setItemMeta(sm);
		
		ItemStack schwert = new ItemStack(Material.DIAMOND_AXE);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack b = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack bb = new ItemStack(Material.IRON_BOOTS);
		
		
		p.getInventory().setItem(0, schwert);
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(b);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(bb);
		p.getInventory().setItem(0, schwert);
		for(int i = 1 ; i < 36 ; i++){
			p.getInventory().setItem(i, Suppe);
		}

		FeastData.removeFormAllKits(p);
		Data.FeastNoKit.remove(p);
		Data.FeastJoin.add(p);
		FeastData.AXT_KIT.add(p);
	}
	
	public static void getLastPlayerKit(Player p){
		if(FeastData.ANFÄNGER_KIT.contains(p)){
			setAnfänger(p);
			return;
		}
		if(FeastData.BOGENSCHÜTZE_KIT.contains(p)){
			setBogen(p);
			return;
		}
		if(FeastData.KANGAROO_KIT.contains(p)){
			setKangaroo(p);
			return;
		}
		if(FeastData.AXT_KIT.contains(p)){
			setAxt(p);
			return;
		}
		
	}
	
}
