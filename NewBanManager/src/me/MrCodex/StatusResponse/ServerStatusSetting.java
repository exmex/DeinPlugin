/*    */ package me.MrCodex.StatusResponse;
/*    */ 
/*    */ public class ServerStatusSetting
/*    */ {
/*    */   private String status;
/*    */   private Integer max;
/*    */   private Integer online;
/*    */ 
/*    */   public ServerStatusSetting(String ServerStatus, Integer OnlinePlayers, Integer MaxPlayers)
/*    */   {
/* 10 */     this.status = ServerStatus;
/* 11 */     this.max = MaxPlayers;
/*    */   }
/*    */ 
/*    */   public Integer getMaxPlayers() {
/* 15 */     return this.max;
/*    */   }
/*    */ 
/*    */   public Integer getOnlinePlayers() {
/* 19 */     return this.online;
/*    */   }
/*    */ 
/*    */   public String getServerStatus() {
/* 23 */     return this.status;
/*    */   }
/*    */ }