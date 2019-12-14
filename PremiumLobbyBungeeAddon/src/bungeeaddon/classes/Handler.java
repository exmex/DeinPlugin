package bungeeaddon.classes;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Handler implements Listener{
	private static ServerInfo server = BungeeCord.getInstance().getServerInfo("PremiumLobby");
	@EventHandler
	public void onLog(ServerConnectEvent e){
		ProxiedPlayer p = e.getPlayer();
		if(p.hasPermission("proxy.premium")){
			try{
			p.connect(server);
			}catch(Exception e1){}
			return;
		}
	}
}
