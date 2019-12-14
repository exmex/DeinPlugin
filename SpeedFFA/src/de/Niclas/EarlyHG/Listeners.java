package de.Niclas.EarlyHG;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Listeners implements Listener {
	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		final Player p = e.getPlayer();
		p.setWalkSpeed(0.2F);
		p.setFoodLevel(20);
		for(int i = 0; i < 100 ; i++) {
			p.sendMessage(" ");
			
		}
		p.sendMessage("§b§l§m------------------------------");
		p.sendMessage(" ");
		p.sendMessage(Data.prefix + "§7Willkommen, §e" + p.getName());
		p.sendMessage(Data.prefix + "§3Nach jedem Kill erhältst du mehr Geschwindigkeit!");
		p.sendMessage(" ");
		p.sendMessage("§b§l§m------------------------------");
		for(Player all : Bukkit.getOnlinePlayers()) {
			Scoreboard.setScoreboard(all);
		}
		new BukkitRunnable() {
			
			@Override
			public void run() {

				p.teleport(Data.getLocation("spawn"));
				
			}
		}.runTaskLater(EarlyHG.Main, 10L);
		
		p.getInventory().clear();
		JoinKit.getItems(p);
	}
	
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)){
				if(p.getHealth() == p.getMaxHealth()) return;
				p.setHealth(p.getHealth() + 7 > p.getMaxHealth() ? p.getMaxHealth() : p.getHealth() + 7);
				p.getItemInHand().setType(Material.BOWL);
			return;
			}
		}
	}
	
	@EventHandler
	public void on(final PlayerDeathEvent e) {
		e.setDeathMessage(null);
		e.getDrops().clear();
		if(e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			addDeaths(p.getUniqueId());
			if(p.getKiller() instanceof Player) {
				addKill(p.getKiller().getUniqueId());
				Bukkit.broadcastMessage(Data.prefix + "§3" + p.getName() + "§7 wurde von §3" + p.getKiller().getName() + "§7 getötet!");
				Scoreboard.setScoreboard(p);
				Scoreboard.setScoreboard(p.getKiller());
				CoinsAPI.addCoins(p.getKiller().getName(), 2);
				p.getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10, 5));
				p.setWalkSpeed(0.2F);
				float i = p.getKiller().getWalkSpeed();
				float newi = (float) (i + 0.1);
				if(i < 1.0){
					p.getKiller().setWalkSpeed(newi);
					p.getKiller().sendMessage(Data.prefix + "§bDein Speed wurde aktualisiert! §8[§b" + i + "§8]");
				}else{
					p.getKiller().setWalkSpeed(0.9F);
					p.getKiller().sendMessage(Data.prefix + "§bDein Speed ist bereits das höchste!");

				}
			} else {
				Bukkit.broadcastMessage(Data.prefix + "§3" + p.getName() + "§7 ist gestorben!");
				Scoreboard.setScoreboard(p);
			}
		}
	}
	
	
	@EventHandler
   public void on(PlayerRespawnEvent e) {
		e.setRespawnLocation(Data.getLocation("spawn"));
		JoinKit.getItems(e.getPlayer());
	}
	
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().equalsIgnoreCase("/setspawn")) {
			e.setCancelled(true);
			if(e.getPlayer().hasPermission("Setspawn.spawn")) {
			Data.setLocation("spawn", e.getPlayer().getLocation());
			e.getPlayer().sendMessage("§cSpawn gesetzt!");
			}
		}
		if(e.getMessage().equalsIgnoreCase("/stats")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Data.prefix + "§7Deine Kills: §c" + getKills(e.getPlayer().getUniqueId()));
			e.getPlayer().sendMessage(Data.prefix + "§7Deine Tode: §c" + getDeaths(e.getPlayer().getUniqueId()));

		}
	}
	
	@EventHandler
	  public void on(AsyncPlayerChatEvent e)
	  {
	    Player p = e.getPlayer();
	    String rank = "§7";
	    if ((p.hasPermission("ClayMC.Hero")) || (p.hasPermission("ClayMC.Ultra"))) {
	      e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
	  }
	    if (PermissionsEx.getUser((Player)p).inGroup("Owner")) {
          e.setFormat("\u00a74Owner \u00a78\u25cf \u00a74" + p.getName() + " \u00a78\u00bb \u00a76" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Admin")) {
          e.setFormat("\u00a7cAdmin \u00a78\u25cf \u00a7c" + p.getName() + " \u00a78\u00bb \u00a76" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Moderator")) {
          e.setFormat("\u00a7cModerator \u00a78\u25cf \u00a7c" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Supporter")) {
          e.setFormat("\u00a79Supporter \u00a78\u25cf \u00a79" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("YouTuber+")) {
          e.setFormat("\u00a75YouTuber+ \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("YouTuber")) {
          e.setFormat("\u00a75YouTuber \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("JrYouTuber")) {
          e.setFormat("\u00a75JrYouTuber \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Ultra")) {
          e.setFormat("\u00a7bUltra \u00a78\u25cf \u00a7b" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Hero")) {
          e.setFormat("\u00a73Hero \u00a78\u25cf \u00a73" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else if (PermissionsEx.getUser((Player)p).inGroup("Gold")) {
          e.setFormat("\u00a76Gold \u00a78\u25cf \u00a76" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      } else {
          e.setFormat("\u00a7a" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
      
      }
	  }
	    
	
	@EventHandler
	public void on(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("suppen")) {
			e.setLine(0, "§7=> §cEarlyHG§7 <=");
			e.setLine(1, "§cSuppen-Refill");
			e.setLine(2, ChatColor.ITALIC + "<Klick>");
			e.setLine(3, "§7=> §cEarlyHG §7<=");
		}
	}
	
	@EventHandler
	public void on(BlockBreakEvent e) {
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(BlockPlaceEvent e) {
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
	
	
	@EventHandler
	public void on(FoodLevelChangeEvent e) {
			e.setCancelled(true);
	}
	
	
	@EventHandler
	public void on(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	

	
    public static void sendActionBar(final Player player, String Nachricht)
    {
           final String NachrichtNeu = Nachricht.replace("_", " ");
      String s = ChatColor.translateAlternateColorCodes('&', NachrichtNeu);
      IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s +
        "\"}");
      PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
      
    }
    
    @EventHandler
    public void onSign(PlayerInteractEvent e) {
    	if(e.getClickedBlock().getType() == Material.WALL_SIGN) {
    		Sign s = (Sign)e.getClickedBlock().getState();
    		if(s.getLine(1).equals("§cSuppen-Refill")) {
    			Inventory GUI = Bukkit.createInventory(e.getPlayer(), 27, "§cSuppen");
    			for (int x = 0; x <= 26; x++) {
    				 ItemStack i = new ItemStack(Material.MUSHROOM_SOUP);
 
    				 GUI.setItem(x, i);
    				}
    			e.getPlayer().openInventory(GUI);
    		}
    	}
    }
    
    public static File f = new File("plugins/SkyPvP","stats.yml");
	public static FileConfiguration config = YamlConfiguration.loadConfiguration(f);
	
	  public static void CheckOrdner(){
	        File file=new File("plugins/SkyPvP");
	        if(file.isDirectory()==false)file.mkdirs();
	  }
	
	public static void setDefaults(String path, String message) {
		config.set(path , message);
		try {
			config.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addKill(UUID uuid) {
		int kills = 0;
		if(config.get(uuid + ".kills") == null) {
			config.set(uuid + ".kills", 0);
			try {
				config.save(f);
			} catch (Exception e1) {
				System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
			}
		}
	    kills = config.getInt(uuid + ".kills");
		kills++;
		config.set(uuid + ".kills", kills);
		try {
			config.save(f);
		} catch (Exception e1) {
			System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
		}
	}

	public static int getKills(UUID uuid) {
		int kills = 0;
		if(config.get(uuid + ".kills") == null) {
			config.set(uuid + ".kills", 0);
			try {
				config.save(f);
			} catch (Exception e1) {
				System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
			}
		}
		kills = config.getInt(uuid + ".kills");
		return kills;
	}
	
	public static int getDeaths(UUID uuid) {
		int kills = 0;
		if(config.get(uuid + ".deaths") == null) {
			config.set(uuid + ".deaths", 0);
			try {
				config.save(f);
			} catch (Exception e1) {
				System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
			}
		}
		kills = config.getInt(uuid + ".deaths");
		return kills;
	}
	
	public static void addDeaths(UUID uuid) {
		int kills = 0;
		if(config.get(uuid + ".deaths") == null) {
			config.set(uuid + ".deaths", 0);
		}
	    kills = config.getInt(uuid + ".deaths");
		kills++;
		config.set(uuid + ".deaths", kills);
		try {
			config.save(f);
		} catch (Exception e1) {
			System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
		}
	}

	public static int getCoins(UUID uuid) {
		int kills = 0;
		if(config.get(uuid + ".coins") == null) {
			config.set(uuid + ".coins", 0);
			try {
				config.save(f);
			} catch (Exception e1) {
				System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
			}
		}
		kills = config.getInt(uuid + ".coins");
		return kills;
	}
	
	public static void addCoins(UUID uuid, int anzahl) {
		int kills = 0;
		if(config.get(uuid + ".coins") == null) {
			config.set(uuid + ".coins", 0);
		}
	    kills = config.getInt(uuid + ".coins");
		;
		config.set(uuid + ".coins", kills + anzahl);
		try {
			config.save(f);
		} catch (Exception e1) {
			System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
		}
	}

	public static void removeCoins(UUID uuid, int anzahl) {
		int kills = 0;
		if(config.get(uuid + ".coins") == null) {
			config.set(uuid + ".coins", 0);
		}
	    kills = config.getInt(uuid + ".coins");
		;
		config.set(uuid + ".coins", kills - anzahl);
		try {
			config.save(f);
		} catch (Exception e1) {
			System.out.print("§4Konnte die Stats eines Spielers nicht updaten.");
		}
	}

}
