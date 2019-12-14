package oneline.methods;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Inventory {

	
	public static void getNormalInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, createItemWE(Material.STICK, 1, 0, "§eStick", Enchantment.KNOCKBACK, 1));
		p.getInventory().setItem(8, createItem(Material.NETHER_STAR, 1, 0, "§eStatistiken"));
	}
	public static ItemStack createItem(Material mat, int anzahl, int shortid, String Displayname){
		ItemStack i = new ItemStack(mat, anzahl, (short)shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		i.setItemMeta(im);
		return i;
	}
	public static ItemStack createItemWE(Material mat, int anzahl, int shortid, String Displayname, Enchantment enchant, int staerke){
		ItemStack i = new ItemStack(mat, anzahl, (short)shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		im.addEnchant(enchant, staerke, true);
		i.setItemMeta(im);
		return i;
	}
	public static ItemStack createItemWD(Material mat, int anzahl, int shortid, String Displayname, int durability){
		ItemStack i = new ItemStack(mat, anzahl, (short)shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		i.setDurability((short) durability);
		i.setItemMeta(im);
		return i;
	}
}
