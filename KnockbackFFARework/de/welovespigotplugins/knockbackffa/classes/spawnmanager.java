/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.main;
import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class spawnmanager
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        Player p;
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            Player p2 = (Player)sender;
            if (p2.hasPermission("claymc.admin")) {
                double x = p2.getLocation().getX();
                double xf = Math.round(x);
                double y = p2.getLocation().getY();
                double yf = Math.round(y);
                File file = new File("plugins//NewKnockbackFFA//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
                p2.sendMessage(String.valueOf(main.Prefix) + "\u00a7bDie Spawnposition wurde zu: \u00a7cX, " + xf + " \u00a78| \u00a7cY, " + yf + "\u00a78 | \u00a7cZ, " + p2.getLocation().getY() + "\u00a7b ge\u00e4ndert! [Spawn]");
                cfg.set("Spawn.X", (Object)p2.getLocation().getX());
                cfg.set("Spawn.Y", (Object)p2.getLocation().getY());
                cfg.set("Spawn.Z", (Object)p2.getLocation().getZ());
                cfg.set("Spawn.Yaw", (Object)Float.valueOf(p2.getLocation().getYaw()));
                cfg.set("Spawn.Pitch", (Object)Float.valueOf(p2.getLocation().getPitch()));
                cfg.set("Spawn.WeltName", (Object)p2.getLocation().getWorld().getName());
                try {
                    cfg.save(file);
                }
                catch (Exception e1) {
                    Bukkit.broadcastMessage((String)"\u00a74\u00a7lFail to set the spawn in spawns.yml \u00a77[\u00a7SetArena-Class\u00a77]");
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("addcoins")) {
            Player p3 = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("addcoins")) {
                if (p3.hasPermission("claymc.admin")) {
                    if (args.length == 0 || args.length == 1) {
                        p3.sendMessage(String.valueOf(main.Prefix) + "\u00a7c/addcoins [Name] [Anzahl]");
                    } else if (args.length == 2) {
                        String target = args[0];
                        String coins = args[1];
                        Player tar = Bukkit.getPlayer((String)target);
                        int anzahl = Integer.parseInt(coins);
                        statsmanager.coins.put(tar, statsmanager.coins.get((Object)tar) + anzahl);
                        p3.sendMessage(String.valueOf(main.Prefix) + "\u00a76Die Coinsanzahl von dem Spieler wurde auf \u00a7c" + statsmanager.getCoins(tar) + "\u00a76 gesetzt!");
                        tar.sendMessage(String.valueOf(main.Prefix) + "\u00a76Der Administrator \u00a7c" + p3.getName() + "\u00a76 hat dir \u00a7c" + anzahl + " \u00a76Coins gutgeschrieben!");
                        if (target == p3.getName()) {
                            p3.sendMessage(String.valueOf(main.Prefix) + "\u00a7cDu kannst dich nicht selbst reporten!");
                        }
                    }
                }
                return false;
            }
        } else if (cmd.getName().equalsIgnoreCase("resetstats") && (p = (Player)sender).hasPermission("claymc.admin")) {
            Player tar = Bukkit.getPlayer((String)args[0]);
            File file = new File("plugins//NewKnockbackFFA//config.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
            File file1 = new File("plugins//NewKnockbackFFA//config.yml");
            YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration((File)file1);
            cfg.set(p.getUniqueId() + ".Kits", (Object)null);
            cfg1.set(p.getUniqueId() + ".reach", (Object)null);
            cfg1.set(p.getUniqueId() + ".played", (Object)null);
            cfg1.set(p.getUniqueId() + ".coins", (Object)null);
            statsmanager.angler.remove((Object)tar);
            statsmanager.bogensch\u00fctze.remove((Object)tar);
            statsmanager.coins.put(tar, 0);
            statsmanager.deaths.put(tar, 0);
            statsmanager.kills.put(tar, 0);
            statsmanager.enderman.remove((Object)tar);
            p.sendMessage(String.valueOf(main.Prefix) + "\u00a76Du hast die Stats von \u00a7c" + tar.getName() + "\u00a76 zur\u00fcckgesetzt!");
            try {
                cfg.save(file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                cfg1.save(file1);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void teleportTopawn(Player p) {
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
        p.teleport(loc);
        if (!p.hasPlayedBefore()) {
            p.teleport(loc);
        }
        p.teleport(loc);
    }
}

