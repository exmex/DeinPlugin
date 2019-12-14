package de.spigotplugins.freebuild.methods;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;

public class PlayerData {

	public static HashMap<UUID, Location> SettedHomeBlocksNotCompleted = new HashMap<>();
	public static HashMap<UUID, Location> SettedHomeBlocks = new HashMap<>();

}
