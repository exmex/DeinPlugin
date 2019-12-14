package de.tiger.NickSystem.event;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerNickEvent
  extends Event
  implements Cancellable
{
  private static final HandlerList handlers = new HandlerList();
  private Player p;
  private String nick;
  private UUID skin;
  private boolean cancel;
  
  public PlayerNickEvent(Player p, String nick, UUID skin)
  {
    this.p = p;
    this.nick = nick;
    this.skin = skin;
    this.cancel = false;
  }
  
  public Player getPlayer()
  {
    return this.p;
  }
  
  public String getNickName()
  {
    return this.nick;
  }
  
  public UUID getSkin()
  {
    return this.skin;
  }
  
  public boolean isCancelled()
  {
    return this.cancel;
  }
  
  public void setCancelled(boolean cancel)
  {
    this.cancel = cancel;
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
