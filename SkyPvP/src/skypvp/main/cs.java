package skypvp.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class cs implements Listener{

	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
		 Player p = e.getPlayer();
		    String msg = e.getMessage();
		    msg = msg.replaceAll("%", "%%");
		    if (PermissionsEx.getUser(p).inGroup("Owner")){
		      msg = ChatColor.translateAlternateColorCodes('&', msg);
		      e.setFormat("§4Owner §8§l» §4" + p.getName() + " §8» §c" + msg);
		    }else if(PermissionsEx.getUser(p).inGroup("CoOwner")){
		    	e.setFormat("§4CoOwner §8§l» §4" + p.getName() + "§8 » §c" + msg);
		    } else if (PermissionsEx.getUser(p).inGroup("Developer")){
		      msg = ChatColor.translateAlternateColorCodes('&', msg);
		      e.setFormat("§bDeveloper §8§l» §b" + p.getName() + " §8» §c" + msg);
		    } else if (PermissionsEx.getUser(p).inGroup("Moderator")){
			      msg = ChatColor.translateAlternateColorCodes('&', msg);
			      e.setFormat("§cModerator §8§l» §c" + p.getName() + " §8» §c" + msg);
		    } else if (PermissionsEx.getUser(p).inGroup("Supporter")){
			      msg = ChatColor.translateAlternateColorCodes('&', msg);
			      e.setFormat("§9Supporter §8§l» §9" + p.getName() + " §8» §c" + msg);
		    } else if (PermissionsEx.getUser(p).inGroup("YouTuber")){
			      msg = ChatColor.translateAlternateColorCodes('&', msg);
			      e.setFormat("§5YouTuber §8§l» §5" + p.getName() + " §8» §c" + msg);
		    }else if (PermissionsEx.getUser(p).inGroup("Premium")){
			      msg = ChatColor.translateAlternateColorCodes('&', msg);
			      e.setFormat("§6Premium §8§l» §6" + p.getName() + " §8» §7" + msg);
			      
		    } else {
			      e.setFormat("§8Spieler §8§l» §r" + p.getName() + " §8» §r" + msg); 	
		    }
		    
		    
	
		
	}
}
