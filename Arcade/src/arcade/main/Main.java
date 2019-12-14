package arcade.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import arcade.data.Data;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix +"§3Das Plugin startet nun...");
	}

}
