package spigotplugins.skywars.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import spigotplugins.skywars.main.DeathListener;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class LoginListener implements Listener{
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		
		if(Data.gs == GameState.INGAME){
			Player p = e.getPlayer();
			KitListener.Kits.put(p.getName(), "§cUnbekannt");
			p.sendMessage("");
			p.sendMessage("");
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage(Data.Prefix + "§eDu schaust als §bZuschauer §ezu!");
			p.sendMessage(Data.Prefix + "§eDerzeit wird auf der Map §6" + Data.MapName + "§e gespielt!");
			p.sendMessage(Data.Prefix + "§9Es verbleiben noch §6" + DeathListener.INGAME.size() + "§9 Spieler!");
		}
		if(Data.gs == GameState.LOBBY){
		Player p = e.getPlayer();
		        int i = Bukkit.getMaxPlayers();
		        if(!(i >= Bukkit.getOnlinePlayers().size())){
		            return;
		        }
		        if(i == Bukkit.getOnlinePlayers().size()) {
		            if(!p.hasPermission("claymc.gold")){
		                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cDu benötigst mindestens den §6Gold §cRang, um diesen Server betreten zu können!");
		            }
		            if(p.hasPermission("claymc.gold")) {
		                int q = 0;
		                for(Player all : Bukkit.getOnlinePlayers()) {

		                    if(all.hasPermission("claymc.gold")) {
		                        q++;
		                        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cDieser Server ist komplett voll. Jeder Spieler hat einen §6Premium §cRang!");
		                        if(q == Bukkit.getOnlinePlayers().size()) {
		                            return;
		                        }
		                    }
		                }
		                for(Player all : Bukkit.getOnlinePlayers()) {
		                    if(!all.hasPermission("claymc.gold")) {

		                        all.kickPlayer("§cDu wurdest von einem §6Premium §cSpieler gekickt! §3http://shop.claymc.net");
		                        e.allow();
		                        return;
		                    }
		                }

		            }else{
		                p.sendMessage("");
		                p.sendMessage(Data.Prefix + "§3http://shop.claymc.net");
		                p.sendMessage("");
		            }
		        }
		    }
		
	}

}
