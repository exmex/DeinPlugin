package de.spigotplugins.antihack.main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.spigotplugins.antihack.commandcheck.NOKNOCKBACKCommand;
import de.spigotplugins.antihack.commandcheck.NOKNOCKBACKListener;

public class Main extends JavaPlugin implements Listener{
	public void onEnable(){
		loadConfig();
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
		getCommand("nb").setExecutor(new NOKNOCKBACKCommand(this));
		Bukkit.getPluginManager().registerEvents(new NOKNOCKBACKListener(), this);
	}
	public void loadConfig(){
		ConfigManager.Prefix = this.getConfig().getString("Prefix").replace("&", "§");
		ConfigManager.NoPerm = this.getConfig().getString("KeineRechte").replace("&", "§");
		ConfigManager.NoKnockbackCommandUsage = this.getConfig().getString("NoKnockbackCommandBenutzung").replace("&", "§");
		ConfigManager.NoKnockbackCommandChecking = this.getConfig().getString("NoKnockbackCommandChecking").replace("&", "§");
		ConfigManager.NoKnockbackCommandPing = this.getConfig().getString("NoKnockbackCommandPing").replace("&", "§");
	}
	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onChat(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/anticheat dev")){
			e.getPlayer().sendMessage(ConfigManager.Prefix + "§eDas Plugin wurde von §6WeLoveSpigotPlugins §egeschrieben.");
			e.getPlayer().sendMessage(ConfigManager.Prefix + "§3https://youtube.com/welovespigotplugins");
			e.setCancelled(true);
		}
	}
}
