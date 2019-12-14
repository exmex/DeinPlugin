package bauevent;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.bossbar.BossBar;
import org.inventivetalent.bossbar.BossBarAPI;

import com.connorlinfoot.actionbarapi.ActionBarAPI;


public class Main extends JavaPlugin{
	public static String Prefix = "§8[§aBauEvent§8] ";
	int cd;
	int cdd;
	public static BOSSSTATE gs = BOSSSTATE.ONE;

	@Override
	public void onEnable() {
		cdd = 5;
		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
		cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				cdd--;
				
				
				if(cdd == 0){
					cdd = 5;
					ActionBarAPI.sendActionBarToAllPlayers("§3ClayMC §8» §6Kämpfen§7 und §bbauen§7!");
					if(gs == BOSSSTATE.ONE){
		                	for(Player all : Bukkit.getOnlinePlayers()){
		    					BossBarAPI.setMessage(all, "§6Willkommen beim §3ClayMC §6BauEvent!");
		    					BossBarAPI.setHealth(all, 100);
		                	}
		             gs = BOSSSTATE.TWO;  
		             return;
					}
		             if(gs == BOSSSTATE.TWO) {
		                	for(Player all : Bukkit.getOnlinePlayers()){
		    					BossBarAPI.setMessage(all, "§3Vorbauen §7und zum §eBuilder §3hocharbeiten");
		    					BossBarAPI.setHealth(all, 70);
		                	}
		                	gs = BOSSSTATE.THREE;
		                	return;
		             }
		             if(gs == BOSSSTATE.THREE) {
		        
		                	for(Player all : Bukkit.getOnlinePlayers()){
		    					BossBarAPI.setMessage(all, "§3... Oder einfach mal §eruhig §ebauen...");
		    					BossBarAPI.setHealth(all, 40);
		                	}
		              gs = BOSSSTATE.FOUR;  
		              return;
		             }
		             if(gs == BOSSSTATE.FOUR){
		                	for(Player all : Bukkit.getOnlinePlayers()){
		    					BossBarAPI.setMessage(all, "§9Das Event läuft bis zum §c18.02.2017");
		    					BossBarAPI.setHealth(all, 11);
		                	}
		                	gs = BOSSSTATE.ONE;
		                	return;
		             }
				
		                
				}
				
			}
		}, 20, 20);
	}
	

}
