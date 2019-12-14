package de.community.specials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;

import de.community.utils.Data;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class Bühne implements Listener{
	
	@EventHandler
	public void onRegionEnter(RegionEnterEvent e){
		if(e.getRegion().getId().equalsIgnoreCase("Eingang1") || e.getRegion().getId().equalsIgnoreCase("Eingang2")){
			Player p = e.getPlayer();
			if(!p.hasPermission("claymc.legend")){
				p.sendMessage(Data.Prefix + "§cDu benötigst mindestens den §5Legend §cRang, um auf die Bühne zu kommen!");
				double x = Data.cfg.getDouble("Buehne.X");
				double y = Data.cfg.getDouble("Buehne.Y");
				double z = Data.cfg.getDouble("Buehne.Z");
				double pitch = Data.cfg.getDouble("Buehne.Pitch");
				double yaw = Data.cfg.getDouble("Buehne.Yaw");
				String weltname = Data.cfg.getString("Buehne.WeltName");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				p.teleport(loc);
				p.sendMessage(Data.Prefix + "§7Du wurdest zur §eBühne§7 teleportiert!");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	

			}else{
				sendTitle(p, "§5YouTuber - Bühne");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	
			}
		}
	}
	public void sendTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(10, 20, 10);


		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
}
