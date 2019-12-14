package lobby.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import lobby.data.Data;
import lobby.main.Main;
import lobby.methods.Inventory;
import lobby.methods.Scoreboard;
import lobby.methods.Sounds;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerLogin implements Listener{
	public PlayerLogin(lobby.main.Main Main){
		this.pl = Main;
	}
	
	static ArrayList<Player> list = new ArrayList<>();
	private lobby.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		list.add(p);
		p.sendMessage(Data.Prefix + "§eDu befindest sich nun auf der §6Silenthub §eund bist zugleich ungestört!");
		Scoreboard.setScoreboard(p);
		for(Player all : Bukkit.getOnlinePlayers()){
			p.hidePlayer(all);
		}
		for(Player all : Bukkit.getOnlinePlayers()){
			if(list.contains(all)){
				all.hidePlayer(p);
			}
		}
		p.teleport(Data.spawn);
		e.setJoinMessage(null);
		p.sendTitle("§e» §bClayMC", "");
		p.setFoodLevel(20);
		p.setHealth(1);

		p.setGameMode(GameMode.ADVENTURE);
		Inventory.getJoinInventory(p);
		Main.sendActionbar(p, "§c» §4Spielerdaten werden abgerufen...");
		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
			
			@Override
			public void run() {
				Sounds.playSound(p);
				sendTitle(p, "§7[§a+§7] §c§lSilentHub");
				p.setHealth(20);
				p.setFoodLevel(20);
			}
		}, 20L);
	}
	 @EventHandler
	    public void on(PlayerChatEvent e) {
	        e.setCancelled(true);
	        e.getPlayer().sendMessage(Data.Prefix + "§cIn der SilentHub herrscht Ruhe!");
	        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
	    }
	 public void sendTitle(Player p, String Nachricht){
			IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
			PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
			PacketPlayOutTitle length = new PacketPlayOutTitle(6, 40, 6);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
		}
}
