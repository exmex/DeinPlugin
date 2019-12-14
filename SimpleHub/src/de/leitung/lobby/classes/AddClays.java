package de.leitung.lobby.classes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class AddClays implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("addclays")){
			if(p.hasPermission("claymc.admin")){
				if(args.length == 0){
					p.sendMessage(Main.Prefix + "§cBenutzung: §3/AddClays [Spieler] [Anzahl]");
					return true;
				}else if(args.length == 2){
					String Player = args[0];
					int Anzahl = Integer.parseInt(args[1]);
					Player target = Bukkit.getPlayer(Player);
					if(target != null){
						CoinsAPI.addCoins(target.getName(), Anzahl);
						p.sendMessage(Main.Prefix + "§3Die Coins von §e" + target.getName()+  "§3 wurden zu §e" + CoinsAPI.getCoins(target.getName()) + "§3 geändert!");
						target.sendMessage(Main.Prefix + "§2Deine Clays wurden auf §e" + CoinsAPI.getCoins(target.getName()) + "§2 geändert!");
					}else{
						p.sendMessage(Main.Prefix + "§cDer Spieler §3" + target.getName() + "§c ist nicht online!");
					}
				}
			}else{
				p.sendMessage(Main.Prefix + "§cDu darfst diesen Befehl nicht nutzen!");
			}
		}
		return false;
	}
	
	

}
