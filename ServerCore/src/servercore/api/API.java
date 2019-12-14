package servercore.api;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import servercore.addons.FirstJoinMessages;
import servercore.data.Data;

public class API {

	public static String getCorePrefix(){
		return Data.Prefix;
	}
	public static boolean PlayerIsVanish(Player p){
		if(Data.playerinvanish.contains(p)){
			return true;
		}else{
			return false;
		}
		
	}
	public static void playCoreSound(Player p){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	}
	public static int getPlayerCount(){
		return FirstJoinMessages.totalPlayers;
	}
}
