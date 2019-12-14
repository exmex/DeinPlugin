package souppvp.listener;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import souppvp.manager.StatsManager;

public class QuitListener implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		StatsManager.loadStatsFromHashMapIntoConfig(p);
		if(ArchievementsData.firstkill.contains(p)){
							Archievements.cfg.set(p.getUniqueId() + ".Firstkill", true);
							try {
								Archievements.cfg.save(Archievements.file);
							} catch (IOException pppp) {
								pppp.printStackTrace();
							}
						}
						if(ArchievementsData.firstdeath.contains(p)){
							Archievements.cfg.set(p.getUniqueId() + "Firstdeath", true);
							try {
								Archievements.cfg.save(Archievements.file);
							} catch (IOException rte) {
								// TODO Auto-generated catch block
								rte.printStackTrace();
							}
						}
	}
}
