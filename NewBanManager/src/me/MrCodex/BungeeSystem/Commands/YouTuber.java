package me.MrCodex.BungeeSystem.Commands;

import me.MrCodex.BungeeSystem.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class YouTuber extends Command{
	
	public YouTuber() {
		super("youtuber");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer)sender;
		if(args.length == 0) {
			p.sendMessage(Data.prefix + "§7Verwende §c/youtuber 250 §7um die §cAnforderungen §7für §cPremium+ §7zu sehen.");
			p.sendMessage(Data.prefix + "§7Verwende §c/youtuber 500 §7um die §cAnforderungen §7für §cYouTuber §7zu sehen.");

		} else if(args[0].equalsIgnoreCase("500")) {
			p.sendMessage(Data.prefix + "§7Vorraussetzungen für §cYouTuber§7:");
			p.sendMessage(Data.prefix + "§7-> Dein §cKanal §7muss mindestens §c500 Abonenten§7 besitzen.");
			p.sendMessage(Data.prefix + "§7-> Du benötigst eine angemessene §cKlickzahl§7.");
			p.sendMessage(Data.prefix + "§7-> Ebenfalls musst du mindestens §c1 Video §7aufnehmen.");
			p.sendMessage(Data.prefix + "§7-> Dieses §cVideo §7muss in angemessener §cQualität §7und §cLänge §7sein.");
			p.sendMessage(Data.prefix + "§7-> Alles erfüllt? Beantrage den §cYouTuber §7Rang im Forum §cwww.ClayMC.net");
		}  else if(args[0].equalsIgnoreCase("250")) {
			p.sendMessage(Data.prefix + "§7Vorraussetzungen für §cPremium+§7:");
			p.sendMessage(Data.prefix + "§7-> Dein §cKanal §7muss mindestens §c250 Abonenten§7 besitzen.");
			p.sendMessage(Data.prefix + "§7-> Du benötigst eine angemessene §cKlickzahl§7.");
			p.sendMessage(Data.prefix + "§7-> Ebenfalls musst du mindestens §c1 Video §7aufnehmen.");
			p.sendMessage(Data.prefix + "§7-> Dieses §cVideo §7muss in angemessener §cQualität §7und §cLänge §7sein.");
			p.sendMessage(Data.prefix + "§7-> Alles erfüllt? Beantrage den §cPremium+ §7Rang im Forum §cwww.ClayMC.net");
		}else {
			p.sendMessage(Data.prefix + "§7Verwende §c/youtuber 250 §7um die §cAnforderungen §7für §cPremium+ §7zu sehen.");
			p.sendMessage(Data.prefix + "§7Verwende §c/youtuber 500 §7um die §cAnforderungen §7für §cYouTuber §7zu sehen.");		}

		
	}

}
