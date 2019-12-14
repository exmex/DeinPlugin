package de.codeexception.events;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.codeexception.oneversusone.Main;

public class Spawn implements Listener{
	public static ArrayList<Player> startlist = new ArrayList<Player>();
	@EventHandler
	public void onPla(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		
		if(e.getMessage().equalsIgnoreCase("/setspawn")){
			if(p.hasPermission("claymc.admin")){
			File file = new File("plugins//1vs1//spawns.yml");
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
		}else if(e.getMessage().equalsIgnoreCase("/setpos1")){
			if(p.hasPermission("claymc.admin")){

			File file = new File("plugins//1vs1//spawns.yml");
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
		}else if(e.getMessage().equalsIgnoreCase("/setpos2")){
			if(p.hasPermission("claymc.admin")){

			File file = new File("plugins//1vs1//spawns.yml");
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
		}else if(e.getMessage().equalsIgnoreCase("/start")){
			if(p.hasPermission("claymc.ultra")){
				if(startlist.isEmpty()){
					if(Bukkit.getOnlinePlayers().size() == 2){
						if(PlayerEvents.waiting > 6){
					Bukkit.broadcastMessage(Main.px + "§eDer Countdown wurde von §3" + p.getName() + "§e verkürtzt!");
					PlayerEvents.waiting = 5;
					startlist.add(p);
						}else{
							p.sendMessage(Main.px + "§cDas Spiel startet bereits!");
						}
					}else{
						p.sendMessage(Main.px + "§cEs müssen mindestens 2 Spieler auf dem Server sein!");
					}
				}else{
					p.sendMessage(Main.px + "§cDas Spiel wurde bereits vorzeitig gestartet!");
				}
			}else{
				p.sendMessage(Main.px + "§cDu benötigst mindestens den §bUltra §cRang!");
			}
		}
	}
	public static void tpspawn(Player p){
		File file = new File("plugins//1vs1//spawns.yml");
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
	}
	public static void tpspawn1(Player p){
		File file = new File("plugins//1vs1//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn1.WeltName");
        double x = cfg.getDouble("Spawn1.X");
        double y = cfg.getDouble("Spawn1.Y");
        double z = cfg.getDouble("Spawn1.Z");
        double yaw = cfg.getDouble("Spawn1.Yaw");
        double pitch = cfg.getDouble("Spawn1.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        p.teleport(loc);
	}
	public static void tpspawn2(Player p){
		File file = new File("plugins//1vs1//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn2.WeltName");
        double x = cfg.getDouble("Spawn2.X");
        double y = cfg.getDouble("Spawn2.Y");
        double z = cfg.getDouble("Spawn2.Z");
        double yaw = cfg.getDouble("Spawn2.Yaw");
        double pitch = cfg.getDouble("Spawn2.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        p.teleport(loc);
	}
	
}
