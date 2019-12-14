package servercore.addons;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import servercore.api.API;
import servercore.data.Data;

public class Vanish implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("vanish") || c.getName().equalsIgnoreCase("v")){
			Player p = (Player)s;
			if(p.hasPermission("core.vanish")){
				if(Data.playerinvanish.contains(p)){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.showPlayer(p);
					}
					p.sendMessage(Data.Prefix + "§aDu hast den Vanish Modus §cverlassen§a!");
					API.playCoreSound(p);
				}else{
					for(Player all : Bukkit.getOnlinePlayers()){
						all.hidePlayer(p);
					}
					p.sendMessage(Data.Prefix + "§aDu hast den Vanish Modus §2betreten§a!");
					API.playCoreSound(p);
				}
			}else{
				p.sendMessage(Data.Prefix + "§cDu bist nicht befugt um diesen Befehl zu nutzen!");
			}
		}
		return false;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player all : Bukkit.getOnlinePlayers()){
			if(Data.playerinvanish.contains(all)){
				p.hidePlayer(all);
			}
		}
	}
	

}
