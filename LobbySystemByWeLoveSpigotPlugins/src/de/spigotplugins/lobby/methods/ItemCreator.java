package de.spigotplugins.lobby.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack createItemWithoutLore(Material mat, int Anzahl, int SubID, String DisplayName){
		ItemStack i = new ItemStack(mat);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		i.setItemMeta(im);
		return i;
	}
	public static ItemStack createItemWithLore(Material mat, int Anzahl, int SubID, String DisplayName, String Lore){
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add(Lore);
		ItemStack i = new ItemStack(mat);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(list);
		i.setItemMeta(im);
		return i;
	}
	public static ItemStack createIDWithoutLore(int id, int Anzahl, int SubID, String DisplayName){
		ItemStack i = new ItemStack(id);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		i.setItemMeta(im);
		return i;
	}
	public static ItemStack createIDWithLore(int id, int Anzahl, int SubID, String DisplayName, String Lore){
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add(Lore);
		ItemStack i = new ItemStack(id);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(list);
		i.setItemMeta(im);
		return i;
	}
}
