package Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;

import Challenger.Challenger;
import Commands.SchutzschildToggle;
import Commands.SetServer;
import Commands.SpawnShop;
import Compass.CompassClick;
import Compass.CompassListener;
import EventListener.Join;
import EventListener.NickListener;
import EventListener.Other;
import EventListener.Schutzschild;
import Utils.Language;

public class Main extends JavaPlugin {

	private static Main instance;
	public static String pre = "§6Revayd §8▏§3 ";

	public static HashMap<Player, Language> playerLanguage = new HashMap<Player, Language>();
	public static HashMap<UUID, String> playerRank = new HashMap<UUID, String>();
	public static HashMap<UUID, Integer> playerBlockRequests = new HashMap<UUID, Integer>();

	public Schutzschild schutz;
	public static int i = 1;
	public static boolean toggleSchutzschild = false;
	public static int playerCount = 0;
	public static Location spawn = null;
	
	File file = new File("plugins/Lobby","Locs.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getMessenger().registerOutgoingPluginChannel(this,
				"BungeeCord");
		register();
		System.out
				.println("|               Lobbysystem aktiviert                 |");
		System.out
				.println("|             Copyright (C) McSmite 2014              |");
		
		
		Chat.globalmute = false;
		i = 1;

 		

		String w = cfg.getString("lobby.spawn.world");
  		double x = cfg.getDouble("lobby.spawn.x");
  		double y = cfg.getDouble("lobby.spawn.y");
  		double z = cfg.getDouble("lobby.spawn.z");
  		double yaw = cfg.getDouble("lobby.spawn.yaw");
  		double pitch = cfg.getDouble("lobby.spawn.pitch");
		World world = Bukkit.getWorld(w);
  		Location loc = new Location(world,x,y,z);
  		loc.setPitch((float) pitch);
  		loc.setYaw((float) yaw);
  		spawn = loc;
	
		if (Bukkit.getPluginManager().getPlugin("PermissionsEx") == null) {
			Bukkit.getServer().setWhitelist(true);
		}
		
		for (Entity e : Bukkit.getWorld("world").getEntities()) {
			if (e instanceof Villager) {
				e.remove();
			}
		}

		SQLStats.MySQL sql = new SQLStats.MySQL();
		sql.init();
		// Task
		SQLStats.MySQL.closeConnection();
		SQLStats.MySQL.openConnection();

		startRestartTimer();
		startMysqlTimer();

	}

	public static void send(Player p, String server) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(server);
		} catch (IOException e) {

		}
		p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onDisable() {
		System.out
				.println("|               Lobbysystem deaktiviert               |");
		System.out
				.println("|             Copyright (C) McSmite 2014              |");
		Bukkit.getScheduler().cancelAllTasks();
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (schutz.run.containsKey(p)) {
				schutz.run.get(p).cancel();
				schutz.run.remove(p);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void startRestartTimer() {	
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
					public void run() {
						Date d = new Date();
						int hour = 04;
						int minute = 00;
						if ((d.getHours() == hour) && (d.getMinutes() == minute)) {
							Bukkit.shutdown();
						}
					}
				}, 0L, 0L);
			}
		}, 600L, 600L);
	}

	@SuppressWarnings("deprecation")
	public void startMysqlTimer() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			public void run() {
				if(SQLStats.MySQL.hasConnection() == false){
					SQLStats.MySQL.openConnection();
				}
			}
		}, 5*20L, 5*20L);
	}

	public void register() {
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Join(this), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new NickListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Other(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Schutzschild(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new CompassListener(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new CompassClick(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new Challenger(), this);

		getCommand("spawnshop").setExecutor(new SpawnShop(this));
		getCommand("schutzschild").setExecutor(new SchutzschildToggle());
		getCommand("setserver").setExecutor(new SetServer());
		getCommand("globalmute").setExecutor(new Chat());


	}

	public static Main getInstance() {
		return instance;
	}

}
