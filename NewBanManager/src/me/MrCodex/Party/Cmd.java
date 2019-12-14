/*    */ package me.MrCodex.Party;
/*    */ 
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Cmd extends Command
/*    */ { 
	  public static String prefix = "§5Party §8§l•» §7";
/*    */ 
/*    */   public Cmd()
/*    */   {
/* 11 */     super("party");
/*    */   }
/*    */ 
/*    */   @SuppressWarnings("deprecation")
public void execute(CommandSender cs, String[] args)
/*    */   {
/* 17 */     if ((cs instanceof ProxiedPlayer)) {
/* 18 */       ProxiedPlayer p = (ProxiedPlayer)cs;
/* 19 */       if (args.length < 1) {
    p.sendMessage("§7Zeige diese Liste: §c/party help");
    p.sendMessage("§7Lade Spieler ein: §c/party invite <Player>");
    p.sendMessage("§7Zeige alle Member: §c/party list");
    p.sendMessage("§7Verlasse die Party: §c/party leave <Player>");
    p.sendMessage("§7Nehme Einladungen an: §c/party accept <Player>");
    p.sendMessage("§7Kicke einen Spieler: §c/party kick <Player>");
    p.sendMessage("§7Springe auf den Server: §c/party join <Player>");                
    p.sendMessage("§7Party-Chat: §c/p <Message>");
/*    */       }
/* 29 */       else if (args[0].equalsIgnoreCase("create")) {
/* 30 */         Party.neueParty(p);
/*    */       }
/* 32 */       else if (args[0].equalsIgnoreCase("list")) {
/* 33 */         Party.List(p);
/*    */       }
/* 35 */       else if (args[0].equalsIgnoreCase("leave")) {
/* 36 */         Party.leave(p);
/*    */       }
/* 35 */       else if (args[0].equalsIgnoreCase("join")) {
/* 36 */         if(args.length > 1) {
	for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
            if (x.getName().equalsIgnoreCase(args[1])) {
                if(Party.inparty.containsKey(p)) {
            	ProxiedPlayer z = ProxyServer.getInstance().getPlayer(args[1]);
                 Server j = z.getServer();
                 p.connect(j.getInfo());
                 p.sendMessage("§7Verbinde auf neuen §cServer§7...");
                } else {
                	p.sendMessage("§7Du bist nicht in seiner §cParty§7..");
                }
		} else {
			p.sendMessage("§7Dieser §cSpieler §7ist nicht§c Online§7..");
		}
	}
}
/*    */       }
/*    */       else
/*    */       {
/* 45 */          if (args[0].equalsIgnoreCase("invite")) {
/* 46 */           if (args.length > 1) {
/* 47 */             for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/* 48 */               if (x.getName().equalsIgnoreCase(args[1])) {
/* 49 */                 ProxiedPlayer z = ProxyServer.getInstance().getPlayer(args[1]);
/* 50 */                 Party.invite(p, z);
/*    */ 
/* 52 */                 return;
/*    */               }
/*    */             }
/* 55 */             			p.sendMessage("§7Dieser Spieler ist nicht Online.");
/*    */           } else {
/* 57 */             p.sendMessage(prefix + "§7Nutze /party invite <Player>");
/*    */           }
/*    */         }
/* 61 */         else if (args[0].equalsIgnoreCase("accept")) {
/* 62 */           Party.accept(p);
/*    */         }
/* 64 */         else if (args[0].equalsIgnoreCase("kick")) {
/* 65 */           if (args.length > 1)
/*    */           {
/* 67 */             for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/* 68 */               if (x.getName().equalsIgnoreCase(args[1])) {
/* 69 */                 Party.kick(p, x);
/*    */ 
/* 71 */                 return;
/*    */               }
/*    */             }
/* 74 */             			p.sendMessage("§7Dieser Spieler ist nicht Online.");
/*    */           }
/*    */           else {
/* 77 */             p.sendMessage("§7Use /party kick <Player>");
/*    */           }
/*    */ 
/*    */         }
/* 81 */         else if (args[0].equalsIgnoreCase("help")) {
	/* 20 */         p.sendMessage("          " + "§6Party-Help" + "          ");
    p.sendMessage("§7Zeige diese Liste: §c/party help");
    p.sendMessage("§7Lade Spieler ein: §c/party invite <Player>");
    p.sendMessage("§7Zeige alle Member: §c/party list");
    p.sendMessage("§7Verlasse die Party: §c/party leave <Player>");
    p.sendMessage("§7Nehme Einladungen an: §c/party accept <Player>");
    p.sendMessage("§7Kicke einen Spieler: §c/party kick <Player>");
    p.sendMessage("§7Springe auf den Server: §c/party join <Player>");                
    p.sendMessage("§7Party-Chat: §c/p <Message>");
/*    */         } else {
	/* 20 */         p.sendMessage("          " + "§6Party-Help" + "          ");
    p.sendMessage("§7Zeige diese Liste: §c/party help");
    p.sendMessage("§7Lade Spieler ein: §c/party invite <Player>");
    p.sendMessage("§7Zeige alle Member: §c/party list");
    p.sendMessage("§7Verlasse die Party: §c/party leave <Player>");
    p.sendMessage("§7Nehme Einladungen an: §c/party accept <Player>");
    p.sendMessage("§7Kicke einen Spieler: §c/party kick <Player>");
    p.sendMessage("§7Springe auf den Server: §c/party join <Player>");                
    p.sendMessage("§7Party-Chat: §c/p <Message>");
}
/*    */       }
/*    */     }
/*    */   }
/*    */ }
