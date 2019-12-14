/*    */ package me.MrCodex.Warns;
/*    */ 
/*    */ import java.util.ArrayList;

import me.MrCodex.BungeeSystem.MOTD.Config;
/*    */ 
/*    */ public class Manager_Warns
/*    */ {
/*    */   public static ArrayList<String> listWarns()
/*    */   {
/*  8 */     return Config.Config.PlayerWarns;
/*    */   }
/*    */ 
/*    */   public static Integer getWarns(String p) {
/* 12 */     for (String warn : Config.Config.PlayerWarns) {
/* 13 */       if (warn.split(" ")[0].equalsIgnoreCase(p)) {
/* 14 */         return Integer.valueOf(warn.split(" ")[1]);
/*    */       }
/*    */     }
/* 17 */     return Integer.valueOf(0);
/*    */   }
/*    */ 
/*    */   public static void addWarn(String p) {
/* 21 */     for (String warn : Config.Config.PlayerWarns) {
/* 22 */       if (warn.split(" ")[0].equalsIgnoreCase(p)) {
/* 23 */         Config.Config.PlayerWarns.remove(warn);
/* 24 */         Config.Config.PlayerWarns.add(p + " " + (
/* 25 */           Integer.valueOf(warn.split(" ")[1]).intValue() + 1));
/* 26 */         Config.SaveConfig();
/* 27 */         return;
/*    */       }
/*    */     }
/* 30 */     Config.Config.PlayerWarns.add(p + " 1");
/* 31 */     Config.SaveConfig();
/*    */   }
/*    */ 
/*    */   public static void setWarns(String p, Integer Warns) {
/* 35 */     for (String warn : Config.Config.PlayerWarns) {
/* 36 */       if (warn.split(" ")[0].equalsIgnoreCase(p)) {
/* 37 */         Config.Config.PlayerWarns.remove(warn);
/* 38 */         if (Warns.intValue() != 0) {
/* 39 */           Config.Config.PlayerWarns.add(p + " " + Warns);
/*    */         }
/* 41 */         Config.SaveConfig();
/* 42 */         return;
/*    */       }
/*    */     }
/* 45 */     if (Warns.intValue() != 0) {
/* 46 */       Config.Config.PlayerWarns.add(p + " " + Warns);
/* 47 */       Config.SaveConfig();
/*    */     }
/*    */   }
/*    */ }