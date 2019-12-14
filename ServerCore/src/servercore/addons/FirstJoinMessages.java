package servercore.addons;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinMessages implements Listener{
	public static int totalPlayers;
	static File file = new File("plugins//ServerCore//player.yml");
	static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(cfg.get(p.getUniqueId() + ".Player") == null){
			cfg.set("Player", cfg.getInt("Players") + 1);
			cfg.set(p.getUniqueId() + ".Player", true);
			try {
				cfg.save(file);
			} catch (IOException e1) {

			}
			totalPlayers = cfg.getInt("Players");
		}
	}

	public static void checkIfConfigExists(){
		if(cfg.get("Players") == null){
			cfg.set("Players", 0);
			totalPlayers = 0;
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
