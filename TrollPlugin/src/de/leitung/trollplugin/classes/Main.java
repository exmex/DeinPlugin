package de.leitung.trollplugin.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static String Prefix = "§8[§cTroll§8] ";
	public static String FakeOPMessage;
	public static String FakeDEOPMessage;

	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(Prefix + "§2Plugin wurde gestartet!");
		getCommand("troll").setExecutor(new TrollCommands(this));
		Bukkit.getPluginManager().registerEvents(new TrollListener(), this);
		File file = new File("plugins//TrollPlugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get("FakeOPMessage") == null){
			cfg.set("FakeOPMessage", "§7[Server: Oppend %Player%]");
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cfg.get("FakeDEOPMessage") == null){
			cfg.set("FakeDEOPMessage", "§7[Server: De-opped %Player%]");
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		registerMessagesFromConfig();
	}
	public void registerMessagesFromConfig(){
		File file = new File("plugins//TrollPlugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	FakeOPMessage = cfg.getString("FakeOPMessage");
	FakeDEOPMessage = cfg.getString("FakeDEOPMessage");
	}
}
