package de.tiger.NickSystem.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerUnNickEvent
  extends Event
{
  private static final HandlerList handlers = new HandlerList();
  private Player p;
  
  public PlayerUnNickEvent(Player p)
  {
    this.p = p;
  }
  
  public Player getPlayer()
  {
    return this.p;
  }
  
  public HandlerList getHandlers()
  {
    return handlers;
  }
  
  public static HandlerList getHandlerList()
  {
    return handlers;
  }
}
