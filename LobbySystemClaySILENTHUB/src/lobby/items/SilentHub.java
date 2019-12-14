package lobby.items;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import lobby.data.Data;
import lobby.methods.Sounds;

public class SilentHub implements Listener{
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
					 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(2.4D).setY(2.0D);
				     p.setVelocity(v);
				     p.sendTitle("§7» §aBetrete...", "§6Normale Lobbys...");
				     Sounds.playTeleportSound(p);
				     Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
						
						@Override
						public void run() {
							p.kickPlayer(Data.Prefix + "§eDu hast die §cSilentHub §everlassen!");
						}
					},30L);
				}
			}
		}catch(Exception e1){}
	}

}
