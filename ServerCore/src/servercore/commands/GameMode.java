package servercore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import servercore.api.API;
import servercore.data.Data;

public class GameMode implements CommandExecutor, Listener{
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@EventHandler
	public void onPlayer(PlayerCommandPreprocessEvent e){
		if(e.getMessage().startsWith("/gamemode")){
			e.setCancelled(true);
			String total = e.getMessage();
			String[] split = total.split(" ");
			Player p = e.getPlayer();
			if(p.hasPermission("core.gamemode") || p.hasPermission("minecraft.command.gamemode")){
				int i = Integer.parseInt(split[1]);
				if(i == 0){
					p.setGameMode(org.bukkit.GameMode.SURVIVAL);
					p.sendMessage(Data.Prefix + "§eDu befindest dich nun im §6Survival §eModus!");
					API.playCoreSound(p);
				}
				if(i == 1){
					p.setGameMode(org.bukkit.GameMode.CREATIVE);
					p.sendMessage(Data.Prefix + "§eDu befindest dich nun im §6Kreativ §eModus!");
					API.playCoreSound(p);
				}
				if(i == 2){
					p.setGameMode(org.bukkit.GameMode.ADVENTURE);
					p.sendMessage(Data.Prefix + "§eDu befindest dich nun im §6Adventure §eModus!");
					API.playCoreSound(p);
				}
				if(i == 3){
					p.setGameMode(org.bukkit.GameMode.SPECTATOR);
					p.sendMessage(Data.Prefix + "§eDu befindest dich nun im §6Spectator §eModus!");
					API.playCoreSound(p);
				}
			}else{
				p.sendMessage(Data.Prefix + "§cStelle sicher, dass du folgende Permission besitzt: §3Core.Gamemode");
			}
			
		}
	}

	

}
