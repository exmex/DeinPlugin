package de.leitung.superspecate;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SuperSpectateCommand implements CommandExecutor, Listener{
	ArrayList<String> hideShow = new ArrayList<String>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("v") || cmd.getName().equalsIgnoreCase("vanish")){
			Player p = (Player)sender;
			p.performCommand("server");
			if(p.hasPermission("claymc.team")) {
				if(hideShow.contains(p.getName())){
					hideShow.remove(p.getName());
					for(Player players : Bukkit.getOnlinePlayers()){
						p.showPlayer(players);
					}
					p.sendMessage(Main.Prefix + "§9Du hast deinen §eVanish §9Modus §cverlassen§9!");
					p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				} else {
					hideShow.add(p.getName());
					for(Player players : Bukkit.getOnlinePlayers()){
						p.hidePlayer(players);
					}
					p.sendMessage(Main.Prefix + "§9Du hast deinen §eVanish §9Modus §cverlassen§9!");
					p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}
		
				
			}else{
				p.sendMessage(Main.Prefix + "§cDir fehlt die nötige Berechtigung um diesen Command ausführen zu können!");
			}
		}
	
			
		
		return false;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player players : Bukkit.getOnlinePlayers()){
			if(hideShow.contains(players.getName())){
				players.hidePlayer(p);
			}
		}
	}

}
