/*     */ package me.MrCodex.BungeeSystem.Util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import me.MrCodex.BungeeSystem.Data;
/*     */ import net.md_5.bungee.BungeeCord;
/*     */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*     */ import net.md_5.bungee.config.Configuration;
/*     */ 
/*     */ public class MuteManager
/*     */ {
/*  12 */   static Configuration cfg = Files.MuteConfig;
/*     */ 
/*     */   public static boolean exists(String playername)
/*     */   {
/*  16 */     return cfg.get("Players." + PlayerUtil.getUUID(playername)) != null;
/*     */   }
/*     */ 
/*     */   public static void createPlayer(String playername)
/*     */   {
/*  21 */     if (!exists(playername)) {
/*  22 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Playername", 
/*  23 */         playername);
/*  24 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Muted", 
/*  25 */         Boolean.valueOf(false));
/*  26 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Reason", "");
/*  27 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".By", "");
/*  28 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".End", Long.valueOf(0L));
/*  29 */       Files.saveMuteFile();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean isMuted(String playername)
/*     */   {
/*  35 */     if (exists(playername)) {
/*  36 */       return cfg.getBoolean("Players." + PlayerUtil.getUUID(playername) + 
/*  37 */         ".Muted");
/*     */     }
/*     */ 
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */   public static void Mute(String playername, String Reason, String von, int seconds)
/*     */   {
/*  46 */     if (!isMuted(playername)) {
/*  47 */       long current = System.currentTimeMillis();
/*  48 */       long end = current + seconds * 1000;
/*  49 */       if (seconds == -1) {
/*  50 */         end = -1L;
/*     */       }
/*  52 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Playername", 
/*  53 */         playername);
/*  54 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Muted", 
/*  55 */         Boolean.valueOf(true));
/*  56 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Reason", 
/*  57 */         Reason);
/*  58 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".By", 
/*  59 */         von);
/*  60 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".End", Long.valueOf(end));
/*  61 */       Files.saveBanFile();
/*     */       List muted;
/*  63 */       if (cfg.getStringList("MutedPlayers") != null)
/*  64 */         muted = cfg.getStringList("MutedPlayers");
/*     */       else {
/*  66 */         muted = new ArrayList();
/*     */       }
/*  68 */       muted.add(playername);
/*  69 */       cfg.set("MutedPlayers", muted);
/*  70 */       Files.saveMuteFile();
/*  71 */       for (ProxiedPlayer o : BungeeCord.getInstance().getPlayers()) {
	if(o.hasPermission("Server.Team")) {
/*  74 */         o.sendMessage(Data.prefix + "§7Der Spieler §c" + playername + " §7wurde §7gemuted.");
/*  75 */         o.sendMessage(Data.prefix + "§7Grund: §c" + Reason);
 				o.sendMessage(Data.prefix + "§7Von: §c" + von);
/*  76 */         o.sendMessage(Data.prefix + "§7Verbleibende Zeit§c " + getRemainingTime(playername));
	}
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void unMute(String playername, String By)
/*     */   {
/*  84 */     if (isMuted(playername)) {
/*  85 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Playername", 
/*  86 */         playername);
/*  87 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Muted", 
/*  88 */         Boolean.valueOf(false));
/*  89 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".Reason", "");
/*  90 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".By", "");
/*  91 */       cfg.set("Players." + PlayerUtil.getUUID(playername) + ".End", Long.valueOf(0L));
/*  92 */       Files.saveBanFile();
/*     */ 
/*  95 */       List banned = cfg.getStringList("MutedPlayers");
/*  96 */       banned.remove(playername);
/*  97 */       cfg.set("MutedPlayers", banned);
/*  98 */       Files.saveMuteFile();
/*  99 */       for (ProxiedPlayer o : BungeeCord.getInstance().getPlayers())
/* 100 */         if (o.hasPermission("Server.Team")) {
/* 101 */           o.sendMessage(Data.prefix + "Der Spieler §c" + playername + " §7wurde von §c" + By + " §7entmuted.");
/*     */     }
}
/*     */   }
/*     */ 
/*     */   public static List<String> getMutedPlayers()
/*     */   {
/* 108 */     return cfg.getStringList("MutedPlayers");
/*     */   }
/*     */ 
/*     */   public static String getReason(String playername) {
/* 112 */     String reason = "";
/* 113 */     if (isMuted(playername)) {
/* 114 */       reason = cfg.getString("Players." + PlayerUtil.getUUID(playername) + 
/* 115 */         ".Reason");
/*     */     }
/*     */ 
/* 118 */     return reason;
/*     */   }
/*     */ 
/*     */   public static String getWhoMuted(String playername) {
/* 122 */     String whomuted = "";
/* 123 */     if (isMuted(playername)) {
/* 124 */       whomuted = cfg.getString("Players." + 
/* 125 */         PlayerUtil.getUUID(playername) + ".By");
/*     */     }
/*     */ 
/* 128 */     return whomuted;
/*     */   }
/*     */ 
/*     */   public static long getEnd(String playername) {
/* 132 */     long end = -1L;
/*     */ 
/* 134 */     if (isMuted(playername)) {
/* 135 */       end = cfg.getLong("Players." + PlayerUtil.getUUID(playername) + 
/* 136 */         ".End");
/*     */     }
/*     */ 
/* 139 */     return end;
/*     */   }
/*     */ 
/*     */   public static String getRemainingTime(String playername) {
/* 143 */     String remainingTime = "";
/* 144 */     if (isMuted(playername)) {
/* 145 */       long current = System.currentTimeMillis();
/* 146 */       long end = getEnd(playername);
/* 147 */       long difference = end - current;
/* 148 */       if (end == -1L) {
/* 149 */         return "§4Permanent";
/*     */       }
/* 151 */       int Sekunden = 0;
/* 152 */       int Minuten = 0;
/* 153 */       int Stunden = 0;
/* 154 */       int Tage = 0;
/* 155 */       while (difference >= 1000L) {
/* 156 */         difference -= 1000L;
/* 157 */         Sekunden++;
/*     */       }
/* 159 */       while (Sekunden >= 60) {
/* 160 */         Sekunden -= 60;
/* 161 */         Minuten++;
/*     */       }
/* 163 */       while (Minuten >= 60) {
/* 164 */         Minuten -= 60;
/* 165 */         Stunden++;
/*     */       }
/* 167 */       while (Stunden >= 24) {
/* 168 */         Stunden -= 24;
/* 169 */         Tage++;
/*     */       }
/*     */ 
/* 172 */       remainingTime = "§b" + Tage + " Tag(e), " + Stunden + 
/* 173 */         " Stunde(n), " + Minuten + " Minute(n) " + Sekunden + " Sekunden";
/*     */     }
/* 175 */     return remainingTime;
/*     */   }
/*     */ }