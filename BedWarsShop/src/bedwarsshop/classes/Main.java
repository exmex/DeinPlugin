package bedwarsshop.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
	Bukkit.getPluginManager().registerEvents(new CMD(), this);
	Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	Bukkit.getPluginManager().registerEvents(new Shop(), this);

	}

	@Override
	public void onDisable() {
		
	}
	
	
}
