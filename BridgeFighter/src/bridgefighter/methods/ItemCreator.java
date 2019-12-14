package bridgefighter.methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack createItem(Material m, int anzahl, int shortid, String DisplayName, String Lore) {
		ItemStack i = new ItemStack(m, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		i.setItemMeta(im);
		return i;

	}

	public static ItemStack createItemWithID(int id, int anzahl, int shortid, String DisplayName, String Lore) {
		ItemStack i = new ItemStack(id, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		i.setItemMeta(im);
		return i;

	}
}
