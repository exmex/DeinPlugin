package de.souppvp.itemfunctions;

import java.util.ArrayList;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.souppvp.data.Data;
import de.souppvp.data.ItemCreator;
import de.souppvp.feast.FeastJoin;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.onevsonemanager.FightManager;
import de.souppvp.onevsonemanager.OneVSOneChallenger;
import de.souppvp.onevsonemanager.OneVSOneLobby;
import de.souppvp.onevsonemanager.OneVSOneWarteschlange;
import de.souppvp.spawnmanager.SpawnManager;

public class Navigator implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(Data.firstJoin.contains(p)){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(e.getItem().getType() == Material.COMPASS){
						Inventory inv = Bukkit.createInventory(null, 9, "§3Navigator");
						ArrayList<String> list = new ArrayList<>();
						list.add("");
						list.add("§7Klicke um §e1vs1 §7zu spielen!");
						
						ArrayList<String> list1 = new ArrayList<>();
						list1.add("");
						list1.add("§7Klicke um zum §eSpawn §7zu gelangen!");
						
						ArrayList<String> list2 = new ArrayList<>();
						list2.add("");
						list2.add("§7Klicke um §eFeast §7zu spielen!");
						ItemStack pf = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);	
						ItemMeta pfm = pf.getItemMeta();
						pfm.setDisplayName(" ");
						pf.setItemMeta(pfm);
						inv.setItem(0, pf);
						inv.setItem(2, pf);
						inv.setItem(3, pf);
						inv.setItem(5, pf);
						inv.setItem(6, pf);
						inv.setItem(8, pf);
						inv.setItem(1, ItemCreator.CreateItemwhitMaterial(Material.DIAMOND_SWORD, 0, 1, "§d1vs1 §8» §fKlick", list));
						inv.setItem(4, ItemCreator.CreateItemwhitMaterial(Material.FIREBALL, 0, 1, "§eSpawn §8» §fKlick", list1));
						inv.setItem(7, ItemCreator.CreateItemwhitMaterial(Material.CHEST, 0, 1, "§3Feast §8» §fKlick", list2));
						
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
						p.openInventory(inv);
					}
				}
			}
		}catch(Exception e1){}
	}
	
	@EventHandler
	public void onCl(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§3Navigator")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				SpawnManager.teleportToSpawn(p, "1vs1");
				p.sendMessage(Data.Prefix + "§7Du hast dich zu §e1vs1 §7teleportiert!");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.closeInventory();
				Data.FeastNoKit.remove(p);
				Data.firstJoin.remove(p);
				Data.FeastJoin.remove(p);
				Data.INOneVSOneJoin.remove(p);
				Data.OneVSOneJoin.add(p);
				OneVSOneLobby.setOneVSOneInventory(p);
				OneVSOneChallenger.fight.remove(p);
				Data.OneVSOneJoin.add(p);
				return;
			}
			if(e.getCurrentItem().getType() == Material.FIREBALL){
				SpawnManager.teleportToSpawn(p, "Spawn");
				Data.FeastNoKit.remove(p);
				PlayerJoinListener.getLobbyItems(p);
				p.sendMessage(Data.Prefix + "§7Du hast dich zum §eSpawn §7teleportiert!");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.closeInventory();
				return;
			}
			if(e.getCurrentItem().getType() == Material.CHEST){
				FightManager.onevsone.remove(p);
				FightManager.PlayerO.remove(p);
				FightManager.PlayerT.remove(p);
				OneVSOneChallenger.fight.remove(p);
				OneVSOneWarteschlange.warteschlange.remove(p);
				SpawnManager.teleportToSpawn(p, "Feast");
				p.sendMessage(Data.Prefix + "§7Du hast dich zum §eFeast §7teleportiert!");
				FeastJoin.startFeast(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
				p.closeInventory();
				return;
			}
		}
	}
}
