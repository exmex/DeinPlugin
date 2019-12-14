package knockpvp.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import knockpvp.main.Main;
import knockpvp.utils.Data;

public class SetHigh implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("sethigh")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 1){
					if(Main.MapList.contains(args[0])){
				Data.cfg.set("High." + args[0], p.getLocation().getY());
				p.sendMessage(Data.Prefix + "§3Du hast die höhe zu §e" + p.getLocation().getY() + "§3 auf der Map §e"+ args[0] + " §3geändert!");
				Main.high = (int) p.getLocation().getY();
				try {
					Data.cfg.save(Data.file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
					p.sendMessage(Data.Prefix + "§cEine Map unter diesem Namen konnte nicht gefunden werden!"); 
				}
				}else{
					p.sendMessage(Data.Prefix + "§c/Sethigh [Map]");
				}
			}else{
				p.sendMessage("No");
			}
		}
		return false;
	}
	
	

}
