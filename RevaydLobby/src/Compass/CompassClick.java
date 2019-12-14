package Compass;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import EventListener.Schutzschild;
import Main.Main;
import Main.Menu;
import Main.SQLStats;
import Utils.Language;

public class CompassClick implements Listener {

	File file = new File("plugins/Lobby", "Locs.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	Main plugin;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick2(InventoryClickEvent event) {

		final Player p = (Player) event.getWhoClicked();

		Language l = Main.playerLanguage.get(p);

		if (event.getInventory().getName().contains("Premium")) {
			event.setCancelled(true);
			Menu.getMenu(p);

			if (event.getCurrentItem().getType() == Material.QUARTZ) {
				if (Schutzschild.jumpbooster_premium.contains(p.getUniqueId())) {
					Schutzschild.jumpbooster_premium.remove(p.getUniqueId());
					Bukkit.getScheduler().scheduleAsyncDelayedTask(
							Main.getInstance(), new Runnable() {
								public void run() {
									SQLStats.setDoublejump(p, 0);
								}
							}, 0L);
					if (l == Language.GERMAN) {
						p.sendMessage(Main.pre
								+ "Du hast dein Doppeljump §edeaktiviert§3!");
					} else {
						p.sendMessage(Main.pre
								+ "Your Doublejump has been §edisabled§3!");
					}
					p.setFlying(false);
					p.setAllowFlight(false);
				} else {
					Schutzschild.jumpbooster_premium.add(p.getUniqueId());
					Bukkit.getScheduler().scheduleAsyncDelayedTask(
							Main.getInstance(), new Runnable() {
								public void run() {
									SQLStats.setDoublejump(p, 1);
								}
							}, 0L);
					if (l == Language.GERMAN) {
						p.sendMessage(Main.pre
								+ "Du hast dein Doppeljump §eaktiviert§3!");
					} else {
						p.sendMessage(Main.pre
								+ "Your Doublejump has been §eenabled§3!");
					}
				}
				p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				event.getView().close();
			}
			if (event.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				if (Schutzschild.boots_premium.contains(p.getUniqueId())) {
					Schutzschild.boots_premium.remove(p.getUniqueId());
					Bukkit.getScheduler().scheduleAsyncDelayedTask(
							Main.getInstance(), new Runnable() {
								public void run() {
									SQLStats.setColorboots(p, 0);
								}
							}, 0L);
					if (l == Language.GERMAN) {
						p.sendMessage(Main.pre
								+ "Du hast deine Farbigen Schuhe §edeaktiviert§3!");
					} else {
						p.sendMessage(Main.pre
								+ "Your colored boots are now §edisabled§3!");
					}
				} else {
					Schutzschild.boots_premium.add(p.getUniqueId());
					Bukkit.getScheduler().scheduleAsyncDelayedTask(
							Main.getInstance(), new Runnable() {
								public void run() {
									SQLStats.setColorboots(p, 1);
								}
							}, 0L);
					if (l == Language.GERMAN) {
						p.sendMessage(Main.pre
								+ "Du hast deine Farbigen Schuhe §eaktiviert§3!");
					} else {
						p.sendMessage(Main.pre
								+ "Your colored boots are now §eenabled§3!");
					}
				}
				p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				event.getView().close();
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		final Player p = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();

		if (event.getInventory().getName().equalsIgnoreCase("Teleporter")) {
			event.setCancelled(true);

			if (item.getType() == Material.MAGMA_CREAM) {
				event.getView().close();

				String w = cfg.getString("lobby.spawn.world");
				double x = cfg.getDouble("lobby.spawn.x");
				double y = cfg.getDouble("lobby.spawn.y");
				double z = cfg.getDouble("lobby.spawn.z");
				double yaw = cfg.getDouble("lobby.spawn.yaw");
				double pitch = cfg.getDouble("lobby.spawn.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else if (item.getType() == Material.STONE_SWORD) {
				event.getView().close();

				String w = cfg.getString("lobby.ffa.world");
				double x = cfg.getDouble("lobby.ffa.x");
				double y = cfg.getDouble("lobby.ffa.y");
				double z = cfg.getDouble("lobby.ffa.z");
				double yaw = cfg.getDouble("lobby.ffa.yaw");
				double pitch = cfg.getDouble("lobby.ffa.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else if (item.getType() == Material.FEATHER) {
				event.getView().close();

				String w = cfg.getString("lobby.jumpnrun.world");
				double x = cfg.getDouble("lobby.jumpnrun.x");
				double y = cfg.getDouble("lobby.jumpnrun.y");
				double z = cfg.getDouble("lobby.jumpnrun.z");
				double yaw = cfg.getDouble("lobby.jumpnrun.yaw");
				double pitch = cfg.getDouble("lobby.jumpnrun.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else if (item.getType() == Material.FISHING_ROD) {
				event.getView().close();

				String w = cfg.getString("lobby.1vs1.world");
				double x = cfg.getDouble("lobby.1vs1.x");
				double y = cfg.getDouble("lobby.1vs1.y");
				double z = cfg.getDouble("lobby.1vs1.z");
				double yaw = cfg.getDouble("lobby.1vs1.yaw");
				double pitch = cfg.getDouble("lobby.1vs1.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else if (item.getType() == Material.CAULDRON_ITEM) {
				event.getView().close();

				String w = cfg.getString("lobby.sg.world");
				double x = cfg.getDouble("lobby.sg.x");
				double y = cfg.getDouble("lobby.sg.y");
				double z = cfg.getDouble("lobby.sg.z");
				double yaw = cfg.getDouble("lobby.sg.yaw");
				double pitch = cfg.getDouble("lobby.sg.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else if (item.getType() == Material.GOLD_INGOT) {
				event.getView().close();

				p.sendMessage(Main.pre + "§cDerzeit nicht Verfügbar!");

			} else if (item.getType() == Material.SKULL_ITEM) {
				event.getView().close();

				p.sendMessage(Main.pre + "§cDerzeit nicht Verfügbar!");

			} else if (item.getType() == Material.GLASS_BOTTLE) {
				event.getView().close();

				p.sendMessage(Main.pre + "§cComing soon!");

			} else if (item.getType() == Material.GOLDEN_CARROT) {
				event.getView().close();

				String w = cfg.getString("lobby.mlg.world");
				double x = cfg.getDouble("lobby.mlg.x");
				double y = cfg.getDouble("lobby.mlg.y");
				double z = cfg.getDouble("lobby.mlg.z");
				double yaw = cfg.getDouble("lobby.mlg.yaw");
				double pitch = cfg.getDouble("lobby.mlg.pitch");
				World world = Bukkit.getWorld(w);
				Location loc = new Location(world, x, y, z);
				Location tp = new Location(world, x, y - 4, z);
				loc.setPitch((float) pitch);
				loc.setYaw((float) yaw);
				p.teleport(loc);
				p.playSound(tp, Sound.ENDERMAN_TELEPORT, 1F, 1F);
				p.playSound(tp, Sound.ENDERDRAGON_WINGS, 1F, 1F);

			} else {
				event.getView().close();
			}
		}
	}

}
