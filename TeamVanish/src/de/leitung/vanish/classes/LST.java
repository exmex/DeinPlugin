package de.leitung.vanish.classes;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class LST implements Listener{

	@EventHandler
	public void onJ(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("claymc.team")){
			IChatBaseComponent comp = ChatSerializer
		            .a("{\"text\":\"" + 
		            "\",\"extra\":[{\"text\":\"" + "§6§lKLICKE UM VANISH ZU WERDEN!" + 
		            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
		            "/v" + "\"}}]}");    
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		
		}
		p.setWalkSpeed(0.2F);
	}
}
