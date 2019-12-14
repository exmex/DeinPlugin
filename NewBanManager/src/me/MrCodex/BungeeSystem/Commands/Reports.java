package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.StatusResponse.ServerStatus.Player;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Reports extends Command {


	public Reports() {
		super("reports");
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		if(p.hasPermission("system.kick")) {
		if(args.length == 1) {
			ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
			if(p2 != null) {
				if(Report.reported.containsKey(p2)) {
				p.connect(p2.getServer().getInfo());
				p.sendMessage(Data.prefix + "§7Verwende§c /v §7um den §cSpieler §7zu beobachten.");
				Report.reported.remove(p2);
				ProxiedPlayer pp = Report.reporter.get(p2);
				pp.sendMessage(Data.prefix + "§7Dein §cReport §7über §c" + args[0] + "§7 wird nun von §c" + p.getName() + "§7 bearbeitet!2");
				Report.reporter.remove(pp);
				Report.reporter.remove(p2);
				} else {
					p.sendMessage(Data.prefix + "§cDieser §cReport §cist nicht mehr öffentlich.");
				}
			} else {
				p.sendMessage(Data.prefix + "§cDieser §cSpieler §cist nicht mehr §cOnline§c.");
			}
		} else {
			p.sendMessage(Data.prefix + "§cNutze /reports");
		}
		}
	}
}
