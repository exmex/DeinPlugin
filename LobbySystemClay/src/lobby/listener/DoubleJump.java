package lobby.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

public class DoubleJump implements Listener{
	HashMap<Player, Boolean> cooldown = new HashMap<Player, Boolean>();
    ArrayList<Player> fixed = new ArrayList<Player>();
	 @EventHandler
     public void onDamage(EntityDamageEvent e) {
             if (e.getCause() == DamageCause.FALL) {
                     if (e.getEntity().getType() == EntityType.PLAYER) {
                             Player p = (Player) e.getEntity();
                            
                             if (p.hasPermission("claymc.hero") || p.hasPermission("claymc.hero")) {
                                     e.setCancelled(true);
                             }
                            
                             if (!p.hasPermission("claymc.hero") && !p.hasPermission("claymc.hero")) return;
                             if (p.isSneaking() == true) {
                                     ArrayList<Block> blocks = new ArrayList<Block>();
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 0)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(1, 1, 0)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 1)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(-1, 1, 0)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, -1)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(1, 1, 1)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(-1, 1, -1)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(2, 1, 0)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(-2, 1, 0)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 2)));
                                     blocks.add(p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, -2)));
                                    
                                     for (Block b : blocks) {
                                             for (Player pl : Bukkit.getOnlinePlayers()) {
                                                     pl.playEffect(b.getLocation(), Effect.STEP_SOUND, b.getTypeId());
                                             }
                                     }
                                    
                                     p.setSneaking(false);
                             }
                     }
             }
     }
    
     @SuppressWarnings("deprecation")
     @EventHandler
     public void onMove(PlayerMoveEvent e) {
             Player p = e.getPlayer();
            
             if (!p.hasPermission("claymc.hero") && p.getAllowFlight() == true && !fixed.contains(p)) {
                     p.setFlying(false);
                     p.setAllowFlight(false);
                     fixed.add(p);
             }
            
             if (p.getGameMode() == GameMode.CREATIVE) return;
             if (!p.hasPermission("claymc.hero")) return;
            
             if (cooldown.get(p) != null && cooldown.get(p) == true) {
                     p.setAllowFlight(true);
             } else {
                     p.setAllowFlight(false);
             }
            
             if (p.isOnGround()) {
                     cooldown.put(p, true);
             }
            
             if (cooldown.get(p) != null && cooldown.get(p) == false) {
                     for (Player pl : Bukkit.getOnlinePlayers()) {
                             pl.playEffect(p.getLocation(), Effect.SMOKE, 2004);
                     }
             }
     }
    
     @SuppressWarnings("deprecation")
     @EventHandler
     public void onFly(PlayerToggleFlightEvent e) {
             Player p = e.getPlayer();
            
             if (p.getGameMode() == GameMode.CREATIVE) return;
             if (p.hasPermission("claymc.hero")) {
                     if (cooldown.get(p) == true) {
                             e.setCancelled(true);
                             cooldown.put(p, false);
                             p.setVelocity(p.getLocation().getDirection().multiply(1.6D).setY(1.0D));
                             p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                             for (Player pl : Bukkit.getOnlinePlayers()) {
                                     pl.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2004);
                             }
                            
                             p.setAllowFlight(false);
                     }
             }
     }
    
     @SuppressWarnings("deprecation")
     @EventHandler
     public void onSneak(PlayerToggleSneakEvent e) {
             Player p = e.getPlayer();
            
             if (p.getGameMode() == GameMode.CREATIVE) return;
             if (!p.hasPermission("claymc.hero")) return;
            
             if (p.isOnGround() == false && cooldown.get(p) != null && cooldown.get(p) == false) {
                     p.setVelocity(new Vector(0, -5, 0));
             }
     }
    
}
