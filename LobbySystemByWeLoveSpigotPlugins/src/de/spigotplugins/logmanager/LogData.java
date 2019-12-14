package de.spigotplugins.logmanager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.configuration.file.YamlConfiguration;

public class LogData {
	public static String now = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
	public static ArrayList<String> logs = new ArrayList<String>();
	
	public static String getTime(){
		String now = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
		String[] t = now.split(" ");
		String end = "| " + t[0] + " | [ " + t[1] + " ] ";
		return end;
	}
	
	public static void checkIfLogFileExists(){
		File file = new File("plugins//LobbySystem//logs.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(file.exists()){
			return;
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
