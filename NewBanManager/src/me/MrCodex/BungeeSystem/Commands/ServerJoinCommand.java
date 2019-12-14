package me.MrCodex.BungeeSystem.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerJoinCommand extends Command {

	public ServerJoinCommand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length == 1) {
			String server = args[0];
			ProxiedPlayer p = (ProxiedPlayer)sender;
			ServerInfo info = ProxyServer.getInstance().getServerInfo(server);
			p.connect(info);
		}
	}

}
