package souppvp.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Chat implements Listener{

	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        
	        String Message = e.getMessage().replaceAll("%", "Prozent");
	        Message.replaceAll("%", "Prozent");
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', Message));
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §4Owner §8• §4" + p.getName() + "§8 » §6" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §cAdmin §8• §c" + p.getName() + "§8 » §6" + Message);
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §cSrModerator §8• §c" + p.getName() + "§8 » §6" +Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §bDeveloper §8• §b" + p.getName() + "§8 » §b" + Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + Message);
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §cModerator §8• §c" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §9Supporter §8• §9" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §5YouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §bUltra §8• §b" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §3Hero §8• §3" + p.getName() + "§8 » §f" + Message);
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §6Gold §8• §6" + p.getName() + "§8 » §f" + Message);
	    }else{
	    	e.setCancelled(false);
	    	e.setFormat("§8[" + souppvp.manager.LevelManager.getLevel(p) + "§8] §7" + e.getPlayer().getName() + "§8 » §f" + Message);
	    }
	 }

	 
}
