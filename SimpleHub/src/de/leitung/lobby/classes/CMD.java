package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CMD implements Listener{

	
	@EventHandler
	public void onA(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("/setspawn")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn.X", (Object)p.getLocation().getX());
                cfg.set("Spawn.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setkitbattle")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn1.X", (Object)p.getLocation().getX());
                cfg.set("Spawn1.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn1.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn1.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn1.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn1.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}if(e.getMessage().equalsIgnoreCase("/setkbffa")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn2.X", (Object)p.getLocation().getX());
                cfg.set("Spawn2.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn2.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn2.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn2.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn2.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setbashit")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn3.X", (Object)p.getLocation().getX());
                cfg.set("Spawn3.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn3.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn3.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn3.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn3.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setfreebuild")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn4.X", (Object)p.getLocation().getX());
                cfg.set("Spawn4.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn4.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn4.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn4.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn4.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setpremiumschiff")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn5.X", (Object)p.getLocation().getX());
                cfg.set("Spawn5.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn5.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn5.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn5.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn5.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setcommunity")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn6.X", (Object)p.getLocation().getX());
                cfg.set("Spawn6.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn6.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn6.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn6.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn6.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setclaywars")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn7.X", (Object)p.getLocation().getX());
                cfg.set("Spawn7.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn7.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn7.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn7.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn7.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setknockpvp")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn8.X", (Object)p.getLocation().getX());
                cfg.set("Spawn8.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn8.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn8.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn8.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn8.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getMessage().equalsIgnoreCase("/setsouppvp")){
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn9.X", (Object)p.getLocation().getX());
                cfg.set("Spawn9.Y", (Object)p.getLocation().getY());
                cfg.set("Spawn9.Z", (Object)p.getLocation().getZ());
                cfg.set("Spawn9.Yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn9.Pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn9.WeltName", (Object)p.getLocation().getWorld().getName());
                p.sendMessage("§aSpawn gesetzt");
                try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
