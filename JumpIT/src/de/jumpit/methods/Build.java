package de.jumpit.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Build {
	public static ItemStack build(Material m, int anzahl, int sh, String name, String lore) {
        ItemStack item = new ItemStack(m, anzahl, (short)sh);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        ArrayList<String> list = new ArrayList<String>();
        list.add(lore);
        itemm.setLore(list);
        item.setItemMeta(itemm);
        return item;
    }
}
