/*    */ package me.MrCodex.BungeeSystem.MOTD;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;

import me.MrCodex.BungeeSystem.Data;
/*    */ import net.cubespace.Yamler.Config.Config;
/*    */ import net.cubespace.Yamler.Config.InvalidConfigurationException;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ 
/*    */ public class Settings extends Config
/*    */ {
/* 19 */   public Integer MaxPlayers = Integer.valueOf(1);
/*    */ 
/* 21 */   public Boolean isLocked = Boolean.valueOf(false);
/*    */ 
/* 23 */   public Boolean noIPs = Boolean.valueOf(true);
/*    */ 
/* 25 */   public Boolean AutoMessagesEnabled = Boolean.valueOf(false);
/*    */ 
/* 27 */   public String AutoMessagesPrefix = "&3[&bAutoMessager&3]&7";
           public String Prefix = Data.prefix;
/*    */ 
/* 29 */   public ArrayList<String> AutoMessages = new ArrayList();
/*    */ 
/* 31 */   public Boolean useMotds = Boolean.valueOf(true);
/*    */ 
/* 33 */   public String DefaultMotd = "&cDein Server ";
/*    */ 
/* 35 */   public ArrayList<String> RandomMotds = new ArrayList();
/*    */ 
/* 37 */   public ArrayList<String> MutedPlayers = new ArrayList();
public ArrayList<String> MutedWerbung = new ArrayList();
public ArrayList<String> Werbungsserver = new ArrayList();
/*    */ 
/* 39 */   public Integer MaxWarns = Integer.valueOf(8);
/*    */ 
/* 41 */   public ArrayList<String> PlayerWarns = new ArrayList();
/*    */ 
/* 43 */   public ArrayList<String> BannedPlayers = new ArrayList();
/*    */ 
/* 45 */   public Integer TimeBanDays = Integer.valueOf(0);
/*    */ 
/*    */   public Settings(Plugin plugin)
/*    */   {
/* 10 */     this.CONFIG_HEADER = new String[] { "Einstellungen f�r System" };
/* 11 */     this.CONFIG_FILE = new File(plugin.getDataFolder(), "einstellungen.yml");
/*    */     try {
/* 13 */       init();
/*    */     } catch (InvalidConfigurationException ex) {
/* 15 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ }