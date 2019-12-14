package de.spigotplugins.logmanager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import de.spigotplugins.lobby.data.Data;

public class LogMethods {

	
	public static void log(String string){
		if(Data.Logging == false){
			return;
		}else{
			File file = new File("plugins//LobbySystem//logs.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			cfg.set(LogData.getTime(), string);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
