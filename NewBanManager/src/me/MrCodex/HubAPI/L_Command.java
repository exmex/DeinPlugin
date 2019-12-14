package me.MrCodex.HubAPI;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class L_Command extends Command {

	public L_Command() {
		super("l");
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		ProxiedPlayer p = (ProxiedPlayer)arg0;
		Hu.send(p);
	}
}
