/*    */ package me.MrCodex.BungeeSystem;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Commands.Ban;
import me.MrCodex.BungeeSystem.Commands.BanList;
import me.MrCodex.BungeeSystem.Commands.Check;
import me.MrCodex.BungeeSystem.Commands.ClearChat;
import me.MrCodex.BungeeSystem.Commands.Globalmute;
import me.MrCodex.BungeeSystem.Commands.JoinMe;
import me.MrCodex.BungeeSystem.Commands.Me;
import me.MrCodex.BungeeSystem.Commands.Mute;
import me.MrCodex.BungeeSystem.Commands.MuteList;
import me.MrCodex.BungeeSystem.Commands.Ping;
import me.MrCodex.BungeeSystem.Commands.Report;
import me.MrCodex.BungeeSystem.Commands.Reports;
import me.MrCodex.BungeeSystem.Commands.ServerJoinCommand;
import me.MrCodex.BungeeSystem.Commands.Strafe;
import me.MrCodex.BungeeSystem.Commands.TeamChat;
import me.MrCodex.BungeeSystem.Commands.TempBan;
import me.MrCodex.BungeeSystem.Commands.TempMute;
import me.MrCodex.BungeeSystem.Commands.UnBan;
import me.MrCodex.BungeeSystem.Commands.UnMute;
import me.MrCodex.BungeeSystem.Commands.Wartungs_Command;
import me.MrCodex.BungeeSystem.Commands.YouTuber;
import me.MrCodex.BungeeSystem.Commands.broadcast;
import me.MrCodex.BungeeSystem.Commands.restart_Command;
import me.MrCodex.BungeeSystem.Listener.CListener;
import me.MrCodex.BungeeSystem.Listener.JoinListener;
import me.MrCodex.BungeeSystem.Listener.PlayerLogin;
import me.MrCodex.BungeeSystem.MOTD.Command_Motd;
import me.MrCodex.BungeeSystem.MOTD.Command_SetMax;
import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.MOTD.Listener_Motds;
import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import me.MrCodex.BungeeSystem.Ranks.Command_Rank;
import me.MrCodex.BungeeSystem.Ranks.Database;
import me.MrCodex.BungeeSystem.Util.Files;
import me.MrCodex.HubAPI.Hub_Command;
import me.MrCodex.HubAPI.L_Command;
import me.MrCodex.HubAPI.Leave_Command;
import me.MrCodex.HubAPI.Lobby_Command;
import me.MrCodex.Party.Cmd;
import me.MrCodex.Party.Cmd_Chat;
import me.MrCodex.Party.Events;
import me.MrCodex.Warns.ChatListener;
import me.MrCodex.Warns.Command_Warn;
import me.MrCodex.Warns.Command_Warns;
import me.MrCodex.Warns.Command_WerbungList;
/*    */ import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.api.plugin.PluginManager;
/*    */ import net.md_5.bungee.config.ConfigurationProvider;
/*    */ import net.md_5.bungee.config.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main extends Plugin
/*    */ {
/*    */   public static boolean updateAvailable;
/* 28 */   PluginManager pm = BungeeCord.getInstance().getPluginManager();
/*    */   public static Main plugin;
private List<String> wort= new ArrayList<>();
private List<String> ads = new ArrayList();
private List<String> plugins = new ArrayList();
public static Database dbConfig = null;
public static int intege = 0;

public static File playerfile;
public static net.md_5.bungee.config.Configuration playerconf;

/*    */   public void onEnable()
/*    */   {
	         plugin = this;
			  Config.LoadConfig(this);
			    this.ads.addAll(Arrays.asList(new String[] { ".arpa",":2", ".to", ".tk", ".eu", ".me", ".biz", ".com", ".info", ".name", ".net", ".org", ".pro", ".aero", ".asia", 
			      ".cat", ".coop", ".edu", ".gov", ".int", ".jobs", ".mil", ".mobi", ".museum", ".post", ".tel", ".de", ".travel", ".xxx", "joint",".gs",". to", ". tk", ". eu", ". me", ". biz", ". com", ". info", ". name", ". net", ". org", ". pro", ". aero", ". asia", 
			      ". cat", ". coop", ". edu", ". gov", ". int", ". jobs", ". mil", ". mobi", ". museum", ". post", ". tel", ". de", ". travel", ". xxx", "joint",". gs","kommt alle auf","(.)","(Punkt)","gommehd","revayd","sevenpvp","lightningpvp","cytooxien","rewinside",".n e t","n e t", "d e", ". com", ". de", ",net",",de", ",com",",tk", ", n e t" }));
			    this.plugins.addAll(Arrays.asList(new String[] { "/plugins","/demote","/promote","/permissionsex:","/pex", "/pl", "/?", "/help", "/bungee", "/me","/bukkit:plugins", "/bukkit:pl", "/bukkit:?", "/bukkit:help", "/bukkit:me", "/version" }));
			    this.wort.addAll(Arrays.asList(new String[] { "ez","noob","l2p","eZ","EZ","ficken", "hurensohn", "missgeburt", "bastard", "basti", "spast", "spasti", "huren","huso", "l2p", "eZ","ez"}));
/* 33 */     try {
			    createFolders();
} catch (Exception e1) {
	
}
/* 34 */     Files.setDefaultConfig();


try{
	if(!getDataFolder().exists()){
		getDataFolder().mkdir();
	}
	playerfile = new File(getDataFolder().getPath(), "playerconf.yml");
	if(!playerfile.exists()){
		playerfile.createNewFile();
		playerconf = ConfigurationProvider.getProvider(YamlConfiguration.class).load(playerfile);
		playerconf.set("Amount", 0);
		ConfigurationProvider.getProvider(YamlConfiguration.class).save(playerconf, playerfile);
	}
	playerconf = ConfigurationProvider.getProvider(YamlConfiguration.class).load(playerfile);
}catch(IOException e){
	System.err.println("Error not create File config.yml");
	return;
}






/* 35 */     this.pm.registerListener(this, new PlayerLogin());
             this.pm.registerCommand(this, new broadcast());
/* 36 */     this.pm.registerCommand(this, new Ban());
/* 36 */     this.pm.registerCommand(this, new Strafe());
/* 37 */     this.pm.registerCommand(this, new UnBan());
/* 38 */     this.pm.registerCommand(this, new TempBan());
/* 39 */     this.pm.registerCommand(this, new BanList());
/* 40 */     this.pm.registerCommand(this, new Check());
/* 41 */     this.pm.registerListener(this, new CListener());
/* 42 */     this.pm.registerCommand(this, new Mute());
/* 43 */    this.pm.registerCommand(this, new UnMute());
/* 44 */    this.pm.registerCommand(this, new TempMute());
/* 47 */     this.pm.registerCommand(this, new MuteList());
             this.pm.registerCommand(this, new Cmd());
             this.pm.registerCommand(this, new Cmd_Chat());
            this.pm.registerCommand(this, new YouTuber());
             this.pm.registerCommand(this, new Ping());
             this.pm.registerCommand(this, new Globalmute());
             this.pm.registerCommand(this, new ClearChat());
             this.pm.registerCommand(this, new Me());
             this.pm.registerCommand(this, new me.MrCodex.BungeeSystem.Commands.Kick());
             this.pm.registerCommand(this, new restart_Command("restart"));
             this.pm.registerCommand(this, new Wartungs_Command("wartungen"));
             this.pm.registerCommand(this, new Wartungs_Command("wartungen"));
             this.pm.registerCommand(this, new TeamChat("tc"));
             this.pm.registerCommand(this, new Command_Motd("motd"));
             this.pm.registerCommand(this, new Command_SetMax("setmax"));
             this.pm.registerCommand(this, new Command_Rank("rechte"));
             this.pm.registerCommand(this, new Command_Warn("warn"));
             this.pm.registerCommand(this, new Command_Warns("warns"));
             this.pm.registerCommand(this, new Command_WerbungList("werbung"));
            this.pm.registerCommand(this, new Hub_Command());
          this.pm.registerCommand(this, new L_Command());    
           this.pm.registerCommand(this, new Leave_Command());    
          this.pm.registerCommand(this, new Lobby_Command());    
             new Events(this);
             pm.registerListener(this, new ChatListener());
             pm.registerListener(this, new Listener_Motds());
             pm.registerListener(this, new Manager_Chat());
             pm.registerListener(this, new JoinListener());
             pm.registerCommand(this, new JoinMe("joinme"));
             pm.registerCommand(this, new ServerJoinCommand("xyserverxyx"));
             this.pm.registerCommand(this, new Report());
             this.pm.registerCommand(this, new Reports());
             this.pm.registerCommand(this, new me.MrCodex.BungeeSystem.Commands.List());

             Timer timer = new Timer();
             Calendar date = Calendar.getInstance();
             date.set(Calendar.HOUR, 0);
             date.set(Calendar.MINUTE, 0);
             date.set(Calendar.SECOND, 0);
             date.set(Calendar.MILLISECOND, 0);
             timer.schedule(
               new TimerTask(),
               date.getTime(),
               1000 * 60 * 60 * 24
             );
             
             ProxyServer.getInstance().getScheduler().schedule(this, new Runnable() {
				
				@Override
				public void run() {
					if(intege == 4) {
						intege = 0;
					} else {
						intege++;
					}
					if(intege == 0) {
						for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
							all.sendMessage(" ");
							all.sendMessage(" ");
                            all.sendMessage(Data.prefix + "     §7Hier steht eine Nachricht!");
                            all.sendMessage(Data.prefix + "             §6Und hier eine weitere");
							all.sendMessage(" ");
							all.sendMessage(" ");
						}
					}
					if(intege == 1) {
						for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
							all.sendMessage(" ");
							all.sendMessage(" ");
                            all.sendMessage(Data.prefix + "     §7Hier steht eine Nachricht!");
                            all.sendMessage(Data.prefix + "             §6Und hier eine weitere");
							all.sendMessage(" ");
							all.sendMessage(" ");
						}
					}
					if(intege == 2) {
						for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
							all.sendMessage(" ");
							all.sendMessage(" ");
                            all.sendMessage(Data.prefix + "     §7Hier steht eine Nachricht!");
                            all.sendMessage(Data.prefix + "             §6Und hier eine weitere");
							all.sendMessage(" "); 
							all.sendMessage(" ");
						}
					}
					if(intege == 3) {
						for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
							all.sendMessage(" ");
							all.sendMessage(" ");
                            all.sendMessage(Data.prefix + "     §7Hier steht eine Nachricht!");
                            all.sendMessage(Data.prefix + "             §6Und hier eine weitere");
							all.sendMessage(" "); 
							all.sendMessage(" ");
						}
					}
				}
			},0 ,5 , TimeUnit.MINUTES);
             
 		    Listener_Motds.LoadMotds();
/*    */ 
/* 52 */     BungeeCord.getInstance().getConsole().sendMessage("BungeeCordSystem wurde geladen");
/*    */   }
/*    */ 
/*    */   public void onDisable()
/*    */   {
/* 60 */     BungeeCord.getInstance().getConsole().sendMessage("BungeeCordSystem wurde deaktiviert.");
/*    */   }
/*    */ 
/*    */   public void createFolders() {
/* 64 */     if (!getDataFolder().exists()) {
/* 65 */       getDataFolder().mkdir();
/*    */     }
/* 67 */     Files.BanFile = new File(getDataFolder().getPath(), "bans.yml");
/* 68 */     if (!Files.BanFile.exists()) {
/*    */       try {
/* 70 */         Files.BanFile.createNewFile();
/*    */       } catch (IOException e) {
/* 72 */         e.printStackTrace();
/*    */       }
/*    */     }
/* 75 */     Files.MuteFile = new File(getDataFolder().getPath(), "mutes.yml");
/* 76 */     if (!Files.MuteFile.exists())
/*    */       try {
/* 78 */         Files.MuteFile.createNewFile();
/*    */       } catch (IOException e) {
/* 80 */         e.printStackTrace();
/*    */       }
/*    */     try
/*    */     {
/* 84 */       Files.MuteConfig = ConfigurationProvider.getProvider(
/* 85 */         YamlConfiguration.class).load(Files.MuteFile);
/*    */     } catch (IOException e1) {
/* 87 */       e1.printStackTrace();
/*    */     }
/*    */     try {
/* 90 */       Files.BanConfig = ConfigurationProvider.getProvider(
/* 91 */         YamlConfiguration.class).load(Files.BanFile);
/*    */     } catch (IOException e) {
/* 93 */       e.printStackTrace();
/*    */     }
/*    */   }
public List<String> getAds() {
    return this.ads;
  }
  public List<String> getPlugins() {
	    return this.plugins;
	  }
  public List<String> getWort() {
	    return this.wort;
	  }
/*    */ }