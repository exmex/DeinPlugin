package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.StatusResponse.ServerStatus.Player;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class JoinMe extends Command {

	public JoinMe(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
     
	public static HashMap<ProxiedPlayer, Integer> used = new HashMap<ProxiedPlayer, Integer>();
	
	@Override
	public void execute(CommandSender sender, String[] args) {
          if(args.length == 0) {
        	  ProxiedPlayer p = (ProxiedPlayer)sender;
        	  if(p.hasPermission("bungeecord.command.joinme")) {
        		  if(!p.hasPermission("bungeecord.joinme.use.nodelay")) {
        		  if(!used.containsKey(p)) {
        			  used.put(p, 0);
        		  }
        		  if(used.get(p) < 6) {
        			  for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
        			        TextComponent msg2 = new TextComponent(Data.prefix + "§8» §7KLICKE HIER, um den §cServer §7zu §cbetreten§7!");
        			        msg2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cVerbinden").create()));
        			        msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/xyserverxyx " + p.getServer().getInfo().getName()));
        			    			  all.sendMessage("§7§l§k----------------------------");
        			    			  all.sendMessage(" ");
        			                  all.sendMessage(Data.prefix + "§c" + p.getName() + "§7 spielt auf §c" +p.getServer().getInfo().getName() +"§7!");
        			                  all.sendMessage(" ");
        			                  all.sendMessage(msg2);
        			                  all.sendMessage(" ");
        			    			  all.sendMessage("§7§l§k----------------------------");

        			                  
        			    			  
        			    			  }
        	  } else {
        		  p.sendMessage(Data.prefix + "§cDu hast diesen Befehl schon zu oft benutzt.");
        	  }
        	  } else {
    			  for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
        TextComponent msg2 = new TextComponent(Data.prefix + "§8» §7KLICKE HIER, um den §cServer §7zu §cbetreten§7!");
        msg2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cVerbinden").create()));
        msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/xyserverxyx " + p.getServer().getInfo().getName()));
		  all.sendMessage("§7§l§k----------------------------");
		  all.sendMessage(" ");
        all.sendMessage(Data.prefix + "§c" + p.getName() + "§7 spielt auf §c" +p.getServer().getInfo().getName() +"§7!");
        all.sendMessage(" ");
        all.sendMessage(msg2);
        all.sendMessage(" ");
		  all.sendMessage("§7§l§k----------------------------");

                  
    			  
    			  }
        	  }
        	  }
          } else if(args.length == 1 && args[0].equalsIgnoreCase("clear")) {
        	  if(sender.hasPermission("bungeecord.command.joinme.clear")) {
        		  JoinMe.used.clear();
        		  sender.sendMessage("§cDu hast alle JoinMe Einträge geleert!");
        	  }
          }
		
	}

}
