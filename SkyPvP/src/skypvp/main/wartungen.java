package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class wartungen implements Listener,CommandExecutor{

	public wartungen(skypvp.main.main main){
		this.pl = main;
	}
	private skypvp.main.main pl;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("wartungen")){
			if(p.hasPermission("SkyPvP.admin")){
			if(pl.getConfig().getBoolean("Wartungen") == true){
				pl.getConfig().set("Wartungen", false);
				p.sendMessage(main.Prefix + "§aDer Server ist nun wieder öffentlich!");
			}else if(pl.getConfig().getBoolean("Wartungen") == false){
				pl.getConfig().set("Wartungen", true);
				p.sendMessage(main.Prefix + "§cDer Server befindet sich nun im Wartungsmodus!");
				for(Player all : Bukkit.getOnlinePlayers()){
					if(!all.hasPermission("SkyPvP.admin")){
						all.kickPlayer("§cDer Server befindet sich nun im Wartungsmodus!");
					}
				}
				
			}
			
		}
		}
		return false;

		
	}
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		if(pl.getConfig().getBoolean("Wartungen") == false){
			e.allow();
		}else if(pl.getConfig().getBoolean("Wartungen") == true){
			e.disallow(null, "§4Der Server befindet sich im Wartungsmodus!");
			if(p.hasPermission("Skypvp.admin")){
				e.allow();
				p.sendMessage("§4Der Server befindet sich im Wartungsmodus!");
				p.sendMessage("§bDu hast ausreichende Rechte, um auf dem Server zu bleiben.");

			}
		}
	}
}