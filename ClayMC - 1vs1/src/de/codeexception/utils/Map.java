package de.codeexception.utils;

import org.bukkit.Location;

public class Map {

	Location lobby;
	Location loc1;
	Location loc2;
	String name;
	
	public Map(String name,Location spawn1,Location spawn2,Location lobbyspawn) {
		this.name = name;
		this.loc1 = spawn1;
		this.loc2 = spawn2;
	}
	public Location getLobbySpawn() {
		return lobby;
	}
	public Location getSpawn1() {
		return loc1;
	}
	public Location getSpawn2() {
		return loc2;
	}
	public String getName() {
		return name;
	}
	
}
