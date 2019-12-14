package me.MrCodex.BungeeSystem.Commands;

import java.util.HashMap;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

public class ClearChat extends Command {
	public ClearChat() {
		super("cc");
	}

	public static HashMap<Server, String> muted = new HashMap<Server, String>();

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		/* 17 */     if (sender.hasPermission("system.kick")) {
			/* 18 */       if (args.length != 0) {
			/* 19 */         sender.sendMessage(Data.prefix + "§7Verwende §c/cc");
			/*    */       } else {
			for(int i = 0 ; i < 200 ; i++) {
				for(ProxiedPlayer all : p.getServer().getInfo().getPlayers()) {
					all.sendMessage(" ");
				}
			}
			for(ProxiedPlayer all : p.getServer().getInfo().getPlayers()) {
				all.sendMessage(Data.prefix + "§7Der §cChat §7wurde geleert!");
			}
			}
			/*    */     }
			/*    */     else
			/* 34 */       sender.sendMessage(Data.prefix + "§3Der §eBefehl §3existiert nicht.");
	}

}
