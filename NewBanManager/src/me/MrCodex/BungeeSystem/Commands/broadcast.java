package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

public class broadcast extends Command {
	public broadcast() {
		super("bc");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		/* 17 */     if (sender.hasPermission("system.bc")) {
			/* 18 */       if (args.length == 0) {
			/* 19 */         sender.sendMessage(Data.prefix + "§7Verwende §c/bc <Nachricht>");
			/*    */       } else {
				 if (args.length >= 1) {        
                     StringBuilder sb = new StringBuilder();
                     for (int i = 0; i < args.length; i++) 
                          sb.append(args[i]+" ");
                     String st = sb.toString();
               for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                       all.sendMessage("§cBROADCAST §8§l•» §7" + st.replace("&", "§"));
               }
               
				 }
           }
			/*    */     }
			/*    */     else
			/* 34 */       sender.sendMessage(Data.prefix + "§7Der §cBefehl §7existiert nicht.");
	}
}