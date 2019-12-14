package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Support extends Command {
	 
	public Support(String string)
	  {
	    super(string);
	  }
	  
	public static HashMap<ProxiedPlayer, ProxiedPlayer> support = new HashMap<>();
	
	  public void execute(CommandSender sender, String[] args)
	  {
	      if (args.length == 0)
	      {
	        sender.sendMessage( "§8[" + ChatColor.AQUA + 
	          ChatColor.BOLD + "§cSupport" + 
	          "§8] " + ChatColor.GOLD + "§c Du hast Support erfolgreich beantragt!");
	        support.put((ProxiedPlayer) sender, null);
	        sender.sendMessage(ChatColor.GOLD + 
	          "§7Verwende bitte" + 
	          ChatColor.AQUA + 
	          "/support <message>" + 
	          ChatColor.GOLD + 
	          " §7um eine Nachricht an für einen Supporter zu schreiben §csofern er dem Chat beigetreten ist§7.");
	     
	      for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
	    	  if(p.hasPermission("system.ban")) {
	    		  p.sendMessage("§8[§cSupport§8] §cDer Spieler " + sender.getName() + " hat Support beantragt! Nehme ihn an mit /support accept " + sender.getName());
	    	  }
	      }
	      }
	      else
	      {
	    	  if(args[0].equalsIgnoreCase("accept")) {
	    		  if(sender.hasPermission("system.ban")) {
	    		  if(args.length == 2) {
	    			  ProxiedPlayer p2 = BungeeCord.getInstance().getPlayer(args[1]);
	    			  if(support.get(p2) == null) {
	    				  support.put(p2, (ProxiedPlayer)sender);
	    				 sender.sendMessage("§cDu bist nun im Support! Schreibe eine Nachricht mit /support <Name> Wenn das Anliegen geklärt ist nutze /support close " + sender.getName());
	    				 p2.sendMessage("§c" + sender.getName() + "§7 hat den §cSupport-Raum §7betreten. Bitte zeige ihm nun dein Anliegen! Mit /support <Nachricht>");
	    			  }
	    		  } else {
	    			  sender.sendMessage("§cBitte verwende /support accept <Name>");
	    		  }
	    		  }
	    	  }
	    	  if(args[0].equalsIgnoreCase("close")) {
	    		  if(sender.hasPermission("system.ban")) {
	    		  if(args.length == 2) {
	    			  ProxiedPlayer p2 = BungeeCord.getInstance().getPlayer(args[1]);
	    			  if(support.get(p2) == null) {
	    				  support.remove(p2);
	    				  support.remove((ProxiedPlayer)sender);
	    				 sender.sendMessage("§cDu bist nun im Support!");
	    				 p2.sendMessage("§c" + sender.getName() + "§7 hat den §cSupport-Raum §7verlassen. Der Raum wurde aufgelöst.");
	    			  }
	    		  } else {
	    			  sender.sendMessage("§cBitte verwende /support close <Name>");
	    		  }
	    		  }
	    	  }
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
	        
	           "§8[" + ChatColor.AQUA + ChatColor.BOLD + "§cSupport" + ChatColor.DARK_GRAY + "§8] " + ChatColor.RED + sender.getName() + " : " + ChatColor.GRAY + Message;
	        System.out.println(Message);
	        if(support.get((ProxiedPlayer)sender) == null || support.equals((ProxiedPlayer)sender)) {
	        	sender.sendMessage("§8[§cSupport§8] §cBitte warte bis ein Supporter den Raum betreten hat!");
	        	return;
	        }
	        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
	          if (support.get((ProxiedPlayer)sender).equals(p)) {
	            p.sendMessage(Message);
	            sender.sendMessage(Message);
	          }
	        }
	      }
	  }

}
