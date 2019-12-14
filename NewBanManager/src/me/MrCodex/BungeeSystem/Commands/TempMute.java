/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.MuteManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class TempMute extends Command
/*    */ {
/*    */   public TempMute()
/*    */   {
/* 11 */     super("tempmute");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.mute")) {
/* 18 */       if (args.length < 4) {
/* 19 */         sender.sendMessage(Data.prefix + "§cAusf§hrung: /tempmute <Spieler> <Zeit> <Zeitform> <Grund> ");
/*    */       } else {
/* 21 */         if (MuteManager.isMuted(args[0])) {
/* 22 */           sender.sendMessage(Data.prefix + "§cDieser §cSpieler §cist bereits gemuted.");
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
/* 36 */           sender.sendMessage(Data.prefix + "§7Du hast den Spieler §c" + args[0] + "§7 erfolgreich gemuted.");
/* 37 */           MuteManager.Mute(args[0], message, sender.getName(), 
/* 38 */             Time * 1);
/*    */         }
/* 40 */         else if ((TimeUnit.equalsIgnoreCase("min")) || 
/* 41 */           (TimeUnit.equalsIgnoreCase("minute")) || 
/* 42 */           (TimeUnit.equalsIgnoreCase("m")) || 
/* 43 */           (TimeUnit.equalsIgnoreCase("mins")) || 
/* 44 */           (TimeUnit.equalsIgnoreCase("minutes"))) {
	/* 36 */           sender.sendMessage(Data.prefix + "§7Du hast den Spieler §c" + args[0] + "§7 erfolgreich gemuted.");
/* 46 */           MuteManager.Mute(args[0], message, sender.getName(), 
/* 47 */             Time * 60);
/*    */         }
/* 49 */         else if ((TimeUnit.equalsIgnoreCase("h")) || 
/* 50 */           (TimeUnit.equalsIgnoreCase("hour")) || 
/* 51 */           (TimeUnit.equalsIgnoreCase("hours"))) {
	/* 36 */           sender.sendMessage(Data.prefix + "§7Du hast den Spieler §c" + args[0] + "§7 erfolgreich gemuted.");
/* 53 */           MuteManager.Mute(args[0], message, 
/* 54 */             sender.getName(), Time * 60 * 60);
/*    */         }
/* 56 */         else if ((TimeUnit.equalsIgnoreCase("d")) || 
/* 57 */           (TimeUnit.equalsIgnoreCase("day")) || 
/* 58 */           (TimeUnit.equalsIgnoreCase("days"))) {
	/* 36 */           sender.sendMessage(Data.prefix + "§7Du hast den Spieler §c" + args[0] + "§7 erfolgreich gemuted.");
/* 60 */           MuteManager.Mute(args[0], message, 
/* 61 */             sender.getName(), Time * 60 * 60 * 24);
/*    */         }
/* 63 */         else if ((TimeUnit.equalsIgnoreCase("w")) || 
/* 64 */           (TimeUnit.equalsIgnoreCase("week")) || 
/* 65 */           (TimeUnit.equalsIgnoreCase("weeks"))) {
	/* 36 */           sender.sendMessage(Data.prefix + "§7Du hast den Spieler §c" + args[0] + "§7 erfolgreich gemuted.");
/* 67 */           MuteManager.Mute(args[0], message, 
/* 68 */             sender.getName(), Time * 60 * 60 * 
/* 69 */             24 * 7);
/*    */         } else {
	/* 71 */           sender.sendMessage(Data.prefix + "§cVerwende folgende Zeitformen");
	/* 72 */           sender.sendMessage(Data.prefix + "§c< s | m | h | d | w >");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 80 */       sender.sendMessage(Data.prefix + "§7Du hast keine Rechte.");
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.TempMute
 * JD-Core Version:    0.6.0
 */