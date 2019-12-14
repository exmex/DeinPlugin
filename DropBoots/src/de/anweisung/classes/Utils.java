package de.anweisung.classes;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Utils {

	public static ArrayList<Player> cookie = new ArrayList<Player>();
	public static ArrayList<Player> gold = new ArrayList<Player>();
	public static ArrayList<Player> iron = new ArrayList<Player>();
	public static ArrayList<Player> scherben = new ArrayList<Player>();
	public static ArrayList<Player> smaragt = new ArrayList<Player>();
	public static ArrayList<Player> diamant = new ArrayList<Player>();

	public static void setCookies(Player p){
		removeFromAll(p);
		cookie.add(p);
		p.sendMessage(Main.Prefix + "§6Du hast dir deine Cookie Schuhe ausgewählt!");
	}
	public static void setGold(Player p){
		removeFromAll(p);
		gold.add(p);
		p.sendMessage(Main.Prefix + "§6Du hast dir deine Gold Schuhe ausgewählt!");
	}
	public static void setIron(Player p){
		removeFromAll(p);
		iron.add(p);
		p.sendMessage(Main.Prefix + "§3Du hast dir deine Iron Schuhe ausgewählt!");
	}
	public static void setScherben(Player p){
		removeFromAll(p);
		scherben.add(p);
		p.sendMessage(Main.Prefix + "§bDu hast dir deine Scherben Schuhe ausgewählt!");
	}
	public static void setSmaragt(Player p){
		removeFromAll(p);
		smaragt.add(p);
		p.sendMessage(Main.Prefix + "§bDu hast dir deine Smaragt Schuhe ausgewählt!");
	}
	public static void setDiamant(Player p){
		removeFromAll(p);
		diamant.add(p);
		p.sendMessage(Main.Prefix + "§5Du hast dir deine Diamant Schuhe ausgewählt!");
	}
	public static void removeFromAll(Player p){
		cookie.remove(p);
		gold.remove(p);
		iron.remove(p);
		scherben.remove(p);
		smaragt.remove(p);
		diamant.remove(p);
		p.closeInventory();
	}
}
