package setrank;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public static String Prefix = "§8[§cRangSystem§8] ";
	public static String NoPerm = Prefix + "§cDir fehlt dafür die nötige Berechtigung!";
	public static String Syntax = Prefix + "§cFalsche Benutzung! Nutze: §e/SetRank [Rang] [Name]";
	public void onEnable(){
		getCommand("setrank").setExecutor(new CMD());
	}
}
