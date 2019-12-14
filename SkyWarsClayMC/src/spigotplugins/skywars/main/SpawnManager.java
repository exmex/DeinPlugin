package spigotplugins.skywars.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import spigotplugins.skywars.storage.Data;

public class SpawnManager {
	public static File file = new File("plugins//SkyWars//spawns.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static void setWarp(Player p, String Name){
		cfg.set("X." + Name, p.getLocation().getX());
		cfg.set("Y." + Name, p.getLocation().getY());
		cfg.set("Z." + Name, p.getLocation().getZ());
		cfg.set("Yaw." + Name, p.getLocation().getYaw());
		cfg.set("Pitch." + Name, p.getLocation().getPitch());
		cfg.set("WeltName." + Name, p.getLocation().getWorld().getName());
		p.sendMessage(Data.Prefix + "§eDer Warp §6" + Name + "§e wurde gesetzt!");
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setGame(Player p, String Map, int SpawnNummer){
		List list;
		list = cfg.getStringList("Maps");
		if(!list.contains(Map)){
			list.add(Map);
			cfg.set("Maps", list);
		}
		cfg.set("X." + Map + "." + SpawnNummer, p.getLocation().getX());
		cfg.set("Y." + Map + "." + SpawnNummer, p.getLocation().getY());
		cfg.set("Z." + Map + "." + SpawnNummer, p.getLocation().getZ());
		cfg.set("Yaw." + Map + "." + SpawnNummer, p.getLocation().getYaw());
		cfg.set("Pitch." + Map + "." + SpawnNummer, p.getLocation().getPitch());
		cfg.set("WeltName." + Map + "." + SpawnNummer, p.getLocation().getWorld().getName());
		p.sendMessage(Data.Prefix + "§eDer Spawn bei der Map §6" + Map + "§e wurde gesetzt! §7| §4" + SpawnNummer);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Location loadWarp(String Name){
		Location loc = new Location(Bukkit.getWorld(cfg.getString("WeltName.Spawn")), cfg.getDouble("X.Spawn"), cfg.getDouble("Y.Spawn"), cfg.getDouble("Z.Spawn"));
		loc.setYaw((float) cfg.getDouble("Yaw.Spawn"));
		loc.setPitch((float) cfg.getDouble("Pitch.Spawn"));
		return loc;
	}
	public static Location loadGame(String Name, int Anzahl){
		Location loc = new Location(Bukkit.getWorld(cfg.getString("WeltName." + Name + "." + Anzahl)), cfg.getDouble("X." + Name + "." + Anzahl), cfg.getDouble("Y." + Name + "." + Anzahl), cfg.getDouble("Z." + Name + "." + Anzahl));
		loc.setYaw((float) cfg.getDouble("Yaw." + Name + "." + Anzahl));
		loc.setPitch((float) cfg.getDouble("Pitch." + Name+ "." + Anzahl));
		return loc;
	}
}
