package de.codeexception.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.codeexception.oneversusone.Main;
import de.codeexception.utils.PlayerStats;
import de.codeexception.utils.SQLStats;

public class Stats implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				PlayerStats stats = new PlayerStats(p.getUniqueId().toString());
				p.sendMessage(Main.px+"Stats von §e" + p.getName());
				p.sendMessage(Main.px+"§6Kills: §c" + stats.getKills());
				p.sendMessage(Main.px+"§6Deaths: §c" + stats.getDeaths());
				}
			else if(args.length == 1) {
				OfflinePlayer t =  Bukkit.getOfflinePlayer(args[0]);
				if(SQLStats.playerEx(t.getUniqueId().toString())) {
					PlayerStats tstats = new PlayerStats(t.getUniqueId().toString());
					p.sendMessage(Main.px+"Stats von §e" + t.getName());
					p.sendMessage(Main.px+"§6Kills: §c" + tstats.getKills());
					p.sendMessage(Main.px+"§6Deaths: §c" + tstats.getDeaths());	
				}else {
					p.sendMessage(Main.px+"Der Spieler " + t.getName() + " ist dem Modus nicht bekannt");
				}
			}else {
				p.sendMessage(Main.px+"/stats <Spieler>");
			}
		}
		return false;
	}

}
