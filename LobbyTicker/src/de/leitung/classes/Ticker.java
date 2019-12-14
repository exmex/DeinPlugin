package de.leitung.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Ticker implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("lobbyticker.tick")){
			String group = PermissionsEx.getUser(p).getGroups()[0].getName();
			File file = new File("plugins//LobbyTicker//ticker.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(cfg.get(group + "." + p.getName()) == null){
				cfg.set(group + "." + p.getName(), 1);
				try {
					cfg.save(file);
				} catch (IOException e1) {
				}
			}else{
				int i = cfg.getInt(group + "." + p.getName());
				cfg.set(group + "." + p.getName(), i+1);
				try {
					cfg.save(file);
				} catch (IOException e1) {
				}
			}
		}
	}

}
