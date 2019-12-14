package me.MrCodex.Warns;


import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MessageListener
{
  private static MessageListener instance = new MessageListener();

  private String prefix = Data.prefix +  ChatColor.RESET;

  public static MessageListener getInstance()
  {
    return instance;
  }

  public void sendMessage(ProxiedPlayer p, MessageType type, String[] messages)
  {
    for (String msg : messages)
      p.sendMessage(new TextComponent(this.prefix + type.getColor() + msg));
  }

  public void sendMessage(MessageType type, String[] messages)
  {
    for (String msg : messages)
      System.out.println(this.prefix + type.getColor() + msg);
  }
}