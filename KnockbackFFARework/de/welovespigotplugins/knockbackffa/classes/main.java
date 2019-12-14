/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.PluginCommand
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package de.welovespigotplugins.knockbackffa.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main
extends JavaPlugin {
    public static String Prefix = "\u00a78[\u00a7cFFA\u00a78] ";
    public static Location loc;
    public static String Output;
    public static double a;
    public String pc;
    public void onEnable() {
    	
        this.getCommand("setspawn").setExecutor((CommandExecutor)new spawnmanager());
        this.getCommand("addcoins").setExecutor((CommandExecutor)new spawnmanager());
        this.getCommand("resetstats").setExecutor((CommandExecutor)new spawnmanager());
        this.getCommand("sethigh").setExecutor(new sethigh());
        Bukkit.getPluginManager().registerEvents((Listener)new kitauswahl(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new listener(this), (Plugin)this);
        File file = new File("plugins//NewKnockbackFFA//spawns.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration((File)file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
    	

    }
}

