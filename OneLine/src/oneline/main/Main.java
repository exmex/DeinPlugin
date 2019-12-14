package oneline.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import com.Sapphire.TitleAPI.TitleAPI;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import oneline.commands.CMD;
import oneline.data.Data;
import oneline.listener.JoinListener;
import oneline.listener.Protection;
import oneline.listener.Streak;
import oneline.methods.Board;
import oneline.methods.Inventory;
import oneline.methods.SpawnManager;

public class Main extends JavaPlugin implements Listener{

	public static int Drop;
	public static int KnockTime;
	public static boolean bool;
	public static int boolint;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		KnockTime = 80;
		bool = false;
		Drop = 30;
		boolint = 20;
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				boolint--;
				if(boolint == 0){
					bool = false;
					boolint = 20;
					return;
				}
				if(bool){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.playSound(all.getLocation(), Sound.ITEM_PICKUP, 10, 10);
					}
					
				}
			}
		}, 1, 1);
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					Board.setBoard(all);
				}
				KnockTime--;
				if(KnockTime == 0){
					KnockTime = 80;
					for(Player all : Bukkit.getOnlinePlayers()){
					Vector vec = new Vector(all.getLocation().getDirection().getX() * 11.2D, 11.0D, all.getLocation().getDirection().getZ() * 11.2D);
					all.setVelocity(vec);
					bool = true;	
					}
					
					
				}
				
			}
		}, 20, 20);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				Drop--;
				if(Drop == 0){
					Drop = 30;
					for(Entity ent : Bukkit.getWorld(SpawnManager.mainLocations.get("S1").getWorld().getName()).getEntities()) {
						if(ent instanceof Player) {
							
						} else {
							ent.remove();
						}
					}
					for(int i = 1 ; i < 6 ; i++){
					Location loc = SpawnManager.mainLocations.get("I" + i);
					int zahl = (int)((Math.random()) * 6 + 1);
					if(zahl == 1){
						loc.getWorld().dropItem(loc, Inventory.createItemWD(Material.BOW, 1, 0, "§6Bogen", 379));
						loc.getWorld().dropItem(loc, Inventory.createItem(Material.ARROW, 5, 0, "§5Pfeil"));
					}
					if(zahl == 2){
						loc.getWorld().dropItem(loc, Inventory.createItemWD(Material.FISHING_ROD, 1, 0, "§6Angel", 46));
					}
					if(zahl == 3){
						loc.getWorld().dropItem(loc, Inventory.createItemWD(Material.FISHING_ROD, 1, 0, "§6Enterhaken", 40));
					}
					if(zahl == 4){
						loc.getWorld().dropItem(loc, Inventory.createItemWD(Material.FLINT_AND_STEEL, 1, 0, "§6Feuerzeug", 60));
					}
					if(zahl == 5){
						loc.getWorld().dropItem(loc, Inventory.createItem(Material.ENDER_PEARL, 1, 0, "§6Enderperle"));
					}
					if(zahl == 6){
						loc.getWorld().dropItem(loc, Inventory.createItem(Material.SNOW_BALL, 4, 0, "§6Schneeball"));
					}
					loc.getWorld().playEffect(loc, Effect.FLAME, 10);
					loc.getWorld().playEffect(loc, Effect.WATERDRIP, 10);
					loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 10);
					loc.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 10);
					
					}
					for(Player all : Bukkit.getOnlinePlayers()){
						all.playSound(all.getLocation(), Sound.FIREWORK_TWINKLE2, 10, 10);
					}
				}
			}
		}, 20, 20);
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					if(all.getLocation().getY() < 0){
						try{
						all.damage(20);
					}catch(Exception e1){}
					}
				}
			}
		}, 5, 5);
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cDas Plugin startet aktuell...");
		getCommand("setspawn").setExecutor(new CMD());
		getCommand("start").setExecutor(new CMD());

		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new Protection(this), this);
		Bukkit.getPluginManager().registerEvents(new Streak(), this);
		Bukkit.getPluginManager().registerEvents(this, this);

		try{
			SpawnManager.mainLocations.put("S1", SpawnManager.loadLocationFromConfig("S1"));
			SpawnManager.mainLocations.put("S2", SpawnManager.loadLocationFromConfig("S2"));
			SpawnManager.mainLocations.put("S3", SpawnManager.loadLocationFromConfig("S3"));
			SpawnManager.mainLocations.put("S4", SpawnManager.loadLocationFromConfig("S4"));
			SpawnManager.mainLocations.put("S5", SpawnManager.loadLocationFromConfig("S5"));
			SpawnManager.mainLocations.put("S6", SpawnManager.loadLocationFromConfig("S6"));
			SpawnManager.mainLocations.put("I1", SpawnManager.loadLocationFromConfig("I1"));
			SpawnManager.mainLocations.put("I2", SpawnManager.loadLocationFromConfig("I2"));
			SpawnManager.mainLocations.put("I3", SpawnManager.loadLocationFromConfig("I3"));
			SpawnManager.mainLocations.put("I4", SpawnManager.loadLocationFromConfig("I4"));
			SpawnManager.mainLocations.put("I5", SpawnManager.loadLocationFromConfig("I5"));
			SpawnManager.mainLocations.put("I6", SpawnManager.loadLocationFromConfig("I6"));
			SpawnManager.mainLocations.put("I7", SpawnManager.loadLocationFromConfig("I7"));


		}catch(Exception e1){
			Bukkit.getConsoleSender().sendMessage("§c§lFEHLER BEIM LADEN DER LOCATIONS!");
		}
	}
	public static void sendActionbar(Player p, String message) {
        	IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" +
            ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        	PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        	((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		p.setHealth(20);		
		Player k = e.getEntity().getKiller();
		e.getDrops().clear();
		e.setDeathMessage(null);
		if(k == null){
		Main.sendActionbar(p, "§c§l◆ §4Gestorben §7» §4Unbekannt... §c§l◆");
		}else{
		Main.sendActionbar(p, "§c§l◆ §4Gestorben §7» §4" + k.getName() + " §c§l◆");
		Main.sendActionbar(k, "§a§l◆ §eGetötet §7» §6" + p.getName() + " §a§l◆");
		TitleAPI.getTitle().sendTitle(k, "§8➤§e " + p.getName(), 3, 8, 3);
		k.playSound(k.getLocation(), Sound.LEVEL_UP, 10, 10);
		k.playSound(k.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);	
		}
		Bukkit.getScheduler().scheduleAsyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				JoinListener.i++;
				if(JoinListener.i == 6){
					JoinListener.i = 1;
				}
				p.teleport(SpawnManager.mainLocations.get("S" + JoinListener.i));
				Inventory.getNormalInventory(p);
				p.updateInventory();
				return;
			}
		},1L);
		p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST2, 10, 10);			
	}

}
