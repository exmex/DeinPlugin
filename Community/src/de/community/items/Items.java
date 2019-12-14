package de.community.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	public static ItemStack createItem(Material mat, int subid, String displayname ) {

        ItemStack item = new ItemStack(mat, 1, (short) subid );
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);
 
        return item;
    }
}
