package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.StatusResponse.ServerStatus.Player;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Report extends Command{

	public Report() {
		super("report");
	}

	public static HashMap<ProxiedPlayer, String> reported = new HashMap<ProxiedPlayer, String>();	
	public static HashMap<ProxiedPlayer, ProxiedPlayer> reporter = new HashMap<ProxiedPlayer, ProxiedPlayer>();	

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
           if (args.length < 2) {
           sender.sendMessage(Data.prefix + "§7Verwende /report <Name> <Hacks, Beleidigungen, Teaming, Werbung, Sonstiges>");
			      } else {
			         if (ProxyServer.getInstance().getPlayer(args[0]) == null) {
			          sender.sendMessage(Data.prefix + "§7Dieser §cSpieler §7ist nicht Online.");
			          return;
			         } else {
/*		       String message = "";
			       for (int i = 1; i < args.length; i++) {
			          message = message + args[i] + " ";
			         }*/
			       if(args[1].equalsIgnoreCase("hacks")) {
			       reporter.put(ProxyServer.getInstance().getPlayer(args[0]), p);
			              p.sendMessage(Data.prefix + "§7Vielen Dank für deinen §cReport§7.");
			              reported.put(ProxyServer.getInstance().getPlayer(args[0]), args[1]);
			              for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
			            	  if(all.hasPermission("system.kick")) {
			            		  all.sendMessage(Data.prefix + "§7Der Spieler §c" + p.getName() + "§7 hat einen §cReport §7erstellt.");
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Gemeldeter Spieler: §c"+ args[0]);
			            		  all.sendMessage(Data.prefix + "§7Angegebender Grund: §c" + args[1]);
			            		  all.sendMessage(Data.prefix + "§7Server: §c" + ProxyServer.getInstance().getPlayer(args[0]).getServer().getInfo().getName());
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Nutze §c/reports " + args[0] + "§7 um diesen zu bearbeiten.");

			            	  }
			              }
			                  } else    if(args[1].equalsIgnoreCase("beleidigungen")) {
			   			       reporter.put(ProxyServer.getInstance().getPlayer(args[0]), p);
					              p.sendMessage(Data.prefix + "§7Vielen Dank für deinen §cReport§7.");
					              reported.put(ProxyServer.getInstance().getPlayer(args[0]), args[1]);
					              for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
					            	  if(all.hasPermission("system.kick")) {
					            		  all.sendMessage(Data.prefix + "§7Der Spieler §c" + p.getName() + "§7 hat einen §cReport §7erstellt.");
					            		  all.sendMessage(Data.prefix + " ");
					            		  all.sendMessage(Data.prefix + "§7Gemeldeter Spieler: §c"+ args[0]);
					            		  all.sendMessage(Data.prefix + "§7Angegebender Grund: §c" + args[1]);
					            		  all.sendMessage(Data.prefix + "§7Server: §c" + ProxyServer.getInstance().getPlayer(args[0]).getServer().getInfo().getName());
					            		  all.sendMessage(Data.prefix + " ");
					            		  all.sendMessage(Data.prefix + "§7Nutze §c/reports " + args[0] + "§7 um diesen zu bearbeiten.");

					            	  }
					              }
					                  }
			                  else if(args[1].equalsIgnoreCase("Teaming")) {
			       reporter.put(ProxyServer.getInstance().getPlayer(args[0]), p);
			              p.sendMessage(Data.prefix + "§7Vielen Dank für deinen §cReport§7.");
			              reported.put(ProxyServer.getInstance().getPlayer(args[0]), args[1]);
			              for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
			            	  if(all.hasPermission("system.kick")) {
			            		  all.sendMessage(Data.prefix + "§7Der Spieler §c" + p.getName() + "§7 hat einen §cReport §7erstellt.");
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Gemeldeter Spieler: §c"+ args[0]);
			            		  all.sendMessage(Data.prefix + "§7Angegebender Grund: §c" + args[1]);
			            		  all.sendMessage(Data.prefix + "§7Server: §c" + ProxyServer.getInstance().getPlayer(args[0]).getServer().getInfo().getName());
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Nutze §c/reports " + args[0] + "§7 um diesen zu bearbeiten.");

			            	  }
			              }
			                  }
			                  else if(args[1].equalsIgnoreCase("Werbung")) {
			       reporter.put(ProxyServer.getInstance().getPlayer(args[0]), p);
			              p.sendMessage(Data.prefix + "§7Vielen Dank für deinen §cReport§7.");
			              reported.put(ProxyServer.getInstance().getPlayer(args[0]), args[1]);
			              for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
			            	  if(all.hasPermission("system.kick")) {
			            		  all.sendMessage(Data.prefix + "§7Der Spieler §c" + p.getName() + "§7 hat einen §cReport §7erstellt.");
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Gemeldeter Spieler: §c"+ args[0]);
			            		  all.sendMessage(Data.prefix + "§7Angegebender Grund: §c" + args[1]);
			            		  all.sendMessage(Data.prefix + "§7Server: §c" + ProxyServer.getInstance().getPlayer(args[0]).getServer().getInfo().getName());
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Nutze §c/reports " + args[0] + "§7 um diesen zu bearbeiten.");

			            	  }
			              }
			                  }
			                  else if(args[1].equalsIgnoreCase("Sonstiges")) {
			       reporter.put(ProxyServer.getInstance().getPlayer(args[0]), p);
			              p.sendMessage(Data.prefix + "§7Vielen Dank für deinen §cReport§7.");
			              reported.put(ProxyServer.getInstance().getPlayer(args[0]), args[1]);
			              for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
			            	  if(all.hasPermission("system.kick")) {
			            		  all.sendMessage(Data.prefix + "§7Der Spieler §c" + p.getName() + "§7 hat einen §cReport §7erstellt.");
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Gemeldeter Spieler: §c"+ args[0]);
			            		  all.sendMessage(Data.prefix + "§7Angegebender Grund: §c" + args[1]);
			            		  all.sendMessage(Data.prefix + "§7Server: §c" + ProxyServer.getInstance().getPlayer(args[0]).getServer().getInfo().getName());
			            		  all.sendMessage(Data.prefix + " ");
			            		  all.sendMessage(Data.prefix + "§7Nutze §c/reports " + args[0] + "§7 um diesen zu bearbeiten.");

			            	  }
			              }
			                  } else {
			                      sender.sendMessage(Data.prefix + "§7Verwende /report <Name> <Hacks, Beleidigungen, Teaming, Werbung, Sonstiges>");
			                  }
			/*    */       }
			         }
           
	}
}
