package souppvp.kitmenu;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class KitHandler implements Listener{
	public static HashMap<String, ArrayList> kits = new HashMap<>();
	File file = new File("plugins//SoupPvP//kits.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(cfg.getBoolean(p.getUniqueId() + ".Bogenschutze") == true){
			KitData.bogenschütze.add(p);
		}
		if(cfg.getBoolean(p.getUniqueId() + ".RodPvP") == true){
			KitData.rodpvp.add(p);
		}
		if(cfg.getBoolean(p.getUniqueId() + ".Kaktus") == true){
			KitData.kaktus.add(p);
		}
		}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(KitData.bogenschütze.contains(p)){
			cfg.set(p.getUniqueId() + ".Bogenschutze", true);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(KitData.rodpvp.contains(p)){
			cfg.set(p.getUniqueId() + ".RodPvP", true);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(KitData.kaktus.contains(p)){
			cfg.set(p.getUniqueId() + ".Kaktus", true);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
