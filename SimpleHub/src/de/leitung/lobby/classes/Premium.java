package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Premium implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender se, Command c, String arg2, String[] args) {
		Player p = (Player)se;
		if(c.getName().equalsIgnoreCase("premium")){
			if(PermissionsEx.getUser(p).inGroup("default")){
			File file = new File("plugins//Lobby//goldtest.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(cfg.get(p.getUniqueId() + ".Used") == null){
				cfg.set(p.getUniqueId() + ".Used", false);
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				if(cfg.getBoolean(p.getUniqueId() + ".Used") == false){
					cfg.set(p.getUniqueId() + ".Used", true);
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setrang " + p.getName() + " Gold 12 h");
				
			
				}
			}
			}else{
				p.sendMessage(Main.Prefix + "§cDu hast bereits einen höhreren Rang als §6Gold§c!");
			}
			
		}
		return false;
	}

	
	
}
