package oneline.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import oneline.data.Data;

public class Protection implements Listener{
	public Protection(oneline.main.Main Main){
		this.pl = Main;
	}
	private oneline.main.Main pl;
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onEntity(EntityDamageByEntityEvent e){
		e.setDamage(0);
	}
	@EventHandler
	public void onFall(EntityDamageEvent e){
		if(e.getCause().equals(DamageCause.FALL)){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBreak(BlockPlaceEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			if(e.getPlayer().getItemInHand().getType() == Material.FLINT_AND_STEEL){
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {
						e.getBlock().setType(Material.AIR);
					}
				}, 100);
				e.setBuild(true);
				e.setCancelled(false);
				return;
			}
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
			e.setCancelled(true);
			e.getPlayer().sendMessage(Data.Prefix + "§cDieses Item kannst du nicht wegwerfen...");
		
	}
	@EventHandler
	  public void onPlayerFish(PlayerFishEvent e)
	  {
		if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("§6Enterhaken")){
		e.getPlayer().getItemInHand().setDurability((short)0);
	    Player p = e.getPlayer();
	    Fish h = e.getHook();
	    if (((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) || (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) || (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) && (Bukkit.getWorld(e.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.AIR) && (Bukkit.getWorld(e.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.STATIONARY_WATER))
	    {
	      Location lc = p.getLocation();
	      Location to = e.getHook().getLocation();
	      lc.setY(lc.getY() + 0.8D);
	      p.teleport(lc);
	      double g = -0.08D;
	      double t;
	      double d = t = to.distance(lc);
	      double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
	      double v_y = (1.0D + 0.08D * t) * (to.getY() - lc.getY()) / t - -0.1D * t;
	      double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;
	      Vector v = p.getVelocity();
	      v.setX(v_x);
	      v.setY(v_y);
	      v.setZ(v_z);
	      p.setVelocity(v);
	      p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
	    }
	  }
}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		e.setFormat("§7" + e.getPlayer().getName() + "§8 » §f" + e.getMessage());
	}
	@EventHandler
	public void onBalla(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			try{
			if(e.getItem().getType() == Material.NETHER_STAR){
				e.getPlayer().sendMessage(Data.Prefix + "§cDie Statistiken werden bei der Hauptrelease veröffentlicht...");
			}
			}catch(Exception e1){}
		}
	}
}