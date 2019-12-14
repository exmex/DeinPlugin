/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import java.util.List;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.MuteManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class MuteList extends Command
/*    */ {
/*    */   public MuteList()
/*    */   {
/* 11 */     super("mutelist");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.mutelist")) {
/* 18 */       if (MuteManager.getMutedPlayers().size() == 0) {
/* 19 */         sender.sendMessage(Data.prefix + "§7Es sind derzeit keine §cSpieler §7gemuted.");
/* 20 */         return;
/*    */       }
/* 22 */       sender.sendMessage(Data.prefix + "§7Diese §cSpieler §7sind derzeit Gemuted:");
/* 23 */       for (String x : MuteManager.getMutedPlayers())
/* 24 */         sender.sendMessage("§c" + x + " §8| §7/check " + x);
/*    */     }
/*    */     else {
/* 27 */       sender.sendMessage(Data.prefix + "§7Dieser §cBefehl§7 existiert nicht.");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.MuteList
 * JD-Core Version:    0.6.0
 */