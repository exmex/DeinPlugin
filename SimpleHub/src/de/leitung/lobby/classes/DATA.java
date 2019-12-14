package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DATA implements Listener{
	public static ArrayList<Player> fireboots = new ArrayList<Player>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		File file = new File("plugins//Lobby//data.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Player p = e.getPlayer();
		if(cfg.get(p.getUniqueId() + ".Fireboots") == null){
			cfg.set(p.getUniqueId() + ".Fireboots", true);
			try {
				cfg.save(file);
				return;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(cfg.getBoolean(p.getUniqueId() + ".Fireboots") == true){
			fireboots.add(p);
		}
	}
	public static void addFireBoots(Player p){
		File file = new File("plugins//Lobby//data.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set(p.getUniqueId() + ".Fireboots", true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
