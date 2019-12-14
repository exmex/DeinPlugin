package lobby.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import lobby.commands.SetSpawn;
import lobby.data.Data;
import lobby.items.Freunde;
import lobby.items.LobbySwitcher;
import lobby.items.Navigator;
import lobby.items.QuickJoiner;
import lobby.items.SilentHub;
import lobby.listener.PlayerLogin;
import lobby.listener.Protection;
import lobby.manager.PingManager;
import lobby.manager.SpawnManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Main extends JavaPlugin implements PluginMessageListener{
	int cdd;
	int update;
	int newimport;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);     
		loadWarps();
		Bukkit.getPluginManager().registerEvents(new PlayerLogin(this), this);
		Bukkit.getPluginManager().registerEvents(new Navigator(this), this);
		Bukkit.getPluginManager().registerEvents(new SetSpawn(), this);
		Bukkit.getPluginManager().registerEvents(new QuickJoiner(), this);
		Bukkit.getPluginManager().registerEvents(new Freunde(), this);
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new LobbySwitcher(this), this);
		Bukkit.getPluginManager().registerEvents(new SilentHub(this), this);

		cdd = 31;
		update = 5;
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				update--;
				for(Player all : Bukkit.getOnlinePlayers()){
					all.setLevel(Data.Lobby01 + Data.Lobby02 + Data.KitBattle + Data.KnockPVP + Data.KnockPVP + Data.ClayWars + Data.SkyWars + Data.KnockbackFFA + Data.Community);
				}
				if(update == 0){
				Data.Lobby01 = PingManager.getPlayerSize("claymc.net", 1);
				Data.Lobby02 = PingManager.getPlayerSize("claymc.net", 2);
				Data.KitBattle = PingManager.getPlayerSize("claymc.net", 10);
				Data.KnockPVP = PingManager.getPlayerSize("claymc.net", 3);
				Data.ClayWars = PingManager.getPlayerSize("claymc.net", 820) + PingManager.getPlayerSize("claymc.net", 821) + PingManager.getPlayerSize("claymc.net", 822) + PingManager.getPlayerSize("claymc.net", 823) + PingManager.getPlayerSize("claymc.net", 824) + PingManager.getPlayerSize("claymc.net", 825);
				Data.KnockbackFFA = PingManager.getPlayerSize("claymc.net", 130) + PingManager.getPlayerSize("claymc.net", 131) + PingManager.getPlayerSize("claymc.net", 132);
				Data.Community = PingManager.getPlayerSize("claymc.net", 4);
				Data.SkyWars = PingManager.getPlayerSize("claymc.net", 5000) + PingManager.getPlayerSize("claymc.net", 5001) + PingManager.getPlayerSize("claymc.net", 5002);
				update = 5;
				}
				if(cdd == 0){
					cdd = 31;
				}
				cdd--;
				if(cdd > 19 && cdd < 32){
					for(Player all : Bukkit.getOnlinePlayers()){
						sendActionbar(all, Data.Prefix + "§7Kennst du unseren §6Shop§7? §ehttp://shop.claymc.net");
					}
				}
				if(cdd > 9 && cdd < 21){
					for(Player all : Bukkit.getOnlinePlayers()){
						sendActionbar(all, Data.Prefix + "§7Sei gespannt auf §btägliche §eUpdates!");
					}
				}
				if(cdd > -1 && cdd < 11){
					for(Player all : Bukkit.getOnlinePlayers()){
						sendActionbar(all, Data.Prefix + "§9Besuche uns auf Twitter: §b@ClayMCNetwork");
					}
				}
			}
		}, 20, 20);
	}
	@Override
	public void onDisable() {
		Bukkit.getScheduler().cancelAllTasks();
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
