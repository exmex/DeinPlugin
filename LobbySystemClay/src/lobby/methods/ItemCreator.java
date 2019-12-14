package lobby.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import ru.tehkode.permissions.bukkit.PermissionsEx;

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
	
	
	public static ItemStack CreateItemwhitOneLore(Material m,int subid,int amount , String DisplayName,String Spielmodus,String lore){
		ArrayList<String> list = new ArrayList<>();
		list.add("§8§m--------------------------");
		list.add(Spielmodus);
		list.add(lore);
		ItemStack is = new ItemStack(m,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		
		im.setLore(list);
		is.setItemMeta(im);
		return is;
		
	}
	public static ItemStack CreateItemwhitTwoLore(Material m,int subid,int amount , String DisplayName,String Spielmodus,String lore, String lore2){
		ArrayList<String> list = new ArrayList<>();
		list.add("§8§m--------------------------");
		list.add(Spielmodus);
		list.add(lore);
		list.add(lore2);
		ItemStack is = new ItemStack(m,amount,(short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		
		im.setLore(list);
		is.setItemMeta(im);
		return is;
		
	}
	public static ItemStack CreateItemwhitthreeLore(Material m,int subid,int amount , String DisplayName,String Spielmodus,String lore, String lore2, String lore3){
		ArrayList<String> list = new ArrayList<>();
		list.add("§8§m--------------------------");
		list.add(Spielmodus);
		list.add(lore);
		list.add(lore2);
		list.add(lore3);
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
public static ItemStack CreateYT(String SpielerName, Player p, String Target){
	String group = PermissionsEx.getUser(Target).getGroups()[0].getName();
	ItemStack skull = new ItemStack(397, 1, (short) 3);
	ItemMeta sm = skull.getItemMeta();
	sm.setDisplayName(Target);
	skull.setItemMeta(sm);
	SkullMeta meta = (SkullMeta) skull.getItemMeta();
	meta.setOwner(Target);
	ArrayList<String> list = new ArrayList<>();
	list.add("§8§m--------------------------");
	list.add("§6" + Target + "'s §7momentaner §6Rang:");
	list.add("§7» " + getColor(Target) + group);
	meta.setLore(list);
	skull.setItemMeta(meta);
	
	return skull;
}
public static String getColor(String p){
	String group = PermissionsEx.getUser(p).getGroups()[0].getName();
	String c = ""; 
	if(group.equalsIgnoreCase("default")){
		c = "§7";
	}
	if(group.equalsIgnoreCase("jryoutuber") || group.equalsIgnoreCase("youtuber")){
		c = "§5";
	}
	return c;
}
public static ItemStack CreateItemONELORE(Material m,int subid,int amount , String DisplayName,String lore){
	ArrayList<String> list = new ArrayList<>();
	list.add(lore);
	ItemStack is = new ItemStack(m,amount,(short)subid);
	ItemMeta im = is.getItemMeta();
	im.setDisplayName(DisplayName);
	im.setLore(list);
	is.setItemMeta(im);
	return is;
	
}
public static ItemStack CreateQuickJoiner(String OnlineOfflineFull, int SpielerAnzahl ,int MaxSpieler, String SpielModus){
	ArrayList<String> list = new ArrayList<>();
	ItemStack i = null;
	if(OnlineOfflineFull.equalsIgnoreCase("Offline")){
		i = new ItemStack(Material.STAINED_CLAY, 0 , (short) 14);
	}
	if(OnlineOfflineFull.equalsIgnoreCase("Online")){
		i = new ItemStack(Material.STAINED_CLAY, SpielerAnzahl, (short) 5);
	}
	if(OnlineOfflineFull.equalsIgnoreCase("Full")){
		i = new ItemStack(Material.STAINED_CLAY, SpielerAnzahl, (short) 4);
	}
	ItemMeta im = i.getItemMeta();
	im.setDisplayName("§6SpielModus §7» §e" + SpielModus);
	list.add("");
	list.add("§7» §a" + SpielerAnzahl + "§7/§6" + MaxSpieler);
	list.add("");
	im.setLore(list);
	i.setItemMeta(im);
	return i;
	
}
}
