package me.MrCodex.BungeeSystem.Commands;

import java.io.PrintStream;

import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamChat
  extends Command
{
  public TeamChat(String string)
  {
    super(string);
  }
  
  public void execute(CommandSender sender, String[] args)
  {
    if (sender.hasPermission("system.teamchat")) {
      if (args.length == 0)
      {
        sender.sendMessage( "§7[" + ChatColor.AQUA + 
          ChatColor.BOLD + "§cTeamChat" + 
          "§7] " + ChatColor.GOLD + "§7Im TeamChat sind gerade diese Spieler:");
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
          if (p.hasPermission("system.teamchat")) {
            sender.sendMessage(ChatColor.GRAY + "§7 - §c" + 
              p.getDisplayName()+"§7 -§c "+p.getServer().getInfo().getName());
          }
        }
        sender.sendMessage(ChatColor.GOLD + 
          "§7Verwende bitte" + 
          ChatColor.AQUA + 
          "/tc <message>" + 
          ChatColor.GOLD + 
          " §7um eine Nachticht an alle Team-Mitglieder zu senden.");
      }
      else
      {
        String Message = "";
        Integer count = Integer.valueOf(0);
        while (count.intValue() < args.length)
        {
          Message = Message + " " + args[count.intValue()];
          count = Integer.valueOf(count.intValue() + 1);
        }
        Message = Manager_Chat.getMessage(sender, Message);
        if (Message == null) {
          return;
        }
        Message = 
        

           "§7[" + ChatColor.AQUA + ChatColor.BOLD + "§cTeamChat" + ChatColor.DARK_GRAY + "§7] " + ChatColor.AQUA + sender.getName() + " : " + ChatColor.BLUE + Message;
        System.out.println(Message);
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
          if (p.hasPermission("system.teamchat")) {
            p.sendMessage(Message);
          }
        }
      }
    }else{
    	 sender.sendMessage("§7Du hast keine Rechte.");
    }
  }
}
