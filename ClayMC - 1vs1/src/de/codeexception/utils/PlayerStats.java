package de.codeexception.utils;

import java.util.HashMap;

public class PlayerStats {

	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> deaths = new HashMap<>();
	private String uuid;
	
	public PlayerStats(String suuid) {
		this.uuid = suuid;
		load();
		
	}
	public void load() {
		if(!kills.containsKey(uuid)) {
			kills.put(uuid, SQLStats.getKills(uuid));
		}
		if(!deaths.containsKey(uuid)) {
			deaths.put(uuid, SQLStats.getDeaths(uuid));
		}
	}
	public void updateToDatabase() {
		SQLStats.setDeaths(uuid, getDeaths());
		SQLStats.setKills(uuid, getKills());
		kills.remove(uuid);
		deaths.remove(uuid);
	}
	
	public Integer getKills() {
		return kills.get(uuid);
	}
	public Integer getDeaths() {
		return deaths.get(uuid);
	}
	public Double getKD() {
		return Double.valueOf(getKills()/getDeaths());
	}
	public void updateKills(int i) {
		kills.get(uuid);
		kills.put(uuid, i);
	}
	public void updateDeaths(int i) {
		deaths.remove(uuid);
		deaths.put(uuid, i);
	}
	public void addKills(int i) {
		updateKills(getKills()+i);
	}
	public void addDeaths(int i) {
		updateDeaths(getDeaths()+i);
	}
	public void removeKills(int i) {
		updateKills(getKills()-i);
	}
	public void removeDeaths(int i) {
		updateDeaths(getDeaths()-i);
	}
	
}
