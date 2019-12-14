package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ping extends Command{
	
	public Ping() {
		super("ping");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		p.sendMessage(Data.prefix + "§7Du hast derzeit eine §cLatenz §7von §c" + p.getPing() + "§7ms.");
		
	}


}
