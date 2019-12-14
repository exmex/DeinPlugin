package souppvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import souppvp.data.Data;
import souppvp.manager.SpawnManager;
import souppvp.methods.Sounds;

public class SetSpawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setspawn")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 1){
					String Spawn = args[0];
					SpawnManager.createSpawn(p, p.getLocation(), Spawn);
					p.sendMessage(Data.Prefix + "§eDu hast den Spawn gesetzt§7 » §6" + Spawn);
					Sounds.playAdminAcceptSound(p);
					return true;
				}else{
					p.sendMessage(Data.Prefix + "§cFalsche Benutzung! §eNutze: §6/SetSpawn [Name]");
					return true;
				}
			}else{
				p.sendMessage(Data.NoPerm);
			}
		}
		return false;
	}
	
	

}
