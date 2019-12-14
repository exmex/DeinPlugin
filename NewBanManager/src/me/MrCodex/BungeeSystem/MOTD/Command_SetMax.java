/*    */ package me.MrCodex.BungeeSystem.MOTD;
/*    */ 
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Command_SetMax extends Command
/*    */ {
/*    */   public Command_SetMax(String string)
/*    */   {
/* 10 */     super(string);
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 16 */     if (sender.hasPermission("system.setmax")){
/* 17 */       if (args.length == 1)
/*    */         try {
/* 19 */           Config.Config.MaxPlayers = Integer.valueOf(args[0]);
/* 20 */           if (!Config.SaveConfig()) {
/* 21 */             sender.sendMessage(ChatColor.RED + 
/* 22 */               "Fehler: java.lang.file_write_error!");
/* 23 */             return;
/*    */           }
/* 25 */           sender.sendMessage(ChatColor.GOLD + 
/* 26 */             "§7Die maximale §bSpieleranzahl§7 wurde zu §b" + args[0] + ChatColor.GOLD + 
/* 28 */             "§7 gesetzt!");
/*    */         } catch (Exception ex) {
/* 30 */           sender.sendMessage(ChatColor.RED + "§b/setmax [maxplayers]");
/*    */         }
/*    */       else
/* 33 */         sender.sendMessage(ChatColor.GOLD + "§7Es können maximal §b" + 
/* 34 */            Config.Config.MaxPlayers + 
/* 35 */           ChatColor.GOLD + "§7 Spieler online!");
/*    */   }else{
	sender.sendMessage("§7Dafür hast du keine §bRechte§7.");
}
}
}
/*    */ 
