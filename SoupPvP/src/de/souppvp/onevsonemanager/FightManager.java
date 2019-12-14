package de.souppvp.onevsonemanager;

import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.conversations.PlayerNamePrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Score;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;
import de.souppvp.main.Main;
import de.souppvp.spawnmanager.SpawnManager;

public class FightManager {
	
	public static ArrayList<Player> onevsone = new ArrayList<>();
	public static HashMap<String, String> PlayerO = new HashMap<>();
	public static HashMap<String, String> PlayerT = new HashMap<>();
 	public static void startOneVSOne(Player PlayerOne, Player PlayerTwo){

 		for(Player all : Bukkit.getOnlinePlayers()){
 			if(!all.getName().equals(PlayerOne.getName()) || !all.getName().equals(PlayerTwo.getName())){
 				PlayerOne.hidePlayer(all);
 				PlayerTwo.hidePlayer(all);
 				PlayerTwo.showPlayer(PlayerOne);
 				PlayerOne.showPlayer(PlayerTwo);
 			}
 		}
 		
 		PlayerOne.sendTitle("", "");
 		PlayerTwo.sendTitle("", "");
		Data.OneVSOneWarteschlange.remove(PlayerOne);
		Data.OneVSOneWarteschlange.remove(PlayerTwo);
		Data.firstJoin.remove(PlayerOne);
		Data.firstJoin.remove(PlayerTwo);
 		OneVSOneChallenger.fight.remove(PlayerOne);
 		OneVSOneChallenger.fight.remove(PlayerTwo);
 		
		SpawnManager.teleportToSpawn(PlayerOne, "1vs1-01");
		SpawnManager.teleportToSpawn(PlayerTwo, "1vs1-02");
		getOneVSOneItemsInGame(PlayerOne);
		getOneVSOneItemsInGame(PlayerTwo);
		onevsone.add(PlayerOne);
		onevsone.add(PlayerTwo);
		Data.OneVSOneJoin.remove(PlayerOne);
		Data.OneVSOneJoin.remove(PlayerTwo);
		Data.INOneVSOneJoin.add(PlayerOne);
		Data.INOneVSOneJoin.add(PlayerTwo);
		PlayerO.put(PlayerOne.getName(), PlayerTwo.getName());
		PlayerT.put(PlayerTwo.getName(), PlayerOne.getName());
		Main.sendActionbar(PlayerOne, Data.Prefix + "§eViel Glück beim §3Kampf §egegen §6" + PlayerTwo.getName());
		Main.sendActionbar(PlayerTwo, Data.Prefix + "§eViel Glück beim §3Kampf §egegen §6" + PlayerOne.getName());
		PlayerOne.playSound(PlayerOne.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
		PlayerTwo.playSound(PlayerTwo.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
		PlayerOne.setLevel(0);
		PlayerOne.setExp(0);
		PlayerTwo.setLevel(0);
		PlayerTwo.setExp(0);
	
		Data.OneVSOneJoin.remove(PlayerOne);
	    Data.OneVSOneJoin.remove(PlayerTwo);
		Scoreboard.setScoreboard(PlayerOne);
		Scoreboard.setScoreboard(PlayerTwo);
		
 	}
	public static void getOneVSOneItemsInGame(Player p){
		p.getInventory().clear();
		ItemStack S = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack h = new ItemStack(Material.IRON_HELMET);
		ItemStack c = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack hh = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack b = new ItemStack(Material.IRON_BOOTS);
		
		p.getInventory().setHelmet(h);
		p.getInventory().setChestplate(c);
		p.getInventory().setLeggings(hh);
		p.getInventory().setBoots(b);
		p.getInventory().setItem(0, S);
		
		ItemStack su = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sm = su.getItemMeta();
		sm.setDisplayName("§3Suppe");
		su.setItemMeta(sm);
		for(int i = 1 ; i < 36 ; i++){
			p.getInventory().setItem(i, su);
		}
		p.updateInventory();
	}
}
