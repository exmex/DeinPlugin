package spigotplugins.knockbackffa.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class StatsManager implements Listener{
	public StatsManager(spigotplugins.knockbackffa.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.knockbackffa.main.Main pl;
	public static HashMap<String, Integer> Kills = new HashMap<>();
	public static HashMap<String, Integer> Deaths = new HashMap<>();
	public static File file = new File("plugins//KnockbackFFA//stats.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				if(cfg.get(p.getUniqueId() + ".Kills") == null){
					Kills.put(p.getName(), 0);
					Deaths.put(p.getName(), 0);
					return;
				}
				Kills.put(p.getName(), cfg.getInt(p.getUniqueId() + ".Kills"));			
				Deaths.put(p.getName(), cfg.getInt(p.getUniqueId() + ".Deaths"));
			}
		},1L);

	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
		cfg.set(e.getPlayer().getUniqueId() + ".Kills", Kills.get(e.getPlayer().getName()));
		cfg.set(e.getPlayer().getUniqueId() + ".Deaths", Deaths.get(e.getPlayer().getName()));
		try {
			cfg.save(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
