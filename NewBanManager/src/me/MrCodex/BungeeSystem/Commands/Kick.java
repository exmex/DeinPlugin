package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.MuteManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class Kick extends Command {

	public Kick() {
		super("kick");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		/* 17 */     if (sender.hasPermission("system.kick")) {
			/* 18 */       if (args.length < 2) {
			/* 19 */         sender.sendMessage(Data.prefix + "§7Verwende §c/kick <Spieler> <Grund>");
			/*    */       } else {
			/* 21 */         if (ProxyServer.getInstance().getPlayer(args[0]) == null) {
			/* 22 */           sender.sendMessage(Data.prefix + "§7Dieser §cSpieler §7ist nicht Online.");
			/* 23 */           return;
			/*    */         } else {
			/* 25 */         String message = "";
			/* 26 */         for (int i = 1; i < args.length; i++) {
			/* 27 */           message = message + args[i] + " ";
			/*    */         }
			/* 29 */         sender.sendMessage("§7Du hast den §cSpieler §7erfolgreich vom Netzwerk geworfen.");
			/* 30 */         ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
			                 for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
			                	 if(all.hasPermission("system.kick")) {
			                	 all.sendMessage(Data.prefix + "§c" + p2.getName() + "§7 wurde von §c" + p.getName() + "§7 vom Server §7gekickt.");
			                	 all.sendMessage(Data.prefix + "§7Grund: §c" + message);
			                	 }
			                 }
			                 String reason = message;
			                 p2.disconnect("§7Du wurdest vom Netzwerk §7gekickt. \n §7Grund: §c" + reason);
			                  }
			/*    */       }
			/*    */     }
			/*    */     else
			/* 34 */       sender.sendMessage(Data.prefix + "§7Der §cBefehl §7existiert nicht.");
	}
	
	

}
