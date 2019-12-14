package spigotplugins.skywars.manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import spigotplugins.skywars.main.SpawnManager;
import spigotplugins.skywars.storage.Data;

public class SpawnCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command c, String arg2, String[] args) {
		Player p = (Player)sender;
		if(!p.hasPermission("claymc.admin")){
			return true;
		}
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(args.length == 1){
				SpawnManager.setWarp(p, args[0]);
				return true;
			}
			if(args.length == 2){
				SpawnManager.setGame(p, args[0], Integer.parseInt(args[1]));
				return true;
			}
			p.sendMessage(Data.Prefix + "§cBitte Tippe: /SetSpawn [Warp] | /SetSpawn [Map] [Nummer]");
		}
		return false;
	}

}
