package spigotplugins.skywars.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.listener.JoinListener;
import spigotplugins.skywars.listener.KitListener;
import spigotplugins.skywars.listener.LoginListener;
import spigotplugins.skywars.listener.MoveListener;
import spigotplugins.skywars.listener.Protection;
import spigotplugins.skywars.listener.QuitListener;
import spigotplugins.skywars.listener.Teamauswahl;
import spigotplugins.skywars.manager.CoinsManager;
import spigotplugins.skywars.manager.SpawnCommands;
import spigotplugins.skywars.manager.StartCMD;
import spigotplugins.skywars.manager.StatsCMD;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class Main extends JavaPlugin{
public static Plugin instance;
public static int wartezeit;
public static boolean fruhstart;
public static int runcountdown;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		new TopNick().loadActualTopNick();
		fruhstart = false;
		DeathListener.endingTime = 16;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				if(Data.gs == GameState.ENDING){
					((CraftServer) Bukkit.getServer()).getServer().setMotd("ENDING");

				}
				if(Data.gs == GameState.INGAME){
					if(DeathListener.INGAME.size() == 0 || DeathListener.INGAME.size() == 1){
						Bukkit.shutdown();
					}
					if(Bukkit.getOnlinePlayers().size() == 0){
						Bukkit.shutdown();
					}
				}
			}
		},20L, 20L);
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				if(Bukkit.getOnlinePlayers().size() < 1){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.kickPlayer(Data.Prefix + "§cAufgrund von Server-Performanten Gründen startet der Server nun neu...");
					}
				}
			}
		}, 72000L, 20L);
		// LOBBY CLASS
		
		new Manager().createTable("SKYWARS");
		
		List list;
		Data.runmovecountdown = false;
		StartCMD.started = false;
		runcountdown = 4;
		list = SpawnManager.cfg.getStringList("Maps");
		if(list.isEmpty()){
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cEs konnten keine Maps gefunden werden...");
		}else{
			int zahl = (int)((Math.random()) * list.size()-1 + 1);
			Data.MapName = (String) list.get(zahl);
			Data.MapLocs.put(1, SpawnManager.loadGame(Data.MapName, 1));
			Data.MapLocs.put(2, SpawnManager.loadGame(Data.MapName, 2));
			Data.MapLocs.put(3, SpawnManager.loadGame(Data.MapName, 3));
			Data.MapLocs.put(4, SpawnManager.loadGame(Data.MapName, 4));
			Data.MapLocs.put(5, SpawnManager.loadGame(Data.MapName, 5));
			Data.MapLocs.put(6, SpawnManager.loadGame(Data.MapName, 6));
			Data.MapLocs.put(7, SpawnManager.loadGame(Data.MapName, 7));
			Data.MapLocs.put(8, SpawnManager.loadGame(Data.MapName, 8));
			
		}
		if(SpawnManager.cfg.get("X.Spawn") != null){
			Data.Locs.put("Spawn", SpawnManager.loadWarp("Spawn"));
		}else{
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cDer Spawn konnte nicht gefunden werden...");
		}
		instance = this;
		Data.gs = GameState.LOBBY;
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§eDas Plugin startet nun...");
		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new QuitListener(this), this);
		Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
		Bukkit.getPluginManager().registerEvents(new KitListener(), this);
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new Teamauswahl(), this);
		Bukkit.getPluginManager().registerEvents(new ChestManager(), this);
		Bukkit.getPluginManager().registerEvents(new LoginListener(), this);

		Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
		getCommand("setspawn").setExecutor(new SpawnCommands());
		getCommand("start").setExecutor(new StartCMD());
		getCommand("stats").setExecutor(new StatsCMD(this));
		getCommand("top").setExecutor(new StatsCMD(this));
		getCommand("addcoins").setExecutor(new CoinsManager());
		wartezeit = 60;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(Data.gs == GameState.INGAME){
					for(Player all : Bukkit.getOnlinePlayers()){
					Boards.setBoard(all);
					}
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					if(!DeathListener.INGAME.contains(all)){
						if(all.getLocation().getY() < 0){
							Location loc = new Location(all.getWorld(), all.getLocation().getX(), 100, all.getLocation().getZ());
							all.teleport(loc);
						}
					}
					if(DeathListener.INGAME.contains(all)){
						if(all.getLocation().getY() < -46){
							all.getPlayer().damage(100.0);
						}
					}
				}
				if(Data.runlobbycountdown){
					if(fruhstart == false){
					if(Bukkit.getOnlinePlayers().size() == 8){
						if(wartezeit > 10){
						wartezeit = 10;
						fruhstart = true;
					}
					}
					}
					if(wartezeit == 60){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					wartezeit--;
					for(Player all : Bukkit.getOnlinePlayers()){
						Boards.setBoard(all);
						all.setLevel(wartezeit);
					}
					if(wartezeit == 50){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if(wartezeit == 40){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if(wartezeit == 30){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if(wartezeit == 20){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if(wartezeit == 10){
						StartCMD.started = true;
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if(wartezeit == 5){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							all.sendTitle("§2§l5", "");
						}
						
					}
					if(wartezeit == 4){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							all.sendTitle("§a§l4", "");
						}
					}
					if(wartezeit == 3){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							all.sendTitle("§e§l3", "");
						}
					}
					if(wartezeit == 2){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6" + wartezeit + "§e Sekunden!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							all.sendTitle("§6§l2", "");
						}
					}
					if(wartezeit == 1){
						Bukkit.broadcastMessage(Data.Prefix + "§eDas Spiel beginnt in §6einer §eSekunde!");
						for(Player all : Bukkit.getOnlinePlayers()){
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							all.sendTitle("§c§l1", "");
						}
						((CraftServer) Bukkit.getServer()).getServer().setMotd("INGAME");
					}
					
					if(wartezeit == 0){
					Data.gs = GameState.INGAME;
					int i = 1;
					for(Player all : Bukkit.getOnlinePlayers()){
							all.teleport(Data.MapLocs.get(i));
							MoveListener.move.add(all);
							all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
						all.getInventory().clear();
						KitListener.setKits(all);
						Data.runlobbycountdown = false;
						Data.runmovecountdown = true;
						i++;
						if(KitListener.Kits.get(all.getName()).equalsIgnoreCase("§cUnbekannt")){
							if(KitListener.BAUARBEITER.contains(all)){
								KitListener.BAUARBEITER.add(all);
								KitListener.Kits.put(all.getName(), "§a§lBauarbeiter");
								all.sendMessage(Data.Prefix + "§eDir wurde das §6Bauarbeiter §eKit festgelegt, da du kein Kit ausgewählt hast.");
								KitListener.setKits(all);
								Boards.setBoard(all);
							}
						}
					}
					for(Player all : Bukkit.getOnlinePlayers()){
						all.setLevel(wartezeit);
						DeathListener.INGAME.add(all);
						all.setGameMode(GameMode.SURVIVAL);
						Boards.setBoard(all);
					}
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage(Data.Prefix + "§aDas Spiel beginnt mit §6" + DeathListener.INGAME.size() + "§a§l Spielern§a!");
					Bukkit.broadcastMessage("");
					

					}	
					}
				
				if(Data.gs == GameState.INGAME){
					if(Data.runmovecountdown){
						runcountdown--;
						if(runcountdown == 3){
							for(Player all : Bukkit.getOnlinePlayers()){
								all.sendTitle("§2§l3", "");
								all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								Boards.setBoard(all);
							}
						}
						if(runcountdown == 2){
							for(Player all : Bukkit.getOnlinePlayers()){
								all.sendTitle("§e§l2", "");
								all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								Boards.setBoard(all);
							}
						}
						if(runcountdown == 1){
							for(Player all : Bukkit.getOnlinePlayers()){
								all.sendTitle("§c§l1", "");
								all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 1, 1);
								Boards.setBoard(all);
							}
						}
						if(runcountdown == 0){
							for(Player all : Bukkit.getOnlinePlayers()){
								all.sendTitle("§aViel Glück", "");
								all.playSound(all.getLocation(), Sound.WITHER_IDLE, 1, 1);
								Boards.setBoard(all);
							}
							Data.runmovecountdown = false;
							MoveListener.move.clear();
						}
					}
				}
			}
		}, 20, 20);
		((CraftServer) Bukkit.getServer()).getServer().setMotd("LOBBY");
	}
	@Override
		public void onDisable() {
		World w = Main.resetWorld(new File("backup_" + Data.MapName) , new File(Data.MapName) , Data.MapName);
		}
	 public static World resetWorld (File backup, File toReset , String worldname) {
	        Bukkit.getServer().unloadWorld(worldname, true);
	        try {
	            FileUtils.deleteDirectory(toReset);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if(!toReset.exists()) {
	            try {
	                FileUtils.copyDirectory(backup , toReset);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        World w  = Bukkit.createWorld(new WorldCreator(worldname));
	        return w;
	    }
}
