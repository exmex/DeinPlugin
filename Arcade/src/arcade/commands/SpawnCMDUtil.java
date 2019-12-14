package arcade.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import arcade.data.Data;
import arcade.manager.SpawnManager;

public class SpawnCMDUtil implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(args.length == 1){
				Player p = (Player)s;
				SpawnManager.setSpawn((Player)s, args[0], p.getLocation());
				p.sendMessage(Data.Prefix + "§eDer Spawn §7[§6" + args[0] + "§7] §e wurde gesetzt!");
			}else{
				s.sendMessage(Data.Prefix + "§eNutze §6/SetSpawn [Name]");
			}
		}
		return false;
	}
}
