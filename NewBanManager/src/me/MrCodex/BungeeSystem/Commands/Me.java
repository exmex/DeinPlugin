package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Me extends Command{
	
	public Me() {
		super("me");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		p.sendMessage(Data.prefix + "§cDieser Befehl ist für dich nicht verfügbar.");
	}		

}
