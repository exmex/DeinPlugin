package de.skywars.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.skywars.gamestates.GameState;
import de.skywars.main.Main;
import de.skywars.utils.Data;
import de.skywars.utils.StatsManager;
import de.tiger.NickSystem.manager.NameUtils;

public class Kits implements Listener{
	public HashMap<Player, Integer> kills = new HashMap<Player, Integer>();
	public static ArrayList<Player>bauarbeiter = new ArrayList<Player>();
	public static ArrayList<Player>holzfäller = new ArrayList<Player>();
	public static ArrayList<Player>panzer = new ArrayList<Player>();

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!kills.containsKey(p)){
			kills.put(p, StatsManager.getKills(NameUtils.getRealName(p)));
		}else{
			kills.put(p, StatsManager.getKills(NameUtils.getRealName(p)));
		}
	}
	@EventHandler
	public void onIn(PlayerInteractEvent e){
		try{
			
			Player p = e.getPlayer();
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Kitauswahl")){
				Inventory inv = Bukkit.createInventory(null, 2*9, "§3Kitauswahl");
				if(kills.get(p) > 10){
				ItemStack i = new ItemStack(Material.BRICK);
				ItemMeta im = i.getItemMeta();
				im.addEnchant(Enchantment.DURABILITY, 1, true);
				im.setDisplayName("§3Bauarbeiter §8| §aFreigeschaltet");
				ArrayList<String>list = new ArrayList<String>();
				list.add("§eStarte mit 3 Stacks Ziegensteinen!");
				list.add("§eBaue dich schnell zu deinen Gegnern.");
				im.setLore(list);
				i.setItemMeta(im);
				inv.setItem(0, i);
			}else{
				ItemStack i = new ItemStack(Material.BRICK);
				ItemMeta im = i.getItemMeta();
				im.addEnchant(Enchantment.DURABILITY, 1, true);
				im.setDisplayName("§3Bauarbeiter §8| §6Ab §a10 §6Kills freigeschaltet!");
				ArrayList<String>list = new ArrayList<String>();
				list.add("§eStarte mit 3 Stacks Ziegensteinen!");
				list.add("§eBaue dich schnell zu deinen Gegnern.");
				im.setLore(list);
				i.setItemMeta(im);
				inv.setItem(0, i);
			}
				if(kills.get(p) > 20){
					ItemStack i = new ItemStack(Material.STONE_AXE);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Holzfäller §8| §aFreigeschaltet");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit 3 Stacks Holz und");
					list.add("§erüste dich so entsprechend aus.");
					im.setLore(list);
					i.setItemMeta(im);
					inv.setItem(1, i);
				}else{
					ItemStack i = new ItemStack(Material.STONE_AXE);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Holzfäller §8| §6Ab §a20 §6Kills freigeschaltet!");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit 3 Stacks Holz und");
					list.add("§erüste dich so entsprechend aus.");
					im.setLore(list);
					i.setItemMeta(im);
					inv.setItem(1, i);
				}
				if(kills.get(p) > 25){
					ItemStack i = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Panzer §8| §aFreigeschaltet");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit einem Eisenbrustpanzer");
					list.add("§eund einer Eisenhose.");
					im.setLore(list);
					i.setItemMeta(im);
					inv.setItem(1, i);
				}else{
					ItemStack i = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Panzer §8| §6Ab §a25 §6Kills freigeschaltet!");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit einem Eisenbrustpanzer");
					list.add("§eund einer Eisenhose.");
					im.setLore(list);
					i.setItemMeta(im);
					inv.setItem(1, i);
				}
				p.openInventory(inv);
			}
			
		}catch(Exception e1){}
	}
	public void removeFromArrayList(Player p){
		bauarbeiter.remove(p);
		holzfäller.remove(p);
		panzer.remove(p);
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§3Kitauswahl")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.BRICK){
				if(kills.get(p) > 9){
					ItemStack i = new ItemStack(Material.BRICK);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Bauarbeiter §8| §aFreigeschaltet");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit 3 Stacks Ziegensteinen!");
					list.add("§eBaue dich schnell zu deinen Gegnern.");
					im.setLore(list);
					i.setItemMeta(im);
				removeFromArrayList(p);
				bauarbeiter.add(p);
				p.sendMessage(Data.Prefix + "§6Du hast das §aBauarbeiter §6Kit ausgewählt!");
				p.getInventory().setItem(7, i);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.closeInventory();
				return;
			}else{
				p.sendMessage(Data.Prefix + "§cDu benötigst mindestens §610 §cKills um dieses Kit zu nutzen!");
			}
			}
			if(e.getCurrentItem().getType() == Material.STONE_AXE){
				if(kills.get(p) > 19){
					ItemStack i = new ItemStack(Material.STONE_AXE);
					ItemMeta im = i.getItemMeta();
					im.addEnchant(Enchantment.DURABILITY, 1, true);
					im.setDisplayName("§3Holzfäller §8| §aFreigeschaltet");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§eStarte mit 3 Stacks Holz und");
					list.add("§erüste dich so entsprechend aus.");
					im.setLore(list);
					i.setItemMeta(im);
					removeFromArrayList(p);
					holzfäller.add(p);
					p.getInventory().setItem(7, i);
					p.sendMessage(Data.Prefix + "§6Du hast das §aHolzfäller §6Kit ausgewählt!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cDu benötigst mindestens §620 §cKills um dieses Kit zu nutzen!");
				return;
				}
			}
			if(kills.get(p) > 24){
				ItemStack i = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta im = i.getItemMeta();
				im.addEnchant(Enchantment.DURABILITY, 1, true);
				im.setDisplayName("§3Panzer §8| §aFreigeschaltet");
				ArrayList<String>list = new ArrayList<String>();
				list.add("§eStarte mit einem Eisenbrustpanzer");
				list.add("§eund einer Eisenhose.");
				im.setLore(list);
				i.setItemMeta(im);
			removeFromArrayList(p);
			panzer.add(p);
			p.sendMessage(Data.Prefix + "§6Du hast das §aBauarbeiter §6Kit ausgewählt!");
			p.getInventory().setItem(7, i);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			p.closeInventory();
			return;
		}else{
			p.sendMessage(Data.Prefix + "§cDu benötigst mindestens §610 §cKills um dieses Kit zu nutzen!");
			return;
		}
		}
	}
	@EventHandler
	public void on(PlayerDropItemEvent e){
		if(Main.gs == GameState.INGAME){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
}
