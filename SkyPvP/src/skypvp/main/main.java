package skypvp.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;




public class main extends JavaPlugin{
	
	public static String Prefix = "§6[§eSkyPvP§6] §r";
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("§aSkyPvP - Aktiviert");
		RegisterEvents();
		RegisterCommands();
		createConfig();
	}
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("§aSkyPvP - §cDeaktiviert");
	}
	public void RegisterEvents(){
		Bukkit.getPluginManager().registerEvents(new death(), this);
		Bukkit.getPluginManager().registerEvents(new invclickvip(), this);
		Bukkit.getPluginManager().registerEvents(new invclickmitglied(), this);
		Bukkit.getPluginManager().registerEvents(new sb(), this);
		Bukkit.getPluginManager().registerEvents(new invclickpremium(), this);
		Bukkit.getPluginManager().registerEvents(new invclick(), this);
		Bukkit.getPluginManager().registerEvents(new rs(), this);
		Bukkit.getPluginManager().registerEvents(new join(), this);
		Bukkit.getPluginManager().registerEvents(new joinitem(), this);
		Bukkit.getPluginManager().registerEvents(new je(this), this);
		Bukkit.getPluginManager().registerEvents(new quit(), this);
		Bukkit.getPluginManager().registerEvents(new ns(), this);
		Bukkit.getPluginManager().registerEvents(new cs(), this);
		Bukkit.getPluginManager().registerEvents(new se(), this);
		Bukkit.getPluginManager().registerEvents(new respawn(this), this);
		Bukkit.getPluginManager().registerEvents(new savejoin(this), this);
		Bukkit.getPluginManager().registerEvents(new sp(this), this);
		Bukkit.getPluginManager().registerEvents(new wartungen(this), this);

		
		







	}
	public void RegisterCommands(){
		getCommand("kit").setExecutor(new kit());
		getCommand("setspawn").setExecutor(new setspawn());
		getCommand("spawn").setExecutor(new sp(this));
		getCommand("wartungen").setExecutor(new wartungen(this));



		
	}

	public void createConfig(){
		
		
		File ordner = new File("plugins//SkyPvP");
		File file = new File ("plugins//SkyPvP//spawns.yml");
		if(!ordner.exists()){
			ordner.mkdir();
			
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				Bukkit.broadcastMessage("§4Problem beim erstellen der config.yml [Main]");
			}
			
		}
		this.getConfig().addDefault("Wartungen", false);
		
		


		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}


	
}
