package me.MrCodex.HubAPI;

import java.util.ArrayList;
import java.util.Random;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Hu {

	@SuppressWarnings("deprecation")
	public static ArrayList<Integer> servers = new ArrayList<Integer>();
	public static String rs = "";

	public static void send(final ProxiedPlayer p) {
		try {

			ServerInfo s1 = BungeeCord.getInstance().getServerInfo("Lobby-01");
			p.connect(s1);
		} catch (Exception e1) {

		}
	}
	

}
