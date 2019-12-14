package knockpvp.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import knockpvp.main.Main;
import knockpvp.utils.Data;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("claymc.admin")){
			if(args.length == 1){
				
				Main.setSpawn(args[0], p);
				p.sendMessage(Data.Prefix + "§eDu hast den Spawn für §6" + args[0] + "§e gesetzt!");
			
			}else{
				p.sendMessage(Data.Prefix + "§cFalsche Benutzung! Nutze bitte /SetSpawn [Name]!");
			}
			}else{
				p.sendMessage(Data.Prefix + "§cDir fehlt die Berechtigung um dies zu tun!");
			}
	
		}
		return false;
	}
	
	

}
