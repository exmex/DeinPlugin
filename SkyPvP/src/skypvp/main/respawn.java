package skypvp.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class respawn implements Listener{
	
	public respawn(skypvp.main.main main){
		this.pl = main;
	}
	private skypvp.main.main pl;
	private int cd;
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	final Player p = e.getPlayer();
			File ordner = new File("plugins//SkyPvP");
			File file = new File ("plugins//SkyPvP//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			
			
		
			final Location lobby = p.getLocation();
			lobby.setX(cfg.getDouble("spawn.x"));
			lobby.setY(cfg.getDouble("spawn.y"));
			lobby.setZ(cfg.getDouble("spawn.z"));
			double ya = cfg.getDouble("spawn.yaw");
			double pitc = cfg.getDouble("spawn.pitch");
			String world = cfg.getString("spawn.world");	
			
			
			 cd = Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){

				@Override
				public void run() {
					p.teleport(lobby);
					p.setHealth(20);
					
					
				}
				
				
				
				},20*1);
			 
	}

}



