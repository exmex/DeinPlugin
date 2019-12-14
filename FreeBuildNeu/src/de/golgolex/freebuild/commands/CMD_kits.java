package de.golgolex.freebuild.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.FreebuildAPI;
import de.golgolex.freebuild.methods.Stats;

public class CMD_kits implements CommandExecutor, Listener{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("kits")){
			if(p.hasPermission("claymc.kits")){
				if(args.length == 0){
					Inventory kits = Bukkit.createInventory(null, 27, "§2Kitauswahl");
					
					kits.setItem(0, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(1, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(2, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(3, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(4, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(5, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(6, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(7, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(8, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(9, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					
					ItemStack hf = new ItemStack(Material.IRON_AXE);
					ItemMeta hfm = hf.getItemMeta();
					hfm.setDisplayName("§6Holzfäller");
					hfm.addEnchant(Enchantment.DIG_SPEED, 2, true);
					ArrayList<String> list = new ArrayList<String>();
					list.add("§b§m§l--------------");
					list.add("§eKosten: §630 Coins");
					list.add("§b§m§l--------------");
					list.add("§eAusrüstung:");
					list.add("§8- §9Eisenaxt (Effizienz 2)");
					list.add("§8- §98 Äpfel");
					list.add("§8- §916 Holz");
					list.add("§b§m§l--------------");
					hfm.setLore(list);
					hf.setItemMeta(hfm);
					
					kits.setItem(10, hf);
					
					kits.setItem(11, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(12, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					
					ItemStack ta = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta tam = ta.getItemMeta();
					tam.setDisplayName("§6Tank");
					ArrayList<String> lista = new ArrayList<String>();
					lista.add("§b§m§l--------------");
					lista.add("§eKosten: §690 Coins");
					lista.add("§b§m§l--------------");
					lista.add("§eAusrüstung:");
					lista.add("§8- §9Volle Eisenrüstung");
					lista.add("§b§m§l--------------");
					tam.setLore(lista);
					ta.setItemMeta(tam);
					
					kits.setItem(13, ta);
					
					kits.setItem(14, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(15, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					
					ItemStack taa = new ItemStack(Material.IRON_SWORD);
					ItemMeta tama = taa.getItemMeta();
					tama.setDisplayName("§6Kämpfer");
					tama.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
					ArrayList<String> listaa = new ArrayList<String>();
					listaa.add("§b§m§l--------------");
					listaa.add("§eKosten: §6160 Coins");
					listaa.add("§b§m§l--------------");
					listaa.add("§eAusrüstung:");
					listaa.add("§8- §9Volle Eisenrüstung");
					listaa.add("§8- §9Eisenschwert (Schärfe 1)");
					listaa.add("§8- §92x Goldapfel");
					listaa.add("§8- §98x Steak");
					listaa.add("§b§m§l--------------");
					tama.setLore(listaa);
					taa.setItemMeta(tama);
					
					kits.setItem(16, taa);
					
					kits.setItem(17, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(18, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(19, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(20, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(21, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(22, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(23, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(24, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(25, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					kits.setItem(26, FreebuildAPI.createItem(Material.STAINED_GLASS_PANE, 15, " "));
					
					p.openInventory(kits);
					
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("§2Kitauswahl")){
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_AXE){
				if(Data.Coins.get(p.getName()) > 29){
				ItemStack hf = new ItemStack(Material.IRON_AXE);
				ItemMeta hfm = hf.getItemMeta();
				hfm.addEnchant(Enchantment.DIG_SPEED, 2, true);
				hf.setItemMeta(hfm);
				ItemStack apple = new ItemStack(Material.APPLE, 8);
				ItemStack wood = new ItemStack(Material.WOOD, 16);
				p.getInventory().addItem(hf);
				p.getInventory().addItem(apple);
				p.getInventory().addItem(wood);
				p.sendMessage(Data.pr + "§7Du hast dir das Kit erfolgreich gekauft");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
				p.closeInventory();
				if(Data.Coins.get(p.getName()) > 29){
					Data.Coins.put(p.getName(), -30);
				}else if(Stats.getMoney(p.getName()) > 29){
					Stats.removeCoins(p.getName(), 30);
				}
				return;

				}else{
					p.sendMessage(Data.pr + "§7Du hast nicht genug Coins um dieses Kit zu kaufen");
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);

				}
			}else if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
				if(Data.Coins.get(p.getName()) > 89 || Stats.getMoney(p.getName()) > 89){
					ItemStack a = new ItemStack(Material.IRON_HELMET);
					ItemStack b = new ItemStack(Material.IRON_CHESTPLATE);
				ItemStack apple = new ItemStack(Material.IRON_LEGGINGS);
				ItemStack wood = new ItemStack(Material.IRON_BOOTS);
				p.getInventory().addItem(a);
				p.getInventory().addItem(b);
				p.getInventory().addItem(apple);
				p.getInventory().addItem(wood);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
				p.closeInventory();
				if(Data.Coins.get(p.getName()) > 89){
					Data.Coins.put(p.getName(), -90);
				}else if(Stats.getMoney(p.getName()) > 89){
					Stats.removeCoins(p.getName(), 90);
				}

				p.sendMessage(Data.pr + "§7Du hast dir das Kit erfolgreich gekauft");
				return;

				}else{
					p.sendMessage(Data.pr + "§7Du hast nicht genug Coins um dieses Kit zu kaufen");
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);

				}
			}else if(e.getCurrentItem().getType() == Material.IRON_SWORD){
				if(Data.Coins.get(p.getName()) > 159 || Stats.getMoney(p.getName()) > 159){
					
					
					ItemStack taa = new ItemStack(Material.IRON_SWORD);
					ItemMeta tama = taa.getItemMeta();
					tama.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
					taa.setItemMeta(tama);
					
					
					
					ItemStack gold = new ItemStack(Material.GOLDEN_APPLE, 2);
					ItemStack ste = new ItemStack(Material.COOKED_BEEF, 8);
					ItemStack a = new ItemStack(Material.IRON_HELMET);
					ItemStack b = new ItemStack(Material.IRON_CHESTPLATE);
				ItemStack apple = new ItemStack(Material.IRON_LEGGINGS);
				ItemStack wood = new ItemStack(Material.IRON_BOOTS);
				p.getInventory().addItem(taa);
				p.getInventory().addItem(a);
				p.getInventory().addItem(b);
				p.getInventory().addItem(apple);
				p.getInventory().addItem(wood);
				p.getInventory().addItem(gold);
				p.getInventory().addItem(ste);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
				p.closeInventory();
				p.sendMessage(Data.pr + "§7Du hast dir das Kit erfolgreich gekauft");
				if(Data.Coins.get(p.getName()) > 159){
					Data.Coins.put(p.getName(), -160);
				}else if(Stats.getMoney(p.getName()) > 159){
					Stats.removeCoins(p.getName(), 160);
				}

				return;

				}else{
					p.sendMessage(Data.pr + "§7Du hast nicht genug Coins um dieses Kit zu kaufen");
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);

				}
			}else if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE){
				p.playSound(p.getLocation(), Sound.BAT_DEATH, 1, 1);
			}
		}
	}

}
