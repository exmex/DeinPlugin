package me.MrCodex.BungeeSystem.Commands;

import java.util.Random;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
import me.MrCodex.BungeeSystem.Util.MuteManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Strafe extends Command {

	public Strafe() {
		super("strafe");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("system.ban")) {
			if (args.length != 2) {
				sender.sendMessage(Data.prefix + "§4§lHack Strafen");
				sender.sendMessage(Data.prefix
						+ "§7» §8Hacks §7| §cAntiKnockback : §b1");
				sender.sendMessage(Data.prefix
						+ "§7» §8Hacks §7| §cKillAura : §b2");
				sender.sendMessage(Data.prefix
						+ "§7» §8Hacks §7| §cFly : §b3");
				sender.sendMessage(Data.prefix
						+ "§7» §8Hacks §7| §cSpeed : §b4");
				sender.sendMessage(Data.prefix
						+ "§7» §8Hacks §7| §cSonstiges : §b5");
				/* 19 */sender.sendMessage(Data.prefix
						+ "§a§lBeleidigungen Strafen");
				sender.sendMessage(Data.prefix
						+ "§7» §8Beleidigungen §7| §cTeam : §b6");
				sender.sendMessage(Data.prefix
						+ "§7» §8Beleidigungen §7| §cSpieler : §b7");
				sender.sendMessage(Data.prefix
						+ "§7» §8Beleidigungen §7| §cNetzwerk : §b8");
				/* 19 */sender.sendMessage(Data.prefix
						+ "§e§lSonstige Strafen");
				sender.sendMessage(Data.prefix
						+ "§7» §8Sonstiges §7| §cBugusing : §b9");
				sender.sendMessage(Data.prefix
						+ "§7» §8Sonstiges §7| §cDrohung : §b10");
				sender.sendMessage(Data.prefix
						+ "§7» §8Sonstiges §7| §cRadikalismus : §b11");
				sender.sendMessage(Data.prefix
						+ "§7» §8Sonstiges §7| §cWerbung : §b12");
				sender.sendMessage(Data.prefix
						+ "§7» §8Sonstiges §7| §cCombat-Log : §b13");
				return;
			} else {
				String bannummer = args[1];
				String banname = args[0];
				if (BanManager.isBanned(banname)) {
					sender.sendMessage(Data.prefix
							+ "§cDieser Spieler wurde bereits bestraft. Seine Strafe wird nun überschrieben...");
				}

				sender.sendMessage(Data.prefix + "§7Du hast den Spieler erfolgreich bestraft.");
				

				switch (bannummer) {
				case "1":
					BanManager.Ban(banname, "Hacking Anti-Knockback #" + getBanID(),
							sender.getName(), 16 * 60 * 60 * 24);
					break;
				case "2":
					BanManager.Ban(banname, "Hacking KillAura #" + getBanID(),
							sender.getName(), 20 * 60 * 60 * 24);
					break;
				case "3":
					BanManager.Ban(banname, "Hacking Fliegen/Fly #" + getBanID(),
							sender.getName(), 14 * 60 * 60 * 24);
					break;
				case "4":
					BanManager.Ban(banname, "Hacking Speed #" + getBanID(),
							sender.getName(), 12 * 60 * 60 * 24);
					break;
				case "5":
					BanManager.Ban(banname, "Hacking Sonstiges #" + getBanID(),
							sender.getName(), 21 * 60 * 60 * 24);
					break;
				case "6":
					MuteManager.Mute(banname, "Beleidigungen Teamler #" + getBanID(),
							sender.getName(), 3 * 60 * 60 * 24);
					break;
				case "7":
					MuteManager.Mute(banname, "Beleidigungen Spieler #" + getBanID(),
							sender.getName(), 2 * 60 * 60 * 24);
					break;
				case "8":
					MuteManager.Mute(banname, "Beleidigungen Netzwerk #" + getBanID(),
							sender.getName(), 1 * 60 * 60 * 24);
					break;
				case "9":
					BanManager.Ban(banname, "Fehlverhalten Bugusing #" + getBanID(),
							sender.getName(),  60 * 60 * 12);
					break;
				case "10":
					BanManager.Ban(banname, "Fehlverhalten Drohung #" + getBanID(),
							sender.getName(),  -1);
					break;
				case "11":
					BanManager.Ban(banname, "Fehlverhalten Radikalismus #" + getBanID(),
							sender.getName(),  -1);
					break;
				case "12":
					MuteManager.Mute(banname, "Fehlverhalten Werbung #" + getBanID(),
							sender.getName(),  2 * 60 * 60 * 24);
					break;
				case "13":
					BanManager.Ban(banname, "Fehlverhalten Combat-Log #" + getBanID(),
							sender.getName(),  60 * 60 * 1);
					break;
				}
				
			}
		} else {
			sender.sendMessage(Data.prefix
					+ "§cDu hast keine Rechte einen Spieler zu bestrafen.");
		}
	}
	
	
	public String getBanID() {
		String str = "";
		int lastrandom = 0;
		for(int i = 0; i < 4; i ++) {
			Random r = new Random();
			int rand = r.nextInt(9);
			while(rand == lastrandom) {
				rand = r.nextInt(9);
			}
			lastrandom = rand;
			str = str + rand;
		}
		
		return str;
	}

}
