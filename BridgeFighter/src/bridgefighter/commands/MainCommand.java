package bridgefighter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bridgefighter.data.Data;
import bridgefighter.methods.TeleportManager;

public class MainCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			Player p = (Player)s;
			if(s.hasPermission("claymc.admin")){
			if(args.length == 1){
				TeleportManager.setSpawn(args[0], p.getLocation());
				p.sendMessage(Data.Prefix + "§eDu hast die Location für §6" + args[0] + "§e gesetzt!");
			}else{
				p.sendMessage(Data.Prefix + "§c/SetSpawn §e[Name]");
			}
			}else{
				s.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun.");
			}
		}
		return false;
	}
	
	

}
