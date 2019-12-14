package lobby.items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lobby.data.Data;
import lobby.methods.ItemCreator;

public class PlayerHider implements Listener{
	public static ArrayList<Player> allplayer = new ArrayList<>();
	public static ArrayList<Player> premiPlayer = new ArrayList<>();
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
	Player p = e.getPlayer();
		
		try{
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3✘ §eAlle Spieler sichtbar §3✘")) {
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					for(Player all : Bukkit.getOnlinePlayers()){
						if(!all.hasPermission("claymc.gold")){
							e.getPlayer().hidePlayer(all);
						}
						premiPlayer.add(e.getPlayer());
					}
					p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 5, 1, "§3✘ §5Nur Premium Spieler sichtbar §3✘", "§7Verstecke deine Mitspieler"));
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					p.sendMessage(Data.Prefix + "§eDu siehst ab jetzt nur noch §5Premium §eSpieler!");
					return;
				}
			}
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3✘ §5Nur Premium Spieler sichtbar §3✘")) {
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					for(Player all : Bukkit.getOnlinePlayers()){
							e.getPlayer().hidePlayer(all);
						allplayer.add(e.getPlayer());
					}
					p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 1, 1, "§3✘ §cAlle Spieler unsichtbar §3✘", "§7Verstecke deine Mitspieler"));
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					p.sendMessage(Data.Prefix + "§eDu siehst nun §cniemanden §emehr!");
					return;
				}
			}
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3✘ §cAlle Spieler unsichtbar §3✘")) {
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					for(Player all : Bukkit.getOnlinePlayers()){
							e.getPlayer().showPlayer(all);
						allplayer.remove(e.getPlayer());
						premiPlayer.remove(e.getPlayer());

					}
					p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 10, 1, "§3✘ §eAlle Spieler sichtbar §3✘", "§7Verstecke deine Mitspieler"));
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					p.sendMessage(Data.Prefix + "§eDu siehst nun wieder §aAlle §eSpieler!");
					return;
				}
			}
		}catch(Exception e1){
			
		}
		}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		for(Player all : Bukkit.getOnlinePlayers()){
			if(allplayer.contains(all)){
			for(int i = 0 ; i < allplayer.size() ; i++){
				allplayer.get(i).hidePlayer(e.getPlayer());
			}
		}
			if(premiPlayer.contains(all)){
				for(int i = 0 ; i < premiPlayer.size() ; i++){
					for(Player alla : Bukkit.getOnlinePlayers()){
						if(!alla.hasPermission("claymc.gold")){
					premiPlayer.get(i).hidePlayer(alla);
				}
					}
				}
			}
		}
		
	}

}
