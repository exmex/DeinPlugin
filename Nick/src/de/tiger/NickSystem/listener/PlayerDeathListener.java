package de.tiger.NickSystem.listener;

import java.util.ArrayList;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginManager;

import de.tiger.NickSystem.Main;

public class PlayerDeathListener
  implements Listener
{
  private Main plugin;
  
  public PlayerDeathListener(Main main)
  {
    this.plugin = main;
    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (!this.plugin.NODEATH.contains(p))
    {
      return;
    }
  }
}
