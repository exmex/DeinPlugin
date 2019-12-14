package servercore.addons;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import servercore.data.Data;

public class MSG implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("c")){
			Player p = (Player)s;
			if(p.hasPermission("core.msg")){
				if(args.length != 0 || args.length != 1){
					Player tar = Bukkit.getPlayer(args[0]);
					if(tar != null){
						if(tar != p){
							
					String Message = "";
					for(int i = 0; i<args.length; i++){
						Message += " " + args[i];
					}
					
					p.sendMessage(Data.Prefix + "§7" + p.getName() + "§8 » §e" + tar.getName() + "§8 » §6" + Message);
					tar.sendMessage(Data.Prefix + "§e" + p.getName() + "§8 » §e" + tar.getName() + "§8 » §6" + Message);
					
					return true;
						}else{
							p.sendMessage(servercore.data.Data.Prefix + "§cDu kannst keine Nachrichten an dich selbst senden!");
						}
					}else{
						p.sendMessage(servercore.data.Data.Prefix + "§cDieser Spieler ist nicht online!");
					}
				}else{
					p.sendMessage(servercore.data.Data.Prefix + "§cFalsche Benutzung! Nutze: §e/MSG [Spieler] [Nachricht]");
				}
			}else{
				p.sendMessage(servercore.data.Data.Prefix + "§cDu hast keine Berechtigung um dies auszuführen!");
			}
		}
		return false;
	}
	
	

}
