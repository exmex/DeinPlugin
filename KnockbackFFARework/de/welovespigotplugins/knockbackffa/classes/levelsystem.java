/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class levelsystem {
    public static HashMap<Player, Integer> latestlevel = new HashMap();
    public static HashMap<Player, Integer> level = new HashMap();

    public static void prepareLevel(Player p) {
        if (statsmanager.kills.get((Object)p) < 21) {
            level.put(p, 1);
        } else if (statsmanager.kills.get((Object)p) < 41) {
            level.put(p, 2);
        } else if (statsmanager.kills.get((Object)p) < 61) {
            level.put(p, 3);
        } else if (statsmanager.kills.get((Object)p) < 81) {
            level.put(p, 4);
        } else if (statsmanager.kills.get((Object)p) < 101) {
            level.put(p, 5);
        } else if (statsmanager.kills.get((Object)p) < 121) {
            level.put(p, 6);
        } else if (statsmanager.kills.get((Object)p) < 141) {
            level.put(p, 7);
        } else if (statsmanager.kills.get((Object)p) < 161) {
            level.put(p, 8);
        } else if (statsmanager.kills.get((Object)p) < 181) {
            level.put(p, 9);
        } else if (statsmanager.kills.get((Object)p) < 201) {
            level.put(p, 10);
        } else if (statsmanager.kills.get((Object)p) < 221) {
            level.put(p, 11);
        } else if (statsmanager.kills.get((Object)p) < 241) {
            level.put(p, 12);
        } else if (statsmanager.kills.get((Object)p) < 261) {
            level.put(p, 13);
        } else if (statsmanager.kills.get((Object)p) < 281) {
            level.put(p, 14);
        } else if (statsmanager.kills.get((Object)p) < 301) {
            level.put(p, 15);
        } else if (statsmanager.kills.get((Object)p) < 321) {
            level.put(p, 16);
        } else if (statsmanager.kills.get((Object)p) < 341) {
            level.put(p, 17);
        } else if (statsmanager.kills.get((Object)p) < 361) {
            level.put(p, 18);
        } else if (statsmanager.kills.get((Object)p) < 381) {
            level.put(p, 19);
        } else if (statsmanager.kills.get((Object)p) < 401) {
            level.put(p, 20);
        }
    }
}

