package knockpvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import NickSystem.Manager.AutoNickManager;
import NickSystem.Manager.NickManager;
import knockpvp.main.GameState;
import knockpvp.main.Main;
import knockpvp.utils.Data;
import knockpvp.utils.Scoreboard;
import knockpvp.utils.Stats;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MainListener implements Listener{
	public MainListener(knockpvp.main.Main Main){
		this.pl = Main;
	}
	private knockpvp.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e){
		for(Player all : Bukkit.getOnlinePlayers()){
			e.getPlayer().showPlayer(all);
		}
		if(NickManager.isNicked(e.getPlayer())){
			AutoNickManager.setNick(e.getPlayer());
		}
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					e.getPlayer().showPlayer(all);
				}				
			}
		}, 20L);
		Player p = e.getPlayer();
		p.setLevel(0);
		p.setHealth(20);
		p.setFoodLevel(20);
		Data.roundkills.put(p.getUniqueId().toString(), 0);
		p.getInventory().clear();
		p.getInventory().setHelmet(Main.helm);
		p.getInventory().setChestplate(Main.chest);
		p.getInventory().setLeggings(Main.hose);
		p.getInventory().setBoots(Main.boots);
		p.getInventory().setItem(0, Main.first);
		p.getInventory().setItem(1, Main.second);
		p.getInventory().setItem(2, Main.third);
		p.getInventory().setItem(3, Main.fourth);
		p.getInventory().setItem(4, Main.fiveth);
		p.getInventory().setItem(5, Main.sixth);
		p.getInventory().setItem(6, Main.seventh);
		p.getInventory().setItem(7, Main.eighth);
		p.getInventory().setItem(8, Main.ninth);
		Stats.loadStatsFormConfigIntoHashMap(p);
		if(Main.gs == GameState.FREE){
			Main.gs = GameState.INGAME;
			ActionBarAPI.sendActionBarToAllPlayers("§cDer Server wird vorbereitet...");
		}
		if(Bukkit.getOnlinePlayers().size() < 8){
		e.setJoinMessage(Data.Prefix + "§eDer Spieler §6" + p.getDisplayName() + "§e spielt nun mit!");
		}else{
			e.setJoinMessage(null);
		}
		Main.teleportToSpawn(Main.MapName, p);

		if(p.hasPlayedBefore()){
		}else{
			Main.teleportToSpawn(Main.MapName, p);
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		Stats.addDeath(p);
		Scoreboard.setScoreboard(p);
		if(k != null){
			if(k == p){
				Location loc = p.getLocation();
				loc.setY(100);
				p.teleport(loc);
				final Player player = e.getEntity();
				e.setDeathMessage(null);
				e.setKeepInventory(true);
				p.setHealth(20);
				p.setFoodLevel(20);
				Location loca = p.getLocation();
				loc.setY(100);
				p.teleport(loca);
				Main.teleportToSpawn(Main.MapName, player);
				p.getInventory().clear();
				p.getInventory().setHelmet(Main.helm);
				p.getInventory().setChestplate(Main.chest);
				p.getInventory().setLeggings(Main.hose);
				p.getInventory().setBoots(Main.boots);
				p.getInventory().setItem(0, Main.first);
				p.getInventory().setItem(1, Main.second);
				p.getInventory().setItem(2, Main.third);
				p.getInventory().setItem(3, Main.fourth);
				p.getInventory().setItem(4, Main.fiveth);
				p.getInventory().setItem(5, Main.sixth);
				p.getInventory().setItem(6, Main.seventh);
				p.getInventory().setItem(7, Main.eighth);
				p.getInventory().setItem(8, Main.ninth);
				p.setHealth(20);
				for(Player all : Bukkit.getOnlinePlayers()){
				all.showPlayer(p);	
				}
				return;
			}
			if(Shop.deathregeneration.contains(k)){
				k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 2));
			}
			k.playSound(k.getLocation(), Sound.LEVEL_UP, 9, 5);
			Data.roundkills.put(p.getUniqueId().toString(), Data.roundkills.get(p.getUniqueId().toString()) +1); 
			int zahl = (int)((Math.random()) * 10 + 1);
			Stats.coins.put(k.getUniqueId().toString(), Stats.coins.get(k.getUniqueId().toString()) +zahl);
			Stats.addKill(k);			
			Scoreboard.setScoreboard(k);
			k.setLevel(k.getLevel() +1);
			sendTitle(k, "§6" + zahl + "§7 » §eCoins");
		}
		Location loc = p.getLocation();
		loc.setY(100);
		p.teleport(loc);
		final Player player = e.getEntity();
		e.setDeathMessage(null);
		e.setKeepInventory(true);
		p.setHealth(20);
		p.setFoodLevel(20);
		Location loca = p.getLocation();
		loc.setY(100);
		p.teleport(loca);
		Main.teleportToSpawn(Main.MapName, player);
		p.getInventory().clear();
		p.getInventory().setHelmet(Main.helm);
		p.getInventory().setChestplate(Main.chest);
		p.getInventory().setLeggings(Main.hose);
		p.getInventory().setBoots(Main.boots);
		p.getInventory().setItem(0, Main.first);
		p.getInventory().setItem(1, Main.second);
		p.getInventory().setItem(2, Main.third);
		p.getInventory().setItem(3, Main.fourth);
		p.getInventory().setItem(4, Main.fiveth);
		p.getInventory().setItem(5, Main.sixth);
		p.getInventory().setItem(6, Main.seventh);
		p.getInventory().setItem(7, Main.eighth);
		p.getInventory().setItem(8, Main.ninth);
		p.setHealth(20);
		for(Player all : Bukkit.getOnlinePlayers()){
		all.showPlayer(p);	
		}
	}
	@EventHandler
	public void on(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onQu(PlayerQuitEvent e){
		e.setQuitMessage(null);
		AutoNickManager.addNickToRandomList(e.getPlayer());
		Player p = e.getPlayer();
		Stats.loadStatsFromHashMapIntoConfig(p);
		if(Bukkit.getOnlinePlayers().size() == 1){
			Main.gs = GameState.FREE;
		}
	}
	@EventHandler
	public void onIte(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onEd(EntityDamageEvent e){
		if(e.getCause().equals(DamageCause.FALL)){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onmove(PlayerMoveEvent e){
		
		if(e.getPlayer().getLocation().getY() < 0){
            e.getPlayer().damage(20.0);
            
		}
	}
	@EventHandler
	public void onPlayerPush(PlayerMoveEvent event) {

		if (event.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE)
	    {
		  Player p = event.getPlayer();
		  org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(2.0D).setY(1.3D);
	      p.setVelocity(v);
	      p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 3);
	      p.playSound(p.getLocation(), Sound.FIZZ, 3.0F, 2.0F);
		
}
	
	}
	
	@EventHandler
	public void on(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE && p.hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void on111(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE && p.hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onaaaa(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/stop") || e.getMessage().equalsIgnoreCase("/rl") || e.getMessage().equalsIgnoreCase("/reload")){
			if(e.getPlayer().hasPermission("claymc.admin")){
				e.setCancelled(true);
				for(Player all : Bukkit.getOnlinePlayers()){
					all.kickPlayer("§cDer Server restartet gerade...");
				}
				Bukkit.reload();
			}
		}
	}
	@EventHandler
	public void onaaff(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        String Message = e.getMessage().replace("%", " Prozent");
	        Message.replace("%", " Prozent");
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)Message));
	        }
	        if(NickManager.isNicked(p)){
	        	e.setFormat("§7" + e.getPlayer().getName() + "§8 » §f" + Message);
	        	return;
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§4Owner §8• §4" + p.getName() + "§8 » §6" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§cAdmin §8• §c" + p.getName() + "§8 » §6" + Message);
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§cSrModerator §8• §c" + p.getName() + "§8 » §6" + Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§bDeveloper §8• §b" + p.getName() + "§8 » §b" + Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + Message);
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§cModerator §8• §c" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5YouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§bUltra §8• §b" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + Message);
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + Message);
	    }else{
	    	e.setCancelled(false);
	    	e.setFormat("§7" + e.getPlayer().getName() + "§8 » §f" + Message);
	    }
	 }
	public void sendTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(1, 11, 1);


		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
	
}
