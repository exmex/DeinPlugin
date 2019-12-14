package de.codeexception.events;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.codeexception.oneversusone.Main;
import de.codeexception.utils.GameState;
import de.codeexception.utils.Item;
import de.codeexception.utils.Map;
import de.codeexception.utils.PlayerStats;
import de.codeexception.utils.SQLStats;

public class PlayerEvents implements Listener {

	ArrayList<Player> players = new ArrayList<>();
	public int countdown;
	public int cd;
	public int runshut;
	public static int waiting = 10;
	public int shutdown = 5;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for(Entity ent : Bukkit.getWorld(Bukkit.getWorld("world").getName()).getEntities()) {
			if(ent instanceof Player) {
			} else {
				ent.remove();
			}
		}
		players.add(e.getPlayer());
		if(Main.state == GameState.Lobby) {
			for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
			}
			Spawn.startlist.clear();
			e.getPlayer().sendMessage("§b§m----------------------");
			e.getPlayer().sendMessage("§3Mit §6/TOP §3kannst du die TOP 10 Spieler sehen!");
			e.getPlayer().sendMessage("§b§m----------------------");

			e.setJoinMessage(Main.px+"§e" + e.getPlayer().getName()+"§7 hat den Server §abetreten§7!");
			e.getPlayer().getInventory().clear();
			Item.getLobbyItems(e.getPlayer());
			e.getPlayer().setLevel(0);
			e.getPlayer().setFoodLevel(20);
			e.getPlayer().setHealth(20);
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
//			e.getPlayer().teleport(Main.map.getLobbySpawn());
			PlayerStats stats = new PlayerStats(e.getPlayer().getUniqueId().toString());
			stats.load();
			Spawn.tpspawn(e.getPlayer());
			if(Bukkit.getOnlinePlayers().size() == 2) {
				players.clear();
				for(Player all : Bukkit.getOnlinePlayers()){
					players.add(all);
				}
				startCountdown();
			}else {
				startWaitingCountdown();
			}
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(Main.px+"§e" + e.getPlayer().getName()+"§7 hat das Spiel §cverlassen!");
		Spawn.startlist.clear();
		if(Main.state == GameState.Lobby) {
			Bukkit.getScheduler().cancelAllTasks();
			waiting = 10;
			startWaitingCountdown();
		}else if(Main.state == GameState.Ingame) {
			Bukkit.broadcastMessage(Main.px+"Du hast das Match §agewonnen§7 , da dein Gegener das Spiel verlassen hat!");
			for (Player all : Bukkit.getOnlinePlayers()) {
				PlayerStats s = new PlayerStats(all.getUniqueId().toString());
				s.addKills(1);
				s.updateToDatabase();
			}
			PlayerStats sa = new PlayerStats(e.getPlayer().getUniqueId().toString());
			sa.addDeaths(1);
			sa.updateToDatabase();
			startShutdown();
		}
	}
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		if(!SQLStats.playerEx(e.getPlayer().getUniqueId().toString())) {
			SQLStats.createPlayer(e.getPlayer().getUniqueId().toString());
		}
		if (Main.state == GameState.Ingame) {
			e.setResult(Result.KICK_FULL);
			e.setKickMessage(Main.px+"§cEs läuft bereits ein Match!");
		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try {
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem().getType() == Material.GLOWSTONE_DUST) {
					e.getPlayer().kickPlayer(Main.px + "§cDu hast den 1vs1 Server verlassen!");
				}
			}	
		} catch (Exception e1) {
			
		}
	}
	@EventHandler
	public void onPvP(EntityDamageByEntityEvent e) {
		if(Main.state == GameState.Lobby || Main.state == GameState.Restarting) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onD(EntityDamageEvent e){
		if(Main.state == GameState.Lobby || Main.state == GameState.Restarting){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		int i = (int) (e.getEntity().getKiller().getHealth() /2);
		PlayerStats sv = new PlayerStats(e.getEntity().getUniqueId().toString());
		e.getEntity().sendMessage(Main.px+"Du hast das Match gegen §e" + e.getEntity().getKiller().getName()+" §cverloren §8[§c" + i + " Herzen§8]");
		e.getEntity().getKiller().sendMessage(Main.px+"Du hast das Match gegen §e"+ e.getEntity().getName()+" §agewonnen");
		e.getEntity().getKiller().setHealth(20);
		sv.addDeaths(1);
		sv.updateToDatabase();
		PlayerStats sg = new PlayerStats(e.getEntity().getKiller().getUniqueId().toString());
		sg.addKills(1);
		sg.updateToDatabase();
		Main.state = GameState.Restarting;
		startShutdown();
		e.setDroppedExp(0);
		e.getDrops().clear();
		
	}
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		e.setRespawnLocation(e.getPlayer().getKiller().getLocation());
		e.getPlayer().setGameMode(GameMode.SPECTATOR);
	}
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMaxPlayers(2);
		if(Main.state == GameState.Ingame) {
			e.setMotd("InGame");
		}else {
			e.setMotd("MapName");
		}
	}
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	public void startMatch(ArrayList<Player> players) {
		File file = new File("plugins//1vs1//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn1.WeltName");
        double x = cfg.getDouble("Spawn1.X");
        double y = cfg.getDouble("Spawn1.Y");
        double z = cfg.getDouble("Spawn1.Z");
        double yaw = cfg.getDouble("Spawn1.Yaw");
        double pitch = cfg.getDouble("Spawn1.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
		players.get(0).teleport(loc);
		
		File file1 = new File("plugins//1vs1//spawns.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
        String w1 = cfg.getString("Spawn2.WeltName");
        double x1 = cfg.getDouble("Spawn2.X");
        double y1 = cfg.getDouble("Spawn2.Y");
        double z1 = cfg.getDouble("Spawn2.Z");
        double yaw1 = cfg.getDouble("Spawn2.Yaw");
        double pitch1 = cfg.getDouble("Spawn2.Pitch");
        Location loc1 = new Location(Bukkit.getWorld((String)w1), x1, y1, z1);
        loc1.setYaw((float)yaw1);
        loc1.setPitch((float)pitch1);
		players.get(1).teleport(loc1);
		Bukkit.broadcastMessage(Main.px+"Das Match hat begonnen!");
		for(Player all : Bukkit.getOnlinePlayers()){
			all.updateInventory();
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).playSound(players.get(i).getLocation(), Sound.ARROW_HIT, 1, 1);
		}
		return;
	}
	public void startCountdown() {
		Bukkit.getScheduler().cancelTask(cd);
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(waiting != 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(waiting);
					}
					if(waiting == 1) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Main.px+"Das Match startet in §e" + waiting +"§7 Sekunde!");
						}
					}else if(waiting == 10 || waiting == 5 || waiting == 15 || waiting == 4 || waiting == 3 || waiting == 2) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Main.px+"Das Match startet in §e" + waiting +"§7 Sekunden!");
							all.playSound(all.getLocation(), Sound.NOTE_PLING, 1, 1);
						}	
					}
					waiting--;
				}else {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(Main.px+"§eDas Match wurde gestartet!");
						all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
						Item.getItems(all);
						all.setLevel(0);
						all.setFoodLevel(20);
						all.setHealth(20);
						all.setGameMode(GameMode.SURVIVAL);
					}
					Main.state = GameState.Ingame;
					startMatch(players);
					Bukkit.getScheduler().cancelAllTasks();
				}
				
			}
		}, 0, 20L);
	}
	@SuppressWarnings("deprecation")
	public void startWaitingCountdown() {
		 cd = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
				
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.sendMessage(Main.px+"Warte auf weitere Spieler!");
				}
			}
		}, 1, 20L*20);
	}
	public void startShutdown() {
		runshut = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(shutdown != 0) {
					if(shutdown == 1) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Main.px+"Der Server stoppt in §e" + shutdown +"§7 Sekunde!");
						}
					}else if(shutdown > 1) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(Main.px+"Der Server stoppt in §e" + shutdown +"§7 Sekunden!");
						}	
					}
					shutdown--;
				}else {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(Main.px+"§eDer Server wird nun gestoppt!");
						all.kickPlayer(Main.px+"Der Match-Server wird nun neugestartet!");
					}
					Bukkit.shutdown();
				}
				
			}
		}, 0, 20L);
	}
}
