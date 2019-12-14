package spigotplugins.skywars.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.storage.Data;

public class StatsCMD implements CommandExecutor{
	public StatsCMD(spigotplugins.skywars.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.skywars.main.Main pl;
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("stats")){
			if(args.length == 0){
				Player p = (Player)s;
				Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						p.sendMessage("");
						p.sendMessage(Data.Prefix + "§eKills: §6" + new Manager().getInt(p.getUniqueId(), "SKYWARS", "KILLS"));
						p.sendMessage(Data.Prefix + "§eDeaths: §6" + new Manager().getInt(p.getUniqueId(), "SKYWARS", "DEATHS"));
						p.sendMessage(Data.Prefix + "§eDein Rang: §6" + new Manager().getRankingFromUUID(p.getUniqueId(), "SKYWARS", "KILLS"));
						p.sendMessage(Data.Prefix + "§eDeine Wins: §6" + new Manager().getInt(p.getUniqueId(), "SKYWARS", "WINS"));
						p.sendMessage(Data.Prefix + "§eDeine Coins: §6" + new Manager().getInt(p.getUniqueId(), "SKYWARS", "COINS"));

					}
				},1L);
			}else{
				s.sendMessage(Data.Prefix + "§eBitte gebe §b/Stats §eein!");
			}
		}
		if(c.getName().equalsIgnoreCase("top")){
			if(args.length == 0){
				Player p = (Player)s;
				Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {

						p.sendMessage(Data.Prefix + "§7[§b#1§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 1) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 1), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#2§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 2) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 2), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#3§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 3) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 3), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#4§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 4) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 4), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#5§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 5) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 5), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#6§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 6) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 6), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#7§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 7) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 7), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#8§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 8) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 8), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#9§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 9) + "§7- §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 9), "SKYWARS", "KILLS") + "§9 Kills");
						p.sendMessage(Data.Prefix + "§7[§b#10§7] §6" + new Manager().getNameRankByID("SKYWARS", "KILLS", 10) + "§7/ §a" + new Manager().getInt(new Manager().getUUIDRankByID("SKYWARS", "KILLS", 10), "SKYWARS", "KILLS") + "§9 Kills");

					}
				}, 1L);
			}else{
				s.sendMessage(Data.Prefix + "§eBitte gebe §b/Top §eein!");
			}
		}
		return false;
	}
	
	

}
