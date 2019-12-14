package lobby.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import lobby.commands.SetSpawn;
import lobby.commands.YouTuber;
import lobby.data.Data;
import lobby.items.Enterhaken;
import lobby.items.Freunde;
import lobby.items.LobbySwitcher;
import lobby.items.Navigator;
import lobby.items.PlayerHider;
import lobby.items.QuickJoiner;
import lobby.items.SilentHub;
import lobby.listener.DoubleJump;
import lobby.listener.PlayerLogin;
import lobby.listener.Protection;
import lobby.manager.PingManager;
import lobby.manager.SpawnManager;
import lobby.shop.Villager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Main extends JavaPlugin implements PluginMessageListener{
	int cdd;
	int update;
	int newimport;
	public static ArrayList<Player> allowactionbar = new ArrayList<>();
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		MySQL.connect();
		MySQL.createTable();
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);     
		loadWarps();
		Bukkit.getPluginManager().registerEvents(new PlayerLogin(this), this);
		Bukkit.getPluginManager().registerEvents(new Navigator(this), this);
		Bukkit.getPluginManager().registerEvents(new SetSpawn(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHider(), this);
		Bukkit.getPluginManager().registerEvents(new DoubleJump(), this);
		Bukkit.getPluginManager().registerEvents(new QuickJoiner(this), this);
		Bukkit.getPluginManager().registerEvents(new Protection(this), this);
		Bukkit.getPluginManager().registerEvents(new YouTuber(), this);
		Bukkit.getPluginManager().registerEvents(new Enterhaken(), this);
		Bukkit.getPluginManager().registerEvents(new LobbySwitcher(this), this);
		Bukkit.getPluginManager().registerEvents(new SilentHub(this), this);
		getCommand("setrank").setExecutor(new YouTuber());
		getCommand("setshop").setExecutor(new Villager(this));
		getCommand("setbelohnungen").setExecutor(new Villager(this));

		loadWarps();
		cdd = 31;
		update = 5;
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				update--;
				
				
				if(update == 0){
				QuickJoiner.nick.clear();
				Data.Lobby01 = PingManager.getPlayerSize("127.0.0.1", 1);
				Data.Lobby02 = PingManager.getPlayerSize("127.0.0.1", 2);
				Data.Lobby03 = PingManager.getPlayerSize("127.0.0.1", 3);
				Data.Lobby04 = PingManager.getPlayerSize("127.0.0.1", 8998);
				Data.Lobby05 = PingManager.getPlayerSize("127.0.0.1", 8999);
				Data.SilentHub = PingManager.getPlayerSize("127.0.0.1", 6);
				Data.KitBattle = PingManager.getPlayerSize("127.0.0.1", 10) + PingManager.getPlayerSize("127.0.0.1", 11) + PingManager.getPlayerSize("127.0.0.1", 12) + PingManager.getPlayerSize("127.0.0.1", 16) + PingManager.getPlayerSize("127.0.0.1", 17) + PingManager.getPlayerSize("127.0.0.1", 18);
				Data.KnockPVP = PingManager.getPlayerSize("127.0.0.1", 5);
				Data.DeathTime = PingManager.getPlayerSize("127.0.0.1", 820) + PingManager.getPlayerSize("127.0.0.1", 821) + PingManager.getPlayerSize("127.0.0.1", 822) + PingManager.getPlayerSize("127.0.0.1", 823) + PingManager.getPlayerSize("127.0.0.1", 824) + PingManager.getPlayerSize("127.0.0.1", 825);
				Data.KnockbackFFA = PingManager.getPlayerSize("127.0.0.1", 130) + PingManager.getPlayerSize("127.0.0.1", 131) + PingManager.getPlayerSize("127.0.0.1", 132);
				Data.Community = PingManager.getPlayerSize("127.0.0.1", 4);
				Data.SkyWars = PingManager.getPlayerSize("127.0.0.1", 5000) + PingManager.getPlayerSize("127.0.0.1", 5001) + PingManager.getPlayerSize("127.0.0.1", 5002);
				Data.TTT = PingManager.getPlayerSize("127.0.0.1", 4000) + PingManager.getPlayerSize("127.0.0.1", 4001) + PingManager.getPlayerSize("127.0.0.1", 4002);
				Data.FFA = PingManager.getPlayerSize("127.0.0.1", 1500) + PingManager.getPlayerSize("127.0.0.1", 1501) + PingManager.getPlayerSize("127.0.0.1", 1502);

				update = 5;
				}
				for(Player all : Bukkit.getOnlinePlayers()){
					all.setLevel(Data.Total);
					all.setExp((float) 0);
				}
				if(cdd == 0){
					cdd = 31;
				}
				cdd--;
				if(cdd > 19 && cdd < 32){
					for(Player all : Bukkit.getOnlinePlayers()){
						if(allowactionbar.contains(all)){
						sendActionbar(all, Data.Prefix + "§7Kennst du unseren §6Shop§7? §ehttp://shop.claymc.net");
					}
					}
				}
				if(cdd > 9 && cdd < 21){
					
					for(Player all : Bukkit.getOnlinePlayers()){
						if(allowactionbar.contains(all)){
						sendActionbar(all, Data.Prefix + "§7Sei gespannt auf §btägliche §eUpdates!");
					}
					}
				}
				if(cdd > -1 && cdd < 11){
					for(Player all : Bukkit.getOnlinePlayers()){
						if(allowactionbar.contains(all)){
						sendActionbar(all, Data.Prefix + "§9Besuche uns auf Twitter: §b@ClayMCNetwork");
					}
					}
				}
			}
		}, 20, 20);
	}
	@Override
	public void onDisable() {
		Bukkit.getScheduler().cancelAllTasks();
		MySQL.disconnect();
	}
	public static void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
	public void loadWarps(){
		try{
		Data.kitbattle = SpawnManager.getLocation("KitBattle");
		Data.knockpvp = SpawnManager.getLocation("KnockPvP");
		Data.skywars = SpawnManager.getLocation("SkyWars");
		Data.claywars = SpawnManager.getLocation("ClayWars");
		Data.knockbackffa = SpawnManager.getLocation("KnockbackFFA");
		Data.spawn = SpawnManager.getLocation("Spawn");
		Data.community = SpawnManager.getLocation("Community");
		Data.claysg = SpawnManager.getLocation("ClaySG");
		Data.souppvp = SpawnManager.getLocation("SoupPvP");
		Data.freebuild = SpawnManager.getLocation("FreeBuild");
		Data.jumpwars = SpawnManager.getLocation("JumpWars");
		Data.ffa = SpawnManager.getLocation("FFA"); 
		Data.coinsshop = SpawnManager.getLocation("CoinsShop"); 
		Data.knocktime = SpawnManager.getLocation("KnockTime");
	}catch(Exception e1){}
	}
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;        
        try {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        } catch (Exception e) {
                e.printStackTrace();
        }
}
}
