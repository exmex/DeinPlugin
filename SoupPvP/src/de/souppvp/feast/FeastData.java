package de.souppvp.feast;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FeastData {

	public static ArrayList<Player> ANFÄNGER_KIT = new ArrayList<>();
	public static ArrayList<Player> BOGENSCHÜTZE_KIT = new ArrayList<>();
	public static ArrayList<Player> KANGAROO_KIT = new ArrayList<>();
	public static ArrayList<Player> SUPPENMEISTER_KIT = new ArrayList<>();
	public static ArrayList<Player> AXT_KIT = new ArrayList<>();

	public static ArrayList<Player> SNEAK = new ArrayList<>();
	public static void removeFormAllKits(Player p){
		ANFÄNGER_KIT.remove(p);
		BOGENSCHÜTZE_KIT.remove(p);
		KANGAROO_KIT.remove(p);
		SUPPENMEISTER_KIT.remove(p);
		AXT_KIT.remove(p);
	}
}
