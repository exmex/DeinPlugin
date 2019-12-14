package de.golgolex.freebuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.Stats;

public class LISTENER_BlockBreakEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onBlockBreak(BlockBreakEvent e){
    	Player p = e.getPlayer();
    	if(e.getBlock().getType() == Material.DIAMOND_ORE){
    	if(p.getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)){
    		p.sendMessage(Data.pr + "§7Du erhälst keine Coins, da du dieses Erz mit einer Silk Touch Spitzhacke abbaust");
    	}else{
    		Bukkit.broadcastMessage(Data.pr + "§7Der Spieler §2" + p.getName() + "§7 hat einen §aDiamanten §7gefunden!");
    		p.playSound(p.getLocation(), Sound.LEVEL_UP, 4, 4);
    		TitleAPI.sendTitle(p, 10, 20, 10, "§8[§a+§8] §210 §7Coins");
    		Stats.Coins.put(p.getUniqueId(), Stats.Coins.get(p.getUniqueId()) + 10);
    		
    	}
    	}else
    	if(e.getBlock().getType() == Material.GLOWING_REDSTONE_ORE || e.getBlock().getType() == Material.REDSTONE_ORE){
        	if(p.getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)){
        		p.sendMessage(Data.pr + "§7Du erhälst keine Coins, da du dieses Erz mit einer Silk Touch Spitzhacke abbaust");
        		return;
        	}else{
        		p.playSound(p.getLocation(), Sound.LEVEL_UP, 4, 4);
        		Stats.Coins.put(p.getUniqueId(), Stats.Coins.get(p.getUniqueId())+ 4);
        		TitleAPI.sendTitle(p, 10, 20, 10, "§8[§a+§8] §24 §7Coins");
        	}
        	}else
    	if(e.getBlock().getType() == Material.LAPIS_ORE){
        	if(p.getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)){
        		p.sendMessage(Data.pr + "§7Du erhälst keine Coins, da du dieses Erz mit einer Silk Touch Spitzhacke abbaust");
        		return;
        	}else{
        		p.playSound(p.getLocation(), Sound.LEVEL_UP, 4, 4);
        		Stats.Coins.put(p.getUniqueId(), Stats.Coins.get(p.getUniqueId())+ 3);
        		TitleAPI.sendTitle(p, 10, 20, 10, "§8[§a+§8] §23 §7Coins");
        	}
        	}else
    	if(e.getBlock().getType() == Material.EMERALD_ORE){
        	if(p.getItemInHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)){
        		p.sendMessage(Data.pr + "§7Du erhälst keine Coins, da du dieses Erz mit einer Silk Touch Spitzhacke abbaust");
        		return;
        	}else{
        		p.playSound(p.getLocation(), Sound.LEVEL_UP, 4, 4);
        		Stats.Coins.put(p.getUniqueId(), Stats.Coins.get(p.getUniqueId())+ 3);
        		TitleAPI.sendTitle(p, 10, 20, 10, "§8[§a+§8] §23 §7Coins");
        	}
        	}
    }

}
