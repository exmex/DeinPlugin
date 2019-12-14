package de.community.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.bossbar.BossBarAPI;

import community.jumpandrun.CommandListener;
import community.jumpandrun.JumpAndRun;
import de.community.items.Navigator;
import de.community.items.PlayerHide;
import de.community.manager.MainListener;
import de.community.manager.SpawnManager;
import de.community.specials.Bühne;
import de.community.utils.Data;
import de.community.utils.Scoreboard;

public class Main extends JavaPlugin{
	static int cd;
	static int cdd;
	@SuppressWarnings("deprecation")
	public void onEnable(){
		cdd = 20;
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6Die ClayUnity startet...");
		try{
		register();	
		}catch(Exception e1){
			Bukkit.getConsoleSender().sendMessage("§4Es gab einen Fehler beim starten...");
			return;
		}
		CommandListener.loadList();
		cd = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				cdd--;
				
				
				if(cdd == 0){
					cdd = 20;
					Navigator.in.clear();
				}
				
			}
		}, 20, 5);
	}

	public void register(){
		Bukkit.getPluginManager().registerEvents(new Navigator(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerHide(), this);
		Bukkit.getPluginManager().registerEvents(new Bühne(), this);
		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
		Bukkit.getPluginManager().registerEvents(new JumpAndRun(), this);

		getCommand("setspawn").setExecutor(new SpawnManager());
		getCommand("jnr").setExecutor(new CommandListener());

	}
}
