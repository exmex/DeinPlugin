/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.scoreboard;
import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class stats {
    public static File f = new File("plugins//NewKnockbackFFA", "stats.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration((File)f);

    public static void CheckOrdner() {
        File file = new File("plugins//SkyPvP");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static void setDefaults(String path, String message) {
        config.set(path, (Object)message);
        try {
            config.save(f);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addKill(UUID uuid, int anzahl) {
        boolean Reach = false;
        if (config.get(uuid + ".reach") == null) {
            config.set(uuid + ".reach", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a7cKonnte die Stats eines Spielers nicht updaten.");
            }
        }
        int total = anzahl;
        config.set(uuid + ".reach", (Object)total);
        try {
            config.save(f);
        }
        catch (Exception e1) {
            System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
        }
    }

    public static int getKill(UUID uuid) {
        int Reach = 0;
        if (config.get(uuid + ".reach") == null) {
            config.set(uuid + ".reach", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
            }
        }
        Reach = config.getInt(uuid + ".reach");
        return Reach;
    }

    public static int getDeaths(UUID uuid) {
        int Played = 0;
        if (config.get(uuid + ".played") == null) {
            config.set(uuid + ".played", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
            }
        }
        Played = config.getInt(uuid + ".played");
        return Played;
    }

    public static void addDeath(UUID uuid, int anzahl) {
        int Played = anzahl;
        if (config.get(uuid + ".played") == null) {
            config.set(uuid + ".played", (Object)0);
        }
        int total = anzahl;
        config.set(uuid + ".played", (Object)total);
        try {
            config.save(f);
        }
        catch (Exception e1) {
            System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
        }
    }

    public static void addCoins(UUID uuid, int anzahl) {
        boolean Reach = false;
        if (config.get(uuid + ".coins") == null) {
            config.set(uuid + ".coins", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a7cKonnte die Stats eines Spielers nicht updaten.");
            }
        }
        int total = anzahl;
        config.set(uuid + ".coins", (Object)total);
        try {
            config.save(f);
        }
        catch (Exception e1) {
            System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
        }
    }

    public static void buyCoins(UUID uuid, Integer anzahl) {
        int Reach = 0;
        if (config.get(uuid + ".coins") == null) {
            config.set(uuid + ".coins", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a7cKonnte die Stats eines Spielers nicht updaten.");
            }
        }
        Reach = config.getInt(uuid + ".coins");
        int total = Reach + anzahl;
        config.set(uuid + ".coins", (Object)total);
        try {
            config.save(f);
        }
        catch (Exception e1) {
            System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
        }
    }

    public static int getCoins(UUID uuid) {
        int Reach = 0;
        if (config.get(uuid + ".coins") == null) {
            config.set(uuid + ".coins", (Object)0);
            try {
                config.save(f);
            }
            catch (Exception e1) {
                System.out.print("\u00a74Konnte die Stats eines Spielers nicht updaten.");
            }
            for (Player all : Bukkit.getOnlinePlayers()) {
                scoreboard.setScoreboard(all);
            }
        }
        Reach = config.getInt(uuid + ".coins");
        return Reach;
    }

    public static void removeCoins(Player p, int i) {
        int Reach = 0;
        Reach = statsmanager.getCoins(p);
        int fin = Reach - i;
        statsmanager.coins.put(p, statsmanager.getCoins(p) - i);
        for (Player all : Bukkit.getOnlinePlayers()) {
            scoreboard.setScoreboard(all);
        }
    }
}

