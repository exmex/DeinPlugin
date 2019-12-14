/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.listener;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class kitmanager {
    public static ArrayList<Player> angler = new ArrayList();
    public static ArrayList<Player> bogensch\u00fctze = new ArrayList();

    public static void setAngler(Player p) {
        p.getInventory().clear();
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
        ItemStack i = new ItemStack(Material.FISHING_ROD);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(1, i);
    }

    public static void setBogen(Player p) {
        p.getInventory().clear();
        ItemStack i = new ItemStack(Material.BOW);
        ItemStack i2 = new ItemStack(Material.ARROW, 32);
        p.getInventory().setItem(1, i);
        p.getInventory().setItem(2, i2);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }

    public static void setSnowman(Player p) {
        p.getInventory().clear();
        ItemStack i = new ItemStack(Material.SNOW_BALL, 16);
        p.getInventory().setItem(1, i);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }

    public static void setKnockback2(Player p) {
        p.getInventory().clear();
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }

    public static void setTod(Player p) {
        p.getInventory().clear();
        ItemStack i = new ItemStack(Material.GOLD_HOE, 1);
        ItemMeta i1 = i.getItemMeta();
        i1.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        i.setItemMeta(i1);
        p.getInventory().setItem(1, i);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }

    public static void setEnderman(Player p) {
        p.getInventory().clear();
        ItemStack i = new ItemStack(Material.ENDER_PEARL, 8);
        p.getInventory().setItem(1, i);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        stick.setItemMeta(stickmeta);
        p.getInventory().setItem(0, stick);
        p.getInventory().setItem(8, listener.build(Material.NETHER_STAR, 1, 0, "\u00a7cKitauswahl", "\u00a77W\u00e4hle dein Kit!"));
    }
}

