package cookieclicker.handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Handler implements Listener{
	
	public static File file = new File("plugins//CookieClicker//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static HashMap<Player, Integer> l = new HashMap<>();
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getClickedBlock().getType() == Material.DIAMOND_BLOCK){
			l.put(p, l.get(p) + 1);
			p.sendMessage("§cDu hast so viele Cookies: §6" + l.get(p));
			p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 10);
			}
		}catch(Exception e1){}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(cfg.get(p.getUniqueId() + ".Cookies") == null){
			cfg.set(p.getUniqueId() + ".Cookies", 0);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			l.put(p, 0);
		}else{
			l.put(p, cfg.getInt(p.getUniqueId() + ".Cookies"));
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		cfg.set(p.getUniqueId() + ".Cookies", l.get(p));
		try {
			cfg.save(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
