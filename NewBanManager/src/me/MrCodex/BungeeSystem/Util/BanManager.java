/*     */package me.MrCodex.BungeeSystem.Util;

/*     */
/*     */import java.util.ArrayList;
/*     */
import java.util.List;

import me.MrCodex.BungeeSystem.Data;
/*     */
import net.md_5.bungee.BungeeCord;
/*     */
import net.md_5.bungee.api.connection.ProxiedPlayer;
/*     */
import net.md_5.bungee.config.Configuration;

/*     */
/*     */public class BanManager
/*     */{
	/* 12 */static Configuration cfg = Files.BanConfig;

	/*     */
	/*     */public static boolean exists(String playername)
	/*     */{
		/* 16 */return cfg.get("Spieler." + PlayerUtil.getUUID(playername)) != null;
		/*     */}

	/*     */
	/*     */public static void createPlayer(String Spielername)
	/*     */{
		/* 21 */if (!exists(Spielername)) {
			/* 22 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Spielername",
			/* 23 */Spielername);
			/* 24 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ban",
			/* 25 */Boolean.valueOf(false));
			/* 26 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Grund", "");
			/* 27 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".von", "");
			/* 28 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ende", Long.valueOf(0L));
			/* 29 */Files.saveBanFile();
			/*     */}
		/*     */}

	/*     */
	/*     */public static boolean isBanned(String Spielername)
	/*     */{
		/* 35 */if (exists(Spielername)) {
			/* 36 */return cfg.getBoolean("Spieler."
					+ PlayerUtil.getUUID(Spielername) +
					/* 37 */".Ban");
			/*     */}
		/*     */
		/* 40 */return false;
		/*     */}

	/*     */
	/*     */public static void Ban(String Spielername, String Grund, String von,
			int Sekunden)
	/*     */{
		/* 46 */if (!isBanned(Spielername)) {
			/* 47 */long current = System.currentTimeMillis();
			/* 48 */long end = current + Sekunden * 1000;
			/* 49 */if (Sekunden == -1) {
				/* 50 */end = -1L;
				/*     */}
			/* 52 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Spielername",
			/* 53 */Spielername);
			/* 54 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ban",
			/* 55 */Boolean.valueOf(true));
			/* 56 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Grund",
			/* 57 */Grund);
			/* 58 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".von",
			/* 59 */von);
			/* 60 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ende", Long.valueOf(end));
			/* 61 */Files.saveBanFile();
			/* 62 */ProxiedPlayer target = BungeeCord.getInstance().getPlayer(
			/* 63 */Spielername);
			/* 64 */if (target != null)
				/* 65 */target.disconnect(getBannedMessage(Spielername));
			/*     */List banned;
			/* 67 */if (cfg.getStringList("GebannteSpieler") != null)
				/* 68 */banned = cfg.getStringList("GebannteSpieler");
			/*     */else {
				/* 70 */banned = new ArrayList();
				/*     */}
			/* 72 */banned.add(Spielername);
			/* 73 */cfg.set("GebannteSpieler", banned);
			/* 74 */Files.saveBanFile();
			/* 75 */for (ProxiedPlayer o : BungeeCord.getInstance()
					.getPlayers()) {
				if(o.hasPermission("System.kick")) {
				/* 77 */o
						.sendMessage(Data.prefix + "§c" + Spielername + "§7 wurde vom §cNetzwerk §7Gesperrt.");
				/* 78 */o.sendMessage(Data.prefix + "§7Grund: §c" + Grund);
				o.sendMessage(Data.prefix + "§7Von: §c" + von);
				/* 79 */o.sendMessage(Data.prefix + "§7Länge: §c"
						+ getRemainingTime(Spielername));
				/*     */
			}
			}
			/*     */}
		/*     */}

	/*     */
	/*     */public static void unBan(String Spielername, String von)
	/*     */{
		/* 88 */if (isBanned(Spielername)) {
			/* 89 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Spielername",
			/* 90 */Spielername);
			/* 91 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ban",
			/* 92 */Boolean.valueOf(false));
			/* 93 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Grund", "");
			/* 94 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".von", "");
			/* 95 */cfg.set("Spieler." + PlayerUtil.getUUID(Spielername)
					+ ".Ende", Long.valueOf(0L));
			/* 96 */Files.saveBanFile();
			/*     */
			/* 99 */List Ban = cfg.getStringList("GebannteSpieler");
			/* 100 */Ban.remove(Spielername);
			/* 101 */cfg.set("GebannteSpieler", Ban);
			/* 102 */Files.saveBanFile();
			/* 103 */for (ProxiedPlayer o : BungeeCord.getInstance()
					.getPlayers()) {
				/* 104 */if(o.hasPermission("System.Kick")){ 
				/* 105 */o.sendMessage(Data.prefix + "§7Der Spieler §b"
						+ Spielername + " §7wurde von §c" + von
						+ " §7entbannt.");
			}
			}
		}
		/*     */}

	/*     */
	/*     */public static List<String> getBannedPlayers()
	/*     */{
		/* 112 */return cfg.getStringList("GebannteSpieler");
		/*     */}

	/*     */
	/*     */public static String getReason(String Spielername) {
		/* 116 */String Grund = "";
		/* 117 */if (isBanned(Spielername)) {
			/* 118 */Grund = cfg.getString("Spieler."
					+ PlayerUtil.getUUID(Spielername) +
					/* 119 */".Grund");
			/*     */}
		/*     */
		/* 122 */return Grund;
		/*     */}

	/*     */
	/*     */public static String getWhoBanned(String Spielername) {
		/* 126 */String whobanned = "";
		/* 127 */if (isBanned(Spielername)) {
			/* 128 */whobanned = cfg.getString("Spieler." +
			/* 129 */PlayerUtil.getUUID(Spielername) + ".von");
			/*     */}
		/*     */
		/* 132 */return whobanned;
		/*     */}

	/* 12 */static Configuration cfgi = Files.BanConfig;

	
	public static void addtoList(String Spielername, String Grund) {
		cfgi.set("BereitsGebannt." + PlayerUtil.getUUID(Spielername), "true");
		cfgi.set("BanGrund." + PlayerUtil.getUUID(Spielername), Grund);
		
	}
	
	public static boolean getfromlist(String Spielername) {
		boolean bool = false;
		if(cfgi.equals("BereitsGebannt." + PlayerUtil.getUUID(Spielername))) {
		if(cfgi.get("BereitsGebannt." + PlayerUtil.getUUID(Spielername)).equals("true")) {
			bool = true;
		}
		} else {
			addtoList(Spielername, "Grundi");
			bool = false;
		}
		
		return bool;
		
	}
	
	public static String getReasonfromlast(String Spielername) {
		String bool = "Unbekannt";
		bool = cfgi.getString("BanGrund." + PlayerUtil.getUUID(Spielername));
		
		return bool;
	}
	/*     */
	/*     */public static long getEnd(String Spielername) {
		/* 136 */long end = -1L;
		/*     */
		/* 138 */if (isBanned(Spielername)) {
			/* 139 */end = cfg.getLong("Spieler."
					+ PlayerUtil.getUUID(Spielername) +
					/* 140 */".Ende");
			/*     */}
		/*     */
		/* 143 */return end;
		/*     */}

	/*     */
	/*     */public static String getRemainingTime(String Spielername) {
		/* 147 */String remainingTime = "";
		/* 148 */if (isBanned(Spielername)) {
			/* 149 */long current = System.currentTimeMillis();
			/* 150 */long end = getEnd(Spielername);
			/* 151 */long difference = end - current;
			/* 152 */if (end == -1L) {
				/* 153 */return "§4Permanent";
				/*     */}
			/* 155 */int Sekunden = 0;
			/* 156 */int Minuten = 0;
			/* 157 */int Stunden = 0;
			/* 158 */int Tage = 0;
			/* 159 */while (difference >= 1000L) {
				/* 160 */difference -= 1000L;
				/* 161 */Sekunden++;
				/*     */}
			/* 163 */while (Sekunden >= 60) {
				/* 164 */Sekunden -= 60;
				/* 165 */Minuten++;
				/*     */}
			/* 167 */while (Minuten >= 60) {
				/* 168 */Minuten -= 60;
				/* 169 */Stunden++;
				/*     */}
			/* 171 */while (Stunden >= 24) {
				/* 172 */Stunden -= 24;
				/* 173 */Tage++;
				/*     */}
			/*     */
			/* 176 */remainingTime = "§b" + Tage + " Tag(e), " + Stunden +
			/* 177 */" Stunde(n), " + Minuten + " Minute(n) " + Sekunden
					+ " Sekunden";
			/*     */}
		/* 179 */return remainingTime;
		/*     */}

	/*     */
	/*     */public static String getBannedMessage(String Spielername) {
		/* 183 */String BanMsg = "";
		/* 184 */if (isBanned(Spielername)) {
			/* 185 */if (getEnd(Spielername) != -1L) {
				/* 186 */BanMsg = "§7Du wurdest vom §cServernetzwerk §7gebannt. \n §7Grund: §c"
						+ getReason(Spielername)
						+ " \n \n §7Verbleibende Zeit: §c  \n"
						+ getRemainingTime(Spielername)
						+ "\n \n §7Unrechter Ban? Stelle einen §cEntbannungsantrag§7 im Forum: \n §cFORUM  \n §7oder auf dem TeamSpeak:  \n §cTEAMSPEAK";
				/*     */}
			/*     */else {
				/* 186 */BanMsg = "§7Du wurdest vom §cServernetzwerk §7gebannt. \n §7Grund: §c"
						+ getReason(Spielername)
						+ " \n \n §7Verbleibende Zeit: §c  \n"
						+ getRemainingTime(Spielername)
						+ "\n \n §7Unrechter Ban? Stelle einen §cEntbannungsantrag§7 im Forum: \n §cFORUM  \n §7oder auf dem TeamSpeak:  \n §cTEAMSPEAK";
				/*     */}
			/*     */}
		/* 192 */return BanMsg;
		/*     */}
	/*     */
}
