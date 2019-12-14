/*    */ package me.MrCodex.BungeeSystem.Util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import net.md_5.bungee.config.Configuration;
/*    */ import net.md_5.bungee.config.ConfigurationProvider;
/*    */ import net.md_5.bungee.config.YamlConfiguration;
/*    */ 
/*    */ public class Files
/*    */ {
/*    */   public static Configuration BanConfig;
/*    */   public static File BanFile;
/*    */   public static Configuration MuteConfig;
/*    */   public static File MuteFile;
/*    */   public static Configuration MessagesConfiguration;
/*    */   public static File MsgFile;
/*    */ 
/*    */   public static void setDefaultConfig()
/*    */   {
/* 20 */     if (BanConfig.get("BannedPlayers") == null) {
/* 21 */       BanConfig.set("BannedPlayers", null);
/*    */       try {
/* 23 */         ConfigurationProvider.getProvider(YamlConfiguration.class)
/* 24 */           .save(BanConfig, BanFile);
/*    */       } catch (IOException e) {
/* 26 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void saveBanFile() {
/*    */     try {
/* 33 */       ConfigurationProvider.getProvider(YamlConfiguration.class).save(
/* 34 */         BanConfig, BanFile);
/*    */     } catch (IOException e) {
/* 36 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void saveMuteFile() {
/*    */     try {
/* 42 */       ConfigurationProvider.getProvider(YamlConfiguration.class).save(
/* 43 */         MuteConfig, MuteFile);
/*    */     } catch (IOException e) {
/* 45 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }
