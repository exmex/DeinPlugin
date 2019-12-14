package de.anweisung.classes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;



public class Main extends JavaPlugin implements Listener{
	public ArrayList<Player>list = new ArrayList<Player>();
	public static String Gold = "§cDu benötigst mindestens den §6Gold §cRang, um diese Funktion nutzen zu können!";
	public static String Hero = "§cDu benötigst mindestens den §3Hero §cRang, um diese Funktion nutzen zu können!";
	public static String Ultra = "§cDu benötigst mindestens den §bUltra §cRang, um diese Funktion nutzen zu können!";
	public static String Legend = "§cDu benötigst mindestens den §5Legend §cRang, um diese Funktion nutzen zu können!";
	public static String Prefix = "§8[§cLobby§8] ";

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Boots(), this);
		Bukkit.getPluginManager().registerEvents(new Interact(), this);
		Bukkit.getPluginManager().registerEvents( this, this);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				if(Bukkit.getOnlinePlayers().size() > 27){
					for(Player all : Bukkit.getOnlinePlayers()){
						if(all.hasPermission("claymc.gold")){
					sendActionBar(all, "§c§lEs sind zu viele Spieler auf der §6Lobby§c§l, um die §5Schuhe §c§lzu aktivieren!");
					}
					}
				}
				for(Entity ent : Bukkit.getWorld(Bukkit.getWorld("world").getName()).getEntities()) {
					if(ent instanceof Player) {
						
					} else {
						ent.remove();
					}
				}
				
			}
		}, 20, 100);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			ItemStack i = new ItemStack(Material.COOKIE);
			ItemStack i2 = new ItemStack(Material.GOLD_INGOT);
			ItemStack i3 = new ItemStack(Material.IRON_INGOT);
			ItemStack i4 = new ItemStack(Material.PRISMARINE_SHARD);
			ItemStack i5 = new ItemStack(Material.EMERALD);
			ItemStack i6 = new ItemStack(Material.DIAMOND);

			@Override
			public void run() {
				if(Bukkit.getOnlinePlayers().size() < 27){
				for(Player all : Bukkit.getOnlinePlayers()){
					if(Utils.cookie.contains(all)){
				all.getWorld().dropItem(all.getLocation(), i);
			}
					if(Utils.gold.contains(all)){
						all.getWorld().dropItem(all.getLocation(), i2);
					}
					if(Utils.iron.contains(all)){
						all.getWorld().dropItem(all.getLocation(), i3);
					}
					if(Utils.scherben.contains(all)){
						all.getWorld().dropItem(all.getLocation(), i4);
					}
					if(Utils.smaragt.contains(all)){
						all.getWorld().dropItem(all.getLocation(), i5);
					}
					if(Utils.diamant.contains(all)){
						all.getWorld().dropItem(all.getLocation(), i6);
					}
			}
				}
			}
		}, 20, 2);
			
	}
	public static void sendActionBar(Player p, String message) {
		 
        PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
 
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(icbc, (byte)2);
 
        connection.sendPacket(packet);
    }
}

