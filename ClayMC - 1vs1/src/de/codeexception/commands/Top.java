package de.codeexception.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.codeexception.oneversusone.Main;
import de.codeexception.utils.UUIDFetcher;

public class Top implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String labael, String[] args) {
		if(cs instanceof Player) {
			Player p = (Player) cs;
			ArrayList<String> topplayers = Main.topplayers;
			for(int i = 0;i < topplayers.size();i++) {
				String name = UUIDFetcher.getName(UUID.fromString(topplayers.get(i)));
				p.sendMessage(Main.px+"§8#§e" + String.valueOf(i+1) + " §7" + name+"");
			}
		}
		return true;
	}

}
