package bauevent;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.setGameMode(GameMode.CREATIVE);
		for(Player all : Bukkit.getOnlinePlayers()){
			all.setGameMode(GameMode.CREATIVE);
		}
		e.setJoinMessage(null);
		check(p);
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("§8» §eBauEvent §8«");
		p.sendMessage("");
		p.sendMessage("§8» §e/PlotMe §3Auto §8» §7Dir wird ein freies Grundstück gesucht");
		p.sendMessage("§8» §e/PlotMe §3Home §8» §7Du wirst zu deinem Plot teleportiert");
		p.sendMessage("§8» §e/PlotMe §3Clear §8» §7Leere dein Grundstück");
		p.sendMessage("");

		p.setGameMode(GameMode.CREATIVE);

		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	}
	@EventHandler
	public void onQ(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
	@EventHandler
	public void ona(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.POTION){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.EXP_BOTTLE){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.ENDER_PEARL){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.BOW){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.SNOW_BALL){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.REDSTONE){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
			if(e.getItem().getType() == Material.REDSTONE_COMPARATOR){
				e.setCancelled(true);
				p.sendMessage(Main.Prefix + "§cMit diesem Item darfst du nicht interagieren!");
				return;
			}
		}catch(Exception e1){
			
		}
	}
	public void check(Player p){
		File file = new File("plugins//BauEvent//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if(cfg.get(p.getUniqueId() + ".Login") == null){
			cfg.set(p.getUniqueId() + ".Login", true);
			try {
				cfg.save(file);
			} catch (IOException e) {
			e.printStackTrace();
			}
			p.getInventory().clear();
			double x = 880.5;
			double y = 150.0;
			double z = 55.5;
			Location loc = new Location(Bukkit.getWorld("plotworld"), x, y, z);
			loc.setYaw(179);
			loc.setPitch(0);
			p.teleport(loc);
			
		}
	}
	@EventHandler
	public void onP(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("/spawn")){
			double x = 880.5;
			double y = 150.0;
			double z = 55.5;
			Location loc = new Location(Bukkit.getWorld("plotworld"), x, y, z);
			loc.setYaw(179);
			loc.setPitch(0);
			p.teleport(loc);
			p.sendMessage(Main.Prefix + "§aDu wurdest zum Spawn teleportiert!");
		}
	}
}
