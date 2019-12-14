package de.tiger.NickSystem.listener;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.manager.Scoreboard;
import de.tiger.NickSystem.message.English_Message;
import de.tiger.NickSystem.message.German_Message;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;

public class PlayerJoinListener
  implements Listener
{
  private Main plugin;
  
  public PlayerJoinListener(Main main)
  {
    this.plugin = main;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    final Player p = e.getPlayer();
    
    //Scoreboard.setScoreboard(p);
    
    e.setJoinMessage(null);
    
	Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	{
	public void run()
	{
		
			
		
	}
	}, 10L);
		
    
  }
  
	  public static boolean isNicked(Player p)
	  {
	    return Main.getInstance().REALNAMES.containsKey(p);
	  }

	  
	  
}
