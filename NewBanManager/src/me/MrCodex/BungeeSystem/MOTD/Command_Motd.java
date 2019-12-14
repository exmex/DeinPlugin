/*    */ package me.MrCodex.BungeeSystem.MOTD;
/*    */ 
/*    */ /*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Command_Motd extends Command
/*    */ {
/*    */   public Command_Motd(String string)
/*    */   {
/* 10 */     super(string);
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
/* 16 */     if (sender.hasPermission("system.motd")) {
/* 17 */       if (args.length >= 1) {
/* 18 */         if (args[0].equalsIgnoreCase("list")) {
/* 19 */           sender.sendMessage(ChatColor.DARK_AQUA + "----------" + 
/* 20 */             ChatColor.GOLD + "Motds" + ChatColor.DARK_AQUA + 
/* 21 */             "----------");
/* 22 */           sender.sendMessage(ChatColor.BLUE + "Default-Motd: " + 
/* 23 */             ChatColor.GRAY + 
/* 24 */             Config.Config.DefaultMotd.replace("&", "§"));
/* 25 */           sender.sendMessage("");
/* 26 */           String OnlinePlayers = "";
/* 27 */           Integer count = Integer.valueOf(1);
/* 28 */           for (String s : Config.Config.RandomMotds) {
/* 29 */             if (OnlinePlayers.replace(" ", "") == "") {
/* 30 */               sender.sendMessage(
/* 31 */                 count + ": " + ChatColor.GRAY + 
/* 32 */                 s.replace("&", "§"));
/* 33 */               count = Integer.valueOf(count.intValue() + 1);
/*    */             } else {
/* 35 */               sender.sendMessage(
/* 36 */                 count + ": " + ChatColor.GRAY + 
/* 37 */                 s.replace("&", "§"));
/* 38 */               count = Integer.valueOf(count.intValue() + 1);
/*    */             }
/*    */           }
/* 41 */           if (count.intValue() == 1) {
/* 42 */             sender.sendMessage("-");
/*    */           }
/* 44 */           return;
/*    */         }
/* 46 */         if (args[0].equalsIgnoreCase("clear")) {
/* 47 */           Integer i = Integer.valueOf(Config.Config.RandomMotds.size());
/* 48 */           Config.Config.RandomMotds.clear();
/* 49 */           if (!Config.SaveConfig()) {
/* 50 */             sender.sendMessage(ChatColor.RED + 
/* 51 */               "Fehler: java.lang.file_write_error!");
/* 52 */             return;
/*    */           }
/* 54 */           Listener_Motds.LoadMotds();
/* 55 */           sender.sendMessage( i + 
/* 56 */             " Random-Motds wurden erfolgreich gelöscht!");
/* 57 */           return;
/*    */         }
/*    */       }
/* 60 */       if (args.length <= 1) {
/* 61 */         sender.sendMessage(ChatColor.RED + "/motd setdefault <motd>");
/* 62 */         sender.sendMessage(ChatColor.RED + "/motd setnewbie <motd>");
/* 63 */         sender.sendMessage(ChatColor.RED + "/motd add <motd>");
/* 64 */         sender.sendMessage(ChatColor.RED + "/motd del <motd>");
/* 65 */         sender.sendMessage(ChatColor.RED + "/motd clear");
/* 66 */         sender.sendMessage(ChatColor.RED + "/motd list");
/* 67 */         return;
/*    */       }
/* 69 */       if (args.length >= 2) {
/* 70 */         if (args[0].equalsIgnoreCase("setdefault")) {
/* 71 */           String Message = "";
/* 72 */           Integer count = Integer.valueOf(1);
/* 73 */           while (count.intValue() < args.length) {
/* 74 */             if (Message != "")
/* 75 */               Message = Message + " " + args[count.intValue()];
/*    */             else {
/* 77 */               Message = args[count.intValue()];
/*    */             }
/* 79 */             count = Integer.valueOf(count.intValue() + 1);
/*    */           }
/* 81 */           Config.Config.DefaultMotd = Message;
/* 82 */           if (!Config.SaveConfig()) {
/* 83 */             sender.sendMessage(ChatColor.RED + 
/* 84 */               "Fehler: java.lang.file_write_error!");
/* 85 */             return;
/*    */           }
/* 87 */           Listener_Motds.LoadMotds();
/* 88 */           sender.sendMessage(ChatColor.GOLD + 
/* 89 */             "Das Default-Motd wurde erfolgreich zu \"" + 
/* 90 */             ChatColor.GRAY + Message.replace("&", "§") + 
/* 91 */             ChatColor.GOLD + "\" geändert!");
/* 92 */           return;
/*    */         }
/* 94 */         if (args[0].equalsIgnoreCase("add")) {
/* 95 */           String Message = "";
/* 96 */           Integer count = Integer.valueOf(1);
/* 97 */           while (count.intValue() < args.length) {
/* 98 */             if (Message != "")
/* 99 */               Message = Message + " " + args[count.intValue()];
/*    */             else {
/* 101 */               Message = args[count.intValue()];
/*    */             }
/* 103 */             count = Integer.valueOf(count.intValue() + 1);
/*    */           }
/* 105 */           Config.Config.RandomMotds.add(Message);
/* 106 */           if (!Config.SaveConfig()) {
/* 107 */             sender.sendMessage(ChatColor.RED + 
/* 108 */               "Fehler: java.lang.file_write_error!");
/* 109 */             return;
/*    */           }
/* 111 */           Listener_Motds.LoadMotds();
/* 112 */           sender.sendMessage(ChatColor.GOLD + "Das Motd \"" + 
/* 113 */             ChatColor.GRAY + Message.replace("&", "§") + 
/* 114 */             ChatColor.GOLD + 
/* 115 */             "\" wurde erfolgreich hinzugefügt!");
/* 116 */           return;
/*    */         }
/* 118 */         if ((args[0].equalsIgnoreCase("remove")) || 
/* 119 */           (args[0].equalsIgnoreCase("del"))) {
/* 120 */           Integer remove = Integer.valueOf(0);
/*    */           try {
/* 122 */             remove = Integer.valueOf(args[1]);
/* 123 */             if (remove.intValue() <= 0) {
/* 124 */               sender.sendMessage(ChatColor.RED + 
/* 125 */                 "/motd del <zahl 1-" + 
/* 126 */                 Config.Config.RandomMotds.size() + ">");
/* 127 */               return;
/*    */             }
/* 129 */             if (remove.intValue() > Config.Config.RandomMotds.size()) {
/* 130 */               sender.sendMessage(ChatColor.RED + 
/* 131 */                 "/motd del <zahl 1-" + 
/* 132 */                 Config.Config.RandomMotds.size() + ">");
/* 133 */               return;
/*    */             }
/*    */           } catch (Exception e) {
/* 136 */             sender.sendMessage(ChatColor.RED + "/motd del <zahl>");
/* 137 */             return;
/*    */           }
/* 139 */           if (Config.Config.RandomMotds.size() != 0) {
/* 140 */             sender.sendMessage(ChatColor.GOLD + 
/* 141 */               "Das Motd \"" + 
/* 142 */               ChatColor.GRAY + 
/* 143 */               ((String)Config.Config.RandomMotds.get(remove.intValue() - 1))
/* 144 */               .replace("&", "§") + ChatColor.GOLD + 
/* 145 */               "\" wurde erfolgreich gel§scht!");
/* 146 */             Config.Config.RandomMotds.remove(remove.intValue() - 1);
/* 147 */             if (!Config.SaveConfig()) {
/* 148 */               sender.sendMessage(ChatColor.RED + 
/* 149 */                 "Fehler: java.lang.file_write_error!");
/* 150 */               return;
/*    */             }
/* 152 */             Listener_Motds.LoadMotds();
/*    */           } else {
/* 154 */             sender.sendMessage(ChatColor.RED + "/motd del <zahl 0-" + 
/* 155 */               Config.Config.RandomMotds.size() + ">");
/*    */           }
/* 157 */           return;
/*    */         }
/* 159 */         sender.sendMessage(ChatColor.RED + "/motd setdefault <motd>");
/* 160 */         sender.sendMessage(ChatColor.RED + "/motd setnewbie <motd>");
/* 161 */         sender.sendMessage(ChatColor.RED + "/motd add <motd>");
/* 162 */         sender.sendMessage(ChatColor.RED + "/motd del <zahl>");
/* 163 */         sender.sendMessage(ChatColor.RED + "/motd clear");
/* 164 */         sender.sendMessage(ChatColor.RED + "/motd list");
/* 165 */         return;
/*    */       }
/*    */     } else {
/* 168 */       sender.sendMessage(ChatColor.RED + 
/* 169 */         "Dafür hast du keine Rechte.");
/*    */     }
/*    */   }
/*    */ }
