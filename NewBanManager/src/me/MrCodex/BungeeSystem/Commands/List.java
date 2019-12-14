package me.MrCodex.BungeeSystem.Commands;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class List extends Command {
	
	public List() {
		super("list");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		p.sendMessage("§7§l§m------------ §c§lServer §8§l- §7§lList §7§l§m------------");
		p.sendMessage(" ");
		p.sendMessage("§7Spieler auf dem Netzwerk: §c" + BungeeCord.getInstance().getOnlineCount());
		p.sendMessage("§7Spieler auf §c" + p.getServer().getInfo().getName() + "§7:§c " + p.getServer().getInfo().getPlayers().size());
		p.sendMessage(" ");
		p.sendMessage("§7§l§m------------ §c§lServer §8§l- §7§lList §7§l§m------------");
	}		


}
