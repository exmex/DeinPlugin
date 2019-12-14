package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class je implements Listener{
	public je(skypvp.main.main main){
		this.pl = main;
	}
	private skypvp.main.main pl;
	public static int hearty;
	public static int heart = 20;
	
	
	public boolean one = false;
	public boolean two = false;
	public boolean three = true;

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		hearty = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){

			
			
			@Override
			
			public void run() {
				
				heart -=1;
				p.setHealth(heart);
				p.setFoodLevel(heart);
				p.sendTitle("§e§lS§a§lK§b§lY§c§lP§4§lV§d§lP", "");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				
				if(p.getHealth() == 1){
					Bukkit.getScheduler().cancelTask(hearty);
					p.setHealth(20);
					p.setFoodLevel(20);
					heart = 20;
					p.sendTitle("§a§lSkyPvP", "§b§lWillkommen " + p.getName());
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
					p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);




					
					
				}
			}
			
			
		}, 4L, 4L);
	


		
		}
	}
