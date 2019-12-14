package oneline.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import oneline.data.Data;
import oneline.main.Main;
import oneline.methods.SpawnManager;

public class CMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(!s.hasPermission("claymc.admin")){
				return true;
			}
			if(args.length == 1){
				SpawnManager.setSpawn(p, args[0].toUpperCase(), p.getLocation());
				s.sendMessage(Data.Prefix + "§eDer Spawn §6" + args[0].toUpperCase() + "§e wurde gesetzt!");
			}else{
				s.sendMessage(Data.Prefix + "§6/SetSpawn §9[S1/2..] §7| §6/SetSpawn §[I1/2..]");
				return true;
			}
		}
		if(c.getName().equalsIgnoreCase("start")){
			if(p.hasPermission("claymc.admin")){
				Main.KnockTime = 4;
			}
		}
		return false;
	}
	
	

}
