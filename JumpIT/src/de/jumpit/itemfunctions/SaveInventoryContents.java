package de.jumpit.itemfunctions;

import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.jumpit.main.Main;

public class SaveInventoryContents implements Listener{
	 public static void saveInventory(Player p)
             throws Exception
           {
             Inventory inv = p.getInventory();
             

             
             
             
             ConfigurationSection sectionContents = cfg.createSection(getUUID.getUUIDFromString(p.getName()) + ".Inventory.Contents");
             for (int i = 0; i < inv.getContents().length; i++) {
               if (inv.getContents()[i] != null) {
                 sectionContents.set(String.valueOf(i), inv.getContents()[i]);
               }
             }
             ConfigurationSection sectionArmor = cfg.createSection(getUUID.getUUIDFromString(p.getName()) + ".Inventory.Armor");
             for (int i = 0; i < p.getInventory().getArmorContents().length; i++) {
               if (p.getInventory().getArmorContents()[i] != null) {
                 sectionArmor.set(String.valueOf(i), p.getInventory().getArmorContents()[i]);
               }
             }
             try
             {
               cfg.save(file);
               p.sendMessage(Main.pr +"Dein §6§lKit §8wurde §6§lerfolgreich §8gespeichert."+ Main.su);
             }
             catch (IOException e)
             {
               e.printStackTrace();
             }
           }
           
           public static void getInventory(Player p)
             throws Exception
           {
                  if(cfg.contains(getUUID.getUUIDFromString(p.getName()))) {
             ItemStack[] contentList = new ItemStack[p.getInventory().getContents().length];
             ItemStack[] armorList = new ItemStack[4];
             
             ConfigurationSection sectionContents = cfg.getConfigurationSection(getUUID.getUUIDFromString(p.getName()) +  ".Inventory.Contents");
             for (int i = 0; i < p.getInventory().getContents().length; i++)
             {
               ItemStack stack = sectionContents.getItemStack(String.valueOf(i));
               contentList[i] = stack;
             }
             ConfigurationSection sectionArmor = cfg.getConfigurationSection(getUUID.getUUIDFromString(p.getName()) + ".Inventory.Armor");
             for (int i = 0; i < p.getInventory().getArmorContents().length; i++)
             {
               ItemStack stack = sectionArmor.getItemStack(String.valueOf(i));
               armorList[i] = stack;
             }
             p.getInventory().setContents(contentList);
             p.getInventory().setArmorContents(armorList);
             p.updateInventory();
             
             p.sendMessage(Main.pr +"Dein §6§lKit §8wird geladen..."+ Main.su);
                  } else {
                      p.sendMessage(Main.pr +"Du hast noch kein §6§lKit §8!"+ Main.su);
                  }
           }
           
}
