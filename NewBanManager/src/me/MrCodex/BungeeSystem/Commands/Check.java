/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
import me.MrCodex.BungeeSystem.Util.MuteManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Check extends Command
/*    */ {
/*    */   public Check()
/*    */   {
/* 12 */     super("check");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 18 */     if (sender.hasPermission("system.check")) {
/* 19 */       if (args.length == 0) {
/* 20 */         sender.sendMessage(Data.prefix + "§7Ausführung: §c/check <Spieler>");
/*    */       } else {
/* 22 */         sender.sendMessage(Data.prefix + "§7Ban Informationen:");
/*    */ 
/* 24 */         sender.sendMessage("§7Spieler: §c" + args[0]);
/*    */ 
/* 27 */         if (BanManager.isBanned(args[0])) {
/* 28 */           sender.sendMessage("§7Gebannt");
/* 30 */           sender.sendMessage("§7Gebannt von: §c" + 
/* 31 */             BanManager.getWhoBanned(args[0]));
/* 32 */           sender.sendMessage("§7Grund: §c" + 
/* 33 */             BanManager.getReason(args[0]));
/* 34 */           sender.sendMessage("§7Verbleibende Zeit: §c" + 
/* 35 */             BanManager.getRemainingTime(args[0]));
/*    */         } else {
/* 37 */           sender.sendMessage("");
/* 38 */           sender.sendMessage("§7Nicht Gebannt.");
/* 39 */           sender.sendMessage("");
/*    */         }
/*    */ 
/* 42 */         if (MuteManager.isMuted(args[0])) {
/* 43 */           sender.sendMessage("");
/* 44 */           sender.sendMessage("§7Gemuted");
/* 45 */           sender.sendMessage("");
/* 46 */           sender.sendMessage("§7Gemuted von: §c" + 
/* 47 */             MuteManager.getWhoMuted(args[0]));
/* 48 */           sender.sendMessage("§7Grund: §c" + 
/* 49 */             MuteManager.getReason(args[0]));
/* 50 */           sender.sendMessage("§7Verbleibende Zeit: §c" + 
/* 51 */             MuteManager.getRemainingTime(args[0]));
/*    */         } else {
/* 53 */           sender.sendMessage("§7Nicht Gemuted,");
/* 54 */           sender.sendMessage("");
/*    */         }
/*    */       }
/*    */     }
/*    */     else
/* 59 */       sender.sendMessage(Data.prefix + "§7Dieser Befehl existiert nicht.");
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.Check
 * JD-Core Version:    0.6.0
 */