/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class TempBan extends Command
/*    */ {
/*    */   public TempBan()
/*    */   {
/* 11 */     super("tempban");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.ban")) {
/* 18 */       if (args.length < 4) {
/* 19 */         sender.sendMessage(Data.prefix + "§7Ausführung:§c /ban <Spieler> <Zeit> <Zeitform> <Grund> ");
/*    */       } else {
/* 21 */         if (BanManager.isBanned(args[0])) {
/* 22 */           sender.sendMessage(Data.prefix + "§7Dieser §cSpieler §7ist bereits gebannt.");
/* 23 */           return;
/*    */         }
/* 25 */         String TimeUnit = args[2];
/* 26 */         String message = "";
/* 27 */         for (int i = 3; i < args.length; i++) {
/* 28 */           message = message + args[i] + " ";
/*    */         }
/* 30 */         int Time = Integer.parseInt(args[1]);
/* 31 */         if ((TimeUnit.equalsIgnoreCase("sec")) || 
/* 32 */           (TimeUnit.equalsIgnoreCase("s")) || 
/* 33 */           (TimeUnit.equalsIgnoreCase("second")) || 
/* 34 */           (TimeUnit.equalsIgnoreCase("seconds")) || 
/* 35 */           (TimeUnit.equalsIgnoreCase("secs"))) {
/* 36 */           sender.sendMessage(Data.prefix + "§7Der Spieler §c" + args[0] + "§7 wurde erfolreich gebannt.");
/*    */ 
/* 38 */           BanManager.Ban(args[0], message, sender.getName(), Time * 1);
/*    */         }
/* 40 */         else if ((TimeUnit.equalsIgnoreCase("min")) || 
/* 41 */           (TimeUnit.equalsIgnoreCase("minute")) || 
/* 42 */           (TimeUnit.equalsIgnoreCase("m")) || 
/* 43 */           (TimeUnit.equalsIgnoreCase("mins")) || 
/* 44 */           (TimeUnit.equalsIgnoreCase("minutes"))) {
/* 45 */           sender.sendMessage(Data.prefix + "§7Der Spieler §c" + args[0] + "§7 wurde erfolreich gebannt.");
/* 46 */           BanManager.Ban(args[0], message, sender.getName(), 
/* 47 */             Time * 60);
/*    */         }
/* 49 */         else if ((TimeUnit.equalsIgnoreCase("h")) || 
/* 50 */           (TimeUnit.equalsIgnoreCase("hour")) || 
/* 51 */           (TimeUnit.equalsIgnoreCase("hours"))) {
/* 52 */           sender.sendMessage(Data.prefix + "§7Der Spieler §c" + args[0] + "§7 wurde erfolreich gebannt.");
/* 53 */           BanManager.Ban(args[0], message, sender.getName(), 
/* 54 */             Time * 60 * 60);
/*    */         }
/* 56 */         else if ((TimeUnit.equalsIgnoreCase("d")) || 
/* 57 */           (TimeUnit.equalsIgnoreCase("day")) || 
/* 58 */           (TimeUnit.equalsIgnoreCase("days"))) {
/* 59 */           sender.sendMessage(Data.prefix + "§7Der Spieler §c" + args[0] + "§7 wurde erfolreich gebannt.");
/* 60 */           BanManager.Ban(args[0], message, 
/* 61 */             sender.getName(), Time * 60 * 60 * 24);
/*    */         }
/* 63 */         else if ((TimeUnit.equalsIgnoreCase("w")) || 
/* 64 */           (TimeUnit.equalsIgnoreCase("week")) || 
/* 65 */           (TimeUnit.equalsIgnoreCase("weeks"))) {
/* 66 */           sender.sendMessage(Data.prefix + "§7Der Spieler §c" + args[0] + "§7 wurde erfolreich gebannt.");
/* 67 */           BanManager.Ban(args[0], message, 
/* 68 */             sender.getName(), Time * 60 * 60 * 
/* 69 */             24 * 7);
/*    */         } else {
/* 71 */           sender.sendMessage(Data.prefix + "§7Verwende folgende Zeitformen");
/* 72 */           sender.sendMessage(Data.prefix + "§c< s | m | h | d | w >");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 80 */       sender.sendMessage(Data.prefix + "§7Dieser §cBefehl§7 existiert nicht.");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.TempBan
 * JD-Core Version:    0.6.0
 */