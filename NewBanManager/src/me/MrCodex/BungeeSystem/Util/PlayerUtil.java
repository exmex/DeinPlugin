/*    */ package me.MrCodex.BungeeSystem.Util;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class PlayerUtil
/*    */ {
/*    */   public static String getUUID(String playername)
/*    */   {
/* 10 */     return UUID.nameUUIDFromBytes(
/* 11 */       ("OfflinePlayer:" + playername).getBytes(Charsets.UTF_8))
/* 12 */       .toString();
/*    */   }
/*    */ }
