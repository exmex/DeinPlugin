package souppvp.kitmenu;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class KitData {

	public static ArrayList<Player> standartkit = new ArrayList<>();
	public static ArrayList<Player> bogenschütze = new ArrayList<>();
	public static ArrayList<Player> rodpvp = new ArrayList<>();
	public static ArrayList<Player> kaktus = new ArrayList<>();

	public static ArrayList<Player> USE_standartkit = new ArrayList<>();
	public static ArrayList<Player> USE_bogenschütze = new ArrayList<>();
	public static ArrayList<Player> USE_rodpvp = new ArrayList<>();
	public static ArrayList<Player> USE_kaktus = new ArrayList<>();

	public static String getCurrentKit(Player p){
		String kit = "";
		if(USE_standartkit.contains(p)){
			kit = "§aStandart";
			return kit;
		}
		if(USE_bogenschütze.contains(p)){
			kit = "§dBogenschütze";
			return kit;
		}
		if(USE_rodpvp.contains(p)){
			kit = "§5RodPvP";
			return kit;
		}
		if(USE_kaktus.contains(p)){
			kit = "§2Kaktus";
			return kit;
		}else{
			kit = "§c§l✘ §c§l✘ §c§l✘";
			return kit;
		}
	}
	public static void removeFromAllArrayList(Player p){
		USE_bogenschütze.remove(p);
		USE_standartkit.remove(p);
		USE_rodpvp.remove(p);
		USE_kaktus.remove(p);
	}
}
