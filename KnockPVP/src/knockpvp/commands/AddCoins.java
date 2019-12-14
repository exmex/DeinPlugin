package knockpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import knockpvp.utils.Data;
import knockpvp.utils.Scoreboard;
import knockpvp.utils.Stats;

public class AddCoins implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("Addcoins")){
			Player p = (Player)sender;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 2){
					if(Bukkit.getPlayer(args[0]) !=null){
						int coins = Integer.parseInt(args[1]);
						Player tar = Bukkit.getPlayer(args[0]);
						Stats.coins.put(p.getName(), Stats.coins.get(p.getName()) + coins);
						p.sendMessage(Data.Prefix + "§3Du hast §6" + p.getName() + "§3 die Coins überwiesen!");
						tar.sendMessage(Data.Prefix + "§6Du hast Coins erhalten!");
						Scoreboard.setScoreboard(tar);
					}
				}
			}
		}
		return false;
	}
	
	

}
