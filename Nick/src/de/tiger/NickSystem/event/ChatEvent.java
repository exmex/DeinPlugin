package de.tiger.NickSystem.event;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.manager.NickManager;

public class ChatEvent implements Listener{

	  public Main plugin;
	  
	  public ChatEvent(Main plugin)
	  {
	    this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	  }
		
	  private boolean isNicked2(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isNicked(Player p)
	  {
	    return Main.getInstance().REALNAMES.containsKey(p);
	  }
	
	}
