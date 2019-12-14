package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;


public class Globalmute extends Command {

public Globalmute() {
	super("globalmute");
}

public static HashMap<Server, Integer> muted = new HashMap<Server, Integer>();

@Override
public void execute(CommandSender sender, String[] args) {
	ProxiedPlayer p = (ProxiedPlayer)sender;
	/* 17 */     if (sender.hasPermission("system.kick")) {
		/* 18 */       if (args.length != 0) {
		/* 19 */         sender.sendMessage(Data.prefix + "§7Verwende §c/rank mute");
		/*    */       } else {
			/* 19 */         sender.sendMessage(Data.prefix + "§7Verwende §c/rank mute");

		/*    */       }
		/*    */     }
		/*    */     else
		/* 34 */       sender.sendMessage(Data.prefix + "§7Der §cBefehl §7existiert nicht.");
}
}