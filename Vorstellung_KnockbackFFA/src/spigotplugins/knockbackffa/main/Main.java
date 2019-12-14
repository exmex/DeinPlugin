package spigotplugins.knockbackffa.main;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import spigotplugins.knockbackffa.listener.CMD;
import spigotplugins.knockbackffa.listener.Damager;
import spigotplugins.knockbackffa.listener.Death;
import spigotplugins.knockbackffa.listener.JoinListener;
import spigotplugins.knockbackffa.listener.KillStreak;
import spigotplugins.knockbackffa.listener.PlayerChat;
import spigotplugins.knockbackffa.listener.Protection;
import spigotplugins.knockbackffa.manager.SpawnManager;

public class Main extends JavaPlugin{
	
	public static String MapName;
	public static int SpawnY;
	public static int KillY;
	public static String KitName;
	public static int KitChange;
	public static int MapChange;
	public static boolean enterHaken;
	public static boolean changeKit;
	public static boolean changeMap;
	public static int i;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		enterHaken = false;
		changeKit = false;
		changeMap = false;
		KitChange = 160;
		MapChange = 400;
		i = -1;
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			//●
			@Override
			public void run() {
				i++;
				for(Player all : Bukkit.getOnlinePlayers()){
					if(i == 0){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §8● ● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 1){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §c● §8● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 2){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §c● ● §8● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 3){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §c● ● ● §8● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 4){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §c● ● ● ● §8● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 5){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §c● ● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 6){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §5● §c● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 7){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §5● ● §c● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 8){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §5● ● ● §c● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 9){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §5● ● ● ● §c● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 10){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §5● ● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 11){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §f● §5● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 12){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §f● ● §5● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 13){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §f● ● ● §5● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 14){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §f● ● ● ● §5● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 15){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §f● ● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 16){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §8● §f● ● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 17){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §8● ● §f● ● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 18){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §8● ● ● §f● ● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
					}
					if(i == 19){
						Main.sendActionbar(all, "§e§lKills §8»§7 " + StatsManager.Kills.get(all.getName()) + " §8● ● ● ● §f● §4§lTode §8»§7 " + StatsManager.Deaths.get(all.getName()) + "");
						i = -1;
					}
			}
			}
		}, 15, 15);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				KitChange--;
				MapChange--;
				if(KitChange == 0){
					KitChange = 200;
					enterHaken = false;
					changeKit = false;
					for(Player all : Bukkit.getOnlinePlayers()){
						pickRandomKit();
						setRandomKit(all);
						all.sendTitle("§eKitChange", "§6" + KitName);
						all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
					}
				}
				if(MapChange == 0){
					MapChange = 400;
					pickRandomMap();
					changeMap = false;
					
				}
				
				for(Player all : Bukkit.getOnlinePlayers()){
					Board.setBoard(all);
				}
			}
		}, 20, 20);
		SpawnManager.Maps = (ArrayList<String>) SpawnManager.cfg.getStringList("Maps");
		for(int i = 0 ; i < SpawnManager.cfg.getStringList("Maps").size() ; i++){
			System.out.println(SpawnManager.Maps.get(i));
			SpawnManager.location.put(SpawnManager.Maps.get(i), SpawnManager.loadSpawn(SpawnManager.Maps.get(i)));
		}
		Bukkit.getScheduler().scheduleAsyncDelayedTask(this, new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < SpawnManager.cfg.getStringList("Maps").size() ; i++){
					System.out.println(SpawnManager.Maps.get(i));
					SpawnManager.location.put(SpawnManager.Maps.get(i), SpawnManager.loadSpawn(SpawnManager.Maps.get(i)));
				}				
			}
		}, 3L);
		Bukkit.getConsoleSender().sendMessage("§f§l###################################");
		Bukkit.getConsoleSender().sendMessage("§a§lKNOCKBACKFFA BY WELOVESPIGOTPLUGINS");
		Bukkit.getConsoleSender().sendMessage("§f§l###################################");
		getCommand("setspawn").setExecutor(new SpawnManager());
		getCommand("changemap").setExecutor(new CMD(this));
		getCommand("changekit").setExecutor(new CMD(this));
		getCommand("stats").setExecutor(new CMD(this));

		Bukkit.getPluginManager().registerEvents(new Damager(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);

		Bukkit.getPluginManager().registerEvents(new Death(this), this);
		Bukkit.getPluginManager().registerEvents(new KillStreak(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new StatsManager(this), this);

		try{
		pickRandomMap();
		pickRandomKit();
		}catch(Exception e1){
			Bukkit.getConsoleSender().sendMessage("§4§lDu musst mindestens eine Map eingerichtet haben, damit das Plugin vernünftig starten kann...");
		}
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					if(all.getLocation().getY() < KillY){
						all.getPlayer().damage(20);
					}
				}
				
			}
		}, 5, 5);
	for(Player all : Bukkit.getOnlinePlayers()){
		Main.setRandomKit(all);
	}
	}
	@Override
	public void onDisable() {
	for(Player all : Bukkit.getOnlinePlayers()){
		StatsManager.cfg.set(all.getUniqueId() + ".Kills", StatsManager.Kills.get(all.getName()));
		StatsManager.cfg.set(all.getUniqueId() + ".Deaths", StatsManager.Deaths.get(all.getName()));
		try {
			StatsManager.cfg.save(StatsManager.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		all.kickPlayer("§cDer Server startet gerade neu...");
	}
	}
	@SuppressWarnings("deprecation")
	public void pickRandomMap(){
		
		Bukkit.getScheduler().scheduleAsyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				ArrayList<String> internList = new ArrayList<>();
				internList = (ArrayList<String>) SpawnManager.cfg.getStringList("Maps");
				int a = (int)((Math.random()) * internList.size());
				if(internList.isEmpty()){
					Bukkit.getConsoleSender().sendMessage("§4§lDu musst mindestens eine Map eingerichtet haben, damit das Plugin vernünftig starten kann...");
					return;
				}
				MapName = internList.get(a);
				SpawnY = SpawnManager.cfg.getInt(internList.get(a) + ".SafeZone");
				KillY = SpawnManager.cfg.getInt(internList.get(a) + ".KillZone");
				
			
			}
		},1L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
					all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
					all.teleport(SpawnManager.loadSpawn(MapName));
					all.sendTitle("§6Mapwechsel", "§e" + MapName);
				}
			}
		},2L);
	}
	public static void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" +
                ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
	public void pickRandomKit(){
		int a = (int)((Math.random()) * 6 +1);
		
		if(a == 1){
			KitName = "Standart";
			
		}
		if(a == 2){
			KitName = "Bogenschütze";
		}
		if(a == 3){
			KitName = "RodPvP";
			
		}
		if(a == 4){
			KitName = "Schneemann";
			
		}
		if(a == 5){
			KitName = "Knockback-3";
			
		}
		if(a == 6){
			enterHaken = true;
			KitName = "Enterhaken";
			
		}
	}
	public static void setRandomKit(Player p){
		p.getInventory().clear();
		if(KitName.equals("Standart")){
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 1));
		}
		if(KitName.equalsIgnoreCase("Bogenschütze")){
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 1));
			p.getInventory().setItem(1, buildItemWAE(Material.BOW, 1, 0, "§bBogen"));
			p.getInventory().setItem(8, buildItemWAE(Material.ARROW, 16, 0, "§6Pfeil"));
		}
		if(KitName.equals("RodPvP")){
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 1));
			p.getInventory().setItem(1, buildItemWAE(Material.FISHING_ROD, 1, 0, "§6Rod"));
		}
		if(KitName.equals("Schneemann")){
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 1));
			p.getInventory().setItem(1, buildItemWAE(Material.SNOW_BALL, 16, 0, "§eSchneeball"));
		}
		if(KitName.equals("Knockback-3")){
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 3));
		}
		if(KitName.equals("Enterhaken")){
			enterHaken = true;
			p.getInventory().setItem(0, buildItem(Material.STICK, 1, 0, "§eKnockback-Stick", Enchantment.KNOCKBACK, 1));
			p.getInventory().setItem(1, buildItemWAE(Material.FISHING_ROD, 1, 0, "§6Rod"));		
			}
	}
	public static ItemStack buildItem(Material mat, int anzahl, int shortid, String Displayname, Enchantment enchant, int staerke){
		
		ItemStack i = new ItemStack(mat, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(Displayname);
		im.addEnchant(enchant, staerke, true);
		i.setItemMeta(im);
		
		return i;
	}
public static ItemStack buildItemWAE(Material mat, int anzahl, int shortid, String Displayname){
		ItemStack i = new ItemStack(mat, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.spigot().setUnbreakable(true);
		im.setDisplayName(Displayname);
		i.setItemMeta(im);
		
		return i;
	}
}
