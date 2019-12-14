package servercore.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import servercore.addons.FirstJoinMessages;
import servercore.addons.Vanish;
import servercore.data.Data;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		try{
			FirstJoinMessages.checkIfConfigExists();
			registerEvents();
			registerCommands();
	}catch(Exception e1){
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§4Core has detected a problem while enabling the system...");
	}
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§aCore successfully ready to play!");

	}
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6Core is going to load many options...");
		
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6Core is going to §cshutdown!");
		
	}
	public void registerEvents(){
		Bukkit.getPluginManager().registerEvents(new Vanish(), this);
	}
	public void registerCommands(){
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("v").setExecutor(new Vanish());
	}
}
