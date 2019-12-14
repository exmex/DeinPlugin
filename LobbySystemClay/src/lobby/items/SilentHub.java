package lobby.items;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import lobby.data.Data;
import lobby.methods.Sounds;

public class SilentHub implements Listener{
	public static ArrayList<Player> list = new ArrayList<>();
	public SilentHub(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.TNT){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(!list.contains(p)){
					 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(2.4D).setY(2.0D);
				     p.setVelocity(v);
				     p.sendTitle("§7» §aAktiviert...", "§9SilentLobby");
				     list.add(p);
				     Sounds.playTeleportSound(p);
				     Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
						
						@Override
						public void run() {
						p.teleport(Data.spawn);
						for(Player all : Bukkit.getOnlinePlayers()){
					    	p.hidePlayer(all);
					    }
						}
					},30L);
				}else{
					list.remove(p);
				    p.sendTitle("§7» §cDeaktiviert...", "§9SilentLobby");
				    p.teleport(Data.spawn);
				    Sounds.playTeleportSound(p);
				    for(Player all : Bukkit.getOnlinePlayers()){
				    	p.showPlayer(all);
				    }
				}
				}
			}
		}catch(Exception e1){}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(int i = 0 ; i < list.size() ; i++){
			Player tar = list.get(i);
			tar.hidePlayer(p);
		}
			
		
	}
}
