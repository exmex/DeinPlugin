package de.skywars.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.skywars.gamestates.GameState;
import de.skywars.listener.GameProtection;
import de.skywars.listener.Kits;
import de.skywars.listener.SetMap;
import de.skywars.methods.SpawnManager;
import de.skywars.utils.CoinsManager;
import de.skywars.utils.Data;
import de.skywars.utils.StatsManager;

public class Main extends JavaPlugin{
	public static List<String> list = Data.cfg.getStringList("Maps"); 
	static int cd;
	public static boolean gamestart;
	public static boolean chestuse;
	public static GameState gs = GameState.LOBBY;
	public static String MapName;
	@SuppressWarnings("deprecation")
	public void onEnable(){		
		for(int i = 0 ; i < Main.list.size() ; i++){
			World w = Main.resetWorld(new File("backup_" + list.get(i)) , new File(list.get(i)) , list.get(i));
			Bukkit.getConsoleSender().sendMessage("§aMAP RESET SUCCESSFULLY FOR §6" + list.get(i));
			}
		SetMap.fin = false;
		File file = new File("plugins//SkyWars//maps.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		MySQL.connect();
		MySQL.createTable();
		list = Data.cfg.getStringList("Maps");
		
			gs = GameState.LOBBY;
			chestuse = false;
			gamestart = false;
			MainListener.cdc = 61;
			MainListener.counddown = false;
			Bukkit.getPluginManager().registerEvents(new ChestListener(), this);
			Bukkit.getPluginManager().registerEvents(new MainListener(this), this);
			Bukkit.getPluginManager().registerEvents(new TeleportListener(this), this);
			Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
			Bukkit.getPluginManager().registerEvents(new GameProtection(), this);
			Bukkit.getPluginManager().registerEvents(new StatsManager(), this);
			Bukkit.getPluginManager().registerEvents(new CoinsManager(), this);
			Bukkit.getPluginManager().registerEvents(new Kits(), this);
			getCommand("setspawn").setExecutor(new SpawnManager());
			getCommand("start").setExecutor(new SpawnManager());
			getCommand("setmap").setExecutor(new SetMap());
			getCommand("forcemap").setExecutor(new SetMap());

			createRandomMap();

			Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					if(gs == GameState.LOBBY){
					if(Bukkit.getOnlinePlayers().size() < 2){
						Bukkit.broadcastMessage(Data.Prefix + "§eWarte auf weitere Spieler...");
					}
				}else{
					Bukkit.getScheduler().cancelTask(cd);
				}
				}
			}, 20, 180);

	}
	@Override
	public void onLoad() {
		
	}
	public void onDisable() {
		for(int i = 0 ; i < Main.list.size() ; i++){
			World w = Main.resetWorld(new File("backup_" + list.get(i)) , new File(list.get(i)) , list.get(i));
			Bukkit.getConsoleSender().sendMessage("§aMAP RESET SUCCESSFULLY FOR §6" + list.get(i));
			}
		for(Player all : Bukkit.getOnlinePlayers()) {
			StatsManager.InsertStatsIntoMySQL(all);
			CoinsManager.loadHashCoinsIntoSQL(all);
			all.kickPlayer("SERVER RELOAD!REJOIN!");
		}
		MySQL.disconnect();
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
	 public void createRandomMap(){
		 int zahl = (int)(Math.random() * list.size() + 1);
			MapName = list.get(zahl -1);
         }
	 }

