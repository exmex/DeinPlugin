package de.leitung.lobby.classes;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.mewin.WGRegionEvents.events.RegionLeaveEvent;


public class MapProtection implements Listener{
	public ArrayList<Player>list = new ArrayList<Player>();
	
	@EventHandler
	public void onR(RegionLeaveEvent e){
		if(e.getRegion().getId().equalsIgnoreCase("spawn")){
		if(list.contains(e.getPlayer())){
			e.setCancelled(false);
		}else{
			Player p = e.getPlayer();
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn.WeltName");
	        double x = cfg.getDouble("Spawn.X");
	        double y = cfg.getDouble("Spawn.Y");
	        double z = cfg.getDouble("Spawn.Z");
	        double yaw = cfg.getDouble("Spawn.Yaw");
	        double pitch = cfg.getDouble("Spawn.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			e.getPlayer().sendMessage(Main.Prefix + "ßcDer Zugang auﬂerhalb der Lobby wird dir nicht gestattet!");
		}
	}
	}
	@EventHandler
	public void onPl(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/outofmap")){
			if(list.contains(e.getPlayer())){
				list.remove(e.getPlayer());
				e.getPlayer().sendMessage(Main.Prefix + "ßcOutOfMap ist aus!");
			}else{
				list.add(e.getPlayer());
				e.getPlayer().sendMessage(Main.Prefix + "ßaOutOfMap ist an!");
			}
		}
	}
	@EventHandler
	public void on(PlayerInteractAtEntityEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void ona(PlayerInteractEntityEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onDa(EntityDamageEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onDaass(EntityDamageByBlockEvent e){
		e.setCancelled(true);
	}
	@EventHandler
    public void onWeizen(PlayerInteractEvent e) {



        if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){

            e.setCancelled(true);

        }

    }
	

}
