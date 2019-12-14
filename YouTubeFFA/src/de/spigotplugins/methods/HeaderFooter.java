package de.spigotplugins.methods;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;


import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class HeaderFooter {
	public static void sendTablistHeaderAndFooter(Player player, String header, String footer) {
		if(header == null) header = "";
		if(footer == null) footer = "";
		
		IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");	
		IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");
		
		PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
		try {
			Field field = headerPacket.getClass().getDeclaredField("b");
			field.setAccessible(true);
			field.set(headerPacket, tabFooter);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			((CraftPlayer)player).getHandle().playerConnection.sendPacket(headerPacket);
		}
	}
}
