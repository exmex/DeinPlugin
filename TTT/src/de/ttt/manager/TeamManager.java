package de.ttt.manager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.ttt.gamestates.GameState;
import de.ttt.main.Main;
import de.ttt.stats.StatsManager;
import de.ttt.utils.Data;

public class TeamManager implements Listener{

	public static ArrayList<Player> normal = new ArrayList<Player>();
	public static ArrayList<Player> detective = new ArrayList<Player>();
	public static ArrayList<Player> traitor = new ArrayList<Player>();

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			
			if(e.getItem().getType() == Material.NETHER_STAR){
				if(Main.gs == GameState.LOBBY){
					if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
						Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§6Pässe");
						ItemStack i = new ItemStack(Material.DIAMOND_SWORD);
						ItemMeta im = i.getItemMeta();
						im.setDisplayName("§4Traitor Pass kaufen");
						i.setItemMeta(im);
						
						ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
						ItemMeta im2 = i2.getItemMeta();
						im2.setDisplayName("§bDetective Pass kaufen");
						i2.setItemMeta(im2);
						
						inv.setItem(1, i2);
						inv.setItem(3, i);
						
						p.openInventory(inv);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						return;
					}
				}
			}
			
		}catch(Exception e1){}
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		try{
			Player p = (Player)e.getWhoClicked();
			if(e.getInventory().getName().equalsIgnoreCase("§6Pässe")){
				p.sendMessage("1");
				if(Main.gs == GameState.LOBBY){
					p.sendMessage("2");
					if(!TeamManager.detective.contains(p) || !TeamManager.traitor.contains(p)){
						p.sendMessage("3");
					if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE){
						p.sendMessage("4");
						if(detective.size() < 4){
							p.sendMessage("5");
						if(StatsManager.detectivepaesse.get(p.getName()) > 0){
							p.sendMessage("6");
							StatsManager.detectivepaesse.put(p.getName(), StatsManager.detectivepaesse.get(p.getName()) -1);
							TeamManager.detective.add(p);
							p.sendMessage(Data.prefix + "§eDu bist den §bDetectives §ebeigetreten!");
							p.closeInventory();
						}else{
							p.sendMessage(Data.prefix + "§cDu hast keine Detective Pässe mehr übrig!");
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
							return;
						}
						return;
					}else{
						p.sendMessage(Data.prefix + "§cEs haben sich bereits zu viele Spieler einen Detective Pass gekauft!");
						return;
					}
					}
					if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
						if(traitor.size() < 6){
							if(StatsManager.traitorpaesse.get(p.getName()) > 0){
								StatsManager.traitorpaesse.put(p.getName(), StatsManager.traitorpaesse.get(p.getName()) -1);
								TeamManager.traitor.add(p);
								p.sendMessage(Data.prefix + "§eDu bist nun im §cTraitor §eTeam!");
								p.closeInventory();
								return;
							}else{ 
								p.sendMessage(Data.prefix + "§cDu hast keine Traitorpässe mehr übrig!");
							    return;
							}
						}else{
							p.sendMessage(Data.prefix + "§cEs haben sich bereits zu viele Spieler einen Traitor Pass gekauft!");
							return;
						}
					}
					}else{
						p.sendMessage(Data.prefix + "§cDu hast dir bereits einen Pass gekauft!");
						p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
						p.closeInventory();
						return;
					}
				}else{
					p.sendMessage(Data.prefix + "§cDu kannst nun keine Pässe mehr auswählen!");
					p.closeInventory();
				}
			}
		}catch(Exception e1){}
	}
	public static void pickRandomTeams(Player p){
		
	}
}
