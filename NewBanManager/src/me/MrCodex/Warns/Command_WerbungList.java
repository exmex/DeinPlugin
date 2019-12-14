/*    */ package me.MrCodex.Warns;
/*    */ 
/*    */ import java.util.ArrayList;

import me.MrCodex.BungeeSystem.MOTD.Config;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Command_WerbungList extends Command
/*    */ {
/*    */   public Command_WerbungList(String string)
/*    */   {
/*  9 */     super(string);
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 15 */     if (sender.hasPermission("system.werbungmute")){
/* 16 */       if (args.length == 1) {
/* 17 */         if ((args[0].equalsIgnoreCase("reset")) || 
/* 18 */           (args[0].equalsIgnoreCase("clear"))) {
/* 19 */           sender.sendMessage(
/* 20 */             Config.Config.Werbungsserver.size() + 
/* 21 */             " Server wurden gefunden.");
/* 22 */           Config.Config.Werbungsserver.clear();
/* 23 */           Config.SaveConfig();
/* 24 */           return;
/*    */         }
/* 26 */         sender.sendMessage(ChatColor.RED + "/werbunglist [clear]");
/*    */       }
/* 29 */       else if (Config.Config.Werbungsserver.size() < 19) {
/* 30 */         sender.sendMessage(ChatColor.DARK_AQUA + "----------" + 
/* 31 */           ChatColor.GOLD + "Es sind " + 
/* 32 */           Config.Config.Werbungsserver.size() + 
/* 33 */           " Server gefunden." + ChatColor.DARK_AQUA + 
/* 34 */           "----------");
/* 35 */         String OnlinePlayers = "";
/* 36 */         for (String s : Config.Config.Werbungsserver) {
/* 37 */           if (OnlinePlayers == "")
/* 38 */             OnlinePlayers = s.split(" ")[0];
/*    */           else {
/* 40 */             OnlinePlayers = OnlinePlayers + "," + 
/* 41 */               s.split(" ")[0];
/*    */           }
/*    */         }
/* 44 */         sender.sendMessage(ChatColor.DARK_RED + OnlinePlayers);
/*    */       } else {
/* 46 */         sender.sendMessage(ChatColor.RED + 
/* 47 */           "Die Server können nicht angezeigt werden. Grund:" + 
/* 48 */           ChatColor.YELLOW + " Zu viele Server.");
/*    */       }
/*    */   }else{
	sender.sendMessage("§cDafür hast du keine Rechte.");
}
}
/*    */ }
