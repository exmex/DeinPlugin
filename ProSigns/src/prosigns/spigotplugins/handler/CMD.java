package prosigns.spigotplugins.handler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import prosigns.spigotplugins.data.Data;

public class CMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("sign")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				if(args.length != 4){
					p.sendMessage("");
					p.sendMessage(Data.Prefix + "§e/Sign §aCreate §c[IP] §6[Port] §3§l[BungeeName]");
					p.sendMessage("");
				}
			
				if(args.length == 4){
					if(args[0].equalsIgnoreCase("Create")){
						p.sendMessage(Data.Prefix + "§3Bitte schlage das Schild, welches du hinzufügen möchtest!");
						Data.Transferdata.put(p.getName(), args[1] + ";" + args[2] + ";" + args[3]);
						Data.createsign.put(p.getName(), true);
					}
				}
			}
		}
		return false;
	}
	

}
