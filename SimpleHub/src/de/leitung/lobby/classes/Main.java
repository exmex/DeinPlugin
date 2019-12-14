package de.leitung.lobby.classes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class Main extends JavaPlugin implements PluginMessageListener{
	public static HashMap<String, Integer> playerCounts = new HashMap<String, Integer>();
	public static Main plugin;
	public static ArrayList<Player> effect = new ArrayList<Player>();
	public static String Prefix = "§8[§cLobby§8] ";
	public static String ScorebardEvent;
	public static String MOTDSkyWars4x11;
	public static int totalplayers;
	public static int message;
	public static int kitbattle;
	public static int knockbackffa;
	public static int BashIT;
	public static int Bauevent;
	public static int Community;
	public static int KnockPvP;
	public static int SkyWars1vs1;
	public static int FreeBuild;
	public static int ClayWars;
	public static int Spawn;
	public static int SkyWars;
	public static int Lobby1;
	public static int SoupPvP;
	public static int Lobby2;
	public static Main instance;
	@SuppressWarnings({ "unused", "deprecation" })
	public static HashMap<String, BungeeServer> server = new HashMap();
    public static HashMap<Player, String> ip = new HashMap();
	public void onEnable(){
		instance = this;
		message = 0;
		plugin = this;
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);     
        
		Bukkit.getPluginManager().registerEvents(new CookiePicker(), this);

		Bukkit.getPluginManager().registerEvents(new CMD(), this);
		Bukkit.getPluginManager().registerEvents(new ItemFunctions(this), this);
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getPluginManager().registerEvents(new Settings(), this);
		Bukkit.getPluginManager().registerEvents(new Schutzschild(), this);
		Bukkit.getPluginManager().registerEvents(new Fly(), this);
		Bukkit.getPluginManager().registerEvents(new CoinsAPIUpgrade(), this);
		Bukkit.getPluginManager().registerEvents(new Gadgets(), this);
		Bukkit.getPluginManager().registerEvents(new DATA(), this);
		Bukkit.getPluginManager().registerEvents(new GadgetsListener(), this);
		Bukkit.getPluginManager().registerEvents(new MapProtection(), this);
		Bukkit.getPluginManager().registerEvents(new WaterKnockback(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHider(), this);
		Bukkit.getPluginManager().registerEvents(new ServerSwitch(this), this);
		getCommand("Premium").setExecutor(new Premium());

		getCommand("addclays").setExecutor(new AddClays());
		getCommand("setevent").setExecutor(new SetEvent());
		File file = new File("plugins//Lobby//event.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		File file1 = new File("plugins//Lobby//data.yml");
		YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
		try{
			
		}catch(Exception e1){
			
		}
		if(cfg.getString("Event") == null){
			cfg.set("Event", "Nicht eingetragen...");
			try {
				cfg.save(file);
			} catch (IOException e) {}
		}
		ScorebardEvent = cfg.getString("Event");


	
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				int sw = 0;
				getPlayerCount("SkyWars-01");
				sw = sw + playerCounts.get("SkyWars-01");
				getPlayerCount("SkyWars-02");
				sw = sw + playerCounts.get("SkyWars-02");
				getPlayerCount("SkyWars-03");
				sw = sw + playerCounts.get("SkyWars-03");
				SkyWars = sw;
				getPlayerCount("Lobby-01");
				Lobby1 = playerCounts.get("Lobby-01");
				getPlayerCount("Lobby-02");
				Lobby2 = playerCounts.get("Lobby-02");
				getPlayerCount("KitBattle-01");
				kitbattle = playerCounts.get("KitBattle-01");
				getPlayerCount("KBFFA-01");
				int kbffa = 0;
				kbffa = kbffa + playerCounts.get("KBFFA-01");
				getPlayerCount("KBFFA-02");
				kbffa = kbffa + playerCounts.get("KBFFA-02");
				getPlayerCount("KBFFA-03");
				kbffa = kbffa + playerCounts.get("KBFFA-03");	
				knockbackffa = kbffa;
				getPlayerCount("SoupPvP");
				SoupPvP = playerCounts.get("SoupPvP");
				getPlayerCount("Community");
				Community = playerCounts.get("Community");
				getPlayerCount("KnockPvP");
				KnockPvP = playerCounts.get("KnockPvP");
				int freebuild = 0;
				getPlayerCount("Freebuild-01");
				freebuild = freebuild + playerCounts.get("Freebuild-01");
				getPlayerCount("Freebuild-02");
				freebuild = freebuild + playerCounts.get("Freebuild-02");
				FreeBuild = freebuild;
				getPlayerCount("Bauevent");
				Bauevent = playerCounts.get("Bauevent");
				int cw = 0;
				getPlayerCount("ClayWars-01");
				cw = cw + playerCounts.get("ClayWars-01");
				getPlayerCount("ClayWars-02");
				cw = cw + playerCounts.get("ClayWars-02");
				getPlayerCount("ClayWars-03");
				cw = cw + playerCounts.get("ClayWars-03");
				getPlayerCount("ClayWars-04");
				cw = cw + playerCounts.get("ClayWars-04");
				getPlayerCount("ClayWars-05");
				cw = cw + playerCounts.get("ClayWars-05");
				getPlayerCount("ClayWars-06");
				cw = cw + playerCounts.get("ClayWars-06");
				getPlayerCount("ClayWars-07");
				cw = cw + playerCounts.get("ClayWars-07");
				getPlayerCount("ClayWars-08");
				cw = cw + playerCounts.get("ClayWars-08");
				getPlayerCount("ClayWars-09");
				cw = cw + playerCounts.get("ClayWars-09");
				ClayWars = cw;
				totalplayers = kitbattle + cw + knockbackffa + BashIT + SkyWars1vs1 + FreeBuild + Spawn + SkyWars + Lobby1 + Lobby2 + Community + KnockPvP + SoupPvP + sw;

			}
		}, 20, 20);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				message++;
				for(Player all : Bukkit.getOnlinePlayers()){
					Scoreboard.setScoreboard(all);
					try{
						
						if(message == 1){
							sendActionBar(all, "§9§lClayMC §8» §6Server-Netzwerk §8«");
						}
						if(message == 2){
							sendActionBar(all, "§7» §6Shop: §3claymc.net/shop §7«");
						}
						if(message == 3){
							sendActionBar(all, "§7» §6Forum: §3claymc.net/forum §7«");
						}
						if(message == 4){
							sendActionBar(all, "§7» §eViel Spaß auf dem Netzwerk §7«");
							message = 0;
						}
						
					}catch(Exception e1){}
					
				}
				
			}
		}, 20, 200);
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
	}
	public static void setFireBoots(Player p){
		if(DATA.fireboots.contains(p)){
			ItemStack b = new ItemStack(Material.LEATHER_BOOTS);
		    LeatherArmorMeta bm = (LeatherArmorMeta)b.getItemMeta();
		    bm.setDisplayName("§6Feuerschuhe");
		    bm.setColor(Color.ORANGE);
		    b.setItemMeta(bm);
		}
	}
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;        
        try {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
                String command = in.readUTF();                
                if (command.equals("PlayerCount")) {
                        String server = in.readUTF();
                        int playerCount = in.readInt();
                        playerCounts.put(server, playerCount);                          
                }
        } catch (Exception e) {
                e.printStackTrace();
        }
}
	    
	   
	    public int getCount(String server) {
	       
	        if (server == null) {
	            server = "ALL";
	        }
	       
	        ByteArrayDataOutput out = ByteStreams.newDataOutput();
	        out.writeUTF("PlayerCount");
	        out.writeUTF(server);
			return playerCounts.get(server);

	       
	    }
		public static void sendActionBar(Player p, String message) {
			 
	        PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
	 
	        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
	        PacketPlayOutChat packet = new PacketPlayOutChat(icbc, (byte)2);
	 
	        connection.sendPacket(packet);
	    }
	  
		 public static void getPlayerCount(String Server){
		        try {        
		            final ByteArrayOutputStream b = new ByteArrayOutputStream();
		            final DataOutputStream out = new DataOutputStream(b);            
		            out.writeUTF("PlayerCount");
		            out.writeUTF(Server);            
		            Bukkit.getServer().sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
		        } catch (IOException e2) {
		            e2.printStackTrace();
		        }        
		    }
		
		public void loadPlayers(){
			getPlayerCount("Lobby-01");
			Lobby1 = playerCounts.get("Lobby-01");
			getPlayerCount("Lobby-02");
			Lobby2 = playerCounts.get("Lobby-02");
			getPlayerCount("KitBattle-01");
			kitbattle = playerCounts.get("KitBattle-01");
			getPlayerCount("KnockbackFFA-01");
			int kbffa = 0;
			kbffa = kbffa + playerCounts.get("KnockbackFFA-01");
			getPlayerCount("KnockbackFFA-02");
			kbffa = kbffa + playerCounts.get("KnockbackFFA-02");
			knockbackffa = kbffa;
			int bashit = 0;
			getPlayerCount("BashIT-01");
			bashit = bashit + playerCounts.get("BashIT-01");
			getPlayerCount("BashIT-02");
			bashit = bashit + playerCounts.get("BashIT-02");
			getPlayerCount("BashIT-03");
			bashit = bashit + playerCounts.get("BashIT-03");
			
			int skywars = 0;
			getPlayerCount("SkyWars-01");
			skywars = skywars + playerCounts.get("SkyWars-01");
			getPlayerCount("SkyWars-02");
			skywars = skywars + playerCounts.get("SkyWars-02");
			getPlayerCount("SkyWars-03");
			skywars = skywars + playerCounts.get("SkyWars-03");
			SkyWars = skywars;
			int sw1vs1 = 0;
			getPlayerCount("1vs1-01");
			sw1vs1 = sw1vs1 + playerCounts.get("1vs1-01");
			getPlayerCount("1vs1-02");
			sw1vs1 = sw1vs1 + playerCounts.get("1vs1-02");
			getPlayerCount("1vs1-03");
			sw1vs1 = sw1vs1 + playerCounts.get("1vs1-03");
			SkyWars1vs1 = sw1vs1;
			int freebuild = 0;
			getPlayerCount("Freebuild-01");
			freebuild = freebuild + playerCounts.get("Freebuild-01");
			getPlayerCount("Freebuild-02");
			freebuild = freebuild + playerCounts.get("Freebuild-02");
			FreeBuild = freebuild;
		}

		public static String getMOTD(String ip, int port) {
	        String returnString = null;
	        try {
	            Socket sock = new Socket();
	            sock.setSoTimeout(100);
	            sock.connect(new InetSocketAddress(ip, port), 100);

	            DataOutputStream out = new DataOutputStream(sock.getOutputStream());
	            DataInputStream in = new DataInputStream(sock.getInputStream());

	            out.write(0xFE);

	            int b;
	            StringBuffer str = new StringBuffer();
	            while ((b = in .read()) != -1) {
	                if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
	                    str.append((char) b);
	                }
	            }

	            String[] data = str.toString().split("§");
	            String serverMotd = data[0];
	            returnString = String.format(serverMotd);
	           
	            sock.close();

	        } catch (ConnectException e) {
	            returnString = "OFFLINE";
	        } catch (UnknownHostException e) {
	            // TODO Auto-generated catch block
	            returnString = "OFFLINE";
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            returnString = "OFFLINE";
	        }
	        return returnString;
	    }
		  public static Main getInstance(){
		        return instance;
		      }
}
