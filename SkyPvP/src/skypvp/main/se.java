package skypvp.main;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class se implements Listener{
	
	@EventHandler
	  public void onMove(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	   
	   
	    if(p.getInventory().getBoots() == null){
	    	
	  }else if (p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("Enderboots")) {
	    
	          p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
	    	  
	      }else if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("SnowBoots")){
	          p.getWorld().playEffect(p.getLocation(), Effect.SNOWBALL_BREAK, 1);
	      }else if(p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("SplashBoots")){
	    	  p.getWorld().playEffect(p.getLocation(), Effect.SPLASH, 1);
	      
	    	  
	      }
	      
	      }
	   

			
		}
	
