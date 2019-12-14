/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class UnBan extends Command
/*    */ {
/*    */   public UnBan()
/*    */   {
/* 11 */     super("unban");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.ban")) {
/* 18 */       if (args.length != 1) {
/* 19 */         sender.sendMessage(Data.prefix + "§7Ausführung:§c /unban <Spieler>");
/*    */       } else {
/* 21 */         if (!BanManager.isBanned(args[0])) {
/* 22 */           sender.sendMessage(Data.prefix + "§7Dieser §cSpieler §7ist nicht gebannt.");
/* 23 */           return;
/*    */         }
/* 25 */         sender.sendMessage(Data.prefix + "§7Der §cSpieler §7wurde entbannt.");
/* 26 */         BanManager.unBan(args[0], sender.getName());
/*    */       }
/*    */     }
/* 29 */     else sender.sendMessage(Data.prefix + "§7Der §cBefehl§7 existiert nicht.");
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.UnBan
 * JD-Core Version:    0.6.0
 */