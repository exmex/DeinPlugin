package farbigerchat.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MainListener implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		String Nachricht = e.getMessage();
		Nachricht.replace("%", "Prozent");
		
		if(PermissionsEx.getUser(p).inGroup("Owner")){
			e.setFormat("§8[§4Owner§8] §4" + p.getName() + "§7 > §6" + Nachricht);
		}
		if(PermissionsEx.getUser(p).inGroup("Premium")){
			e.setFormat("§8[§6Premium§8] §6" + p.getName() + "§7 > §7" + Nachricht);
		}
		if(PermissionsEx.getUser(p).inGroup("default")){
			e.setFormat("§8[§7Spieler§8] §7" + p.getName() + "§7 > §7" + Nachricht);
		}
			
	}

}
