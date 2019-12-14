package de.souppvp.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.bossbar.BossBarAPI;

import de.souppvp.commands.SetSpawn;
import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;
import de.souppvp.feast.FeastListener;
import de.souppvp.feast.KitAuswahl;
import de.souppvp.feast.KitFunctions;
import de.souppvp.feast.KitManager;
import de.souppvp.feast.VerlassenFeast;
import de.souppvp.itemfunctions.Navigator;
import de.souppvp.itemfunctions.Profil;
import de.souppvp.itemfunctions.Verlassen;
import de.souppvp.levelsystem.LevelData;
import de.souppvp.levelsystem.LevelHandler;
import de.souppvp.listener.ChatEvent;
import de.souppvp.listener.ChatListener;
import de.souppvp.listener.DeathListener;
import de.souppvp.listener.ItemDrop;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.listener.PlayerQuitEvent;
import de.souppvp.listener.Protection;
import de.souppvp.listener.SoupListener;
import de.souppvp.onevsonemanager.LeaveOneVSOne;
import de.souppvp.onevsonemanager.OneVSOneChallenger;
import de.souppvp.onevsonemanager.OneVSOneDeath;
import de.souppvp.onevsonemanager.OneVSOneQuitListener;
import de.souppvp.onevsonemanager.OneVSOneWarteschlange;
import de.souppvp.spawnmanager.SpawnManager;
import de.souppvp.statssystem.StatsSystem;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Main extends JavaPlugin{

	public static Main plugin;
	int firststart;
	int i;
	int c;
	int reset = 120;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		firststart = 5;
		c = 4;
		plugin = this;
		registerEvents();
		registerCommands();
		LevelData.createLevel();
		i = 100;
		reset = 200;
		for(Player all : Bukkit.getOnlinePlayers()){
			SpawnManager.teleportToSpawn(all, "Spawn");
			 Data.firstJoin.add(all);
			 StatsSystem.loadStatsFormConfigIntoHashMap(all);
		}
		Bukkit.broadcastMessage(Data.Prefix + "§7Das §eSpiel §7wurde neu geladen!");
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				c--;
				reset--;
				World w = Bukkit.getWorld("world");
				w.setTime(1500);
				w.setAnimalSpawnLimit(0);
				w.setMonsterSpawnLimit(0);
				
				if(reset == 60){
					Bukkit.broadcastMessage(Data.Prefix + "§eAlle §6herumliegenden §eItems §ewerden in §660 Sekunden §everschwinden!");
				}
				if(reset == 10){
					Bukkit.broadcastMessage(Data.Prefix + "§eAlle §6herumliegenden §eItems §ewerden in §610 Sekunden §everschwinden!");
				}
				if(reset == 0){
					Bukkit.broadcastMessage(Data.Prefix + "§eAlle §6herumliegenden §eItems §esind verschwunden!");
					for(Player all : Bukkit.getOnlinePlayers()){
					for(Entity ent : all.getWorld().getEntities()) {
						if(ent instanceof Player) {
						} else {
							ent.remove();
						}
					}
					}
					reset = 200;
				}
				if(i == 50){
					i = 100;
				}
				i--;
				i--;
				i--;
				i--;
				i--;
				if(c == 0){
					c = 4;
				}
			for(Player all : Bukkit.getOnlinePlayers()){
				if(!Data.firstJoin.contains(all)){
					BossBarAPI.removeBar(all);	
				}
				if(firststart != 0){
					firststart--;
					sendActionbar(all, Data.Prefix + "§7Das Spiel wird §cvorbereitet...§7!");
				}else{
				}
				if(Data.firstJoin.contains(all)){
					sendActionbar(all, Data.Prefix + "§7Dein §bSüppchen §7Modus!");
					BossBarAPI.setMessage(all, "§eUnsere §6Süppchen §eschmecken am besten!");
					BossBarAPI.setHealth(all, i);
					all.setLevel(Bukkit.getOnlinePlayers().size());
					all.setExp(0);
				}
				if(Data.OneVSOneJoin.contains(all)){
					if(Data.OneVSOneWarteschlange.contains(all)){
						if(c == 4){
							sendActionbar(all, Data.Prefix + "§aWarteschlange §7» §2§l");
						}
						if(c == 3){
							sendActionbar(all, Data.Prefix + "§aWarteschlange §7» §2§l•");
						}
						if(c == 2){
							sendActionbar(all, Data.Prefix + "§aWarteschlange §7» §2§l• •");
						}
						if(c == 1){
							sendActionbar(all, Data.Prefix + "§aWarteschlange §7» §2§l• • •");
						}
						if(c == 0){
							sendActionbar(all, Data.Prefix + "§aWarteschlange §7» §2§l• • • •");
						}
					}else{
						sendActionbar(all, Data.Prefix + "§7Soup §e1vs1 §7Modus!");
					}
					all.setLevel(Bukkit.getOnlinePlayers().size());
					all.setExp(0);
				}
				if(Data.FeastNoKit.contains(all)){
						if(c == 4){
							sendActionbar(all, Data.Prefix + "§6Wähle ein Kit! §7» §2§l");
						}
						if(c == 3){
							sendActionbar(all, Data.Prefix + "§6Wähle ein Kit! §7» §2§l•");
						}
						if(c == 2){
							sendActionbar(all, Data.Prefix + "§6Wähle ein Kit! §7» §2§l• •");
						}
						if(c == 1){
							sendActionbar(all, Data.Prefix + "§6Wähle ein Kit! §7» §2§l• • •");
						}
						if(c == 0){
							sendActionbar(all, Data.Prefix + "§6Wähle ein Kit! §7» §2§l• • • •");
						}
					}
				if(Data.FeastJoin.contains(all)){
					sendActionbar(all, Data.Prefix + "§6Dein Kit §7» §a§l" + KitManager.getKitName(all));
					all.setLevel(0);
					all.setExp(0);
				}
					all.setLevel(Bukkit.getOnlinePlayers().size());
					all.setExp(0);
				}
			
			}
		}, 20, 20);
		
		
	}
	@Override
	public void onDisable() {
		for(Player all : Bukkit.getOnlinePlayers()){
			SpawnManager.teleportToSpawn(all, "Spawn");
			StatsSystem.loadStatsFromHashMapIntoConfig(all);
			all.sendMessage(Data.Prefix + "§7Deine Statistiken wurden §ezwischengespeichert§7!");
			PlayerJoinListener.getLobbyItems(all);
		}
	}
	public void registerEvents(){
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new LevelHandler(), this);
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
		Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new Navigator(), this);
		Bukkit.getPluginManager().registerEvents(new Profil(), this);
		Bukkit.getPluginManager().registerEvents(new Verlassen(this), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveOneVSOne(), this);
		Bukkit.getPluginManager().registerEvents(new OneVSOneChallenger(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveOneVSOne(), this);
		Bukkit.getPluginManager().registerEvents(new OneVSOneDeath(this), this);
		Bukkit.getPluginManager().registerEvents(new ItemDrop(), this);
		Bukkit.getPluginManager().registerEvents(new OneVSOneQuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new SoupListener(), this);
		Bukkit.getPluginManager().registerEvents(new OneVSOneWarteschlange(), this);
		Bukkit.getPluginManager().registerEvents(new VerlassenFeast(), this);
		Bukkit.getPluginManager().registerEvents(new KitAuswahl(), this);
		Bukkit.getPluginManager().registerEvents(new FeastListener(this), this);
		Bukkit.getPluginManager().registerEvents(new KitFunctions(), this);


	}
	public void registerCommands(){
		getCommand("setspawn").setExecutor(new SetSpawn());
	}
	public static void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
}
