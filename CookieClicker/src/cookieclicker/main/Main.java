package cookieclicker.main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import cookieclicker.handler.Handler;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§aCookieClicker startet!");
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
		for(Player all : Bukkit.getOnlinePlayers()){
			Handler.l.put(all, Handler.cfg.getInt(all.getUniqueId() + ".Cookies"));
		}
	}
	@Override
	public void onDisable() {
		for(Player all : Bukkit.getOnlinePlayers()){
		Handler.cfg.set(all.getUniqueId() + ".Cookies", Handler.l.get(all));
		try {
			Handler.cfg.save(Handler.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
