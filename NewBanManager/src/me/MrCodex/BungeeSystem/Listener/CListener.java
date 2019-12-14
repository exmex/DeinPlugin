/*    */ package me.MrCodex.BungeeSystem.Listener;
/*    */ 
/*    */ import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Main;
import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.Util.MuteManager;
import me.MrCodex.HubAPI.Hu;
import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ 
/*    */ public class CListener
/*    */   implements Listener
/*    */ {
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onsecond(PostLoginEvent e) {
		  if(ProxyServer.getInstance().getOnlineCount() > Config.Config.MaxPlayers) {
			  if(!e.getPlayer().hasPermission("bungeecord.premiumlobby")) {
				  e.getPlayer().disconnect(Data.prefix + 
			              "§7Das maximale §cSpielerLimit §7von §c" + Config.Config.MaxPlayers + "§7 ist erreicht. \n §c \n §7Nur noch §cSpieler §7mit dem §cPremiumRang §7können noch §cJoinen§7! \n §7TeamSpeak: §cClayMC.net");
		  }
		  }
	}
	
	
	  @EventHandler
	    public void onPostLogin(final PostLoginEvent event) {
		 final ProxiedPlayer p = event.getPlayer();
		 Hu.send(p);
		  ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
			if(Main.playerconf.get("Spieler" + p.getName()) == null) {
              Main.playerconf.set("Spieler" + p.getName(), p.getName());
              Main.playerconf.set("Amount", Main.playerconf.getInt("Amount") + 1);
				for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
					all.sendMessage("§7———————————————————————————————————————————————————————————");
					all.sendMessage(" ");
					all.sendMessage(" ");
					all.sendMessage(Data.prefix + "§c" + p.getName() + "§7 ist neu auf dem §cServer§7! §8§l[ §c§l#" + Main.playerconf.getInt("Amount") +"§8§l ]");
					all.sendMessage(" ");
					all.sendMessage(" ");
					all.sendMessage("§7———————————————————————————————————————————————————————————");
				}
				try {
					ConfigurationProvider.getProvider(YamlConfiguration.class).save(Main.playerconf, Main.playerfile);
				} catch (IOException e) {
				}

			}
			
			}
			
			
		}, 2, TimeUnit.SECONDS);

	    }
	  
	  
	public static ArrayList<ProxiedPlayer> list = new ArrayList<ProxiedPlayer>();
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void onChat(ChatEvent e) {
/*    */   	ProxiedPlayer ps = (ProxiedPlayer)e.getSender();

   if(e.getMessage().equalsIgnoreCase("/help")) {
	   e.setCancelled(true);
	   ps.sendMessage("§7§l§m-----------------------------------------");
	   ps.sendMessage(" ");
	   ps.sendMessage(Data.prefix + "§7Zeige deine Freunde: §c/friend");
	   ps.sendMessage(Data.prefix + "§7Erstelle eine Party: §c/party");
	   ps.sendMessage(Data.prefix + "§7Betrete die Lobby: §c/hub");
	   ps.sendMessage(Data.prefix + "§7Zeige deine Stats: §c/stats");
	   ps.sendMessage(Data.prefix + "§7Zeige Informationen über den YouTuber Rang: §c/youtuber");
	   ps.sendMessage(Data.prefix + "§7Spende für den Server: §c/gold /hero /ultra");
	   ps.sendMessage(" ");
	   ps.sendMessage("§7§l§m-----------------------------------------");

   }
	   if(e.getMessage().startsWith("/aac")) {
		   ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		   p.sendMessage("Unknown command. Type " + "'/help'" + " for help.");
		   e.setCancelled(true);
		   return;
	   } else if(e.getMessage().startsWith("/aac:aac")) {
		   ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		   p.sendMessage("Unknown command. Type " + "'/help'" + " for help.");
		   e.setCancelled(true);
		   return;
	   }  else if(e.getMessage().startsWith("/AAC:AAC")) {
		   ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		   p.sendMessage("Unknown command. Type " + "'/help'" + " for help.");
		   e.setCancelled(true);
		   return;
	   } else if(e.getMessage().startsWith("/AAC")) {
		   ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		   p.sendMessage("Unknown command. Type " + "'/help'" + " for help.");
		   e.setCancelled(true);
		   return;
	   }
	   
/* 17 */     final ProxiedPlayer p = (ProxiedPlayer)e.getSender();
if(!e.getMessage().startsWith("/")) {
	if(!p.hasPermission("System.ban")) {
      if(list.contains(p)) {
    	  e.setCancelled(true);
    	  p.sendMessage(Data.prefix + "§cDeine Chatnachricht wurde nicht gesendet. Grund: Verdacht auf Spamming!");
      } else {
    	  list.add(p);
    	  ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
			
			@Override
			public void run() {

				list.remove(p);
			}
		}, 3, TimeUnit.SECONDS);
      }
	}
}
/* 18 */     String msg = e.getMessage();
/* 23 */     if (MuteManager.isMuted(p.getName())) {
/* 24 */       long current = System.currentTimeMillis();
/* 25 */       long end = MuteManager.getEnd(p.getName());
/* 26 */       if ((end < current) && (end != -1L)) {
/* 27 */         MuteManager.unMute(p.getName(), 
/* 28 */           "Automatische Cloud");
/* 29 */         e.setCancelled(false);
/*    */       }
/* 31 */       else if (!e.getMessage().startsWith("/")) {
/* 32 */         e.setCancelled(true);
/* 33 */         p.sendMessage(Data.prefix + "§7Der §cZugriff §7zum §cChat §7wird dir derzeit verweigert.");
/* 34 */         p.sendMessage(Data.prefix + "§7Grund: §c" + MuteManager.getReason(p.getName()));
/* 35 */         p.sendMessage(Data.prefix + "§7Verbleibende Zeit: §c" + MuteManager.getRemainingTime(p.getName()));
/*    */       }
/*    */     }
/*    */   }


/*    */ }
