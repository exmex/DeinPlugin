package spigotplugins.knockbackffa.listener;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import spigotplugins.knockbackffa.main.Main;
import spigotplugins.knockbackffa.main.StatsManager;
import spigotplugins.knockbackffa.manager.SpawnManager;
import spigotplugins.knockbackffa.storage.Data;

public class JoinListener implements Listener{
	public JoinListener(spigotplugins.knockbackffa.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.knockbackffa.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		e.getPlayer().setFoodLevel(20);
		e.getPlayer().setHealthScale(1);
		e.getPlayer().setHealth(1);
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setArmorContents(null);
		e.setJoinMessage(new Data().Prefix + "§eDer Spieler §6" + e.getPlayer().getName() +"§e spielt nun mit §7(§a" + Bukkit.getOnlinePlayers().size() + "§7/§c" + Bukkit.getMaxPlayers() + "§7)");
		Main.setRandomKit(e.getPlayer());
		Main.sendActionbar(e.getPlayer(), new Data().Prefix + "§aWillkommen auf §6MeinServer.de");		
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		e.getPlayer().setGameMode(GameMode.ADVENTURE);

		Player p = e.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				
				p.teleport(SpawnManager.location.get(Main.MapName));
			}
		},5L);
		
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				p.sendMessage("§b§m-------------------------------");
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
			}
		}, 5L);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				p.sendMessage("");
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
			}
		}, 8L);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				p.sendMessage(new Data().Prefix + "§eDeine Kills §7» §7[§6" + StatsManager.Kills.get(p.getName()) + "§7]");
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
			}
		}, 11L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				p.sendMessage(new Data().Prefix + "§eDeine Tode §7» §7[§6" + StatsManager.Deaths.get(p.getName()) + "§7]");

				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
			}
		}, 14L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
		
		@Override
		public void run() {
			p.sendMessage("");

			p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 10, 10);
		}
		}, 17L);
	Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
		
		@Override
		public void run() {
			p.sendMessage("§b§m-------------------------------");
			p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 10);
			p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 10, 10);

		}
	}, 20L);
	
	}
}

