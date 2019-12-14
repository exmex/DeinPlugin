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
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);

		
	}
}
