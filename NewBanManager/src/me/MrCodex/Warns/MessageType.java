package me.MrCodex.Warns;

import net.md_5.bungee.api.ChatColor;

public enum MessageType
{
  GOOD(ChatColor.GOLD), 
  INFO(ChatColor.AQUA), 
  BAD(ChatColor.RED);

  private ChatColor color;

  private MessageType(ChatColor color) { this.color = color; }

  public ChatColor getColor()
  {
    return this.color;
  }
}