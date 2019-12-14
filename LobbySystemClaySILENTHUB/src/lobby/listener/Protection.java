package lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Protection implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
	@EventHandler
	public void onEn(EntityDamageByEntityEvent e){
		e.setCancelled(true);
	}
	 @EventHandler
	 public void onDeath(PlayerDeathEvent e){
		 e.setDeathMessage(null);
	 }	
	 @EventHandler
	 public void onBreak(BlockBreakEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onBreaak(BlockPlaceEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onHunger(FoodLevelChangeEvent e){
		 e.setCancelled(true);
	 }
	 @EventHandler
	 public void i(InventoryClickEvent e){
		 Player p = (Player)e.getWhoClicked();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void ond(PlayerDropItemEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
		public void on(PlayerInteractAtEntityEvent e){
			e.setCancelled(true);
		}
		@EventHandler
		public void ona(PlayerInteractEntityEvent e){
			e.setCancelled(true);
		}
		@EventHandler
		public void onDa(EntityDamageEvent e){
			e.setCancelled(true);
		}
		@EventHandler
		public void onDaass(EntityDamageByBlockEvent e){
			e.setCancelled(true);
		}
		@EventHandler
	    public void onWeizen(PlayerInteractEvent e) {
			if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
				
			}else{
	        e.setCancelled(true);
			if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
	            e.setCancelled(true);
	        }
	        
	    }
		}
}

