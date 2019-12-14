package de.ttt.manager;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack CreateItem(Material m, int Anzahl, int SubID, String Displayname, String lore){
	
	ItemStack i = new ItemStack(m, Anzahl, (short) SubID);
	ItemMeta im = i.getItemMeta();
	im.setDisplayName(Displayname);
	ArrayList<String> list = new ArrayList<>();
	list.add(lore);
	im.setLore(list);
	i.setItemMeta(im);
	return i;
	
		
	}
}
