package farbigerchat.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage("§6Farbiger Chat > §aAktivert!");
		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
	}
	
}
