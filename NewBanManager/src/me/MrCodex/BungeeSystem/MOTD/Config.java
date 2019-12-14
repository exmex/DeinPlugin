/*    */ package me.MrCodex.BungeeSystem.MOTD;
/*    */ 
/*    */ /*    */ import net.cubespace.Yamler.Config.InvalidConfigurationException;
import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class Config
/*    */ {
/*  8 */   public static Settings Config = null;
/*    */ 
/*    */   public static void LoadConfig(Plugin p)
/*    */   {
/* 12 */     Config = null;
/* 13 */     Config = new Settings(p);
/* 14 */     if (Config.MaxPlayers.intValue() == -1) {
/* 15 */       Config.MaxPlayers = 
/* 16 */         Integer.valueOf(ProxyServer.getInstance().getConfig()
/* 16 */         .getPlayerLimit());
/* 17 */       SaveConfig();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static boolean SaveConfig() {
/*    */     try {
/* 23 */       Config.save();
/* 24 */       return true; } catch (InvalidConfigurationException ex) {
/*    */     }
/* 26 */     return false;
/*    */   }
/*    */ }
