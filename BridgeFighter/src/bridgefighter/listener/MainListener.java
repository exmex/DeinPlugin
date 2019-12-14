package bridgefighter.listener;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import bridgefighter.data.Data;
import bridgefighter.methods.Inventorys;
import bridgefighter.methods.Scoreboard;
import bridgefighter.methods.Sounds;
import bridgefighter.stats.StatsManager;

public class MainListener implements Listener {
	public MainListener(bridgefighter.main.Main Main){
		this.pl = Main;
	}
	int i;
	private bridgefighter.main.Main pl;
	public static HashMap<String, Integer> Sound = new HashMap<>();
	public static HashMap<String, Integer> CD = new HashMap<>();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Data.gegner.put(e.getPlayer().getName(), "Unbekannt");
		CD.put(e.getPlayer().getName(), 0);
		Sound.put(e.getPlayer().getName(), 10);
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		p.setFoodLevel(20);
		Inventorys.getPlayerNormalInventory(p);
		System.out.println(Data.MapLocations.get("Spawn").toString());
		p.teleport(Data.MapLocations.get("Spawn"));
		i = CD.get(p.getName());
		i = Bukkit.getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {
			@Override
			public void run() {
				if(Sound.get(p.getName()) == 10){
					p.setHealth(2);
					p.setFoodLevel(20);
					p.sendTitle("§6§lC", "§a§l●");
					p.sendMessage("");
				}
				if(Sound.get(p.getName()) == 9){
					p.sendTitle("§6§lCL", "§a§l● ●");
					p.sendMessage(Data.Prefix + "§a§lNEU §7auf §3§lClayMC.net"); 
					p.setHealth(4);
				}
				if(Sound.get(p.getName()) == 8){
					p.sendTitle("§6§lCLA", "§a§l● ● ●");
					p.sendMessage(Data.Prefix + "§6§lBridgeFighter");
					p.setHealth(6);
				}
				if(Sound.get(p.getName()) == 7){
					p.sendTitle("§6§lCLAY", "§a§l● ● ● ●");
					p.sendMessage(Data.Prefix + "§9Versuche in einem 1vs1 deinen §eGegner §9von");
					p.setHealth(8);
				}
				if(Sound.get(p.getName()) == 6){
					p.sendTitle("§6§lCLAYM", "§a§l● ● ● ● ●");
					p.sendMessage(Data.Prefix + "§9einer §eBrücke §9zu schubsen!");
				}
				if(Sound.get(p.getName()) == 5){
					p.sendTitle("§6§lCLAYMC", "§a§l● ● ● ● ● ●");
					p.setHealth(10);
					p.sendMessage("");
				}
				if(Sound.get(p.getName()) == 4){
					p.sendTitle("§6§lCLAYMC.", "§a§l● ● ● ● ● ●");
					p.setHealth(12);
				}
				if(Sound.get(p.getName()) == 3){
					p.sendTitle("§6§lCLAYMC.N", "§a§l● ● ● ● ● ● ●");
					p.setHealth(14);
				}
				if(Sound.get(p.getName()) == 2){
					p.sendTitle("§6§lCLAYMC.NE", "§a§l● ● ● ● ● ● ● ●");
					p.setHealth(16);
				}
				if(Sound.get(p.getName()) == 1){
					p.sendTitle("§6§lCLAYMC.NET", "§a§l● ● ● ● ● ● ● ● ●");
					p.setHealth(18);
				}
				
				if(Sound.get(p.getName()) != 0){
				p.playSound(p.getLocation(), org.bukkit.Sound.LEVEL_UP, Sound.get(p.getName()), Sound.get(p.getName()));
				p.playSound(p.getLocation(), org.bukkit.Sound.NOTE_SNARE_DRUM, Sound.get(p.getName()), Sound.get(p.getName()));
				p.playSound(p.getLocation(), org.bukkit.Sound.NOTE_STICKS, Sound.get(p.getName()), Sound.get(p.getName()));
				Sound.put(p.getName(), Sound.get(p.getName()) -1);
				p.setHealth(20);
			}else{
				Bukkit.getScheduler().cancelTask(i);
				Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {
						p.sendTitle("§eClayMC.net", "§9» BridgeFighter «");
						p.playSound(p.getLocation(),org.bukkit.Sound.NOTE_PIANO , 2, 2);
						p.playSound(p.getLocation(),org.bukkit.Sound.NOTE_BASS_DRUM , 3, 3);
					}
				}, 10);
				
			}
			}
		}, 2, 2);
		try {
			StatsManager.loadStatsFromPlayerIntoHashMap(p);
		} catch (IOException e1) {
		   p.sendMessage(Data.Prefix + "§cFehler beim laden der Stats von " + p.getName());
		   p.kickPlayer(Data.Prefix + "§cFehler beim Laden deiner Stats...");
		   return;
		   
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
	}
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
}
