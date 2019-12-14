/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import java.util.List;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class BanList extends Command
/*    */ {
/*    */   public BanList()
/*    */   {
/* 11 */     super("banlist");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.banlist")) {
/* 18 */       if (BanManager.getBannedPlayers().size() == 0) {
/* 19 */         sender.sendMessage(Data.prefix + "§7Derzeit sind keine §cSpieler §7gebannt.");
/* 20 */         return;
/*    */       }
/* 22 */       sender.sendMessage(Data.prefix + "§7Diese §cSpieler §7sind derzeit gebannt:");
/* 23 */       for (String x : BanManager.getBannedPlayers())
/* 24 */         sender.sendMessage(Data.prefix + "§c" + x + " §8| §7/check§c " + x);
/*    */     }
/*    */     else {
/* 27 */       sender.sendMessage(Data.prefix + "§7Dieser §cBefehl§7 existiert nicht.");
/*    */     }
/*    */   }
/*    */ }
