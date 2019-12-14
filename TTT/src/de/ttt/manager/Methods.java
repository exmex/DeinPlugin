package de.ttt.manager;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.ttt.utils.Data;

public class Methods {

	public HashMap<String, Location> spawns = new HashMap<>();
	
	public void setWarp(Player p, String Warpname){
		Data.cfg.set(Warpname + ".X", p.getLocation().getX());
		Data.cfg.set(Warpname + ".Y", p.getLocation().getY());
		Data.cfg.set(Warpname + ".Z", p.getLocation().getZ());
		Data.cfg.set(Warpname + ".Yaw", p.getLocation().getYaw());
		Data.cfg.set(Warpname + ".Pitch", p.getLocation().getPitch());
		Data.cfg.set(Warpname + ".WeltName", p.getLocation().getWorld().getName());
		try {
			Data.cfg.save(Data.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Location loadLocation(String WarpName){
		Location loc = new Location(Bukkit.getWorld(Data.cfg.getString(WarpName + ".WeltName")), Data.cfg.getDouble(WarpName + ".X"), Data.cfg.getDouble(WarpName + ".Y"), Data.cfg.getDouble(WarpName + ".Z"));
		double ya = Data.cfg.getDouble(WarpName + ".Yaw");
		double pi = Data.cfg.getDouble(WarpName + ".Pitch");
		loc.setYaw((float) ya);
		loc.setPitch((float) pi);
		return loc;
		
	}
}
