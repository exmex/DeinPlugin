package blocker.classes;

import java.util.jar.JarEntry;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
	}
}
