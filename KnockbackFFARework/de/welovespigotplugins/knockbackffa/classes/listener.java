/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.EntityPlayer
 *  net.minecraft.server.v1_8_R3.IChatBaseComponent
 *  net.minecraft.server.v1_8_R3.IChatBaseComponent$ChatSerializer
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutChat
 *  net.minecraft.server.v1_8_R3.PlayerConnection
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Effect
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Player$Spigot
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.FoodLevelChangeEvent
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.player.PlayerDropItemEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 *  org.bukkit.event.player.PlayerRespawnEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.util.Vector
 *  ru.tehkode.permissions.bukkit.PermissionsEx
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.kitauswahl;
import de.welovespigotplugins.knockbackffa.classes.kitmanager;
import de.welovespigotplugins.knockbackffa.classes.levelsystem;
import de.welovespigotplugins.knockbackffa.classes.main;
import de.welovespigotplugins.knockbackffa.classes.scoreboard;
import de.welovespigotplugins.knockbackffa.classes.spawnmanager;
import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class listener
implements Listener {
    private static main pl;

    public listener(main main2) {
        pl = main2;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        statsmanager.putConfigStatsIntoHashMap(p);
        statsmanager.putPlayerKitsIntoArrayList(p);
        statsmanager.reloadPlayerKitsIntoArrayList(p);
        for (Player all : Bukkit.getOnlinePlayers()) {
            scoreboard.setScoreboard(all);
        }
        p.sendTitle("\u00a73KnockbackFFA", "\u00a7cTeaming verboten!");
        spawnmanager.teleportTopawn(p);
        listener.setMainInventory(p);
        e.setJoinMessage(null);
        p.sendMessage("");
        p.sendMessage("\u00a7b\u00a7m\u00a7l-------------------------------");
        p.sendMessage(String.valueOf(main.Prefix) + "\u00a76KnockbackFFA \u00a73ist nun in der Beta Phase!");
        p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cEventuell k\u00f6nnen trotzdem Bugs auftreten.");
        p.sendMessage("");
        p.sendMessage(String.valueOf(main.Prefix) + "\u00a7eExtra Feature: \u00a73Random-NoHitDelay!");
        p.sendMessage("");
        p.sendMessage("\u00a7b\u00a7m\u00a7l-------------------------------");
        p.sendMessage("");
        levelsystem.prepareLevel(p);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player k = e.getEntity().getKiller();
        Player p = e.getEntity();
        this.sendActionbar(p, "\u00a73Gekillt von: \u00a7eUnbekannt");
        if (k != null) {
            k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            statsmanager.kills.put(k, statsmanager.kills.get((Object)k) + 1);
            statsmanager.coins.put(k, statsmanager.coins.get((Object)k) + 3);
            this.sendActionbar(k, "\u00a73Gekillt: \u00a7e" + p.getName());
            this.sendActionbar(p, "\u00a73Gekillt von: \u00a7e" + k.getName());
            levelsystem.prepareLevel(k);
        }
        String Prefix = "Prefix";
        String Hi = "Hi";
        e.setDeathMessage(null);
        e.getDrops().clear();
        p.spigot().respawn();
        listener.respawnWithDelay(p);
        statsmanager.deaths.put(p, statsmanager.deaths.get((Object)p) + 1);
        for (Player all : Bukkit.getOnlinePlayers()) {
            scoreboard.setScoreboard(all);
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        File file = new File("plugins//NewKnockbackFFA//spawns.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        e.setRespawnLocation(loc);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc1 = p.getLocation();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        Location loc = new Location(p.getLocation().getWorld(), x, y, z);
        if (loc.subtract(0.0, 0.5, 0.0).getBlock().getType().equals((Object)Material.SPONGE)) {
            Vector v = p.getLocation().getDirection().multiply(1.5).setY(1.2);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 3.0f, 2.0f);
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 2);
        }
        if (loc1.getY() < 0.0) {
            e.getPlayer().damage(20.0);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE && p.hasPermission("claymc.admin")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak1(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE && p.hasPermission("claymc.admin")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayer(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)e.getMessage()));
        }
        if (e.getMessage().contains("%")) {
            e.setMessage(e.getMessage().replaceAll("%", "Prozent"));
        }
        if (PermissionsEx.getUser((Player)p).inGroup("Owner")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a74Owner \u00a78\u25cf \u00a74" + p.getName() + " \u00a78\u00bb \u00a76" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Admin")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a7cAdmin \u00a78\u25cf \u00a7c" + p.getName() + " \u00a78\u00bb \u00a76" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Moderator")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a7cModerator \u00a78\u25cf \u00a7c" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Supporter")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a79Supporter \u00a78\u25cf \u00a79" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("YouTuber+")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a75YouTuber+ \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("YouTuber")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a75YouTuber \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("JrYouTuber")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a75JrYouTuber \u00a78\u25cf \u00a75" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Ultra")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a7bUltra \u00a78\u25cf \u00a7b" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Hero")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a73Hero \u00a78\u25cf \u00a73" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else if (PermissionsEx.getUser((Player)p).inGroup("Gold")) {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a76Gold \u00a78\u25cf \u00a76" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        } else {
            e.setFormat("\u00a7e(" + levelsystem.level.get((Object)p) + ") \u00a7a" + p.getName() + " \u00a78\u00bb \u00a7f" + e.getMessage());
        }
    }

    @EventHandler
    public void onEntity(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();
        p.sendMessage(String.valueOf(main.Prefix) + "\u00a7cIn diesem Spielmodus darfst du keine Items wegwerfen!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();
        statsmanager.putHashMapStatsIntoConfig(p);
    }

    @EventHandler
    public void onDa(EntityDamageEvent e){
    	e.setDamage(0.0);
    }
    @EventHandler
    public void onPl(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("claymc.admin") && (e.getMessage().equalsIgnoreCase("/rl") || e.getMessage().equalsIgnoreCase("/stop"))) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.kickPlayer("\u00a76Der Server startet neu!");
            }
        }
    }

    public static void setMainInventory(Player p) {
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }

    public static ItemStack build(Material m, int anzahl, int sh, String name, String lore) {
        ItemStack item = new ItemStack(m, anzahl, (short)sh);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        ArrayList<String> list = new ArrayList<String>();
        list.add(lore);
        itemm.setLore(list);
        item.setItemMeta(itemm);
        return item;
    }

    public static void respawnWithDelay(Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)pl, new Runnable(){

            @Override
            public void run() {
                listener.setMainInventory(p);
                if (kitauswahl.usefisherman.contains(p)) {
                    kitmanager.setAngler(p);
                }
                if (kitauswahl.usebogensch\u00fctze.contains(p)) {
                    p.getInventory().clear();
                    kitmanager.setBogen(p);
                }
                if (kitauswahl.useschneemann.contains(p)) {
                    p.getInventory().clear();
                    kitmanager.setSnowman(p);
                }
                if (kitauswahl.useknockback2.contains(p)) {
                    p.getInventory().clear();
                    kitmanager.setKnockback2(p);
                }
                if (kitauswahl.tod.contains(p)) {
                    p.getInventory().clear();
                    kitmanager.setTod(p);
                }
                if (kitauswahl.enderman.contains(p)) {
                    p.getInventory().clear();
                    kitmanager.setEnderman(p);
                }
            }
        }, 1);
    }

    public void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a((String)("{\"text\": \"" + ChatColor.translateAlternateColorCodes((char)'&', (String)message) + "\"}"));
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)bar);
    }

}

