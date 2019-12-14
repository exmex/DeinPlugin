package spigotplugins.skywars.listener;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import NickSystem.Manager.Nick;
import NickSystem.Manager.NickManager;
import NickSystem.Manager.NickNameManager;
import me.eder.statsapi.StatsAPI;
import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.main.Boards;
import spigotplugins.skywars.main.ChestManager;
import spigotplugins.skywars.main.DeathListener;
import spigotplugins.skywars.main.StatsManager;
import spigotplugins.skywars.main.TabList;
import spigotplugins.skywars.manager.Inventorys;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class JoinListener implements Listener{
	public JoinListener(spigotplugins.skywars.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.skywars.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(NickManager.isNicked(p)){
			if(Data.gs == GameState.LOBBY){
				NickSystem.Manager.AutoNickManager.setNick(p);
			}
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			TabList.setScoreboard(all);
		}
		p.setLevel(0);
		if(Data.gs == GameState.LOBBY){
			p.setGameMode(GameMode.ADVENTURE);
			StatsManager.Coins.put(p.getName(), 0);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "KILLS");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "DEATHS");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "COINS");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "BAUARBEITER");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "BOGENSCHUETZE");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "WINS");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "TANK");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "ASSASSINE");
				new Manager().createPlayer(p.getUniqueId(),p.getName(), "SKYWARS", "MLG");
				ChestManager.openchests.put(p, 0);
				StatsManager.Coins.put(p.getName(), new Manager().getInt(p.getUniqueId(), "SKYWARS", "COINS"));
				if(new Manager().getInt(p.getUniqueId(), "SKYWARS", "BAUARBEITER") == 1){
					KitListener.BAUARBEITER.add(p);
				}
				if(new Manager().getInt(p.getUniqueId(), "SKYWARS", "BOGENSCHUETZE") == 1){
					KitListener.BOGENSCHUETZE.add(p);
				}
				if(new Manager().getInt(p.getUniqueId(), "SKYWARS", "TANK") == 1){
					KitListener.TANK.add(p);
				}
				if(new Manager().getInt(p.getUniqueId(), "SKYWARS", "ASSASSINE") == 1){
					KitListener.ASSASSINE.add(p);
				}
				if(new Manager().getInt(p.getUniqueId(), "SKYWARS", "MLG") == 1){
					KitListener.MLG.add(p);
				}
				
			}
		}, 1L);
		p.setHealth(20);
		p.setFoodLevel(20);
		Boards.setBoard(p);
		KitListener.Kits.put(p.getName(), "§cUnbekannt");
		if(Data.Locs.containsKey("Spawn")){
			p.teleport(Data.Locs.get("Spawn"));
		}else{
			p.sendMessage(Data.Prefix + "§cDer Spawn wurde noch nicht gesetzt...");
		}
		if(Data.gs == GameState.LOBBY){
			String Name = p.getName().replace("§7", "");
			e.setJoinMessage(Data.Prefix + "§eDer Spieler §9" + Name + "§e spielt nun mit §7(§a" + Bukkit.getOnlinePlayers().size() + "§7/§c8§7)");
		}
		Boards.setBoard(p);
		if(Bukkit.getOnlinePlayers().size() >= 2){
			if(Data.runlobbycountdown == false){
				Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {
						Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt, da genügend §9Spieler §eonline sind!");
						Data.runlobbycountdown = true;
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
						}
					}
				},6L);
			}
			}
			
			
		Inventorys.setLobbyItems(p);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				ItemStack a = new ItemStack(Material.AIR);
				p.getInventory().setItem(2, a);
				p.getInventory().setItem(6, a);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
			}
		},15);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				ItemStack a = new ItemStack(Material.AIR);
				p.getInventory().setItem(3, a);
				p.getInventory().setItem(5, a);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			}
		},23L);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				ItemStack a = new ItemStack(Material.AIR);
				p.getInventory().setItem(4, a);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
				p.sendTitle("§6SkyWars", "§9" + p.getName());
			}
		},31L);
		
	}else{
		int a = 0;
		e.setJoinMessage(null);
		for(Player all : Bukkit.getOnlinePlayers()){
			all.hidePlayer(p);
		}
			ChestManager.openchests.put(p, 0);
			try{
            p.teleport(DeathListener.INGAME.get(a));
			}catch(Exception e1){
				Bukkit.shutdown();
			}
            p.setGameMode(GameMode.SPECTATOR);
            Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
				
				@Override
				public void run() {

					p.setGameMode(GameMode.SPECTATOR);
					
				}
			},5L);
		}
	
	}


}
