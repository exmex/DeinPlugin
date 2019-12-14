package setrank;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Manager{
	public static List<String> list;
	public static void logFile(Player p, String target, String Gruppe){
		File file = new File("plugins//RankSystem//"+ p.getName() + ".yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		list = cfg.getStringList("LOG");
		cfg.options().header("### HERE YOU FIND THE LOG FOR MATE " + p.getName() + "###");
		cfg.set(target, "SET INTO GROUP " + Gruppe);
		String date = (new SimpleDateFormat("yy-MM-dd-HH").format(new java.util.Date()));
		cfg.set(target, "DATE: " + date);
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		cfg.set(target, "TIME: " + df);
		list.add("SET " + target + " INTO GROUP " + Gruppe + " AT " + df + " ON " + date);
		cfg.set("LOG", list);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

