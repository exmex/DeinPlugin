package de.spigotplugins.ffa.main;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.spigotplugins.ffa.commands.Commands;
import de.spigotplugins.ffa.data.Data;
import de.spigotplugins.ffa.events.MainEvents;
import de.spigotplugins.methods.Inv;
import de.spigotplugins.methods.LevelHandler;
import de.spigotplugins.methods.NoHitDelay;
import de.spigotplugins.methods.Scoreboard;
import de.spigotplugins.methods.Shop;
import de.spigotplugins.methods.StatsManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Main extends JavaPlugin implements Listener{
	public static int i;
	//entity.setNoDamageTicks(0);
    //entity.setMaximumNoDamageTicks(0);
	public static String MapName;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		Data.enable = true;
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§aDas Plugin startet...");
		StatsManager.checkIfStatsDataExists();
		Bukkit.getPluginManager().registerEvents(new MainEvents(), this);
		Bukkit.getPluginManager().registerEvents(new LevelHandler(), this);
		Bukkit.getPluginManager().registerEvents(new Shop(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("ffa").setExecutor(new Commands());
		getCommand("shop").setExecutor(new Shop());
		getCommand("nohitdelay").setExecutor(new NoHitDelay());
		File file = new File("plugins//FFA//spawns.yml");
		if(!file.exists()){
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§e§m-----------------------------------------------");
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cDu musst einen Spawn Setzen, damit das Plugin startet!");
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§c/FFA SetSpawn [MapName]");
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§c/FFA SetHigh [MapName]");
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§e§m-----------------------------------------------");
			Data.enable = false;
			return;
		}
		loadAvailableMaps();
		try {
			loadNHD();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		processLocations();
		changeMap();
		for(Player all : Bukkit.getOnlinePlayers()){
			StatsManager.loadStatsFromConfigIntoHashMap(all);
			teleportToMap(all);
			all.sendMessage(Data.Prefix + "§eDas Spiel wurde neu geladen!");
			Inv.getPlayerStandart(all);
		}
		i = 180;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				i--;
				for(Player all : Bukkit.getOnlinePlayers()){
					sendActionbar(all, Data.Prefix + "§eDie Map wechselt in §6" + i + "§e Sekunden!");
				}
				if(i == 0){
					changeMap();
					i = 180;
				}
			}
		}, 20, 20);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cDas Plugin stoppt...");
		for(Player all : Bukkit.getOnlinePlayers()){
			all.kickPlayer("§cDer Server startet neu!");
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		e.setDeathMessage(null);
		Player p = e.getEntity();
		
		p.setLevel(0);
		Player k = e.getEntity().getKiller();
		e.getDrops().clear();
		p.setHealth(20);
		teleportToMap(p);
     	p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
		StatsManager.deaths.put(p.getUniqueId(), StatsManager.deaths.get(p.getUniqueId()) +1);
		Scoreboard.setScoreboard(p);
		Bukkit.getScheduler().scheduleAsyncDelayedTask(this, new Runnable() {
			@Override
			public void run() {
				
				if(Data.nhd == true){
				Inv.getPlayerStandart(p);
				ItemStack a = new ItemStack(Material.DIAMOND_HELMET);
				ItemStack b = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack ca = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemStack d = new ItemStack(Material.DIAMOND_BOOTS);
				p.setMaximumNoDamageTicks(0);
				p.getInventory().setHelmet(a);
				p.getInventory().setChestplate(b);
				p.getInventory().setLeggings(ca);
				p.getInventory().setBoots(d);
				}else{
					Inv.getPlayerStandart(p);
				}
				p.updateInventory();
				teleportToMap(p);
			}
		}, 2);
		if(k != null){
			p.sendMessage(Data.Prefix + "§eDu wurdest von §c" + k.getName() + "§e getötet!"); 
			k.sendMessage(Data.Prefix + "§eDu hast §6" + p.getName() + "§e getötet!");
			k.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 70, 3));
			k.playSound(k.getLocation(), Sound.LEVEL_UP, 10, 10);
			StatsManager.kills.put(k.getUniqueId(), StatsManager.kills.get(k.getUniqueId()) +1);
			Scoreboard.setScoreboard(k);
		}else{
		}
	}
	public static void loadAvailableMaps(){
		File file = new File("plugins//FFA//maps.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Data.Maps = cfg.getStringList("Maps");
		if(Data.Maps.isEmpty()){
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§cEs wurden keine §eMaps §cgefunden!"); 
			return;
		}
		return;
	}
	public static void safeAvailableMaps(){
		File file = new File("plugins//FFA//maps.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Maps", Data.Maps);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void changeMap(){
		loadAvailableMaps();
		File file = new File("plugins//FFA//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		try{
	        String Map = Data.Maps.get(new Random().nextInt(Data.Maps.size()));
	        MapName = Map;
	        Data.hohe = cfg.getDouble("Hohe." + MapName);
	        for(Player all : Bukkit.getOnlinePlayers()){
	        	all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 1, 5);
	        	all.setHealth(20);
	        	Scoreboard.setScoreboard(all);
	        	teleportToMap(all);
	        	all.sendTitle("§eNeue Map", "§5" + MapName);
	        }
		}catch(Exception e1){
			
			for(Player all : Bukkit.getOnlinePlayers()){
				all.kickPlayer(Data.Prefix + "§cEin Fehler ist aufgetreten! Bitte kontaktiere einen Administrator!");
				Bukkit.broadcastMessage(Data.Prefix + "§c§lSPAM! §cEin Fehler ist in der Mapkonfiguration aufgetreten. Eine Map konnte nicht geladen werden...");
				Bukkit.reload();
			}
			
		}
		
	}
	public void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" +
                ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
	public void processLocations(){
		for(int i = 0 ; i < Data.Maps.size() ; i++){
			Data.MapLocation.put(Data.Maps.get(i), returnLocationFromConfig(Data.Maps.get(i)));
		}
	}
	private Location returnLocationFromConfig(String Map) {
		try{
		Location loc = null;
		File file = new File("plugins//FFA//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		double x = cfg.getDouble("Spawn.X." + Map);
		double y = cfg.getDouble("Spawn.Y." + Map);
		double z = cfg.getDouble("Spawn.Z." + Map);
		float yaw = (float) cfg.getDouble("Spawn.Yaw." + Map);
		float pitch = (float) cfg.getDouble("Spawn.Pitch." + Map);
		String wn = cfg.getString("Spawn.Weltname." + Map);
		loc = new Location(Bukkit.getWorld(wn), x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		

		
	return loc;

		}catch(Exception e1){
			
			for(Player all : Bukkit.getOnlinePlayers()){
				all.kickPlayer(Data.Prefix + "§cEin Fehler ist aufgetreten! Bitte warte auf einen Administrator!");
				Bukkit.broadcastMessage("§c§lEINE LOCATION KONNTE NICHT GELADEN WERDEN! SETZE ALLE SPAWNS NEU!");
			}
			return null;
		}
	}

	public static Location returnLocation(String Map){
		Location loc = Data.MapLocation.get(MapName);
		
		return loc;
	}
	public static void teleportToMap(Player p){
		Location loc = returnLocation(MapName);
		p.teleport(loc);
	}
	public void loadNHD() throws IOException{

	File filea = new File("plugins//FFA//nhd.yml");
	YamlConfiguration cfga = YamlConfiguration.loadConfiguration(filea);
	
	if(cfga.get("NHD") != null){
		if(cfga.getBoolean("NHD") == true){
			Data.nhd = true;
		}else{
			Data.nhd = false;
		}
	}else{
		cfga.set("NHD", false);
		cfga.save(filea);
		Data.nhd = false;
	}
	
}
	public static void putMapName(String Map){
		File file = new File("plugins//FFA//maps.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Maps", Data.Maps);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Data.Maps = cfg.getStringList("Maps");
		Data.Maps.add(Map);
	}
	public static boolean loadMapName(String Name){
		File file = new File("plugins//FFA//maps.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.getStringList("Maps").contains(Name)){
			return true;
		}else{
			return false;
		}
	}
	public static void removeMapName(String Name){
		if(loadMapName(Name) == true){
			File file = new File("plugins//FFA//maps.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			cfg.getStringList("Maps").remove(Name);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Data.Maps = cfg.getStringList("Maps");
			return;
		}else{
			return;
		}
	}
}
