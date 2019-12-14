/*    */ package me.MrCodex.Warns;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.chat.ClickEvent;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ 
/*    */ public class Command_Warns extends Command
/*    */ {
/*    */   public Command_Warns(String string)
/*    */   {
/* 11 */     super(string);
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 17 */     if (sender.hasPermission("system.warns")){
/* 18 */       if (args.length >= 1) {
/* 19 */         if ((args[0].equalsIgnoreCase("clear")) || 
/* 20 */           (args[0].equalsIgnoreCase("reset"))) {
/* 21 */           if (args.length == 2) {
/* 22 */             sender.sendMessage(
/* 23 */               Manager_Chat.getComponent(
/* 24 */               null, 
/* 25 */               ChatColor.GREEN + 
/* 26 */            
/* 27 */               "Hier klicken", 
/* 28 */               ChatColor.RED + 
/* 29 */               ", um das Zurücksetzen der Warns von", 
/* 30 */               new ClickEvent(
/* 31 */               ClickEvent.Action.RUN_COMMAND, 
/* 32 */               "/warns clear* " + args[1]), 
/* 33 */               ChatColor.GREEN + 
/* 34 */               "Alle Warns zurücksetzen..."));
/* 35 */             sender.sendMessage(ChatColor.RED + "\"" + 
/* 36 */               ChatColor.GOLD + args[1] + ChatColor.RED + 
/* 37 */               "\" zu bestätigen.");
/* 38 */           } else if (args.length == 1) {
/* 39 */             sender.sendMessage(
/* 40 */               Manager_Chat.getComponent(
/* 41 */               null, 
/* 42 */               ChatColor.GREEN + 
/* 43 */              
/* 44 */               "Hier klicken", 
/* 45 */               ChatColor.RED + 
/* 46 */               ", um das Zurücksetzen aller Warns zu bestätigen.", 
/* 47 */               new ClickEvent(
/* 48 */               ClickEvent.Action.RUN_COMMAND, 
/* 49 */               "/warns clear*"), 
/* 50 */               ChatColor.GREEN + 
/* 51 */               "Alle Warns zurücksetzen..."));
/*    */           } else {
/* 53 */             sender.sendMessage(ChatColor.RED + 
/* 54 */               "/warns <clear|get|list> [player]");
/*    */           }
/* 56 */           return;
/*    */         }
/* 58 */         if (args[0].equalsIgnoreCase("clear*")) {
/* 59 */           if (args.length == 2) {
/* 60 */             Integer oldWarns = Manager_Warns.getWarns(args[1]);
/* 61 */             Manager_Warns.setWarns(args[1], Integer.valueOf(0));
/* 62 */             sender.sendMessage(ChatColor.GREEN + "Die " + 
/* 63 */               ChatColor.YELLOW + "Warns (" + oldWarns + 
/* 64 */               " Warns) " + ChatColor.GREEN + "von \"" + 
/* 65 */               ChatColor.GOLD + args[1] + ChatColor.GREEN + 
/* 66 */               "\", wurden erfolgreich resetet.");
/*    */           }
/* 68 */           if (args.length == 1) {
/* 69 */             Config.Config.PlayerWarns.clear();
/* 70 */             if (!Config.SaveConfig()) {
/* 71 */               sender.sendMessage(ChatColor.RED + 
/* 72 */                 "Fehler: java.lang.file_write_error!");
/* 73 */               return;
/*    */             }
/* 75 */             sender.sendMessage(ChatColor.GREEN + 
/* 76 */               "Alle Warns wurden erfolgreich resetet.");
/*    */           }
/* 78 */           return;
/*    */         }
/* 80 */         if (args[0].equalsIgnoreCase("get")) {
/* 81 */           if (args.length == 2)
/* 82 */             sender.sendMessage(ChatColor.GREEN + 
/* 83 */               "Verwarnungen von " + ChatColor.GOLD + 
/* 84 */               args[1] + ChatColor.GREEN + ": " + 
/* 85 */               ChatColor.YELLOW + 
/* 86 */               Manager_Warns.getWarns(args[1]) + 
/* 87 */               ChatColor.GREEN + ".");
/*    */           else {
/* 89 */             sender.sendMessage(ChatColor.RED + 
/* 90 */               "/warns <clear|get|list> [player]");
/*    */           }
/* 92 */           return;
/*    */         }
/* 94 */         if (args[0].equalsIgnoreCase("list")) {
/* 95 */           if (Manager_Warns.listWarns().size() < 19) {
/* 96 */             sender.sendMessage(ChatColor.DARK_AQUA + "----------" + 
/* 97 */               ChatColor.GOLD + "Verwarnungen (" + 
/* 98 */               Manager_Warns.listWarns().size() + ")" + 
/* 99 */               ChatColor.DARK_AQUA + "----------");
/* 100 */             for (String s : Manager_Warns.listWarns())
/* 101 */               if (s.contains(" "))
/* 102 */                 sender.sendMessage(ChatColor.YELLOW + "  " + 
/* 103 */                   s.split(" ")[0] + ": " + 
/* 104 */                   ChatColor.RED + s.split(" ")[1]);
/*    */           }
/*    */           else
/*    */           {
/* 108 */             sender.sendMessage(ChatColor.RED + 
/* 109 */               "Die Spieler können nicht angezeigt werden. Grund:" + 
/* 110 */               ChatColor.YELLOW + " Zu viele Spieler.");
/*    */           }
/* 112 */           return;
/*    */         }
/* 114 */         sender.sendMessage(ChatColor.RED + 
/* 115 */           "/warns <clear|get|list> [player]");
/*    */       } else {
/* 117 */         sender.sendMessage(ChatColor.RED + 
/* 118 */           "/warns <clear|get|list> [player]");
/*    */       }
/*    */   }else{
	sender.sendMessage("§cDafür hast du keine Rechte.");
}
}
/*    */ }