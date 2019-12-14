package bungeeaddon.classes;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Main  {
	PluginManager pm = BungeeCord.getInstance().getPluginManager();
    public static Main plugin;
	public void onEnable(){
		plugin = this;
		
        this.pm.registerListener((Plugin)this, (Listener)new Handler());

	}
}
