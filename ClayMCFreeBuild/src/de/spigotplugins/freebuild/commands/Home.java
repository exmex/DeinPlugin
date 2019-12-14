package de.spigotplugins.freebuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.spigotplugins.freebuild.data.Data;

public class Home implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("sethome")){
			s.sendMessage(Data.Prefix + "§cUm einen Home zu setzen, benötigst du einen §eHome-Block§c!");
			s.sendMessage(Data.Prefix + "§eDiesen §5Block §efindest du am §6Spawn §eim §6Shop§e! §8[§b/Spawn§8]");
			return true;
		}
		return false;
	}
	
	

}
