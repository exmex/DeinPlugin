package lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.golgolex.coinsapi.main.CoinsAPI;
import de.golgolex.coinsapi.main.CoinsAPI;
import lobby.data.Data;
import lobby.methods.ItemCreator;
import lobby.methods.Scoreboard;

public class Protection implements Listener{
	public Protection(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
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
			e.setCancelled(false);
		}
		@EventHandler
		public void ona(PlayerInteractEntityEvent e){
			e.setCancelled(false);
		}
		@EventHandler
		public void onDa(EntityDamageEvent e){
			e.setCancelled(true);
		}
		@EventHandler
		public void onDaass(EntityDamageByBlockEvent e){
			e.setCancelled(true);
		}
		@EventHandler(ignoreCancelled = true)
	    public void onWeizen(PlayerInteractEvent e) {
			try{
				
				if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
				e.setCancelled(true);
				return;
				
				}
			if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
				return;
			}else{
				if(e.getItem().getType() != Material.FISHING_ROD){
				e.setCancelled(true);
				}
			}
			if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
	            e.setCancelled(true);
	        }
	        
	    }catch(Exception e1){}
		}
		@EventHandler
		public void onPlayerFish(PlayerFishEvent event) {
			if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
				Entity caught = event.getCaught();
				if (!(caught instanceof Item))
			    return;
				Item item = (Item) caught;
				int zahl = (int)((Math.random()) * 25 + 1);
				CoinsAPI.addCoins(event.getPlayer(), zahl);
				item.setItemStack(ItemCreator.CreateItemONELORE(Material.GOLD_NUGGET, 0, 1, "§6Clays §8[§e" + zahl + "§8]", "§eDu hast Clays geangelt! §8[§e" + zahl + "§8]"));
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {
						event.getPlayer().sendTitle("§6§lGeangelt:", "§e" + zahl + "§e§l Clays");
						event.getPlayer().getInventory().remove(Material.GOLD_NUGGET);
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.FIREWORK_BLAST, 1, 1);
						Scoreboard.setScoreboard(event.getPlayer());
					}
				}, 30L);
			
			}
		}
		@EventHandler(ignoreCancelled = true)
		public void onEntitiy(PlayerInteractEntityEvent e){
			e.setCancelled(false);
		}
		
		
		}
