package souppvp.methods;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Sounds {

	public static void playAdminAcceptSound(Player p){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	}
	public static void playAdminFailureSound(Player p){
		p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 10);
	}
	public static void playKitPickSound(Player p){
		p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
		p.playSound(p.getLocation(), Sound.WITHER_HURT, 10, 10);
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);
	}
}
