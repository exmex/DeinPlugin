package me.MrCodex.Party;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Cmd_Chat extends Command {

	public Cmd_Chat() {
		super("p");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
			if(Party.inparty.containsKey(p) || Party.partyfuehrer.contains(p)) {
			int i;
          String msg = "";
         for (i = 0; i < args.length; i++) {
             msg = msg + args[i] + " ";
          Party.chat(p, msg);
         }
			} else {
				p.sendMessage(Cmd.prefix + "§7Du befindest dich in keiner §bParty§7.");
			}
		}

}
