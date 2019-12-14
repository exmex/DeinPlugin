package lobbysystem.main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import lobbysystem.commands.SetSpawn;
import lobbysystem.data.Data;
import lobbysystem.functions.Compass;
import lobbysystem.functions.LobbySwitcher;
import lobbysystem.functions.PlayerHider;
import lobbysystem.listener.LobbyProtection;
import lobbysystem.listener.MainListener;

public class Main extends JavaPlugin{
	static int i;
	public static ItemStack OnlineLobby;
	public static ItemStack OfflineLobby;
	public void onEnable(){
		i = 0;
		Bukkit.getConsoleSender().sendMessage("§6LobbySystem wird aktiviert...");
		Bukkit.getPluginManager().registerEvents(new Compass(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHider(), this);
		Bukkit.getPluginManager().registerEvents(new LobbyProtection(), this);
		Bukkit.getPluginManager().registerEvents(new LobbySwitcher(this), this);

		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
		Bukkit.getPluginManager().registerEvents(new SetSpawn(), this);
		updateLobbys();
		loadLocations();
		
        load1();
        load2();
        load3();
        load4();
        load5();
        load6();
	
	}
	public void onDisable(){
		
		Bukkit.getConsoleSender().sendMessage("§6LobbySystem wird deaktiviert...");
		
	}
	public void loadLocations(){
		File file = new File("plugins//LobbySystem//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        Data.spawn = loc;

	}
	public void load1(){
		File file = new File("plugins//LobbySystem//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("1.WeltName");
        double x = cfg.getDouble("1.X");
        double y = cfg.getDouble("1.Y");
        double z = cfg.getDouble("1.Z");
        double yaw = cfg.getDouble("1.Yaw");
        double pitch = cfg.getDouble("1.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        Data.spawn1 = loc;
	}
public void load2(){
	File file = new File("plugins//LobbySystem//spawns.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    String w = cfg.getString("2.WeltName");
    double x = cfg.getDouble("2.X");
    double y = cfg.getDouble("2.Y");
    double z = cfg.getDouble("2.Z");
    double yaw = cfg.getDouble("2.Yaw");
    double pitch = cfg.getDouble("2.Pitch");
    Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    Data.spawn2 = loc;
	}
public void load3(){
	File file = new File("plugins//LobbySystem//spawns.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    String w = cfg.getString("3.WeltName");
    double x = cfg.getDouble("3.X");
    double y = cfg.getDouble("3.Y");
    double z = cfg.getDouble("3.Z");
    double yaw = cfg.getDouble("3.Yaw");
    double pitch = cfg.getDouble("3.Pitch");
    Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    Data.spawn3 = loc;
}
public void load4(){
	File file = new File("plugins//LobbySystem//spawns.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    String w = cfg.getString("4.WeltName");
    double x = cfg.getDouble("4.X");
    double y = cfg.getDouble("4.Y");
    double z = cfg.getDouble("4.Z");
    double yaw = cfg.getDouble("4.Yaw");
    double pitch = cfg.getDouble("4.Pitch");
    Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    Data.spawn4 = loc;
}
public void load5(){
	File file = new File("plugins//LobbySystem//spawns.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    String w = cfg.getString("5.WeltName");
    double x = cfg.getDouble("5.X");
    double y = cfg.getDouble("5.Y");
    double z = cfg.getDouble("5.Z");
    double yaw = cfg.getDouble("5.Yaw");
    double pitch = cfg.getDouble("5.Pitch");
    Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    Data.spawn5 = loc;
}
public void load6(){
	File file = new File("plugins//LobbySystem//spawns.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    String w = cfg.getString("6.WeltName");
    double x = cfg.getDouble("6.X");
    double y = cfg.getDouble("6.Y");
    double z = cfg.getDouble("6.Z");
    double yaw = cfg.getDouble("6.Yaw");
    double pitch = cfg.getDouble("6.Pitch");
    Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
    loc.setYaw((float)yaw);
    loc.setPitch((float)pitch);
    Data.spawn6 = loc;
}

public void updateLobbys(){
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		
		@Override
		public void run() {
			if(i == 0){
				ItemStack online = new ItemStack(Material.STAINED_CLAY, Bukkit.getOnlinePlayers().size(), (short)5);
				ItemMeta om = online.getItemMeta();
				om.setDisplayName("§aLobby-01§8 » §2Online");
				ArrayList<String> list = new ArrayList<String>();
				list.add("§7§m------------------------");
				list.add("§6Online§8 » §3" + Bukkit.getOnlinePlayers().size());
				list.add("§6Status §8» §2Online");
				list.add("§6Aktualisieren:");
				list.add("§7§m------------------------");
				om.setLore(list);
				online.setItemMeta(om);
				
				ItemStack offline = new ItemStack(Material.STAINED_CLAY, 0, (short)14);
				ItemMeta ofm = offline.getItemMeta();
				ofm.setDisplayName("§aLobby §8» §cWird bei Bedarf gestartet");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("§7§m------------------------");
				list1.add("§6Online§8 » §30");
				list1.add("§6Status §8» §cOffline");
				list1.add("§6Aktualisieren:");
				list1.add("§7§m------------------------");
				ofm.setLore(list1);
				offline.setItemMeta(ofm);
				
				OfflineLobby = offline;
				OnlineLobby = online;
			}
			i++;
			
			for(Player all : Bukkit.getOnlinePlayers()){
				if(LobbySwitcher.into.contains(all)){
					Inventory inv = Bukkit.createInventory(null, 9, "§6Lobby Switcher");
					inv.setItem(0, Main.OnlineLobby);
					inv.setItem(1, Main.OfflineLobby);
					inv.setItem(2, Main.OfflineLobby);
					inv.setItem(3, Main.OfflineLobby);
					inv.setItem(4, Main.OfflineLobby);
					inv.setItem(5, Main.OfflineLobby);
					inv.setItem(6, Main.OfflineLobby);
					inv.setItem(7, Main.OfflineLobby);
					inv.setItem(8, Main.OfflineLobby);
					LobbySwitcher.into.remove(all);
					all.openInventory(inv);
					LobbySwitcher.into.add(all);
				}
			}
			
			if(i == 1){
				ItemStack online = new ItemStack(Material.STAINED_CLAY, Bukkit.getOnlinePlayers().size(), (short)5);
				ItemMeta om = online.getItemMeta();
				om.setDisplayName("§aLobby-01§8 » §2Online");
				ArrayList<String> list = new ArrayList<String>();
				list.add("§7§m------------------------");
				list.add("§6Online§8 » §3" + Bukkit.getOnlinePlayers().size());
				list.add("§6Status §8» §2Online");
				list.add("§6Aktualisieren: §a•");
				list.add("§7§m------------------------");
				om.setLore(list);
				online.setItemMeta(om);
				
				ItemStack offline = new ItemStack(Material.STAINED_CLAY, 0, (short)14);
				ItemMeta ofm = offline.getItemMeta();
				ofm.setDisplayName("§aLobby §8» §cWird bei Bedarf gestartet");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("§7§m------------------------");
				list1.add("§6Online§8 » §30");
				list1.add("§6Status §8» §cOffline");
				list1.add("§6Aktualisieren: §a•");
				list1.add("§7§m------------------------");
				ofm.setLore(list1);
				offline.setItemMeta(ofm);
				
				OfflineLobby = offline;
				OnlineLobby = online;
			}
			if(i == 2){
				ItemStack online = new ItemStack(Material.STAINED_CLAY, Bukkit.getOnlinePlayers().size(), (short)5);
				ItemMeta om = online.getItemMeta();
				om.setDisplayName("§aLobby-01§8 » §2Online");
				ArrayList<String> list = new ArrayList<String>();
				list.add("§7§m------------------------");
				list.add("§6Online§8 » §3" + Bukkit.getOnlinePlayers().size());
				list.add("§6Status §8» §2Online");
				list.add("§6Aktualisieren: §a• §e•");
				list.add("§7§m------------------------");
				om.setLore(list);
				online.setItemMeta(om);
				
				ItemStack offline = new ItemStack(Material.STAINED_CLAY, 0, (short)14);
				ItemMeta ofm = offline.getItemMeta();
				ofm.setDisplayName("§aLobby §8» §cWird bei Bedarf gestartet");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("§7§m------------------------");
				list1.add("§6Online§8 » §30");
				list1.add("§6Status §8» §cOffline");
				list1.add("§6Aktualisieren: §a• §e•");
				list1.add("§7§m------------------------");
				ofm.setLore(list1);
				offline.setItemMeta(ofm);
				
				OfflineLobby = offline;
				OnlineLobby = online;
		}
			if(i == 3){
				ItemStack online = new ItemStack(Material.STAINED_CLAY, Bukkit.getOnlinePlayers().size(), (short)5);
				ItemMeta om = online.getItemMeta();
				om.setDisplayName("§aLobby-01§8 » §2Online");
				ArrayList<String> list = new ArrayList<String>();
				list.add("§7§m------------------------");
				list.add("§6Online§8 » §3" + Bukkit.getOnlinePlayers().size());
				list.add("§6Status §8» §2Online");
				list.add("§6Aktualisieren: §a• §e• §c•");
				list.add("§7§m------------------------");
				om.setLore(list);
				online.setItemMeta(om);
				
				ItemStack offline = new ItemStack(Material.STAINED_CLAY, 0, (short)14);
				ItemMeta ofm = offline.getItemMeta();
				ofm.setDisplayName("§aLobby §8» §cWird bei Bedarf gestartet");
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("§7§m------------------------");
				list1.add("§6Online§8 » §30");
				list1.add("§6Status §8» §cOffline");
				list1.add("§6Aktualisieren: §a• §e• §c•");
				list1.add("§7§m------------------------");
				ofm.setLore(list1);
				offline.setItemMeta(ofm);
				
				OfflineLobby = offline;
				OnlineLobby = online;
				
				
		}
			if(i == 4){
				i = 0;
			}
		}
	}, 20, 10);
}

}
