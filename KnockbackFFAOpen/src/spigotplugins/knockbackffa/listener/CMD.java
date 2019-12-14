package spigotplugins.knockbackffa.listener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import spigotplugins.knockbackffa.main.Main;
import spigotplugins.knockbackffa.main.StatsManager;
import spigotplugins.knockbackffa.storage.Data;

public class CMD implements CommandExecutor{
	public CMD(spigotplugins.knockbackffa.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.knockbackffa.main.Main pl;
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("stats")){
			s.sendMessage("");
			s.sendMessage("�eDeine Kills: �6" + StatsManager.Kills.get(p.getName()));
			s.sendMessage("�eDeine Tode: �6" + StatsManager.Deaths.get(p.getName()));
			s.sendMessage("");
			return true;
		}
		if(c.getName().equalsIgnoreCase("changekit")){
			if(!p.hasPermission("knockbackffa.changekit")){
				return true;
			}
			if(Main.changeKit == false){
				if(Main.KitChange < 10){
					p.sendMessage(new Data().Prefix + "�cDas Kit wird in den n�chsten 10 Sekunden ge�ndert...");
					return true;
				}
				Main.changeKit = true;
				p.sendMessage(new Data().Prefix + "�eDas Kit wird in 10 Sekunden ge�ndert");
				Main.KitChange = 10;
			}else{
				p.sendMessage(new Data().Prefix + "�cDas Kit wird bereits ge�ndert...");
			}
			return true;
		}
		if(c.getName().equalsIgnoreCase("changemap")){
			if(!p.hasPermission("knockbackffa.changemap")){
				return true;
			}
			if(Main.changeMap == false){
				if(Main.MapChange < 10){
					p.sendMessage(new Data().Prefix + "�cDie Map wird in den n�chsten 10 Sekunden ge�ndert...");
					return true;
				}
				Main.changeMap = true;
				p.sendMessage(new Data().Prefix + "�eDie Karte wird in 10 Sekunden ge�ndert");
				Main.MapChange = 10;
			}else{
				p.sendMessage(new Data().Prefix + "�cDie Karte wird bereits ge�ndert...");
			}
			return true;
		}
		return false;
	}
	
	

}
