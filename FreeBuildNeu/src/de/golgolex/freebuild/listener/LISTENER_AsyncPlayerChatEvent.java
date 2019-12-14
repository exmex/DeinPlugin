package de.golgolex.freebuild.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class LISTENER_AsyncPlayerChatEvent implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if (p.hasPermission("claymc.hero") || p.hasPermission("claymc.ultra")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        }
		if (e.getMessage().contains("%")) {
            e.setMessage(e.getMessage().replaceAll("%", "Prozent"));
        }
		
        if (PermissionsEx.getUser(p).inGroup("Owner")) {
            e.setFormat("§4Owner §8 | §4" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Admin")) {
            e.setFormat("§cAdmin §8| §c" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Moderator")) {
            e.setFormat("§cModerator §8| §c" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Supporter")) {
            e.setFormat("§9Supporter §8| §9" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("YouTuber+")) {
            e.setFormat("§5YouTuber+ §8| §5" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("YouTuber")) {
            e.setFormat("§5YouTuber §8| §5" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("JrYouTuber")) {
            e.setFormat("§5JrYouTuber §8| §5" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Ultra")) {
            e.setFormat("§bUltra §8| §b" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Hero")) {
            e.setFormat("§3Hero §8| §3" + p.getName() + " §7» §7" + e.getMessage());
        } else if (PermissionsEx.getUser(p).inGroup("Gold")) {
            e.setFormat("§6Gold §8| §6" + p.getName() + " §7» §7" + e.getMessage());
        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
            e.setFormat("§eBuilder §8| §e" + p.getName() + " §7» §7" + e.getMessage());
    }else if(PermissionsEx.getUser(p).inGroup("SrModerator")){
        e.setFormat("§cSrModerator §8| §c" + p.getName() + " §7» §7" + e.getMessage());
    } else {
            e.setFormat("§a" + p.getName() + " §7» §7" + e.getMessage());
        }
    }

}
