package souppvp.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import souppvp.data.Data;
import souppvp.methods.Sounds;

public class RundeVerlassen implements Listener{
	public static ArrayList<Player> list = new ArrayList<>();
	public RundeVerlassen(souppvp.main.Main Main){
		this.pl = Main;
	}
	private souppvp.main.Main pl;
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		Player p = e.getPlayer();
		if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cRunde verlassen§7 «")){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(Data.eventmodus == false){
					if(!list.contains(p)){
					list.add(p);
					Location loc = p.getLocation();
					loc.setY(loc.getY() + 50);
					p.teleport(loc);
					Sounds.playAdminFailureSound(p);
					Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
						@Override
						public void run() {
						
							p.kickPlayer(Data.Prefix + "§cDu hast die Runde verlassen!");
							
						}
					}, 17L);
					}
				}else{
					p.kickPlayer(Data.Prefix + "§cDu hast die Runde verlassen!");
				}
			
		}
		}
		}catch(Exception e1){}
	return;
	}

}
