package de.anweisung.classes;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.server.v1_8_R3.PistonExtendsChecker;

public class Boots implements Listener{
	public static ArrayList<Player>list = new ArrayList<Player>();

	

	@EventHandler
	public void onP(PlayerPickupItemEvent e){
		if(e.getItem().getItemStack().getType() == Material.COOKIE || e.getItem().getItemStack().getType() == Material.GOLD_INGOT || e.getItem().getItemStack().getType() == Material.IRON_INGOT || e.getItem().getItemStack().getType() == Material.PRISMARINE_SHARD || e.getItem().getItemStack().getType() == Material.EMERALD || e.getItem().getItemStack().getType() == Material.DIAMOND){
			e.setCancelled(true);
		}
	}
	public static void addKekse(Player p){
		list.add(p);
		ItemStack i = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta im = (LeatherArmorMeta) i.getItemMeta();
		im.setColor(Color.PURPLE);
		i.setItemMeta(im);
		
		p.getInventory().setBoots(i);
	}
	public static void removeKekse(Player p){
		list.remove(p);
		p.getInventory().setBoots(null);
	}
	}


