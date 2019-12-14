/*    */ package me.MrCodex.Party;
/*    */ 
/*    */ /*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.event.PlayerDisconnectEvent;
/*    */ import net.md_5.bungee.api.event.ServerSwitchEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Events
/*    */   implements Listener
/*    */ {
/*    */   public Events(Plugin main)
/*    */   {
/* 16 */     ProxyServer.getInstance().getPluginManager().registerListener(main, this);
/*    */   }
/* 20 */   @EventHandler
/*    */   public void onSwitch(ServerSwitchEvent e) { ProxiedPlayer p = e.getPlayer();
/* 21 */     if (Party.partyfuehrer.contains(p.getName()))
/*    */     {
/* 24 */       ServerInfo si = p.getServer().getInfo();
/*    */ 
/* 26 */       p.sendMessage(Party.pr + "§7Die Party hat den Server §c" + si.getName() + "§7 betreten.");
/* 27 */       for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers())
/*    */       {
/* 29 */         if ((!Party.inparty.containsKey(x.getName())) || 
/* 30 */           (Party.inparty.get(x.getName()) != p.getName())) continue;
/* 26 */       p.sendMessage(Party.pr + "§7Die Party hat den Server §d" + si.getName() + "§7 betreten.");
/* 32 */         x.connect(si);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void leave(PlayerDisconnectEvent e)
/*    */   {
/* 45 */     ProxiedPlayer p = e.getPlayer();
/* 46 */     if (Party.partyfuehrer.contains(p.getName()))
/* 47 */       Party.leave(p);
            
/*    */   }
/*    */ }
