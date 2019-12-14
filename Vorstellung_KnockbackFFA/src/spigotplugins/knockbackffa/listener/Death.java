package spigotplugins.knockbackffa.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import spigotplugins.knockbackffa.main.Main;
import spigotplugins.knockbackffa.main.StatsManager;
import spigotplugins.knockbackffa.manager.SpawnManager;
import spigotplugins.knockbackffa.storage.Data;

public class Death implements Listener{
	public Death(spigotplugins.knockbackffa.main.Main Main){
		this.pl = Main;
	}
	private spigotplugins.knockbackffa.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(p == p.getKiller()){
			e.setDeathMessage(null);
			e.setDeathMessage(new Data().Prefix + "§6" + p.getName() + "§e ist gestorben...");
			StatsManager.Deaths.put(p.getName(), StatsManager.Deaths.get(p.getName()) +1);
			p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);
			p.setHealthScale(1);
			p.setHealth(1);
			p.teleport(SpawnManager.location.get(Main.MapName));
			p.setHealthScale(1);
			p.setHealth(1);
			e.getDrops().clear();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
				@Override
				public void run() {
					Main.setRandomKit(p);
				}
			},2L);
			return;
		}
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);
		e.setDeathMessage(null);
		StatsManager.Deaths.put(p.getName(), StatsManager.Deaths.get(p.getName()) +1);
		if(p.getKiller() == null){
			p.sendTitle("§4§l✖", "§cGESTORBEN");
			e.setDeathMessage(new Data().Prefix + "§6" + p.getName() + "§e ist gestorben...");
		}else{
			StatsManager.Kills.put(p.getKiller().getName(), StatsManager.Kills.get(p.getKiller().getName()) +1);
			p.sendTitle("§4§l✖", "§9" + p.getKiller().getName());
			p.getKiller().sendTitle("§a§l✔", "§7" + p.getName());
			p.getKiller().playSound(p.getKiller().getLocation(), Sound.LEVEL_UP, 10, 10);
			
		}
		p.setHealthScale(1);
		p.setHealth(1);
		p.teleport(SpawnManager.location.get(Main.MapName));
		p.setHealthScale(1);
		p.setHealth(1);
		e.getDrops().clear();
		
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				Main.setRandomKit(p);
			}
		},2L);
	}
}
