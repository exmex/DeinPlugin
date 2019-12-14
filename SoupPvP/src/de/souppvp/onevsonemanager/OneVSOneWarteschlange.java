package de.souppvp.onevsonemanager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Score;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;

public class OneVSOneWarteschlange implements Listener{
	public static ArrayList<Player> warteschlange = new ArrayList<>();

	@EventHandler
	public void onClick(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			ItemStack a = new ItemStack(Material.AIR);
			ItemStack i = new ItemStack(Material.INK_SACK, 1, (short)10);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName("§dWarteschlange §7» [§aAn§7]");
			i.setItemMeta(im);
			
			ItemStack i1 = new ItemStack(Material.INK_SACK, 1, (short)8);
			ItemMeta im1 = i1.getItemMeta();
			im1.setDisplayName("§dWarteschlange §7» [Aus]");
			i1.setItemMeta(im1);
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dWarteschlange §7» [Aus]")){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(Data.OneVSOneJoin.contains(p)){
						if(!Data.OneVSOneWarteschlange.contains(p)){
						Data.OneVSOneWarteschlange.add(p);
						p.setItemInHand(a);
						p.setItemInHand(i);
						p.sendTitle("§eWarteschlange", "§7» §aSpielersuche...");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
						Scoreboard.setScoreboard(p);
						warteschlange.add(p);
						if(warteschlange.size() == 2){
							Player one = warteschlange.get(0);
							Player two = warteschlange.get(1);
							if(one.isOnline() && two.isOnline()){
							FightManager.startOneVSOne(one, two);
							one.sendMessage(Data.Prefix + "§aDer Kampf beginnt nun!");
							two.sendMessage(Data.Prefix + "§aDer Kampf beginnt nun!");
							OneVSOneChallenger.fight.remove(one);
							OneVSOneChallenger.fight.remove(two);
							Data.firstJoin.remove(one);
							Data.firstJoin.remove(two);
							warteschlange.remove(one);
							warteschlange.remove(two);
						}else{
							if(one.isOnline()){
							one.sendMessage(Data.Prefix + "§cEs ist ein Fehler aufgetreten! Bitte beutze die Warteschlange erneut!");
							Data.OneVSOneWarteschlange.remove(p);
						    Data.OneVSOneJoin.add(p);
							OneVSOneLobby.setOneVSOneInventory(p);
							warteschlange.remove(p);
							}
							if(two.isOnline()){
								two.sendMessage(Data.Prefix + "§cEs ist ein Fehler aufgetreten! Bitte beutze die Warteschlange erneut!");
								OneVSOneLobby.setOneVSOneInventory(p);
								Data.OneVSOneWarteschlange.remove(p);
							    Data.OneVSOneJoin.add(p);
								warteschlange.remove(p);

							}
						}
						}
						
						return;
					}
					}
				}
			}
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dWarteschlange §7» [§aAn§7]")){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(Data.OneVSOneJoin.contains(p)){
						if(Data.OneVSOneWarteschlange.contains(p)){
						Data.OneVSOneWarteschlange.remove(p);
						p.setItemInHand(a);
						p.setItemInHand(i1);
						warteschlange.remove(p);
						p.sendTitle("§eWarteschlange", "§7» §cVerlassen...");
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 10);
						Scoreboard.setScoreboard(p);
						return;
					}
				}
				}
			}
		}catch(Exception e1){}
	}

}
