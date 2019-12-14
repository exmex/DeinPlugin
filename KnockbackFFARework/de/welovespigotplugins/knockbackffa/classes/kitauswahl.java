/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryType
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryHolder
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.kitmanager;
import de.welovespigotplugins.knockbackffa.classes.listener;
import de.welovespigotplugins.knockbackffa.classes.main;
import de.welovespigotplugins.knockbackffa.classes.stats;
import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class kitauswahl
implements Listener {
    public static ArrayList<Player> usefisherman = new ArrayList();
    public static ArrayList<Player> usebogensch\u00fctze = new ArrayList();
    public static ArrayList<Player> useschneemann = new ArrayList();
    public static ArrayList<Player> useknockback2 = new ArrayList();
    public static ArrayList<Player> tod = new ArrayList();
    public static ArrayList<Player> enderman = new ArrayList();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cKitauswahl")) {
                Player p = e.getPlayer();
                if (p.getLocation().getY() > main.a){
                    Inventory inv = Bukkit.createInventory((InventoryHolder)null, (InventoryType)InventoryType.HOPPER, (String)"\u00a76W\u00e4hle eine Option!");
                    ItemStack meine = listener.build(Material.CHEST, 1, 0, "\u00a73Meine Kits", "\u00a77W\u00e4hle ein Kit aus");
                    ItemStack kaufen = listener.build(Material.GOLD_INGOT, 1, 0, "\u00a76Kits kaufen", "\u00a77Kaufe neue Kits!");
                    ItemStack premium = listener.build(Material.DIAMOND, 1, 0, "\u00a76Premium Kits", "\u00a77Kaufe Premium Kits!");
                    inv.setItem(0, meine);
                    inv.setItem(2, premium);
                    inv.setItem(4, kaufen);
                    p.openInventory(inv);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu darfst die Kitauswahl nur am Spawn benutzen!");
                }
            }
        }
        catch (Exception p) {
            // empty catch block
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("\u00a76W\u00e4hle eine Option!")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.CHEST) {
                ItemStack angel;
                ItemStack barrier;
                p.closeInventory();
                Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)9, (String)"\u00a76Deine Kits");
                if (statsmanager.angler.contains((Object)p)) {
                    angel = listener.build(Material.FISHING_ROD, 1, 0, "\u00a76Angler", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(0, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cAngler nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(0, barrier);
                }
                if (statsmanager.bogensch\u00fctze.contains((Object)p)) {
                    angel = listener.build(Material.BOW, 1, 0, "\u00a76Bogensch\u00fctze", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(1, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cBogensch\u00fctze nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(1, barrier);
                }
                if (statsmanager.schneemann.contains((Object)p)) {
                    angel = listener.build(Material.SNOW_BALL, 1, 0, "\u00a76Schneemann", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(2, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cSchneemann nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(2, barrier);
                }
                if (statsmanager.knockback2.contains((Object)p)) {
                    angel = listener.build(Material.STICK, 1, 0, "\u00a76Knockback2", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(3, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cKnockback2 nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(3, barrier);
                }
                if (statsmanager.tod.contains((Object)p)) {
                    angel = listener.build(Material.GOLD_HOE, 1, 0, "\u00a76Tod", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(4, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cTod nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(4, barrier);
                }
                if (statsmanager.enderman.contains((Object)p)) {
                    angel = listener.build(Material.ENDER_PEARL, 1, 0, "\u00a76Enderman", "\u00a77W\u00e4hle das Kit aus");
                    inv.setItem(5, angel);
                } else {
                    barrier = listener.build(Material.BARRIER, 1, 0, "\u00a7cEnderman nicht freigeschaltet!", "\u00a7cNicht freigeschaltet");
                    inv.setItem(5, barrier);
                }
                p.openInventory(inv);
            } else if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                p.closeInventory();
                Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)9, (String)"\u00a76Kits kaufen");
                if (statsmanager.angler.contains((Object)p)) {
                    inv.setItem(0, listener.build(Material.BARRIER, 1, 0, "\u00a76Fisherman \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(0, listener.build(Material.FISHING_ROD, 1, 0, "\u00a76Fisherman \u00a78| \u00a73100 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                if (statsmanager.bogensch\u00fctze.contains((Object)p)) {
                    inv.setItem(1, listener.build(Material.BARRIER, 1, 0, "\u00a76Bogensch\u00fctze \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(1, listener.build(Material.BOW, 1, 0, "\u00a76Bogensch\u00fctze \u00a78| \u00a73200 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                if (statsmanager.schneemann.contains((Object)p)) {
                    inv.setItem(2, listener.build(Material.BARRIER, 1, 0, "\u00a76Schneemann \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(2, listener.build(Material.SNOW_BALL, 1, 0, "\u00a76Schneemann \u00a78| \u00a73200 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                if (statsmanager.knockback2.contains((Object)p)) {
                    inv.setItem(3, listener.build(Material.BARRIER, 1, 0, "\u00a76Knockback2 \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(3, listener.build(Material.STICK, 1, 0, "\u00a76Knockback2 \u00a78| \u00a73500 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                if (statsmanager.tod.contains((Object)p)) {
                    inv.setItem(4, listener.build(Material.BARRIER, 1, 0, "\u00a76Tod \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(4, listener.build(Material.GOLD_HOE, 1, 0, "\u00a76Tod \u00a78| \u00a73400 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                if (statsmanager.enderman.contains((Object)p)) {
                    inv.setItem(5, listener.build(Material.BARRIER, 1, 0, "\u00a76Enderman \u00a72gekauft!", "\u00a77W\u00e4hle es unter deinen Kits aus!"));
                } else {
                    inv.setItem(5, listener.build(Material.ENDER_PEARL, 1, 0, "\u00a76Enderman \u00a78| \u00a73700 Coins", "\u00a76Kaufe dir das Kit!"));
                }
                p.openInventory(inv);
            } else if (e.getCurrentItem().getType() == Material.DIAMOND) {
                if (p.hasPermission("claymc.gold")) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDiese Funktion ist derzeit noch nicht verf\u00fcgbar!");
                    p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 1.0f, 1.0f);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDiese Funktion ist nur f\u00fcr \u00a76Gold, \u00a73Hero, \u00a7bUltra's \u00a7cverf\u00fcgbar!");
                    p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 1.0f, 1.0f);
                }
            }
        }
    }

    @EventHandler
    public void onClickk(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("\u00a76Deine Kits")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
                usefisherman.add(p);
                kitmanager.setAngler(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast dir dieses Kit noch nicht freigeschaltet!");
            } else if (e.getCurrentItem().getType() == Material.BOW) {
                usebogensch\u00fctze.add(p);
                kitmanager.setBogen(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
                useschneemann.add(p);
                kitmanager.setSnowman(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (e.getCurrentItem().getType() == Material.GOLD_HOE) {
                tod.add(p);
                kitmanager.setTod(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                enderman.add(p);
                kitmanager.setEnderman(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (e.getCurrentItem().getType() == Material.STICK) {
                useknockback2.add(p);
                kitmanager.setKnockback2(p);
                p.closeInventory();
                p.sendMessage(String.valueOf(main.Prefix) + "\u00a72Du hast das Kit ausgew\u00e4hlt!");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            }
        } else if (e.getInventory().getName().equalsIgnoreCase("\u00a76Kits kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
                if (statsmanager.getCoins(p) > 99) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 100);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    usefisherman.add(p);
                    kitmanager.setAngler(p);
                    statsmanager.angler.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Fisherman", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            } else if (e.getCurrentItem().getType() == Material.BOW) {
                if (statsmanager.getCoins(p) > 199) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 200);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    usebogensch\u00fctze.add(p);
                    kitmanager.setBogen(p);
                    statsmanager.bogensch\u00fctze.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Bogenschuetze", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            } else if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
                if (statsmanager.getCoins(p) > 199) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 200);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    useschneemann.add(p);
                    kitmanager.setSnowman(p);
                    statsmanager.schneemann.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Schneemann", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            } else if (e.getCurrentItem().getType() == Material.STICK) {
                if (statsmanager.getCoins(p) > 499) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 500);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    useknockback2.add(p);
                    kitmanager.setKnockback2(p);
                    statsmanager.knockback2.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Knockback2", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            } else if (e.getCurrentItem().getType() == Material.GOLD_HOE) {
                if (statsmanager.getCoins(p) > 399) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 400);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    tod.add(p);
                    kitmanager.setTod(p);
                    statsmanager.tod.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Tod", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            } else if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                if (statsmanager.getCoins(p) > 699) {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast dir das Kit gekauft!");
                    stats.removeCoins(p, 700);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    File file = new File("plugins//NewKnockbackFFA//config.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                    enderman.add(p);
                    kitmanager.setEnderman(p);
                    statsmanager.enderman.add(p);
                    p.closeInventory();
                    cfg.set(p.getUniqueId() + ".Kits.Enderman", (Object)true);
                    try {
                        cfg.save(file);
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    statsmanager.reloadPlayerKitsIntoArrayList(p);
                } else {
                    p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu hast nicht gen\u00fcgend Coins um dies zu tun!");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
                }
            }
        }
    }
  
}

