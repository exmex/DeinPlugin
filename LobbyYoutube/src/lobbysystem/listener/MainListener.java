package lobbysystem.listener;

import java.security.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import lobbysystem.data.Data;
import lobbysystem.methods.Methods;
import lobbysystem.methods.Scoreboard;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MainListener implements Listener{

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p= e.getPlayer();
		e.setJoinMessage(null);
		Methods.setLobbyItems(p);
		p.setHealthScale(1);
		p.setHealth(1);
		p.setFoodLevel(20);
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
		if(p.hasPlayedBefore()){
			p.teleport(Data.spawn);
		}else{
			p.teleport(Data.spawn);
		}
	}
	@EventHandler
	public void onJoin(PlayerQuitEvent e){
		Player p= e.getPlayer();
		e.setQuitMessage(null);
	}
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
