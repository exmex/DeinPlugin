package clayhandler;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setclays")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 1){
					int i = Integer.parseInt(args[0]);
					p.sendMessage(Data.Prefix + "§eMan erhält nun pro Kill §6" + i + "§e Clays!");
					Data.CurrentClays = i;
					Data.cfg.set("Clays", i);
					try {
						Data.cfg.save(Data.file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				p.sendMessage(Data.Prefix + "§cDu darfst diesen Befehl leider nicht nutzen!");
			}
		}
		if(c.getName().equalsIgnoreCase("getserverclays")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				p.sendMessage(Data.Prefix + "§eAuf diesem Server wurden insgesamt schon §6" + Data.ServerClays + " §eClays verteilt!");
			}else{
				p.sendMessage(Data.Prefix + "§cDu darfst diesen Befehl leider nicht nutzen!");
			}
		}
		return false;
	}
	
	

}
