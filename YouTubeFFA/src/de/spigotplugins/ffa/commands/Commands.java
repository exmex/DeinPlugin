package de.spigotplugins.ffa.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.spigotplugins.ffa.data.Data;
import de.spigotplugins.ffa.main.Main;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(s instanceof Player){
			Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("ffa")){
			if(args.length == 0){
				p.sendMessage(Data.Prefix + "§eDu befindest dich hier auf einem System, welches von WeLoveSpigotPlugins programmiert wurde!");
			if(p.hasPermission("ffa.admin")){
				p.sendMessage(Data.Prefix + "§6/FFA Setspawn [Map] §8» §eSetze den Main Spawn!");
				p.sendMessage(Data.Prefix + "§6/FFA Sethigh [Map] §8» §eÜber dem Punkt kann man sich nicht mehr schlagen!");
				p.sendMessage(Data.Prefix + "§6/FFA Remove [Map] §8» §eEntferne eine bekannte Map!");
				p.sendMessage(Data.Prefix + "§6/FFA List §8» §eEntferne eine bekannte Map!");
				p.sendMessage(Data.Prefix + "§6/NoHitDelay §aOn§7/§cOff §8» §eBestimme den Hitdelay");
			}
				return true;
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("setspawn")){
					if(p.hasPermission("ffa.admin")){
						if(Data.enable == false){
							p.sendMessage("§7§m-----------------------------------");
							p.sendMessage(Data.Prefix + "§aBitte starte nun deinen Server neu!");
							p.sendMessage(Data.Prefix + "§3Danach wird der Server funktionieren.");
							p.sendMessage("§7§m-----------------------------------");
						}
						String Map = args[1];
						File file = new File("plugins//FFA//spawns.yml");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						Location loc = p.getLocation();
						cfg.set("Spawn.X." + Map, loc.getX());
						cfg.set("Spawn.Y." + Map, loc.getY());
						cfg.set("Spawn.Z." + Map, loc.getZ());
						cfg.set("Spawn.Yaw." + Map, loc.getYaw());
						cfg.set("Spawn.Pitch." + Map ,loc.getPitch());
						cfg.set("Spawn.Weltname." + Map, loc.getWorld().getName());
						if(Main.loadMapName(Map) == true){
							
							return true;
						}
						p.sendMessage(Data.Prefix + "§eBitte starte diesen Server neu / reloade ihn, damit diese Map entsprechend angewendet werden kann!");
						Main.putMapName(Map);
						Main.safeAvailableMaps();
						try {
							cfg.save(file);
						} catch (IOException e) {
							Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cFehler");
						}
						p.sendMessage(Data.Prefix + "§aDu hast den Spawn für §e" + Map + " §aerfolgreich gesetzt!");
						
					}else{
						p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun!");
					return true;
					}
				}else if(args[0].equalsIgnoreCase("remove")){
					if(Main.loadMapName(args[1]) == true){
						Main.safeAvailableMaps();
						p.sendMessage(Data.Prefix + "§eDiese Map wird nicht erneut in dem Random Verfahren vorkommen!");
						File file = new File("plugins//FFA//spawns.yml");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						cfg.set("Spawn.X." + args[1], null);
						cfg.set("Spawn.Y." + args[1], null);
						cfg.set("Spawn.Z." + args[1], null);
						cfg.set("Spawn.Yaw." + args[1], null);
						cfg.set("Spawn.Pitch." + args[1], null);
						cfg.set("Spawn.Weltname." + args[1], null);
						Main.removeMapName(args[1]);
						Data.Maps.remove(args[1]);
						Main.safeAvailableMaps();
						Main.loadAvailableMaps();
						try {
							cfg.save(file);
						} catch (IOException e) {
							
						}
					}else{
						p.sendMessage(Data.Prefix + "§cEine Map unter dem Namen §e" + args[1] + "§c konnte nicht gefunden werden");
					}
				}
				
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					Main.loadAvailableMaps();
					if(Data.Maps.isEmpty()){
						p.sendMessage(Data.Prefix + "§cDerzeit hast du noch keine Maps gesetzt!");
						return true;
					}
					for(int i = 0 ; i < Data.Maps.size() ; i++){
						p.sendMessage(Data.Prefix + "§6Map §7» §3" + Data.Maps.get(i));
					}
				
			}
			}else{
				p.sendMessage(Data.Prefix + "§cFalsche benutzung! Nutze /FFA Setspawn §e[Map]");
			}

				if(args[0].equalsIgnoreCase("sethigh")){
					
					Data.hohe = p.getLocation().getY();
					File file = new File("plugins//FFA//spawns.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Hohe." + args[1], p.getLocation().getY());
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.sendMessage(Data.Prefix + "§eDu hast die Höhe auf §e" + args[1] + "§e gesetzt! Über dieser höhe kann man sich NICHT mehr schlagen!");
				
				}
		}
		}
		return false;
	}
	
	

}
