package bedwarsshop.classes;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Methods {

	public static void erfolg(Player p){
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10, 10);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
		p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 10, 10);
		p.playSound(p.getLocation(), Sound.FIREWORK_TWINKLE2, 10, 10);
	}
	public static void kaufErfolg(Player p){
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10, 10);
	}
	public static void adminErfolg(Player p){
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
	}
	public static void fehler(Player p){
		
	}
}
