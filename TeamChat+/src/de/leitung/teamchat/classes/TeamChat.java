package de.leitung.teamchat.classes;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tc")){
			if(sender instanceof Player){
				Player p = (Player)sender;
			if(p.hasPermission("teamchat.use")){
				if(args.length == 0){
					p.sendMessage("§cFolgende Benutzung: §b/TC [Nachricht]");
				}else{
				String Message = "";
				for(int i = 0; i<args.length; i++){
					Message += " " + args[i];
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					if(all.hasPermission("teamchat.use")){
						all.sendMessage("§8[§bTeamChat§8] §6" + p.getName() + "§7 >> §3" + Message.toString());
						all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					}
				}
				}
				}else{
				p.sendMessage("§cDu bist nicht befugt diesen Chat zu nutzen!");
			}
		}else{
			sender.sendMessage("§cDu musst ein Spieler sein!");
		}
		}
		return false;
	}
	
	

}
