package spigotplugins.knockbackffa.listener;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import spigotplugins.knockbackffa.main.Main;
import spigotplugins.knockbackffa.storage.Data;

public class Protection implements Listener{
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onFood(EntityDamageEvent e){
		if(e.getCause().equals(DamageCause.FALL)){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("knockbackffa.build")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBlockBreak(BlockPlaceEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("knockbackffa.build")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
			e.getPlayer().sendMessage(new Data().Prefix + "§cDu darfst keine §c§lItems §cweg werfen...");
		}
	}
	@EventHandler
	  public void onPlayerFish(PlayerFishEvent e)
	  {
		if(!Main.enterHaken){
			return;
		}
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
	@EventHandler
	public void onPlayerPush(PlayerMoveEvent event) {

		if (event.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE)
	    {
		  Player p = event.getPlayer();
		  org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(2.0D).setY(1.3D);
	      p.setVelocity(v);
	      p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 3);
	      p.playSound(p.getLocation(), Sound.FIZZ, 3.0F, 2.0F);
		
}
}
}
