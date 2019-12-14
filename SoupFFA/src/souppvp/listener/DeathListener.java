package souppvp.listener;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.core.jmx.StatusLoggerAdmin;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Score;

import com.connorlinfoot.titleapi.TitleAPI;

import souppvp.data.Data;
import souppvp.kitmenu.LastKit;
import souppvp.manager.StatsManager;
import souppvp.methods.Scoreboard;
import souppvp.methods.Sounds;

public class DeathListener implements Listener{
	public static HashMap<Location, String> chest = new HashMap<>();
	public static ArrayList<Player> canswitchkit = new ArrayList<>();
	public static HashMap<String, Material> oldblock = new HashMap<>();
	public static HashMap<String, Location> loc = new HashMap<>();
	
	public DeathListener(souppvp.main.Main Main){
		this.pl = Main;
	}
	private souppvp.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Data.notitle.add(p);
		e.setDeathMessage(null);
		StatsManager.deaths.put(p.getUniqueId().toString(), StatsManager.deaths.get(p.getUniqueId().toString()) +1);
		Scoreboard.setScoreboard(p);

		Player k = e.getEntity().getKiller();
		if(k == null){
			p.sendMessage(Data.Prefix + "§eDu bist auf §cunerklärliche §eWeise gestorben!");
		}
		if(k != null){
			StatsManager.coins.put(k.getUniqueId().toString(), StatsManager.coins.get(p.getUniqueId().toString()) + 3);
			p.sendMessage(Data.Prefix + "§eDu wurdest von §6" + k.getName() + "§e getötet!");
			k.sendMessage(Data.Prefix + "§eDu hast §6" + p.getName() + "§e getötet!");
			StatsManager.kills.put(k.getUniqueId().toString(), StatsManager.kills.get(k.getUniqueId().toString()) +1);
			Sounds.playAdminAcceptSound(k);
			Scoreboard.setScoreboard(k);
		}
		if(oldblock.containsKey(p.getName())){
			Location newloc = loc.get(p.getName());
			Material b = oldblock.get(p.getName());
			newloc.getBlock().setType(b);
			oldblock.remove(p.getName());
			loc.remove(p.getName());
			newloc.getWorld().playEffect(newloc, Effect.CRIT, 10);
			newloc.getWorld().playEffect(newloc, Effect.FLAME, 10);
			newloc.getWorld().playEffect(newloc, Effect.SPELL, 10);
			newloc.getWorld().playEffect(newloc, Effect.LAVA_POP, 10);
			newloc.getWorld().playSound(newloc, Sound.ANVIL_BREAK, 3, 3);
			newloc.getWorld().playSound(newloc, Sound.FIREWORK_BLAST, 10, 10);
			newloc.getWorld().playSound(newloc, Sound.FIREWORK_LARGE_BLAST, 10, 10);
			newloc.getWorld().playEffect(newloc, Effect.EXPLOSION, 10);
		}
		e.getDrops().clear();
		loc.put(p.getName(), p.getLocation());
		p.setHealth(20);
		canswitchkit.add(p);
		if(Data.mapsky.contains(p)){
		p.teleport(Data.sky);
		}
		if(Data.maptripple.contains(p)){
			p.teleport(Data.tripple);
		}
		p.playSound(p.getLocation(), Sound.BAT_DEATH, 1, 1);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				LastKit.getLastPlayerKit(p);
				
			}
		}, 2);
		TitleAPI.sendFullTitle(p, 3, 30, 3, "§4Sneaken um Kit", "§ezu wechseln §7[§a2 Sekunden§7]");
		Location cl = loc.get(p.getName());
		oldblock.put(p.getName(), cl.getBlock().getType());
		cl.getBlock().setType(Material.CHEST);
		chest.put(cl.getBlock().getLocation(), p.getName());
		cl.getWorld().playEffect(cl, Effect.ENDER_SIGNAL, 10);
		cl.getWorld().playEffect(cl, Effect.CLOUD, 10);
		cl.getWorld().playSound(cl, Sound.CHEST_OPEN, 3, 3);
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				Location newloc = loc.get(p.getName());
				Material b = oldblock.get(p.getName());
				newloc.getBlock().setType(b);
				oldblock.remove(p.getName());
				loc.remove(p.getName());
				newloc.getWorld().playEffect(newloc, Effect.CRIT, 10);
				newloc.getWorld().playEffect(newloc, Effect.FLAME, 10);
				newloc.getWorld().playEffect(newloc, Effect.SPELL, 10);
				newloc.getWorld().playSound(newloc, Sound.ANVIL_BREAK, 3, 3);
				newloc.getWorld().playSound(newloc, Sound.FIREWORK_BLAST, 3, 3);
				newloc.getWorld().playSound(newloc, Sound.FIREWORK_BLAST, 10, 10);
				newloc.getWorld().playSound(newloc, Sound.FIREWORK_LARGE_BLAST, 10, 10);
				newloc.getWorld().playEffect(newloc, Effect.LAVA_POP, 10);
				newloc.getWorld().playEffect(newloc, Effect.EXPLOSION, 10);
				ChestListener.chests.remove(newloc.getBlock().getLocation());
			}
		},100L);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				canswitchkit.remove(p);
				Data.notitle.remove(p);
			}
		}, 40);
		
	}
}
