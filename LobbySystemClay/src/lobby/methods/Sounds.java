package lobby.methods;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Sounds {

	public static void playSound(Player p){
			p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
			p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
			p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
			p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
			p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
			p.playSound(p.getLocation(), Sound.FALL_BIG, 10, 10);
			p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 10, 10);
			p.playSound(p.getLocation(), Sound.HORSE_LAND, 10, 10);
			p.playSound(p.getLocation(), Sound.ARROW_HIT, 10, 10);
			p.playSound(p.getLocation(), Sound.HURT_FLESH, 10, 10);
			p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10, 10);
			p.playSound(p.getLocation(), Sound.BAT_LOOP, 10, 10);
			p.playSound(p.getLocation(), Sound.CAT_PURREOW, 10, 10);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	}
	public static void playTeleportSound(Player p){
		p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_TWINKLE, 10, 10);

	}
	public static void playInventoryClick(Player p){
		p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
		p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
		p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
		p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
		p.playSound(p.getLocation(), Sound.NOTE_STICKS, 10, 10);
		p.playSound(p.getLocation(), Sound.FALL_BIG, 10, 10);
		p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 10, 10);
	}
	public static void playOpenInventorySound(Player p){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
	}
}
