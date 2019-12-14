package spigotplugins.skywars.manager;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class Inventorys {

	public static void setLobbyItems(Player p){
		p.getInventory().setArmorContents(null);
		p.setFireTicks(0);
		for (PotionEffect effect : p.getActivePotionEffects()){
	        p.removePotionEffect(effect.getType());
		}
		ItemStack a = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName(" ");
		a.setItemMeta(am);
		p.getInventory().clear();
		p.getInventory().setItem(0, createItem(Material.ENDER_CHEST, 1, 0, "§7» §eKits §7[§aRechtsklick§7]", "§7Wähle dir ein passendes Kit aus"));
		p.getInventory().setItem(1, createItem(Material.NETHER_STAR, 1, 0, "§7» §eTeam-Wahl §7[§aRechtsklick§7]", "§7Wähle ein Team aus"));
		p.getInventory().setItem(2, a);
		p.getInventory().setItem(3, a);
		p.getInventory().setItem(4, a);
		p.getInventory().setItem(5, a);
		p.getInventory().setItem(6, a);
		p.getInventory().setItem(7, createItem(Material.BARRIER, 1, 0, "§7» §cKein Kit", "§7Bisher hast du kein Kit ausgewählt"));
		p.getInventory().setItem(8, createItem(Material.SLIME_BALL, 1, 0, "§7» §cVerlassen §7[§4Rechtsklick§7]", "§7Verlasse die aktuelle Runde"));
	}
	public static ItemStack createItem(Material Item, int Anzahl, int ShortID, String DisplayName, String Lore){
		ItemStack i = new ItemStack(Item, Anzahl, (short) ShortID);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add(Lore);
		im.setLore(list);
		i.setItemMeta(im);
		
		return i;
	}
	public static ItemStack createKit(Material Item, int ShortID, String KitName, boolean KitGekauft, int Coins, String BS1, String BS2){
		ItemStack i = new ItemStack(Item, 1, (short) ShortID);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§7» §3Kit: §b" + KitName);
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		if(KitGekauft){
			list.add("§5Gekauft §8● §aJa");
			im.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}else{
			list.add("§5Gekauft §8● §cNein");
			list.add("§6Preis §8● §e" + Coins);
		}
		list.add("");
		list.add("§b§m------------------------");
		list.add("§7" +BS1);
		list.add("§7" +BS2);
		list.add("§b§m------------------------");
		list.add("");
		im.setLore(list);
		i.setItemMeta(im);
		
		return i;
	}
}
