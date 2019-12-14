/*    */ package me.MrCodex.StatusResponse;
/*    */ 
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ 
/*    */ public class StatusResponse
/*    */ {
/*    */   private ServerInfo _server;
/*    */   private String _ServerMotd;
/*    */   private Integer _OnlinePlayers;
/*    */   private Integer _MaxPlayers;
/*    */   private Boolean _isOnline;
/*    */ 
/*    */   public StatusResponse(ServerInfo Info, Boolean isOnline, String ServerMotd, Integer OnlinePlayers, Integer MaxPlayers)
/*    */   {
/* 14 */     this._server = Info;
/* 15 */     this._isOnline = isOnline;
/* 16 */     this._ServerMotd = ServerMotd;
/* 17 */     this._OnlinePlayers = OnlinePlayers;
/* 18 */     this._MaxPlayers = MaxPlayers;
/*    */   }
/*    */ 
/*    */   public ServerInfo getServerInfo() {
/* 22 */     return this._server;
/*    */   }
/*    */ 
/*    */   public String getServerMotd() {
/* 26 */     return this._ServerMotd;
/*    */   }
/*    */ 
/*    */   public Integer getMaxPlayers() {
/* 30 */     return this._MaxPlayers;
/*    */   }
/*    */ 
/*    */   public Integer getOnlinePlayers() {
/* 34 */     return this._OnlinePlayers;
/*    */   }
/*    */ 
/*    */   public Boolean isOnline() {
/* 38 */     return this._isOnline;
/*    */   }
/*    */ }
