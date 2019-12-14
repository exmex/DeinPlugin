/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.MuteManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class UnMute extends Command
/*    */ {
/*    */   public UnMute()
/*    */   {
/* 11 */     super("unmute");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.mute")) {
/* 18 */       if (args.length < 1) {
/* 19 */         sender.sendMessage(Data.prefix + "§7Ausführung:§c /unmute <Spieler>");
/*    */       } else {
/* 21 */         if (!MuteManager.isMuted(args[0])) {
/* 22 */           sender.sendMessage(Data.prefix + "§7Dieser §cSpieler§7 ist nicht gemuted.");
/* 23 */           return;
/*    */         }
/* 25 */         sender.sendMessage(Data.prefix + "§7Dieser §cSpieler §7wurde erfolgreich entmuted.");
/* 26 */         MuteManager.unMute(args[0], sender.getName());
/*    */       }
/*    */     }
/* 29 */     else sender.sendMessage(Data.prefix + "§7Dieser §cBefehl§7 existiert nicht.");
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.UnMute
 * JD-Core Version:    0.6.0
 */