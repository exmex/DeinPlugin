package bedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bedwars.utils.Data;

public class LateSpawnManager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("bw")){
			Player p = (Player)sender;
			if(args.length == 0){
			p.sendMessage("§b§m---------------------");
			p.sendMessage(Data.Prefix + "§6Entwicklung: §7Anweisung");
			p.sendMessage("§b§m---------------------");
			if(p.hasPermission("claymc.admin")){
			p.sendMessage(Data.Prefix + "§6/BW SetSpawn [1-4]");
			p.sendMessage(Data.Prefix + "§6/BW SetTeam §7[§bBlau§7/§cRot§7/§eGelb§7/§aGrün§7]");
			p.sendMessage("§b§m---------------------");
			}
		return true;
			}
			if(args.length == 2){
			if(args[0].equalsIgnoreCase("SetSpawn")){
				
			}
			}
		}
		return false;
	}
	
	

	
}
