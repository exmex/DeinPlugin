package lobby.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
	public static ItemStack CreateItemwhitID(int id,int subid,int amount , String DisplayName,ArrayList<String> lore){
		
		ItemStack is = new ItemStack(id,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
		
	}
	
	public static ItemStack CreateItemwhitMaterial(Material m,int subid,int amount , String DisplayName,String lore){
		ArrayList<String> list = new ArrayList<>();
		list.add(lore);
		ItemStack is = new ItemStack(m,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(list);
		is.setItemMeta(im);
		return is;
		
	}
	
public static ItemStack CreateItemwhitMaterial(Material m,int subid,int amount ,int level, String KitName,String lore1, String lore2){
		
		ItemStack is = new ItemStack(m,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("§aKit §7» §e" + KitName);
		ArrayList<String> list = new ArrayList<>();
		list.add(" ");
		list.add("§7Benötigte §eLevel§7 » §6" + level);
		list.add(" ");
		list.add("§9Beschreibung §7»");
		list.add("§b§m----------------------");
		list.add("§7" + lore1);
		list.add("§7" + lore2);
		list.add("§b§m----------------------");
		list.add(" ");
		im.setLore(list);
		is.setItemMeta(im);
		return is;
		
	}
public static ItemStack CreateKit(Material m,int subid,int amount ,int level,String Rang, String KitName,String lore1, String lore2, String Cooldown){
	
	ItemStack is = new ItemStack(m,amount,(short)subid);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName("§aKit §7» §e" + KitName);
	ArrayList<String> list = new ArrayList<>();
	list.add(" ");
	list.add("§7Benötigte §eLevel§7 » §6" + level);
	list.add("§9oder");
	list.add("§7» " + Rang);
	list.add("    ");
	list.add("§9Beschreibung §7»");
	list.add("§b§m----------------------");
	list.add("§7" + lore1);
	list.add("§7" + lore2);
	list.add("§b§m----------------------");
	list.add(" ");
	list.add("§7» §6Cooldown:");
	list.add("§b» " + Cooldown);
	list.add("         ");
	im.setLore(list);
	is.setItemMeta(im);
	return is;
	
}

}
