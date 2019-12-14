package de.spigotplugins.lobby.general;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.spigotplugins.lobby.configmanager.Strings;
import de.spigotplugins.lobby.data.Data;
import de.spigotplugins.logmanager.AsyncLogging;

public class FirstJoin {

	public static void checkIfPlayerHasGotFirstJoin(Player p){
		if(Data.FirstJoinRundruf == true){
			AsyncLogging.logAsynchrounusly(p.getName() + " hat den Server zum ersten mal betreten.");
			File file = new File("plugins//LobbySystem//firstjoin.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(cfg.get(p.getUniqueId() + ".FirstJoin") == null){
				cfg.set(p.getUniqueId() + ".FirstJoin", true);
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				return;
			}
			if(cfg.get("Player") == null){
				cfg.set("Player", 1);
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				Data.FirstJoinPlayers = cfg.getInt("Player");
				cfg.set("Player", Data.FirstJoinPlayers +1);
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(Strings.Prefix + Strings.FirstJoinMessageFormat.replace("%PLAYER%", p.getName()).replace("%PLAYERNUMBER%", Data.FirstJoinPlayers +1 +""));
			Bukkit.broadcastMessage("");
		}
	}
}
