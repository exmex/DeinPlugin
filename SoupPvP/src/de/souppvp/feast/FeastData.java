package de.souppvp.feast;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FeastData {

	public static ArrayList<Player> ANF�NGER_KIT = new ArrayList<>();
	public static ArrayList<Player> BOGENSCH�TZE_KIT = new ArrayList<>();
	public static ArrayList<Player> KANGAROO_KIT = new ArrayList<>();
	public static ArrayList<Player> SUPPENMEISTER_KIT = new ArrayList<>();
	public static ArrayList<Player> AXT_KIT = new ArrayList<>();

	public static ArrayList<Player> SNEAK = new ArrayList<>();
	public static void removeFormAllKits(Player p){
		ANF�NGER_KIT.remove(p);
		BOGENSCH�TZE_KIT.remove(p);
		KANGAROO_KIT.remove(p);
		SUPPENMEISTER_KIT.remove(p);
		AXT_KIT.remove(p);
	}
}
