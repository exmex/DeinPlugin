package me.MrCodex.BungeeSystem.Listener;

import java.util.ArrayList;
import java.util.Random;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

	
	/*  @EventHandler
	    public void onPostLogin(final PostLoginEvent event) {
		  ProxiedPlayer p = event.getPlayer();
			ServerInfo s1 = BungeeCord.getInstance().getServerInfo("lobby_01");
			ServerInfo s2 = BungeeCord.getInstance().getServerInfo("lobby_02");
			ServerInfo s3 = BungeeCord.getInstance().getServerInfo("lobby_03");


if(s1.getPlayers().size() > s2.getPlayers().size() && s2.getPlayers().size() < s3.getPlayers().size()) {
	p.connect(s2);
} else if(s1.getPlayers().size() < s2.getPlayers().size() && s1.getPlayers().size() < s3.getPlayers().size()){
			p.connect(s1);
} else if(s3.getPlayers().size() < s1.getPlayers().size() && s3.getPlayers().size() < s2.getPlayers().size()) {
	p.connect(s3);
} else {
	 p.connect(s2);
}
	    }*/
}
