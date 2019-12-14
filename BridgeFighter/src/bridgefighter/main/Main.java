package bridgefighter.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import bridgefighter.commands.MainCommand;
import bridgefighter.data.Data;
import bridgefighter.listener.MainListener;
import bridgefighter.methods.TeleportManager;
import bridgefighter.mobs.Warteschlange;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new MainListener(this), this);
		Bukkit.getPluginManager().registerEvents(new Warteschlange(), this);

		getCommand("setspawn").setExecutor(new MainCommand());
		loadSpawns();
	}
	public void loadSpawns(){
		Data.MapLocations.put("Spawn", TeleportManager.loadSpawn("Spawn"));
	}
}
