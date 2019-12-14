package lobby.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;

import de.golgolex.coinsapi.main.CoinsAPI;
import lobby.data.Data;
import lobby.main.Main;
import lobby.methods.Inventory;
import lobby.methods.Scoreboard;
import lobby.methods.Sounds;
import lobby.shop.Villager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerLogin implements Listener{
	public PlayerLogin(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(CoinsAPI.getCoins(p) == null) {
			CoinsAPI.setCoins(p, 0);
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
		Villager.daten.put(p, "");
		p.teleport(Data.spawn);
		e.setJoinMessage(null);
		p.sendTitle("§e» §aWillkommen", "§6" + p.getName());
		p.setFoodLevel(20);
		p.setHealth(1);
		p.setGameMode(GameMode.ADVENTURE);
		
				p.getInventory().clear();
				Inventory.getJoinInventory(p);		
				Main.allowactionbar.add(p);
				
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				Sounds.playSound(p);
				Vector vec = new Vector(p.getLocation().getDirection().getX() * 1.2D, 1.0D, p.getLocation().getDirection().getZ() * 1.2D);
				p.setVelocity(vec);
				p.setHealth(20);
				p.setFoodLevel(20);
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 10, 10);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 10, 10);
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 10, 10);

			}
		}, 10L);
       
	}
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        String Message = e.getMessage().replaceAll("%", "Prozent");
	        Message.replaceAll("%", "Prozent");
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra") || p.hasPermission("ClayMC.Legend")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)Message));
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
		    }
		        else if(PermissionsEx.getUser(p).inGroup("Script")){
		        	e.setCancelled(false);
		        	e.setFormat("§3Script §8• §3" + p.getName() + "§8 » §6" + Message);

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
	        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
	        	e.setCancelled(false);
	        	e.setFormat("§eBuilder §8• §e" + p.getName() + "§8 » §f" + Message);
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
	        	e.setFormat("§aUltra §8• §a" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + Message);
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + Message);
	        }else{
	        	e.setCancelled(true);
	        	p.sendMessage(Data.Prefix + "§cDu benötigst mindestens den §6Gold §cRang, um in der Lobby schreiben zu können.");
	        }
	      
	    }
	 public void sendTitle(Player p, String Nachricht){
			IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
			PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
			PacketPlayOutTitle length = new PacketPlayOutTitle(6, 40, 6);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
		}
	 public static String getTime(){
			String now = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
			return now;
		}
}
