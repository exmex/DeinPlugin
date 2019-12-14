package servercore.boardmanager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener{
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)e.getMessage()));
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§4Owner §8• §4" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§cAdmin §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§cSrModerator §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§bDeveloper §8• §b" + p.getName() + "§8 » §b" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + e.getMessage());
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§cModerator §8• §c" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5YouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§bUltra §8• §b" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + e.getMessage());
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + e.getMessage());
	    }else{
	    	e.setCancelled(false);
	    	e.setFormat("§7" + e.getPlayer().getName() + "§8 » §f" + e.getMessage());
	    }
	 }
}