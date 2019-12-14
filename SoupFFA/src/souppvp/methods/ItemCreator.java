package souppvp.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
public static ItemStack CreateItemwhitID(int id,int subid,int amount , String DisplayName,String lore){
		ArrayList<String>list = new ArrayList<>();
		list.add(lore);
		ItemStack is = new ItemStack(id,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(list);
		is.setItemMeta(im);
		return is;
		
	}
	
	public static ItemStack CreateItemwhitMaterial(Material m,int subid,int amount , String DisplayName,String lore){
		
		ArrayList<String>list = new ArrayList<>();
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
public static ItemStack CreateKit(Material m,int subid,int amount ,String Premium, int Coins, String KitName,String lore1, String lore2, String Cooldown, String Freigeschaltet, Enchantment enchantment){
	
	ItemStack is = new ItemStack(m,amount,(short)subid);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName("§aKit §7» §e" + KitName);
	ArrayList<String> list = new ArrayList<>();
	list.add("    ");
	list.add("§8● §6Premium §7benötigt » §6" + Premium);
	list.add("§8● §7Benötige §6Coins§7» §e" + Coins);
	list.add("    ");
	list.add("§9Beschreibung §7»");
	list.add("§b§m----------------------");
	list.add("§7" + lore1);
	list.add("§7" + lore2);
	list.add("§b§m----------------------");
	list.add(" ");
	list.add("§8● §5Freigeschaltet §7»");
	list.add("§9§l» " + Freigeschaltet);
	list.add("");
	list.add("§8● §6Cooldown §7»");
	list.add("§9§l» " + Cooldown);
	list.add("         ");
	im.setLore(list);
	im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	im.addEnchant(enchantment, 1, true);
	is.setItemMeta(im);
	return is;
	
}
public static ItemStack CreateKitWAEnchantment(Material m,int subid,int amount ,String Premium, int Coins, String KitName,String lore1, String lore2, String Cooldown, String Freigeschaltet ){
	
	ItemStack is = new ItemStack(m,amount,(short)subid);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName("§aKit §7» §e" + KitName);
	ArrayList<String> list = new ArrayList<>();
	list.add("    ");
	list.add("§8● §6Premium §7benötigt » §6" + Premium);
	list.add("§8● §7Benötige §6Coins§7» §e" + Coins);
	list.add("    ");
	list.add("§9Beschreibung §7»");
	list.add("§b§m----------------------");
	list.add("§7" + lore1);
	list.add("§7" + lore2);
	list.add("§b§m----------------------");
	list.add(" ");
	list.add("§8● §5Freigeschaltet §7»");
	list.add("§9§l» " + Freigeschaltet);
	list.add("");
	list.add("§8● §6Cooldown §7»");
	list.add("§9§l» " + Cooldown);
	list.add("         ");
	im.setLore(list);
	is.setItemMeta(im);
	return is;
	
}
public static ItemStack CreateForChest(Material m, int anzahl, int subid){
	ItemStack is = new ItemStack(m,anzahl,(short)subid);
	ItemMeta im = is.getItemMeta();
	is.setItemMeta(im);
	return is;
}
}
