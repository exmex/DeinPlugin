package de.welovespigotplugins.knockbackffa.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class sethigh implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("sethigh")){
			if(sender.hasPermission("knockbackffa.admin")){
				File file = new File("plugins//NewKnockbackFFA//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				Player p = (Player)sender;
				cfg.set("SetHigh", p.getLocation().getY());
				try {
					cfg.save(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				main.a = p.getLocation().getY();
				p.sendMessage(main.Prefix + "§6Die höhe wurde auf §c" + p.getLocation().getY() + "§6 gesetzt!");
			}
		}
		return false;
	}

}
