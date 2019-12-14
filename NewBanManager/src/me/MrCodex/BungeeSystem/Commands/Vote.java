package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Vote  extends Command {
	
	public Vote() {
		super("premium");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
      p.sendMessage(Data.prefix + "§7Du möchtest den §cServer §7unterstützen? Dann kaufe dir doch §cPremium§7!");
	}	
}