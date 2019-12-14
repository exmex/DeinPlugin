package de.skywars.methods;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.skywars.main.Main;
import de.skywars.main.MainListener;
import de.skywars.utils.Data;

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
						
					}
					}else{
						if(args.length == 2){
					int i = Integer.parseInt(args[0]);
					Location loc = p.getLocation();
					String MapName = args[1];
						Data.cfg.set("Spawn" + MapName + i + ".X", loc.getX());
						Data.cfg.set("Spawn" + MapName + i + ".Y", loc.getY());
						Data.cfg.set("Spawn" + MapName + i + ".Z", loc.getZ());
						Data.cfg.set("Spawn" + MapName + i + ".Yaw", loc.getYaw());
						Data.cfg.set("Spawn" + MapName + i + ".Pitch", loc.getPitch());
						Data.cfg.set("Spawn" + MapName + i + ".Weltname", loc.getWorld().getName());
						if(!Main.list.contains(MapName)){
						Main.list.add(MapName);
						Data.cfg.set("Maps", Main.list);
						}
						try {
							Data.cfg.save(Data.file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						p.sendMessage(Data.Prefix + "§aDu hast den Spawn unter dem Namen§e " + MapName + " §aerfolgreich gesetzt! §8 » §3" + i);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						
						}
					}
				
			}else{
				p.sendMessage(Data.Prefix + "§cDu hast nicht die nötigen Rechte um dies zu tun!");
			}
		}
		if(c.getName().equalsIgnoreCase("start")){
			
			if(s.hasPermission("skywars.start")){
				if(Main.gamestart == false){
					if(Bukkit.getOnlinePlayers().size() > 1){
					Main.gamestart = true;
				MainListener.cdc = 11;
				s.sendMessage(Data.Prefix + "§aDu hast das Spiel frühzeitig gestartet!");
					}else{
						s.sendMessage(Data.Prefix + "§cEs müssen mindestens §32 §cSpieler online sein!");
					}
				}else{
					s.sendMessage(Data.Prefix + "§cDas Spiel startet bereits...");
				}
			}else{
				s.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun...");
			
			}
		}
		return false;
	}
	
	public static void teleportToArena(Player p, int Spawn){
		int x = Data.cfg.getInt("Spawn" + Main.MapName + Spawn + ".X");
		int y = Data.cfg.getInt("Spawn" + Main.MapName + Spawn + ".Y");
		int z = Data.cfg.getInt("Spawn" + Main.MapName + Spawn + ".Z");
		float yaw = (float) Data.cfg.getDouble("Spawn" + Main.MapName + Spawn + ".Yaw");
		float pitch = (float) Data.cfg.getDouble("Spawn" + Main.MapName + Spawn + ".Pitch");
		String weltname = Data.cfg.getString("Spawn" + Main.MapName + Spawn + ".Weltname");
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
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		p.teleport(loc);
	}

}
