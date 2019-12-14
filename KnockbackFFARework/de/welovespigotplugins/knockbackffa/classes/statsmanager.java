/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.stats;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class statsmanager {
    public static ArrayList<Player> angler = new ArrayList();
    public static ArrayList<Player> bogensch\u00fctze = new ArrayList();
    public static ArrayList<Player> schneemann = new ArrayList();
    public static ArrayList<Player> knockback2 = new ArrayList();
    public static ArrayList<Player> tod = new ArrayList();
    public static ArrayList<Player> enderman = new ArrayList();
    public static HashMap<Player, Integer> kills = new HashMap();
    public static HashMap<Player, Integer> deaths = new HashMap();
    public static HashMap<Player, Integer> coins = new HashMap();

    public static void putConfigStatsIntoHashMap(Player p) {
        kills.put(p, stats.getKill(p.getUniqueId()));
        deaths.put(p, stats.getDeaths(p.getUniqueId()));
        coins.put(p, stats.getCoins(p.getUniqueId()));
    }

    public static void putHashMapStatsIntoConfig(Player p) {
        stats.addDeath(p.getUniqueId(), deaths.get((Object)p));
        stats.addKill(p.getUniqueId(), kills.get((Object)p));
        stats.addCoins(p.getUniqueId(), coins.get((Object)p));
    }

    public static void putPlayerKitsIntoArrayList(Player p) {
        File file = new File("plugins//NewKnockbackFFA//config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        if (cfg.get(p.getUniqueId() + ".Kits.Fisherman") == null) {
            cfg.set(p.getUniqueId() + ".Kits.Fisherman", (Object)false);
            cfg.set(p.getUniqueId() + ".Kits.Bogenschuetze", (Object)false);
            cfg.set(p.getUniqueId() + ".Kits.Schneemann", (Object)false);
            cfg.set(p.getUniqueId() + ".Kits.Tod", (Object)false);
            cfg.set(p.getUniqueId() + ".Kits.Enderman", (Object)false);
            try {
                cfg.save(file);
            }
            catch (IOException var3_3) {
                // empty catch block
            }
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Fisherman")) {
            angler.add(p);
        } else {
            angler.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Bogenschuetze")) {
            bogensch\u00fctze.add(p);
        } else {
            bogensch\u00fctze.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Schneemann")) {
            schneemann.add(p);
        } else {
            schneemann.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Knockback2")) {
            knockback2.add(p);
        } else {
            knockback2.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Tod")) {
            tod.add(p);
        } else {
            tod.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Enderman")) {
            enderman.add(p);
        } else {
            enderman.remove((Object)p);
        }
    }

    public static void reloadPlayerKitsIntoArrayList(Player p) {
        File file = new File("plugins//NewKnockbackFFA//config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Fisherman")) {
            angler.add(p);
        } else {
            angler.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Bogenschuetze")) {
            bogensch\u00fctze.add(p);
        } else {
            bogensch\u00fctze.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Schneemann")) {
            schneemann.add(p);
        } else {
            schneemann.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Knockback2")) {
            knockback2.add(p);
        } else {
            knockback2.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Tod")) {
            tod.add(p);
        } else {
            tod.remove((Object)p);
        }
        if (cfg.getBoolean(p.getUniqueId() + ".Kits.Enderman")) {
            enderman.add(p);
        } else {
            enderman.remove((Object)p);
        }
    }

    public static int getCoins(Player p) {
        int i = coins.get((Object)p);
        return i;
    }
}

