package de.Niclas.EarlyHG;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;




public class EarlyHG extends JavaPlugin implements Listener {
	
	public static EarlyHG Main;
    public Utils utils;

	public void onEnable() {
		Main = this;
        this.utils = new Utils();
		System.out.print("EarlyHG wurde aktiviert!");
		new TimeRun().runTaskTimerAsynchronously(this, 0L, 20L);
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getPluginManager().registerEvents(new Cloud(), this);
		Bukkit.getPluginManager().registerEvents(new ChestManager(), this);

		
	}
}
