package knockpvp.main;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import knockpvp.commands.AddCoins;
import knockpvp.commands.Commands;
import knockpvp.commands.SetHigh;
import knockpvp.listener.MainListener;
import knockpvp.listener.Shop;
import knockpvp.utils.Data;
import knockpvp.utils.Scoreboard;
import knockpvp.utils.Stats;
import net.minecraft.server.v1_8_R3.MobSpawnerAbstract.a;

public class Main extends JavaPlugin{
	
	public static int high;
	public static ItemStack helm;
	public static ItemStack chest;
	public static ItemStack hose;
	public static ItemStack boots;
	public static ItemStack first;
	public static ItemStack second;
	public static ItemStack third;
	public static ItemStack fourth;
	public static ItemStack fiveth;
	public static ItemStack sixth;
	public static ItemStack seventh;
	public static ItemStack eighth;
	public static ItemStack ninth;
	public static GameState gs;
	public static int min;
	public static int cd;
	public static int level;
	public static int cdd;
	public static String MapName;
	public static String Kit;
	public static int dd;
	public static String Sek;
	static boolean s;
	public static List<String> MapList;
	public void onEnable(){
		ItemStack shop = new ItemStack(Material.GOLD_INGOT);
		ItemMeta sm = shop.getItemMeta();
		sm.setDisplayName("§6Shop");
		shop.setItemMeta(sm);
		ninth = shop;
		try{
			
		selectKit();
		selectMap();
		s = false;
		min = 1;
		cdd = 50;
		runKitsAndMapCountdown();
		if(Data.cfg.get("Maps") != null){
			MapList = Data.cfg.getStringList("Maps");	
			
		}
		getCommand("setspawn").setExecutor(new Commands());
		getCommand("sethigh").setExecutor(new SetHigh());
		getCommand("addcoins").setExecutor(new AddCoins());
		Bukkit.getPluginManager().registerEvents(new MainListener(this), this);
		Bukkit.getPluginManager().registerEvents(new Shop(), this);
		}catch(Exception e1){
		Bukkit.getConsoleSender().sendMessage("§4FEHLER!");
		getCommand("setspawn").setExecutor(new Commands());
	}

	}
	
	public static void setSpawn(String SpawnName, Player p){
		String i = SpawnName;
		if(!SpawnName.equalsIgnoreCase("Spawn")){

		Location loc = p.getLocation();
		Data.cfg.set("Spawn" + i + ".X", loc.getX());
		Data.cfg.set("Spawn" + i + ".Y", loc.getY());
		Data.cfg.set("Spawn" + i + ".Z", loc.getZ());
		Data.cfg.set("Spawn" + i + ".Yaw", loc.getYaw());
		Data.cfg.set("Spawn" + i + ".Pitch", loc.getPitch());
		Data.cfg.set("Spawn" + i + ".Weltname", loc.getWorld().getName());
		MapList = Data.cfg.getStringList("Maps");
		MapList.add(SpawnName);
		Data.cfg.set("Maps", MapList);
		try {
			Data.cfg.save(Data.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MapList = Data.cfg.getStringList("Maps");
	}else{
		Location loc = p.getLocation();
		Data.cfg.set("Spawn" + i + ".X", loc.getX());
		Data.cfg.set("Spawn" + i + ".Y", loc.getY());
		Data.cfg.set("Spawn" + i + ".Z", loc.getZ());
		Data.cfg.set("Spawn" + i + ".Yaw", loc.getYaw());
		Data.cfg.set("Spawn" + i + ".Pitch", loc.getPitch());
		Data.cfg.set("Spawn" + i + ".Weltname", loc.getWorld().getName());
		try {
			Data.cfg.save(Data.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public static void teleportToSpawn(String SpawnName, Player p){
		int x = Data.cfg.getInt("Spawn" + SpawnName +  ".X");
		int y = Data.cfg.getInt("Spawn" + SpawnName + ".Y");
		int z = Data.cfg.getInt("Spawn" + SpawnName + ".Z");
		float yaw = (float) Data.cfg.getDouble("Spawn" + SpawnName + ".Yaw");
		float pitch = (float) Data.cfg.getDouble("Spawn" + SpawnName + ".Pitch");
		String weltname = Data.cfg.getString("Spawn" + SpawnName + ".Weltname");
		Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		p.teleport(loc);
	}
	
	public void runKitsAndMapCountdown(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(gs == GameState.FREE){
					return;
				}
				Sek = cdd + "";
				if(cdd > -1 && cdd < 10){
					Sek = "0" + cdd;
				}
				if(min > -1 && cdd != -1){
					if(cdd == 0 && min > 0){
						min--;
						Sek = "1:00";
						cdd = 60;
						s = true;
					}
				cdd--;
				if(s == false){
					ActionBarAPI.sendActionBarToAllPlayers("§6Kit + Map §3Change in §e" + min + ":" + Sek + "§3 Minuten!");
				}else{
					ActionBarAPI.sendActionBarToAllPlayers("§6Kit + Map §3Change in §e" + Sek + "§3 Minuten!");
				s = false;	
				}
				if(cdd == 0 && min == 0){
					if(Bukkit.getOnlinePlayers().size() > 30){
						for(Player all : Bukkit.getOnlinePlayers()){
							all.sendMessage(Data.Prefix + "§cDer Map + Kit - Switch wurde aufgrund von zu vielen Spielern blockiert.");
							cdd = 50;
							min = 1;
						}
						return;
					}
				
					int i = 0;
					String Name = "Unbekannt";
					for(Player all : Bukkit.getOnlinePlayers()){
						if(i < all.getLevel() || i == all.getLevel()){
							Name = all.getName();
							i = all.getLevel();
						}
					}
					
				
					Bukkit.broadcastMessage("§3§m----------------------------------");
					Bukkit.broadcastMessage("§bRunden-Kills");
					Bukkit.broadcastMessage("§3§m----------------------------------");
					Bukkit.broadcastMessage("§eSpieler §8» §6" + Name);
					Bukkit.broadcastMessage("§eKills §8» §6" + i);
					Bukkit.broadcastMessage("§3§m----------------------------------");

					Sek = "0:00";
					selectKit();
					selectMap();
					Bukkit.broadcastMessage(Data.Prefix + "§3Es wird nun auf der Map §e" + MapName + "§3 mit dem Kit §e" + Kit + "§3 gespielt!");
					for(Player all : Bukkit.getOnlinePlayers()){
						all.setLevel(0);
						all.sendTitle("§3Map: §e" + MapName, "§3Kit: §e" + Kit);
						all.getInventory().clear();
						all.getInventory().setHelmet(helm);
						all.getInventory().setChestplate(chest);
						all.getInventory().setLeggings(hose);
						all.getInventory().setBoots(boots);
						all.getInventory().setItem(0, first);
						all.getInventory().setItem(1, second);
						all.getInventory().setItem(2, third);
						all.getInventory().setItem(3, fourth);
						all.getInventory().setItem(4, fiveth);
						all.getInventory().setItem(5, sixth);
						all.getInventory().setItem(6, seventh);
						all.getInventory().setItem(7, eighth);
						all.getInventory().setItem(8, ninth);
						teleportToSpawn(MapName, all);
						cdd = 50;
						min = 1;
					}
				}
					
					
					
					
				}
				
			}
		}, 20, 20);
	}
	
	public void selectKit(){
	
		
		level = 0;
    	ItemStack shop = new ItemStack(Material.GOLD_INGOT);
		ItemMeta sm = shop.getItemMeta();
		sm.setDisplayName("§6Shop");
		shop.setItemMeta(sm);
		Shop.MapSwitch = false;
		Random num= new Random();
        int number;
        number = num.nextInt(7);
        switch (number) {
        
        case 0:
        	Kit = "Standart";
        	ItemStack h = new ItemStack(Material.IRON_HELMET);
        	ItemStack c = new ItemStack(Material.IRON_CHESTPLATE);
        	ItemStack l = new ItemStack(Material.IRON_LEGGINGS);
        	ItemStack b = new ItemStack(Material.IRON_BOOTS);
        	ItemStack one = new ItemStack(Material.IRON_SWORD);
        	helm = h;
        	chest = c;
        	hose = l;
        	boots = b;
        	first = one;
        	second = null;
        	third = null;
        	fourth = null;
        	fiveth = null;
        	sixth = null;
        	seventh = null;
        	eighth = null;

    		ninth = shop;
            break;
            
        case 1:
        	Kit = "Bogenschütze";
        	ItemStack h1 = new ItemStack(Material.IRON_HELMET);
        	ItemStack bogen = new ItemStack(Material.BOW);
        	ItemStack pfeil = new ItemStack(Material.ARROW, 64);
        	ItemStack c1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        	ItemStack l1 = new ItemStack(Material.IRON_LEGGINGS);
        	ItemStack b1 = new ItemStack(Material.IRON_BOOTS);
        	ItemStack one1 = new ItemStack(Material.WOOD_SWORD);
        	helm = h1;
        	chest = c1;
        	hose = l1;
        	boots = b1;
        	first = one1;
        	second = bogen;
        	third = null;
        	fourth = null;
        	fiveth = null;
        	sixth = null;
        	seventh = pfeil;
        	eighth = null;
    		ninth = shop;
            break;
        case 2:
        	Kit = "Angler";
        	ItemStack h11 = new ItemStack(Material.IRON_HELMET);
        	ItemStack bogen1 = new ItemStack(Material.FISHING_ROD);
        	ItemStack c11 = new ItemStack(Material.IRON_CHESTPLATE);
        	ItemStack l11 = new ItemStack(Material.IRON_LEGGINGS);
        	ItemStack b11 = new ItemStack(Material.IRON_BOOTS);
        	ItemStack one11 = new ItemStack(Material.STONE_SWORD);
        	helm = h11;
        	chest = c11;
        	hose = l11;
        	boots = b11;
        	first = one11;
        	second = bogen1;
        	third = null;
        	fourth = null;
        	fiveth = null;
        	sixth = null;
        	seventh = null;
        	eighth = null;
        	ninth = shop;
        	break;
        case 3:
        	Kit = "Heiler";
        	ItemStack a = new ItemStack(Material.IRON_HELMET);
        	ItemStack a1 = new ItemStack(Material.POTION, 1, (short)16421);
        	ItemStack a2 = new ItemStack(Material.IRON_CHESTPLATE);
        	ItemStack a3 = new ItemStack(Material.IRON_LEGGINGS);
        	ItemStack a4 = new ItemStack(Material.IRON_BOOTS);
        	ItemStack a5 = new ItemStack(Material.IRON_SWORD);
        	helm = a;
        	chest = a2;
        	hose = a3;
        	boots = a4;
        	first = a5;
        	second = a1;
        	third = a1;
        	fourth = a1;
        	fiveth = a1;
        	sixth = a1;
        	seventh = a1;
        	eighth = a1;
        	ninth = shop;
        	break;
        case 4:
        	Kit = "Enderman";
        	ItemStack aa = new ItemStack(Material.IRON_HELMET);
        	ItemStack a1a = new ItemStack(Material.ENDER_PEARL, 8);
        	ItemStack a2a = new ItemStack(Material.LEATHER_CHESTPLATE);
        	ItemStack a3a = new ItemStack(Material.LEATHER_LEGGINGS);
        	ItemStack a4a = new ItemStack(Material.IRON_BOOTS);
        	ItemStack a5a = new ItemStack(Material.WOOD_SWORD);
        	helm = aa;
        	chest = a2a;
        	hose = a3a;
        	boots = a4a;
        	first = a5a;
        	second = a1a;
        	third = null;
        	fourth = null;
        	fiveth = null;
        	sixth = null;
        	seventh = null;
        	eighth = null;
        	ninth = shop;
        	break;
        case 5:
        	Kit = "Schneemann";
        	ItemStack aaa = new ItemStack(Material.LEATHER_HELMET);
        	ItemStack a1aa = new ItemStack(Material.SNOW_BALL, 16);
        	ItemStack a2aa = new ItemStack(Material.LEATHER_CHESTPLATE);
        	ItemStack a3aa = new ItemStack(Material.LEATHER_LEGGINGS);
        	ItemStack a4aa = new ItemStack(Material.DIAMOND_BOOTS);
        	ItemStack a5aa = new ItemStack(Material.WOOD_SWORD);
        	helm = aaa;
        	chest = a2aa;
        	hose = a3aa;
        	boots = a4aa;
        	first = a5aa;
        	second = a1aa;
        	third = a1aa;
        	fourth = a1aa;
        	fiveth = a1aa;
        	sixth = a1aa;
        	seventh = a1aa;
        	eighth = a1aa;
        	ninth = shop;
        	break;
        case 6: 
        	Kit = "Assassine";
        	ItemStack aaaa = new ItemStack(Material.LEATHER_HELMET);
        	ItemStack a1aaa = new ItemStack(Material.SNOW_BALL, 16);
        	ItemStack a2aaa = new ItemStack(Material.LEATHER_CHESTPLATE);
        	ItemStack a3aaa = new ItemStack(Material.LEATHER_LEGGINGS);
        	ItemStack a4aaa = new ItemStack(Material.DIAMOND_BOOTS);
        	ItemStack a5aaa = new ItemStack(Material.WOOD_SWORD);
        	helm = null;
        	chest = a2aaa;
        	hose = a3aaa;
        	boots = null;
        	first = a5aaa;
        	second = null;
        	third = null;
        	fourth = null;
        	fiveth = null;
        	sixth = null;
        	seventh = null;
        	eighth = null;
        	ninth = shop;
        	break;
        }
	}
	public void selectMap(){
        MapList = Data.cfg.getStringList("Maps");
        String Map = MapList.get(new Random().nextInt(MapList.size()));
        MapName = Map;
        high = Data.cfg.getInt("High." + MapName);
        for(Player all : Bukkit.getOnlinePlayers()){
        	Scoreboard.setScoreboard(all);
        	all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 1, 5);
        	all.setHealth(20);
        }
	}

	

	
}
