package de.spigotplugins.ffa.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.ItemStack;

import de.spigotplugins.ffa.data.Data;
import de.spigotplugins.ffa.main.Main;
import de.spigotplugins.methods.HeaderFooter;
import de.spigotplugins.methods.Inv;
import de.spigotplugins.methods.Scoreboard;
import de.spigotplugins.methods.StatsManager;

public class MainEvents implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		 Player p = e.getPlayer();
		 if(Data.enable == false){
			 if(p.hasPermission("ffa.admin")){
					p.sendMessage(Data.Prefix + "§e§m-----------------------------------------------");
					p.sendMessage(Data.Prefix + "§cDu musst einen Spawn Setzen, damit das Plugin startet!");
				    p.sendMessage(Data.Prefix + "§c/FFA SetSpawn [MapName]");
					p.sendMessage(Data.Prefix + "§c/FFA SetHigh [MapName]");
					p.sendMessage(Data.Prefix + "§e§m-----------------------------------------------");
					return;
			 }
		 }
		 HeaderFooter.sendTablistHeaderAndFooter(p, "§7» §6FFA §7«", "§aDein Spielmodus");
		 e.setJoinMessage(Data.Prefix + "§eDer Spieler §6" + p.getName() + "§e ist der Runde beigetreten!");
		 p.setLevel(0);
		 try{
			 Main.teleportToMap(p);
		 }catch(Exception e1){
			 if(p.hasPermission("ffa.admin")){
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
				 p.sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN! UNBEDINGT NEU SETZEN!");
			 }else{
				 p.kickPlayer(Data.Prefix + "§cEin Fehler ist aufgetreten...");
				 Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§c§lFEHLER! DIE SPAWNLOCATION KONNTE NICHT GELADEN WERDEN!");
			 }
			 
			 
		 }
			 p.sendTitle("§3FFA", "§aWillkommen");
			 p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
			 if(Data.nhd == true){
			 Inv.getPlayerStandart(p);
			 ItemStack a = new ItemStack(Material.DIAMOND_HELMET);
				ItemStack b = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack ca = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemStack d = new ItemStack(Material.DIAMOND_BOOTS);
					p.setMaximumNoDamageTicks(0);
					p.getInventory().setHelmet(a);
					p.getInventory().setChestplate(b);
					p.getInventory().setLeggings(ca);
					p.getInventory().setBoots(d);	 
			 }else{
				 Inv.getPlayerStandart(p);
			 }
			 p.setGameMode(GameMode.ADVENTURE);
			 StatsManager.loadStatsFromConfigIntoHashMap(p);
			 for(Player all : Bukkit.getOnlinePlayers()){
			 Scoreboard.setScoreboard(all);
			 if(Data.nhd == true){
				 p.setMaximumNoDamageTicks(0);
			 }else{
				 p.setMaximumNoDamageTicks(20);
			 }
			 }
	}
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		StatsManager.loadStatsFromHashMapIntoConfig(p);
		e.setQuitMessage(Data.Prefix + "§eDer Spieler §6" + p.getName() + "§e hat die Runde §cverlassen§e!");
		
	}
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/stop") || e.getMessage().equalsIgnoreCase("/rl") || e.getMessage().equalsIgnoreCase("/reload")){
			if(e.getPlayer().hasPermission("ffa.admin")){
				for(Player all : Bukkit.getOnlinePlayers()){
					all.kickPlayer("§cDer Server startet neu!");
				}
			}
		}
	}
	@EventHandler
	public void onConsole(ServerCommandEvent e){
		if(e.getSender() instanceof ConsoleCommandSender){
			if(e.getCommand().equalsIgnoreCase("stop") || e.getCommand().equalsIgnoreCase("rl") || e.getCommand().equalsIgnoreCase("reload")) {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.kickPlayer("§cDer Server startet neu!");
				}
		}
	
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
		Location loc = Main.returnLocation(Main.MapName);
		if(e.getDamager().getLocation().getY() > Data.hohe -1 && loc.distance(e.getDamager().getLocation()) < 6){
			e.getDamager().sendMessage(Data.Prefix + "§cDu kannst hier noch nicht kämpfen!");
			e.setCancelled(true);
		}
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String Message = e.getMessage().replace("%", "Prozent");
		e.setFormat(Data.Prefix + "§7[§b" + StatsManager.kills.get(p.getUniqueId()) + "§7] §a" + p.getName() + "§7 » §9" + Message);
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		e.setCancelled(true);
		e.getPlayer().sendMessage(Data.Prefix + "§eDu darfst keine Items droppen!");
	}
	@EventHandler
	public void onP(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/start")){
			if(e.getPlayer().hasPermission("testtaaaa")){
			Main.i = 10;
		}
		}
	}
}
