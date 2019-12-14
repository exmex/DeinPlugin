package de.codeexception.events;

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
	        String rank = "";
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)e.getMessage()));
	        }
	        if (ChatColor.stripColor((String)p.getDisplayName()).equals(p.getName())) {
	            if (PermissionsEx.getUser((Player)p).inGroup("Owner")) {
	                e.setFormat(String.valueOf(rank) + " \u00a74Owner \u00a78| " + (Object)ChatColor.DARK_RED + p.getName() + "\u00a78\u00a7l \u00bb \u00a7c" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Moderator")) {
	                e.setFormat(String.valueOf(rank) + " \u00a7cModerator \u00a78| \u00a7c" + p.getName() + "\u00a78\u00a7l \u00bb \u00a7c" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("SrModerator")) {
	                e.setFormat(String.valueOf(rank) + " \u00a7cSrModerator \u00a78| \u00a7c" + p.getName() + "\u00a78\u00a7l \u00bb \u00a7c" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("JrYouTuber")) {
	                e.setFormat(String.valueOf(rank) + " \u00a7dJr YouTuber \u00a78| \u00a7d" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Supporter")) {
	                e.setFormat(String.valueOf(rank) + " \u00a73Supporter \u00a78| \u00a73" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("YouTuber")) {
	                e.setFormat(String.valueOf(rank) + " \u00a75YouTuber \u00a78| \u00a75" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Premium") || PermissionsEx.getUser((Player)p).inGroup("Gold")) {
	                e.setFormat(String.valueOf(rank) + " \u00a76Gold \u00a78| \u00a76" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Hero")) {
	                e.setFormat(String.valueOf(rank) + " \u00a73Hero \u00a78| \u00a73" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Ultra")) {
	                e.setFormat(String.valueOf(rank) + " \u00a7bUltra \u00a78| \u00a7b" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else if (PermissionsEx.getUser((Player)p).inGroup("Builder")) {
	                e.setFormat(String.valueOf(rank) + " \u00a77Builder \u00a78| \u00a77" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            } else {
	                e.setFormat(String.valueOf(rank) + " \u00a7a" + p.getName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	            }
	        } else {
	            e.setFormat(String.valueOf(rank) + " \u00a7a" + p.getDisplayName() + "\u00a78\u00a7l \u00bb \u00a77" + e.getMessage());
	        }
	    }
}
