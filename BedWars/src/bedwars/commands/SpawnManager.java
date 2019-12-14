package bedwars.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bedwars.listener.MainListener;
import bedwars.main.Main;
import bedwars.utils.Data;


public class SpawnManager implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("spawn")){
						String i = "Spawn";
						Location loc = p.getLocation();
						Data.cfg.set("Spawn" + i + ".X", loc.getX());
						Data.cfg.set("Spawn" + i + ".Y", loc.getY());
						Data.cfg.set("Spawn" + i + ".Z", loc.getZ());
						Data.cfg.set("Spawn" + i + ".Yaw", loc.getYaw());
						Data.cfg.set("Spawn" + i + ".Pitch", loc.getPitch());
						Data.cfg.set("Spawn" + i + ".Weltname", loc.getWorld().getName());
						
						try {
							Data.cfg.save(Data.file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						p.sendMessage(Data.Prefix + "§aDu hast den Spawn erfolgreich gesetzt! §8 » §3" + i);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						
						
					}else{
					int i = Integer.parseInt(args[0]);
					Location loc = p.getLocation();
					
						Data.cfg.set("Spawn" + i + ".X", loc.getX());
						Data.cfg.set("Spawn" + i + ".Y", loc.getY());
						Data.cfg.set("Spawn" + i + ".Z", loc.getZ());
						Data.cfg.set("Spawn" + i + ".Yaw", loc.getYaw());
						Data.cfg.set("Spawn" + i + ".Pitch", loc.getPitch());
						Data.cfg.set("Spawn" + i + ".Weltname", loc.getWorld().getName());

						try {
							Data.cfg.save(Data.file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						p.sendMessage(Data.Prefix + "§aDu hast den Spawn erfolgreich gesetzt! §8 » §3" + i);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						

					}
				}else{
					p.sendMessage(Data.Prefix + "§e/SetSpawn §7[§61-8§7]");
					return true;
				}
			}else{
				p.sendMessage(Data.Prefix + "§cDu hast nicht die nötigen Rechte um dies zu tun!");
			}
		}
		
		return false;
	}
	
	public static void teleportToArena(Player p, int Spawn){
		int x = Data.cfg.getInt("Spawn" + Spawn + ".X");
		int y = Data.cfg.getInt("Spawn" + Spawn + ".Y");
		int z = Data.cfg.getInt("Spawn" + Spawn + ".Z");
		double yaw = Data.cfg.getDouble("Spawn" + Spawn + ".Yaw");
		double pitch = Data.cfg.getDouble("Spawn" + Spawn + ".Pitch");
		String weltname = Data.cfg.getString("Spawn" + Spawn + ".Weltname");
		Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		
		p.teleport(loc);
		
		return;
		
	}
	public static void teleportToSpawn(Player p){
		String Spawn = "Spawn";
		int x = Data.cfg.getInt("Spawn" + Spawn + ".X");
		int y = Data.cfg.getInt("Spawn" + Spawn + ".Y");
		int z = Data.cfg.getInt("Spawn" + Spawn + ".Z");
		double yaw = Data.cfg.getDouble("Spawn" + Spawn + ".Yaw");
		double pitch = Data.cfg.getDouble("Spawn" + Spawn + ".Pitch");
		String weltname = Data.cfg.getString("Spawn" + Spawn + ".Weltname");
		Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
		
		p.teleport(loc);
	}

}
