package de.codeexception.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public class Build implements CommandExecutor,Listener {
	
	  public static ArrayList<String> build = new ArrayList<String>();
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (p.hasPermission("build")) {
			      if (args.length == 0)  {
			        if (build.contains(p.getName())) {
			          build.remove(p.getName());
			          p.sendMessage("§7Du kannst §cnicht §7mehr bauen und abbauen!");
			        } else {
			          build.add(p.getName());
			          p.sendMessage("§7Du kannst nun §abauen §7und §aabbauen!");
			        }
			      } else {
			        p.sendMessage("§7Bitte benutze §c/build");
			      }
			    }
		return true;
	    }

	  @EventHandler
	  public void onPlace(BlockPlaceEvent e) {
	    Player p = e.getPlayer();
	    if(!p.getWorld().getName().equals(p.getName())) {
		    if (Build.build.contains(p.getName())) {
			      e.setCancelled(false);
			    } else {
			      e.setCancelled(true);
			    }
	    }else {
	    	e.setCancelled(false);
	    }

	  }
	  
	  @EventHandler
	  public void onPlace(BlockBreakEvent e) {
	    Player p = e.getPlayer();
	    if(!p.getWorld().getName().equals(p.getName())) {
		    if (Build.build.contains(p.getName())) {
			      e.setCancelled(false);
			    } else {
			      e.setCancelled(true);
			    }
	    }else {
	    	e.setCancelled(false);
	    }

	  }
}
