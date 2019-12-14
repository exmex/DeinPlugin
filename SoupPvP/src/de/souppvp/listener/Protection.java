package de.souppvp.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import de.souppvp.data.Data;

public class Protection implements Listener{
	
	@EventHandler
	public void onEntity(FoodLevelChangeEvent e){
			e.setCancelled(true);
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("claymc.admin") && p.getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBlockBreak(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("claymc.admin") && p.getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
    public void onWeizen(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
            e.setCancelled(true);
        
}
}
	@EventHandler(ignoreCancelled = true)
	public void onEn(EntityDamageEvent e){
		try{
		if(e.getEntity() instanceof ArmorStand){
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
		if(Data.firstJoin.contains(e.getEntity())){
			e.setCancelled(true);
		}
		if(Data.FeastJoin.contains(e.getEntity())){
			e.setCancelled(false);
		}
		}
		}catch(Exception e1){}
	}
	@EventHandler
	public void onJJ(EntityDamageEvent e){
		if(Data.INOneVSOneJoin.contains(e.getEntity())){
			if(e.getCause().equals(DamageCause.FALL)){
				e.setCancelled(true);
			}
		}
	}
	}

