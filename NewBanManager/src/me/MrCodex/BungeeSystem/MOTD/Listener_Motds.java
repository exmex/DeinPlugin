/*    */ package me.MrCodex.BungeeSystem.MOTD;
/*    */ 
/*    */ /*    */ import java.util.HashMap;
/*    */ import java.util.Random;

/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.ServerPing;
/*    */ import net.md_5.bungee.api.event.ProxyPingEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Listener_Motds
/*    */   implements Listener
/*    */ {
/* 15 */   public static HashMap<String, String> PlayerData = new HashMap();
/* 16 */   private static ServerPing.PlayerInfo[] OnlineScore = null;
/* 17 */   static String NewLine = System.getProperty("line.separator");
/*    */ 
/*    */   public static void LoadMotds() {
/* 20 */     PlayerData.clear();
/* 21 */     if (NewLine.length() == 2) {
/* 22 */       NewLine = NewLine.substring(1, 2);
/*    */     }
/* 24 */     OnlineScore = getOnlinePlayers();
/*    */   }
/*    */ 
/*    */   private static ServerPing.PlayerInfo[] getOnlinePlayers() {
/* 28 */     String s = Config.Config.DefaultMotd;
/* 29 */     while (s.startsWith(" ")) {
/* 30 */       s = s.substring(1);
/*    */     }
/* 32 */     while (s.endsWith(" ")) {
/* 33 */       s = s.substring(0, s.length() - 1);
/*    */     }
/* 35 */     ServerPing.PlayerInfo[] PlayerInfo = { 
/* 36 */       new ServerPing.PlayerInfo(ChatColor.BLACK + " ", ""), 
/* 37 */       new ServerPing.PlayerInfo(ChatColor.BLACK + "  " + 
/* 38 */       ChatColor.WHITE + s.replace("&", "§") + 
/* 39 */       ChatColor.BLACK + "  ", ""), 
/* 40 */       new ServerPing.PlayerInfo(ChatColor.BLACK + " ", "") };
/* 41 */     return PlayerInfo;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onEvent(ProxyPingEvent event) {
/* 47 */     ServerPing.Players OnlinePlayers = new ServerPing.Players(Config.Config.MaxPlayers.intValue(), 
/* 48 */       ProxyServer.getInstance().getOnlineCount(), event.getResponse()
/* 49 */       .getPlayers().getSample());
/* 50 */     if ((event.getConnection().getVersion() == 4) || 
/* 51 */       (event.getConnection().getVersion() == 5)) {
/* 52 */       OnlinePlayers = new ServerPing.Players(Config.Config.MaxPlayers.intValue(),
/* 53 */         ProxyServer.getInstance().getOnlineCount(), OnlineScore);
/*    */     }
/* 55 */     String ServerImage = "";
/* 56 */     if (event.getResponse().getFavicon() != null) {
/* 57 */       ServerImage = event.getResponse().getFavicon();
/*    */     }
/* 59 */     if (Manager_Chat.Wartungen.booleanValue()) {
/* 60 */       event.setResponse(
/* 65 */         new ServerPing(new ServerPing.Protocol(ChatColor.RED +"Wartungsmodus " + ChatColor.GRAY + ProxyServer.getInstance().getOnlineCount() + ChatColor.DARK_GRAY + "/" + ChatColor.GRAY + Config.Config.MaxPlayers, 0), OnlinePlayers, 
/* 62 */         Config.Config.DefaultMotd.replace("&", "§") + NewLine + 
/* 63 */         ChatColor.DARK_RED + 
/* 64 */         "§7Der §cWartungsmodus§7 ist derzeit aktiviert!", 
/* 65 */         ServerImage));
/* 66 */       return;
/*    */     }
/* 68 */     ServerPing.Protocol Version = new ServerPing.Protocol("§4§lFalsche Version!", event
/* 69 */       .getResponse().getVersion().getProtocol());
/* 70 */     if (Config.Config.useMotds.booleanValue())
/*    */     {
/* 72 */       if (PlayerData.containsKey(event.getConnection().getAddress()
/* 72 */         .getAddress().toString().replace("/", ""))) {
/* 73 */         String Message = "";
/* 74 */         if (Config.Config.RandomMotds.isEmpty()) {
/* 75 */           Message = "";
/*    */         } else {
/* 77 */           Random r = new Random();
/* 78 */           Message = (String)Config.Config.RandomMotds.get(r
/* 79 */             .nextInt(Config.Config.RandomMotds.size()));
/*    */         }
/* 81 */         event.setResponse(
/* 91 */           new ServerPing(Version, OnlinePlayers, 
/* 82 */           Config.Config.DefaultMotd.replace("&", "§") + 
/* 83 */           ChatColor.RESET + 
/* 84 */           NewLine + 
/* 85 */           ChatColor.RESET + 
/* 86 */           Message.replace("&", "§").replace(
/* 87 */           "%player%", 
/* 88 */           (CharSequence)PlayerData.get(event.getConnection()
/* 89 */           .getAddress().getAddress()
/* 90 */           .toString().replace("/", ""))), 
/* 91 */           ServerImage));
/*    */       } else {
/* 93 */         Integer count = Integer.valueOf(0);
/* 94 */         String Message = "%player%";
/* 95 */         if (!Config.Config.RandomMotds.isEmpty()) {
/* 96 */           while ((count.intValue() <= 10) && (Message.contains("%player%"))) {
/* 97 */             Random r = new Random();
/* 98 */             Message = (String)Config.Config.RandomMotds.get(r
/* 99 */               .nextInt(Config.Config.RandomMotds.size()));
/* 100 */             count = Integer.valueOf(count.intValue() + 1);
/*    */           }
/*    */         }
/* 103 */         count = Integer.valueOf(0);
/* 104 */         if (Message.contains("%player%")) {
/* 105 */           Message = "";
/*    */         }
/* 107 */         event.setResponse(
/* 110 */           new ServerPing(Version, OnlinePlayers, 
/* 108 */           Config.Config.DefaultMotd.replace("&", "§") + 
/* 109 */           ChatColor.RESET + NewLine + ChatColor.RESET + 
/* 110 */           Message.replace("&", "§"), ServerImage));
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\BungeeEssentails2.jar
 * Qualified Name:     me.Crusader_99.BungeeEssentails.Listener_Motds
 * JD-Core Version:    0.6.0
 */