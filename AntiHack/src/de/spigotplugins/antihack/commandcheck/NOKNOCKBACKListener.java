package de.spigotplugins.antihack.commandcheck;

import java.util.ArrayList;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class NOKNOCKBACKListener implements Listener{
	public static ArrayList<Player> list = new ArrayList<Player>();
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(list.contains(p)){
			if(e.getFrom().getY()<e.getTo().getY()){
				if(!((CraftPlayer) e.getPlayer()).getHandle().onGround) e.setCancelled(true);
				}
		}
	}
}
