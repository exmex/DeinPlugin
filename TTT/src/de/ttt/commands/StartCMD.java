package de.ttt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ttt.game.MainListener;
import de.ttt.gamestates.GameState;
import de.ttt.main.Main;
import de.ttt.utils.Data;

public class StartCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("start")){
			if(s instanceof Player){
			Player p = (Player)s;
			if(s.hasPermission("ttt.start")){
				if(Bukkit.getOnlinePlayers().size() > 0){
					if(Main.gs == GameState.LOBBY){
						if(MainListener.cdz >= 10){
							MainListener.cdz = 11;
							p.sendMessage(Data.prefix + "§aDu hast die Wartezeit verkürzt!");
							return true;
						}else{
							p.sendMessage(Data.prefix + "§cDas Spiel startet bereits");
						}
					}else{
						p.sendMessage(Data.prefix + "§cDas Spiel hat bereits begonnen!");
					}
				}else{
					p.sendMessage(Data.prefix + "§cEs müssen mindestens 4 Spieler Online sein!");
				}
			}
		}else{
			s.sendMessage(Data.prefix + "§cDu musst ein Spieler sein!");
		}
	}
		return false;
	}
}
