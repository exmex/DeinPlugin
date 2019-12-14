package lobby.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import lobby.data.Data;
import lobby.manager.SpawnManager;

public class SetSpawn implements Listener{

	@EventHandler
	public void onPlayer(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("/setkitbattle")){
			SpawnManager.createSpawn(p, p.getLocation(), "KitBattle");
			Data.kitbattle = SpawnManager.getLocation("KitBattle");
			p.sendMessage(Data.Prefix + "§eKitBattle wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setknockpvp")){
			SpawnManager.createSpawn(p, p.getLocation(), "KnockPvP");
			Data.knockpvp = SpawnManager.getLocation("KnockPvP");
			p.sendMessage(Data.Prefix + "§eKnockPvP wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setskywars")){
			SpawnManager.createSpawn(p, p.getLocation(), "SkyWars");
			Data.skywars = SpawnManager.getLocation("SkyWars");
			p.sendMessage(Data.Prefix + "§eSkyWars wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setclaywars")){
			SpawnManager.createSpawn(p, p.getLocation(), "ClayWars");
			Data.claywars = SpawnManager.getLocation("ClayWars");
			p.sendMessage(Data.Prefix + "§eClayWars wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setknockbackffa")){
			SpawnManager.createSpawn(p, p.getLocation(), "KnockbackFFA");
			Data.knockbackffa = SpawnManager.getLocation("KnockbackFFA");
			p.sendMessage(Data.Prefix + "§eKnockbackFFA wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setspawn")){
			SpawnManager.createSpawn(p, p.getLocation(), "Spawn");
			Data.spawn = SpawnManager.getLocation("Spawn");
			p.sendMessage(Data.Prefix + "§eSpawn wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setcommunity")){
			SpawnManager.createSpawn(p, p.getLocation(), "Community");
			Data.community = SpawnManager.getLocation("Community");
			p.sendMessage(Data.Prefix + "§eCommunity wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setfreebuild")){
			SpawnManager.createSpawn(p, p.getLocation(), "FreeBuild");
			Data.community = SpawnManager.getLocation("FreeBuild");
			p.sendMessage(Data.Prefix + "§eFreeBuild wurde gesetzt!");
		}
		if(e.getMessage().equalsIgnoreCase("/setclaysg")){
			SpawnManager.createSpawn(p, p.getLocation(), "ClaySG");
			Data.community = SpawnManager.getLocation("ClaySG");
			p.sendMessage(Data.Prefix + "§eClaySG wurde gesetzt!");
		}
	}
	
}
