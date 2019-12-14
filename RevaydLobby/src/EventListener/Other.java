package EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import Challenger.Challenger;
import Main.Main;
import Main.Menu;
import Utils.ParticleEffect;

public class Other implements Listener {

	Main plugin;
	Main pluginTimer = Main.getInstance();
	
	private List<UUID> king = new ArrayList<>();

	public static List<UUID> ueberschreiben = new ArrayList<>();

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);

	}

	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onBlockSpread(BlockSpreadEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		if(e.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE) {
			if(king.contains(e.getPlayer().getUniqueId())) {
				return;
			}
			
			if(this.king.size() > 0) {
			for(UUID uuid : this.king) {
				Bukkit.getPlayer(uuid).sendMessage(Main.pre+" §cDu bist nicht mehr king of leader!");
				Bukkit.getPlayer(uuid).getInventory().setHelmet(null);
				this.king.remove(uuid);
			}
			}
			king.add(e.getPlayer().getUniqueId());
			e.getPlayer().sendMessage(Main.pre+" §3Du bist nun der King of leader!");
			for(Entity en : e.getPlayer().getNearbyEntities(5D, 5D, 5D)) {
				if(en instanceof Player) {
					Player p = (Player) en;
					p.sendMessage(Main.pre+" §e"+e.getPlayer().getName()+" §3ist nun king of leader!");
				}
			}
			e.getPlayer().getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			
		}
	}
	
//	@EventHandler
//	public void on(PlayerInteractEntityEvent e)  {
//		if(e.getRightClicked() instanceof Player) {
//			e.getPlayer().setPassenger(e.getRightClicked());
//		}
//	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteract(PlayerInteractEntityEvent event1) {
		final Player clicked = event1.getPlayer();
		Entity entity = event1.getRightClicked();
		if (clicked.getItemInHand().getType() == Material.SHEARS) {
			event1.setCancelled(true);
			if (entity instanceof Player) {
				// Challenger.openSettings(clicked);
				final Player getclicked = (Player) entity;
				Challenger.openChallenger(clicked, getclicked);
				ueberschreiben.add(clicked.getUniqueId());

				Bukkit.getScheduler().scheduleAsyncDelayedTask(
						Main.getInstance(), new Runnable() {
							public void run() {
								ueberschreiben.remove(clicked.getUniqueId());
							}
						}, 5L);
			}
		}
	}

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent e) {
		Player p = (Player) e.getWhoClicked();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBurn(BlockBurnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEat(PlayerItemConsumeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		e.blockList().clear();
	}

	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onPickupItem(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if (e.getEntityType() != EntityType.VILLAGER) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Menu.getMenu(e.getPlayer());
		e.setRespawnLocation(Main.spawn);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		GameMode gamemode = p.getGameMode();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK)
				|| (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType() == Material.CHEST
					|| e.getClickedBlock().getType() == Material.DISPENSER
					|| e.getClickedBlock().getType() == Material.ENDER_CHEST
					|| e.getClickedBlock().getType() == Material.DROPPER
					|| e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE
					|| e.getClickedBlock().getType() == Material.FURNACE
					|| e.getClickedBlock().getType() == Material.WORKBENCH
					|| e.getClickedBlock().getType() == Material.ANVIL
					|| e.getClickedBlock().getType() == Material.BEACON
					|| e.getClickedBlock().getType() == Material.TRAPPED_CHEST
					|| e.getClickedBlock().getType() == Material.WOOD_BUTTON
					|| e.getClickedBlock().getType() == Material.STONE_BUTTON
					|| e.getClickedBlock().getType() == Material.TRAP_DOOR
					|| e.getClickedBlock().getType() == Material.FENCE_GATE)
				if (p.isOp() && gamemode == GameMode.CREATIVE) {
					e.setCancelled(false);
				} else
					e.setCancelled(true);
		}
		if (e.getAction().equals(Action.PHYSICAL)) {
			if (e.getClickedBlock().getTypeId() == 60) {
				if (e.getPlayer() != null) {
					e.setCancelled(true);
				}

			}
		}
	}

	@EventHandler(ignoreCancelled = true)
	public void onArmorSlot(InventoryClickEvent event) {
		if (event.getSlotType().equals(SlotType.ARMOR)
				&& !event.getCurrentItem().getType().equals(Material.AIR))
			event.setCancelled(true);
	}

	@EventHandler
	public void onPortalEnter(PlayerPortalEvent e) {
		e.setCancelled(true);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onFly(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if ((player.hasPermission("premium.features"))
				&& (Schutzschild.jumpbooster_premium.contains(player
						.getUniqueId()))
				&& (player.getGameMode() != GameMode.CREATIVE)) {
			event.setCancelled(true);
			player.setAllowFlight(false);
			player.setFlying(false);
			player.setVelocity(player.getLocation().getDirection()
					.multiply(1.7D).setY(1.0D));
			player.getLocation()
					.getWorld()
					.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F,
							-5.0F);

			for (Player p : Bukkit.getOnlinePlayers()) {
				try {
					ParticleEffect.CLOUD.sendToPlayer(p, player.getLocation(),
							1.0F, 1.0F, 1.0F, 1.0F, 40);
					player.setExp(0.0F);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMovePartyBoots(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.getLocation().getY() > 200) {
			p.teleport(Main.spawn);
			p.playSound(Main.spawn, Sound.ENDERMAN_TELEPORT, 1F, 1F);
			p.playSound(Main.spawn, Sound.ENDERDRAGON_WINGS, 1F, 1F);
		}
		if (p.getLocation().getBlock().getType() == Material.STONE_PLATE) {
			if (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.REDSTONE_BLOCK) {
				p.setVelocity(p.getLocation().getDirection().setY(0.2D)
						.multiply(3.5D));
				p.playEffect(p.getLocation(), Effect.EXTINGUISH, 55);

			}
		}
		if ((p.hasPermission("premium.features"))
				&& (Schutzschild.jumpbooster_premium.contains(p.getUniqueId())
						&& (p.getGameMode() != GameMode.CREATIVE) && (p
						.getLocation().getBlock().getRelative(BlockFace.DOWN)
						.getType() != Material.AIR))) {
			e.getPlayer().setAllowFlight(true);
		}
		if (p.hasPermission("premium.features")
				&& Schutzschild.boots_premium.contains(p.getUniqueId())) {

			Random color = new Random();
			int bc = color.nextInt(16);

			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			LeatherArmorMeta bootm = (LeatherArmorMeta) boots.getItemMeta();
			bootm.setDisplayName("Party Boots");
			if (bc == 0) {
				bootm.setColor(Color.AQUA);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 1) {
				bootm.setColor(Color.BLACK);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 2) {
				bootm.setColor(Color.BLUE);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 3) {
				bootm.setColor(Color.FUCHSIA);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 4) {
				bootm.setColor(Color.GRAY);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 5) {
				bootm.setColor(Color.GREEN);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 6) {
				bootm.setColor(Color.LIME);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 7) {
				bootm.setColor(Color.MAROON);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 8) {
				bootm.setColor(Color.NAVY);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 9) {
				bootm.setColor(Color.OLIVE);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 10) {
				bootm.setColor(Color.ORANGE);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 11) {
				bootm.setColor(Color.PURPLE);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 12) {
				bootm.setColor(Color.RED);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 13) {
				bootm.setColor(Color.SILVER);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 14) {
				bootm.setColor(Color.TEAL);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 15) {
				bootm.setColor(Color.WHITE);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
			if (bc == 16) {
				bootm.setColor(Color.YELLOW);
				boots.setItemMeta(bootm);
				p.getInventory().setBoots(boots);
			}
		}

	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {

		if (!e.getWorld().isThundering()) {
			e.setCancelled(true);
		} else {
			e.getWorld().setThundering(false);
		}

	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		GameMode gamemode = p.getGameMode();
		if (p.isOp() && gamemode == GameMode.CREATIVE) {
			e.setCancelled(false);
			return;
		} else
			e.setCancelled(true);
	}

}
