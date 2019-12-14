package de.spigotplugins.logmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;

import de.spigotplugins.lobby.data.Data;

public class AsyncLogging {

	public static ArrayList<String> AsyncLogging = new ArrayList<>();
	
	public static void logAsynchrounusly(String string){
		if(Data.Logging == false){
			return;
		}else{
			String packed = "";
			packed = LogData.getTime() + ";" + string;
			AsyncLogging.add(packed);
			return;
		}
	}
	public static void saveAsyncLogs(){
		File file = new File("plugins//LobbySystem//logs.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		String o;
		String[] splitted;
		for(int i = 0 ; i < AsyncLogging.size() ; i++){
			o = AsyncLogging.get(i);
			splitted = o.split(";");
			cfg.set(splitted[0], splitted[1]);
			try {
				cfg.save(file);
			} catch (IOException e) {
			}
		}
	}
}
