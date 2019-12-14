package de.leitung.lobby.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class CoinsAPIUpgrade implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins//Lobby//coinsapi.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get(p.getUniqueId() + ".Name") == null){
			cfg.set(p.getUniqueId() + ".Name", p.getName());
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		String PlayerName = p.getName();
		String ConfigName = cfg.getString(p.getUniqueId() + ".Name");
		if(PlayerName.contains(ConfigName)){
			return;
		}else{
			int oldcoins = CoinsAPI.getCoins(ConfigName);
			CoinsAPI.addCoins(p.getName(), oldcoins);
			p.sendMessage(Main.Prefix + "§2Deine Clays wurden erfolgreich auf deinen neuen Account übertragen!"); 
			cfg.set(p.getUniqueId() + ".Name", null);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
