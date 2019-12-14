package de.skywars.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.skywars.gamestates.GameState;
import de.skywars.utils.Data;
import de.skywars.utils.Scoreboard;


public class SetMap implements CommandExecutor{

	public static boolean fin;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setmap")){
			Player p = (Player)sender;
			if(p.hasPermission("claymc.admin")){
				File file = new File("plugins//SkyWars//maps.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if(args.length == 0){
					p.sendMessage(Data.Prefix + "§cBitte gebe einen Mapnamen ein!");
				}else if(args.length == 1){
					String Map = args[0];
					p.sendMessage(Data.Prefix + "§eDie Karte wurde zu §6" + Map + "§e geändert!");
					de.skywars.main.Main.MapName = Map;
					for(Player all : Bukkit.getOnlinePlayers()){
					Scoreboard.setScoreboard(all);
					}
					cfg.set("Map", Map);
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}else{
				p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um die Karte zu ändern!");
			}
		}else if(cmd.getName().equalsIgnoreCase("forcemap")){
			Player p = (Player)sender;
			if(p.hasPermission("claymc.forcemap")){
				if(args.length == 0){
				for(int i = 0 ; i < de.skywars.main.Main.list.size() ; i++){
					p.sendMessage(Data.Prefix + "§6Karte: §e" + de.skywars.main.Main.list.get(i));
				}
				}else if(args.length == 1){
					if(de.skywars.main.Main.gs == GameState.LOBBY){
					if(de.skywars.main.Main.list.contains(args[0])){
						if(fin == false){
							fin = true;
						de.skywars.main.Main.MapName = args[0];
						for(Player all : Bukkit.getOnlinePlayers()){
							Scoreboard.setScoreboard(all);
						}
						p.sendMessage(Data.Prefix + "§6Du hast die Map erfolgreich geändert!");
						}else{
							p.sendMessage(Data.Prefix + "§cDie Map wurde bereits ein Map geändert!");
						}
						}else{
						p.sendMessage(Data.Prefix + "§cEine Map unter diesem Namen wurde nicht gefunden!");
					}
					}else{
						p.sendMessage(Data.Prefix + "§cDu kannst die Map nicht mehr wechseln!");
					}
					
					
				}
			}else{
				p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun...");
			}
		}
		return false;
	}
	
	

}
