package de.spigotplugins.freebuild.methods;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Sounds {

	public static void playAcceptSound(Player p){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	}
}
