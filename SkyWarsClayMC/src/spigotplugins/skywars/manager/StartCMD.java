package spigotplugins.skywars.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import spigotplugins.skywars.main.Main;
import spigotplugins.skywars.storage.Data;

public class StartCMD implements CommandExecutor{
	public static boolean started;
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("start")){
			if(!s.hasPermission("claymc.skywars.start")){
				s.sendMessage(Data.Prefix + "§cDiesen Command kannst du mit dem §5YouTuber §cRang ausführen.");
				return true;
			}
			if(Bukkit.getOnlinePlayers().size() > 1){
				if(started == false){
			Main.wartezeit = 11;
			started = true;
			s.sendMessage(Data.Prefix + "§aDu hast die Wartezeit verkürzt!");
				}else{
				s.sendMessage(Data.Prefix + "§cDas Spiel startet bereits!");
				}
				}else{
			s.sendMessage(Data.Prefix + "§cEs sind zu wenige Spieler online, um dies zu tun!");
		}
				
		}
		return false;
	}

}
