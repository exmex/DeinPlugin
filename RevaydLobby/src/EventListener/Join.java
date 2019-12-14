package EventListener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Main.Menu;
import Main.SQLStats;
import Utils.Language;
import Utils.LanguageUtil;
import Utils.ScoreboardUtil;

public class Join implements Listener {

	public Join(Main plugin) {
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.setHealth(20);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 5F); 

		final LanguageUtil lu = new LanguageUtil();

		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(),
				new Runnable() {
					public void run() {


						

						if (SQLStats.MySQL.playerDataContainsPlayer(p) == false) {
							SQLStats.registerPlayer(p);
						}

						if (Main.playerBlockRequests.get(p.getUniqueId()) == null) {
							if (SQLStats.getChallengerBlockRequest(p) == true) {
								Main.playerBlockRequests.put(p.getUniqueId(), 1);
							}
						}

						if (!Schutzschild.hiders.contains(p.getUniqueId())) {
							if (SQLStats.getVerstecken(p) == true) {
								hidePlayers(p);
								Schutzschild.hiders.add(p.getUniqueId());
							}
						} else {
							hidePlayers(p);
						}

						if (p.hasPermission("premium.features")) {

							if (!Schutzschild.boots_premium.contains(p
									.getUniqueId())) {
								if (SQLStats.getColorboots(p) == true) {
									Schutzschild.boots_premium.add(p
											.getUniqueId());
								}
							}

							if (!Schutzschild.jumpbooster_premium.contains(p
									.getUniqueId())) {
								if (SQLStats.getDoublejump(p) == true) {
									Schutzschild.jumpbooster_premium.add(p
											.getUniqueId());
								}
							}

						}

						Bukkit.getScheduler().scheduleSyncDelayedTask(
								Main.getInstance(), new Runnable() {
									public void run() {
										Language l = Main.playerLanguage.get(p);
										if (l == Language.GERMAN) {
											p.sendMessage(" ");
											p.sendMessage("           §3Herzlich Willkommen auf §6Revayd.net§3! ");
											p.sendMessage("                  §3Teamspeak: §ets.revayd.net");
											p.sendMessage(" ");

										} else {
											p.sendMessage(" ");
											p.sendMessage("           §3Welcome to the PvP Server §6Revayd.net§3! ");
											p.sendMessage("                  §3Teamspeak: §ets.revayd.net");
											p.sendMessage(" ");
										}

										if (p.getGameMode() != GameMode.ADVENTURE) {
											p.setGameMode(GameMode.ADVENTURE);
										}

										for (UUID hider : Schutzschild.hiders) {
											if (Bukkit.getPlayer(hider) != null) {
												Bukkit.getPlayer(hider)
														.hidePlayer(p);
											}
										}

										if (!e.getPlayer().hasPlayedBefore()) {
											p.teleport(Main.spawn);
											p.playSound(Main.spawn,
													Sound.ENDERMAN_TELEPORT,
													1F, 1F);
											p.playSound(Main.spawn,
													Sound.ENDERDRAGON_WINGS,
													1F, 1F);
										}
										Menu.getMenu(p);
										ScoreboardUtil.updateScoreboard(p);
									}
								}, 0L);

					}
				}, 0L);

	}

	public void hidePlayers(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(),
				new Runnable() {
					@SuppressWarnings("deprecation")
					public void run() {
						for (Player other : Bukkit.getServer()
								.getOnlinePlayers()) {
							p.hidePlayer(other);
							if (other.getName() != p.getName()) {
								p.playEffect(other.getLocation(),
										Effect.ENDER_SIGNAL, 0);
							}
						}
					}
				}, 0L);

	}

	@SuppressWarnings("deprecation")
	public void openInv(final Player p) {
		final Inventory inv = p.getPlayer().getServer()
				.createInventory(null, 9, "Choose your Language");

		ItemStack g = new ItemStack(Material.INK_SACK, 1, (short) 11);
		ItemMeta gm = g.getItemMeta();
		gm.setDisplayName("§aDeutsch");
		g.setItemMeta(gm);

		ItemStack e = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta em = e.getItemMeta();
		em.setDisplayName("§eEnglish");
		e.setItemMeta(em);

		inv.setItem(2, g);
		inv.setItem(6, e);

		Bukkit.getServer().getScheduler()
				.scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
					public void run() {
						Bukkit.getServer().getScheduler()
						.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
							public void run() {
								if (p != null && p.isOnline())
									;
								p.openInventory(inv);
							}
						}, 0L);
						
					}
				}, 5L);

	}

	// @SuppressWarnings("deprecation")
	// @EventHandler
	// public void onLogin(PlayerLoginEvent e) {
	// final Player p = e.getPlayer();
	//
	// if((Bukkit.getOnlinePlayers().length >= Bukkit.getMaxPlayers())) {
	// if(p.hasPermission("premium.joinfull")) {
	// Player k = getRandomPlayerWhosNotPremium();
	// if(k == null) {
	// e.disallow(Result.KICK_OTHER, "§cDer Server ist voll.");
	// }else{
	// Player haha = k;
	// k.kickPlayer("§cDu wurdest gekickt, um für ein Teammitglied oder Premiummitglied Platz zu machen!");
	// e.setResult(Result.ALLOWED);
	// p.sendMessage("§cDu hast Spieler §e"+haha+" §cgekickt.");
	// }
	// }else{
	// e.disallow(Result.KICK_OTHER,
	// "§cDer Server ist voll.\n§3Premium kaufen: §estore.revayd.net");
	// }
	//
	// }
	//
	//
	//
	// }

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if ((Bukkit.getOnlinePlayers().size() >= Bukkit.getServer()
				.getMaxPlayers())) {
			if (p.hasPermission("premium.joinfull")) {
				Player k = getRandomPlayerWhosNotPremium();
				Player k2 = getRandomPlayerWhosPremium();
				if (k == null) {
					if (p.hasPermission("staff.joinfull") && k2 != null) {
						Player haha = k2;

						if (Main.playerLanguage.get(k2) == Language.GERMAN) {
							k2.kickPlayer("§cDu wurdest gekickt, um für ein Teammitglied Platz zu machen!");
						} else {
							k2.kickPlayer("§cYou were kicked to make space for a staff member!");
						}
						e.setResult(Result.ALLOWED);

						if (Main.playerLanguage.get(p) == Language.GERMAN) {
							p.sendMessage("§cDu hast Spieler §e" + haha
									+ " §cgekickt.");
						} else {
							p.sendMessage("§cYou kicked §e" + haha + "§c.");
						}
					} else {
						if (Main.playerLanguage.get(p) == Language.GERMAN) {
							e.disallow(Result.KICK_OTHER,
									"§cDer Server ist voll.");
						} else {
							e.disallow(Result.KICK_OTHER,
									"§cThe server is full.");
						}
					}
				} else {
					Player haha = k;
					if (Main.playerLanguage.get(k) == Language.GERMAN) {
						k.kickPlayer("§cDu wurdest gekickt, um für ein Teammitglied oder Premiummitglied Platz zu machen!");
					} else {
						k.kickPlayer("§cYou were kicked to make space for a premium or a staff member!");
					}
					e.setResult(Result.ALLOWED);
					if (Main.playerLanguage.get(p) == Language.GERMAN) {
						p.sendMessage("§cDu hast Spieler §e" + haha
								+ " §cgekickt.");
					} else {
						p.sendMessage("§cYou kicked §e" + haha + "§c.");
					}
				}
			} else {
				if (Main.playerLanguage.get(p) == Language.GERMAN) {
					e.disallow(Result.KICK_OTHER,
							"§cDer Server ist voll.\n§3Premium kaufen: §estore.revayd.net");
				} else {
					e.disallow(Result.KICK_OTHER,
							"§cThe server is full.\n§3Buy Premium here: §estore.revayd.net");
				}
			}

		} 
	}

	@SuppressWarnings("deprecation")
	public static Player getRandomPlayerWhosNotPremium() {
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!on.hasPermission("premium.joinfull")) {
				return on;
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static Player getRandomPlayerWhosPremium() {
		for (Player on : Bukkit.getOnlinePlayers()) {
			if (!on.hasPermission("staff.joinfull")) {
				return on;
			}
		}
		return null;
	}

}
