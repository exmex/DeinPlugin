package de.spigotplugins.freebuild.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack createItem(Material material, int anzahl, int subid, String Displayname, String lore){
		ItemStack i = new ItemStack(material, anzahl, (short)subid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		ArrayList<String> list = new ArrayList<>();
		list.add(lore);
		im.setLore(list);
		i.setItemMeta(im);
		return i;
	}
}
