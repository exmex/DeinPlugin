package de.souppvp.data;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Data {

	//Nachrichten
	public static String Prefix = "§7┃ §eSoupPvP §8» ";
	public static String NoPerm = Prefix + "§cDu hast nicht genügend Rechte um dies zu tun!";
	
	//ArrayList
	public static ArrayList<Player> firstJoin = new ArrayList();
	public static ArrayList<Player> FeastJoin = new ArrayList();
	public static ArrayList<Player> OneVSOneJoin = new ArrayList();
	public static ArrayList<Player> INOneVSOneJoin = new ArrayList();
	public static ArrayList<Player> OneVSOneWarteschlange = new ArrayList();
	public static ArrayList<Player> FeastNoKit = new ArrayList();

}
