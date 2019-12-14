package de.souppvp.feast;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.souppvp.data.Data;
import de.souppvp.data.ItemCreator;
import de.souppvp.data.Scoreboard;
import de.souppvp.levelsystem.LevelData;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.spawnmanager.SpawnManager;

public class KitAuswahl implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eKitauswahl §7» §f§lKLICK")){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR ) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(Data.FeastJoin.contains(p) || Data.FeastNoKit.contains(p)){
						Inventory inv = Bukkit.createInventory(null, 18, Data.Prefix);
						inv.setItem(0, ItemCreator.CreateItemwhitMaterial(Material.IRON_CHESTPLATE, 0, 1, 0, "Anfänger", "Kämpfe mit dem Standart", "Kit"));
						inv.setItem(1, ItemCreator.CreateItemwhitMaterial(Material.BOW, 0, 1, 0, "Bogenschütze", "Du magst den Fernkampf?", "Hier ist das Perfekte Kit"));
						inv.setItem(2, ItemCreator.CreateKit(Material.FIREWORK, 0, 2, 2, "§6Gold", "Kangaroo", "Hebe mithilfe deiner Rakete", "komplett ab!", "§c§l✖"));
						inv.setItem(3, ItemCreator.CreateKit(Material.LEATHER, 0, 3, 3, "§6Gold", "Suppenmeister", "Du hast einen Rucksack in dem", "sich unendlich viele Suppen befinden!", "§c§l✖"));
						inv.setItem(4, ItemCreator.CreateKit(Material.DIAMOND_AXE, 0, 3, 3, "§6Gold", "Axt", "Kämpfst du lieber mit einer Axt?", "Das ist das Perfekte Kit für dich!", "§c§l✖"));

						inv.setItem(17, ItemCreator.CreateItemwhitMaterial(Material.BARRIER, 0, 1, "§cVerlassen", null));
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10, 10);
						p.openInventory(inv);
					}
				}
			}
		}catch(Exception e1){}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase(Data.Prefix)){
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit §7» §eAnfänger")){
				KitMethods.setAnfänger(p);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.sendMessage(Data.Prefix + "§eDu hast diese Kit §6erfolgreich §eangelegt!");
				Scoreboard.setScoreboard(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit §7» §eBogenschütze")){
				KitMethods.setBogen(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.sendMessage(Data.Prefix + "§eDu hast diese Kit §6erfolgreich §eangelegt!");
				p.closeInventory();
				Scoreboard.setScoreboard(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit §7» §eKangaroo")){
				if(LevelData.getLevelToINT(p) > 0  || p.hasPermission("claymc.gold")){
				KitMethods.setKangaroo(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.sendMessage(Data.Prefix + "§eDu hast diese Kit §6erfolgreich §eangelegt!");
				p.closeInventory();
				Scoreboard.setScoreboard(p);
				return;
			}else{
				p.sendMessage(Data.Prefix + "§7Dein §bLevel§7 muss höher sein, damit du dieses Kit nutzen darfst!");
				p.sendMessage(Data.Prefix + "§eKeine Lust zu warten? §9http://shop.claymc.net");
			}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit §7» §eSuppenmeister")){
				if(LevelData.getLevelToINT(p) > 1  || p.hasPermission("claymc.gold")){
				KitMethods.setSuppenmeister(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.sendMessage(Data.Prefix + "§eDu hast diese Kit §6erfolgreich §eangelegt!");
				p.closeInventory();
				Scoreboard.setScoreboard(p);
				return;
			}else{
				p.sendMessage(Data.Prefix + "§7Dein §bLevel§7 muss höher sein, damit du dieses Kit nutzen darfst!");
				p.sendMessage(Data.Prefix + "§eKeine Lust zu warten? §9http://shop.claymc.net");
			}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit §7» §eAxt")){
				if(LevelData.getLevelToINT(p) > 1  || p.hasPermission("claymc.gold")){
				KitMethods.setAxt(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.sendMessage(Data.Prefix + "§eDu hast diese Kit §6erfolgreich §eangelegt!");
				p.closeInventory();
				Scoreboard.setScoreboard(p);
				return;
			}else{
				p.sendMessage(Data.Prefix + "§7Dein §bLevel§7 muss höher sein, damit du dieses Kit nutzen darfst!");
				p.sendMessage(Data.Prefix + "§eKeine Lust zu warten? §9http://shop.claymc.net");
			}
			}
			if(e.getCurrentItem().getType() == Material.BARRIER){
				PlayerJoinListener.getLobbyItems(p);
				SpawnManager.teleportToSpawn(p, "Spawn");
				Data.FeastJoin.remove(p);
				Data.FeastNoKit.remove(p);
			}
		}
	}
	
	
}
