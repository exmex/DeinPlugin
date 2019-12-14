/*    */ package me.MrCodex.BungeeSystem.Listener;
/*    */ 
/*    */ import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Main;
import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.Util.BanManager;
import me.MrCodex.BungeeSystem.Util.MuteManager;
import me.MrCodex.HubAPI.Hu;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ 
/*    */ public class PlayerLogin
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onLogin(LoginEvent e)
/*    */   {
/* 15 */     String playername = e.getConnection().getName();
/* 16 */     BanManager.createPlayer(playername);
/* 17 */     MuteManager.createPlayer(playername);
/* 18 */     if (BanManager.isBanned(playername)) {
/* 19 */       long current = System.currentTimeMillis();
/* 20 */       long end = BanManager.getEnd(playername);
/* 21 */       if ((end > current) || (end == -1L)) {
/* 22 */         e.setCancelled(true);
/* 23 */         e.setCancelReason(BanManager.getBannedMessage(playername));
/*    */       } else {
/* 25 */         e.setCancelled(false);
/* 26 */         BanManager.unBan(playername, "Automatische Cloud");
/*    */       }
/*    */     }
/*    */   }

  

           @EventHandler
           public void on(ServerConnectEvent e) {
        	   try {
   			for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
    			String header = "§7\n §7» §6DEIN SERVER §8✘ §fDein §6Netzwerk §7« \n §fDerzeit spielen §6 " + BungeeCord.getInstance().getOnlineCount() + "/" + Config.Config.MaxPlayers + " §fSpieler \n §7";
    			String footer = "§7\n §fServer §8» §6" + all.getServer().getInfo().getName() + " §8\n §fTeamSpeak §8» §6TS3.TS3.TS3.de§8 \n §fForum §8» §6FORUM.FORUM.DE \n§7";
    			
			 all.setTabHeader(new TextComponent(header) , new TextComponent(footer));

			}
      			} catch (Exception e1) {
       				
       			}	 
        		}
           
           @EventHandler
           public void on(ServerDisconnectEvent e) {
        	   try {
          			for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
            			String header = "§7\n §7» §6DEIN SERVER §8✘ §fDein §6Netzwerk §7« \n §fDerzeit spielen §6 " + BungeeCord.getInstance().getOnlineCount() + "/" + Config.Config.MaxPlayers + " §fSpieler \n §7";
            			String footer = "§7\n §fServer §8» §6" + all.getServer().getInfo().getName() + " §8\n §fTeamSpeak §8» §6TS3.TS3.TS3.de§8 \n §fForum §8» §6FORUM.FORUM.DE \n§7";
            			
        			 all.setTabHeader(new TextComponent(header) , new TextComponent(footer));

        			}
      			} catch (Exception e1) {
       				
       			}
        		}
           @EventHandler
           public void on(final ServerSwitchEvent e) {
        	   final String server = e.getPlayer().getServer().getInfo().getName();
        	   try {
        	   BungeeCord.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {

				@Override
				public void run() {
		   			for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
		    			String header = "§7\n §7» §6DEIN SERVER §8✘ §fDein §6Netzwerk §7« \n §fDerzeit spielen §6 " + BungeeCord.getInstance().getOnlineCount() + "/" + Config.Config.MaxPlayers + " §fSpieler \n §7";
		    			String footer = "§7\n §fServer §8» §6" + all.getServer().getInfo().getName() + " §8\n §fTeamSpeak §8» §6TS3.TS3.TS3.de§8 \n §fForum §8» §6FORUM.FORUM.DE \n§7";
		    			
					 all.setTabHeader(new TextComponent(header) , new TextComponent(footer));

					}
        		/*	for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
            			String header = "§7\n §7» §cClayMC.net §8✘ §c" + all.getServer().getInfo().getName() + " §7« \n §7Derzeit sind §c " + BungeeCord.getInstance().getOnlineCount() +"§7 Spieler Online \n §3";
            			String footer = "§7 \n §7TeamSpeak Server: §cClayMC.net \n §7Webseite / Forum: §cwww.ClayMC.net \n§7";
            			
        			 all.setTabHeader(new TextComponent(header) , new TextComponent(footer));
        			}*/
				}
        		   
        	   }, 15, TimeUnit.MILLISECONDS);
      			} catch (Exception e1) {
       				
       			}	 
        		}
/*    */ }
