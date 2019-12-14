package de.spigotplugins.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.spigotplugins.ffa.data.Data;

public class Shop implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("shop")){
			Player p = (Player)s;
			Inventory inv = Bukkit.createInventory(null, 9, "§6Shop");
			inv.setItem(0, createItemStack(Material.GOLDEN_APPLE, 1, 0, "§6Goldapfel", 3, "§bRegeneration + Extraherzen"));
			
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10, 10);
			p.openInventory(inv);
		}
		return false;
	}
	
	public static ItemStack createItemStack(Material m, int anzahl, int shortid, String DM, int level, String beschreibung){
		ItemStack i = new ItemStack(m, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DM);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("§7» §9Beschreibung");
		list.add("§8● " + beschreibung);
		list.add("§7«§7§m---------------§7»");
		list.add("§7» §9Kosten");
		list.add("§8● §5" + level + "§e Level");
		list.add("    ");
		im.setLore(list);
		i.setItemMeta(im);
		return i;
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equals("§6Shop")){
			e.setCancelled(true);
			 if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE){
				 if(p.getLevel() > 2){
					 p.setLevel(p.getLevel() -3);
					 ItemStack i = new ItemStack(Material.GOLDEN_APPLE);
					 p.getInventory().addItem(i);
					 p.closeInventory();
					 p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10, 10);
					 return;
				 }else{
					 p.closeInventory();
					 p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Level, um diese Aktion durchzuführen!");
						p.playSound(p.getLocation(), Sound.ENDERDRAGON_HIT, 10, 10);
					 return;
				 }
			 }
		}
	}
}
