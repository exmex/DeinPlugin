package souppvp.data;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Data {
	
	public static ArrayList<Player> amspawn = new ArrayList<>();
	
	public static String Prefix;
	public static String NoPerm = Prefix + "§cDu hast nicht genügend Rechte um dies zu tun!";
	public static boolean eventmodus;
	public static Location spawn;
	public static Location tripple;
	public static Location sky;
	public static ArrayList<Player>nopickedkit = new ArrayList<>();
	public static ArrayList<Player>notitle = new ArrayList<>();
	public static ArrayList<Player> mapsky = new ArrayList<>();
	public static ArrayList<Player> maptripple = new ArrayList<>();
}
