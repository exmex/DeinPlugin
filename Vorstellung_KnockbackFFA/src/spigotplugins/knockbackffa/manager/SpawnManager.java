package spigotplugins.knockbackffa.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import spigotplugins.knockbackffa.storage.Data;

public class SpawnManager implements CommandExecutor{

	public static ArrayList<String> Maps = new ArrayList<>();
	public static File file = new File("plugins//KnockbackFFA//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static HashMap<String, Location> location = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(s.hasPermission("knockbackffa.setspawn")) {
				if(args.length == 3){
					Maps = (ArrayList<String>) cfg.getStringList("Maps");
						setMap(p, args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
						p.sendMessage(new Data().Prefix + "§eDie Map §6" + args[0] + "§e wurde erfolgreich gesetzt!");
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					
				}else{
					s.sendMessage("§cFolgende Befehle sind verfügbar:");
					s.sendMessage("§6/SetSpawn [MapName] [Y-Koordinate(Spawn)] [Y-Koordinate(Sterben)]");
				}
			}else{
				s.sendMessage(new Data().Prefix + "§cDu hast keine Rechte um dies zu tun...");
			}
		}
		return false;
	}
	
	public void setMap(Player p, String SpawnName, int yspawn, int ykill){
		cfg.set(SpawnName + ".X", p.getLocation().getX());
		cfg.set(SpawnName + ".Y", p.getLocation().getY());
		cfg.set(SpawnName + ".Z", p.getLocation().getZ());
		cfg.set(SpawnName + ".Yaw", p.getLocation().getYaw());
		cfg.set(SpawnName + ".Pitch", p.getLocation().getPitch());
		cfg.set(SpawnName + ".Yaw", p.getLocation().getYaw());
		cfg.set(SpawnName + ".WeltName", p.getLocation().getWorld().getName());
		cfg.set(SpawnName + ".SafeZone", yspawn);
		cfg.set(SpawnName + ".KillZone", ykill);
		Maps = (ArrayList<String>) cfg.getStringList("Maps");
		if(!Maps.contains(SpawnName)){
			Maps.add(SpawnName);
		}
		cfg.set("Maps", Maps);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static Location loadSpawn(String Name){
		Location loc = new Location(Bukkit.getWorld(cfg.getString(Name + ".WeltName")), cfg.getInt(Name + ".X"), cfg.getInt(Name + ".Y"), cfg.getInt(Name + ".Z"));
		loc.setYaw((float) cfg.getDouble(Name + ".Yaw"));
		loc.setPitch((float) cfg.getDouble(Name + ".Pitch"));
		return loc;
	}
}
