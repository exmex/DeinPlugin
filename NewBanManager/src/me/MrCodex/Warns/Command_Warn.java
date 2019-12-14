/*     */ package me.MrCodex.Warns;
/*     */ 
/*     */ import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import net.md_5.bungee.api.ChatColor;
/*     */ import net.md_5.bungee.api.CommandSender;
/*     */ import net.md_5.bungee.api.ProxyServer;
/*     */ import net.md_5.bungee.api.chat.ClickEvent;
/*     */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*     */ import net.md_5.bungee.api.plugin.Command;
/*     */ 
/*     */ 
/*     */ public class Command_Warn extends Command
/*     */ {
/*  11 */   private String LastWarn = "- -";
/*     */ 
/*     */   public Command_Warn(String string) {
/*  14 */     super(string);
/*     */   }
/*     */ 
/*     */   public void execute(CommandSender sender, String[] args)
/*     */   {
/*  20 */     if (sender.hasPermission("system.warn")){
/*  21 */       if (args.length == 0) {
/*  22 */         sender.sendMessage(ChatColor.RED + "§c/warn <player> [reason]");
/*     */       } else {
/*  24 */         ProxiedPlayer p = null;
/*  25 */         for (ProxiedPlayer pl : ProxyServer.getInstance().getPlayers()) {
/*  26 */           if (pl.getName().equalsIgnoreCase(args[0])) {
/*  27 */             if (pl.hasPermission("system.warn")) {
/*  28 */               sender.sendMessage(ChatColor.RED + 
/*  29 */                 "§7Du kannst diesen§c Spieler§7 nicht warnen.");
/*  30 */               return;
/*     */             }
/*  32 */             p = pl;
/*  33 */             break;
/*     */           }
/*     */         }
/*  36 */         if (((sender instanceof ProxiedPlayer)) && 
/*  37 */           (sender.getName().equalsIgnoreCase(args[0]))) {
/*  38 */           sender.sendMessage(ChatColor.RED + 
/*  39 */             "§7Du kannst dich nicht selbst warnen!");
/*  40 */           return;
/*     */         }
/*     */ 
/*  43 */         if (p == null) {
/*  44 */           if (args[0].endsWith("*"))
/*     */           {
/*  46 */             if (!this.LastWarn.equals(sender.getName() + " " + 
/*  46 */               args[0].toLowerCase())) {
/*  47 */               askWarn(sender, args[0].replace("*", ""), null);
/*  48 */               this.LastWarn = 
/*  49 */                 (sender.getName() + " " + 
/*  49 */                 args[0].toLowerCase());
/*     */             }
/*  51 */             return;
/*     */           }
/*  53 */           this.LastWarn = "- -";
/*  54 */           sender.sendMessage(ChatColor.RED + 
/*  55 */             "§7Der §cSpieler§7 wurde nicht gefunden oder ist offline! ");
/*  56 */           if ((sender instanceof ProxiedPlayer)) {
/*  57 */             sender.sendMessage(Manager_Chat.getComponent(null, 
/*  58 */               ChatColor.GREEN + 
/*  59 */               "Hier klicken", ChatColor.RED + 
/*  60 */               ", um \"" + ChatColor.GOLD + args[0] + 
/*  61 */               ChatColor.RED + 
/*  62 */               "\" trotzdem zu warnen.", 
/*  63 */               new ClickEvent(ClickEvent.Action.RUN_COMMAND, 
/*  64 */               "/warn " + args[0] + "*"), 
/*  65 */               ChatColor.GREEN + args[0] + 
/*  66 */               " trotzdem warnen..."));
/*     */           }
/*  68 */           return;
/*     */         }
/*  70 */         String Message = null;
/*  71 */         if (args.length > 1) {
/*  72 */           Message = "";
/*  73 */           Integer count = Integer.valueOf(1);
/*  74 */           while (count.intValue() < args.length) {
/*  75 */             Message = Message + " " + args[count.intValue()];
/*  76 */             count = Integer.valueOf(count.intValue() + 1);
/*     */           }
/*  78 */           Message = Manager_Chat.getMessage(sender, Message);
/*  79 */           if (Message == null) {
/*  80 */             return;
/*     */           }
/*     */         }
/*  83 */         askWarn(sender, p.getName(), Message);
/*     */       }
}else{
	sender.sendMessage("§cDafür hast du keine Rechte.");
}
/*     */   }
/*     */ 
/*     */   public void askWarn(CommandSender sender, String PlayerName, String Reason)
/*     */   {
/*  90 */     if (Warn(sender, PlayerName, Reason).booleanValue()) {
/*  91 */       for (String bp : Config.Config.BannedPlayers) {
/*  92 */         if ((bp.length() >= 3) && 
/*  93 */           (PlayerName.equalsIgnoreCase(bp.split(" ")[0]))) {
/*  94 */           return;
/*     */         }
/*     */       }
/*     */ 
/*  98 */       sender.sendMessage("");
/*  99 */       sender.sendMessage(ChatColor.RED + "Der Spieler " + ChatColor.GOLD + 
/* 100 */         PlayerName + ChatColor.RED + " sollte jetzt, wegen");
/* 101 */       sender.sendMessage(ChatColor.RED + "zuvielen " + ChatColor.YELLOW + 
/* 102 */         "Warns" + ChatColor.DARK_RED + " gebannt " + 
/* 103 */         ChatColor.RED + "werden.");
/* 104 */       sender.sendMessage(Manager_Chat.getComponent(null, ChatColor.GREEN + 
/* 105 */          "Hier klicken", ChatColor.RED + 
/* 106 */         ", um das Bannen von \"" + ChatColor.GOLD + PlayerName + 
/* 107 */         ChatColor.RED + "\" zu bestätigen.", 
/* 108 */         new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ban " + 
/* 109 */         PlayerName + "**"), ChatColor.GREEN + PlayerName + 
/* 110 */         " vom Server bannen..."));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Boolean Warn(CommandSender Who, String PlayerName, String Reason)
/*     */   {
/* 116 */     Manager_Warns.addWarn(PlayerName);
/* 117 */     Integer warns = Manager_Warns.getWarns(PlayerName);
/* 118 */     ProxiedPlayer p = ProxyServer.getInstance().getPlayer(PlayerName);
/* 119 */     if (Reason == null)
/* 120 */       ProxyServer.getInstance().broadcast(
/* 121 */         ChatColor.DARK_AQUA + "Der Spieler " + ChatColor.RED + 
/* 122 */         ChatColor.BOLD + "\"" + PlayerName + "\"" + 
/* 123 */         ChatColor.DARK_AQUA + " bekam einen " + 
/* 124 */         ChatColor.GOLD + "Warn " + ChatColor.DARK_AQUA + 
/* 125 */         "(" + ChatColor.YELLOW + warns + 
/* 126 */         ChatColor.DARK_AQUA + "/" + ChatColor.YELLOW + 
/* 127 */         Config.Config.MaxWarns + ChatColor.DARK_AQUA + 
/* 128 */         ").");
/*     */     else {
/* 130 */       ProxyServer.getInstance().broadcast(
/* 131 */         ChatColor.DARK_AQUA + "Der Spieler " + ChatColor.RED + 
/* 132 */         ChatColor.BOLD + "\"" + PlayerName + "\"" + 
/* 133 */         ChatColor.DARK_AQUA + " bekam einen " + 
/* 134 */         ChatColor.GOLD + "Warn " + ChatColor.DARK_AQUA + 
/* 135 */         "(" + ChatColor.YELLOW + warns + 
/* 136 */         ChatColor.DARK_AQUA + "/" + ChatColor.YELLOW + 
/* 137 */         Config.Config.MaxWarns + ChatColor.DARK_AQUA + 
/* 138 */         "). " + ChatColor.RED + "Grund: " + 
/* 139 */         ChatColor.YELLOW + Reason);
/*     */     }
/* 141 */     if (p != null) {
/* 142 */       if (warns != null) {
/* 143 */         p.sendMessage(ChatColor.GOLD + "Du hast " + ChatColor.RED + 
/* 144 */           warns + ChatColor.GOLD + "/" + ChatColor.GOLD + 
/* 145 */           Config.Config.MaxWarns + ChatColor.RED + " Warns.");
/*     */       }
/* 147 */       if (warns.intValue() >= Config.Config.MaxWarns.intValue()) {
/* 148 */         p.disconnect(ChatColor.RED + "Du wurdest wegen " + 
/* 149 */           ChatColor.GOLD + warns + ChatColor.RED + "/" + 
/* 150 */           ChatColor.RED + Config.Config.MaxWarns + 
/* 151 */           ChatColor.GOLD + " Warns vom Server geworfen.");
/*     */       }
/*     */     }
/* 154 */     if (warns.intValue() >= Config.Config.MaxWarns.intValue()) {
/* 155 */       return Boolean.valueOf(true);
/*     */     }
/* 157 */     return Boolean.valueOf(false);
/*     */   }
/*     */ }
