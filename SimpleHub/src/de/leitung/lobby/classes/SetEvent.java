package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetEvent implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setevent")){
			Player p = (Player)sender;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 0){
					p.sendMessage(Main.Prefix + "§cBenutzung: §6/SetEvent [Daten]");
				}else{
					
					String Message = "";
					for(int i = 0; i<args.length; i++){
						Message += " " + args[i];
					}
					Main.ScorebardEvent = Message;
					File file = new File("plugins//Lobby//event.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Event", Message.toString());
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Player all : Bukkit.getOnlinePlayers()){
						Scoreboard.setScoreboard(all);
					}
				}
			}else{
				p.sendMessage(Main.Prefix + "§cDu musst ein Teammitglied sein, um diesen Befehl ausführen zu können!");
			}
		}
		return false;
	}

}
