package Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import EventListener.Schutzschild;
import Utils.Language;

public class Menu {
	
	public static void getMenu(Player p){
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR, 1));

		Language l = Main.playerLanguage.get(p);
		
	    //Strings
		Inventory inventory = p.getInventory();
		//Item-Menu
		ItemStack Server = new ItemStack(Material.COMPASS);
		ItemMeta serversMeta = Server.getItemMeta();
		if (l == Language.GERMAN) {
			serversMeta.setDisplayName("§6Teleporter");
		} else {
			serversMeta.setDisplayName("§6Teleporter");
		}
		Server.setItemMeta(serversMeta);
		inventory.setItem(0, Server); 
		
		
		ItemStack lang = new ItemStack(Material.EMERALD);
		ItemMeta langMeta = lang.getItemMeta();
		if (l == Language.GERMAN) {
			langMeta.setDisplayName("§6Wähle deine Sprache");
		} else {
			langMeta.setDisplayName("§6Choose your Language");
		}
		lang.setItemMeta(langMeta);
		inventory.setItem(4, lang);
		
		ItemStack sh = new ItemStack(Material.SHEARS);
		ItemMeta shMeta = sh.getItemMeta();
        List<String> lore12 = new ArrayList<String>();   

		if (l == Language.GERMAN) {
			shMeta.setDisplayName("§6Challenger");
			lore12.add("§8‣ §7Fordere einen Spieler heraus.");
			shMeta.setLore(lore12);

		} else {
			shMeta.setDisplayName("§6Challenger");
			lore12.add("§8‣ §7Challenge a Player.");
			shMeta.setLore(lore12);

		}
		sh.setItemMeta(shMeta);
		inventory.setItem(8, sh);
		
		if(!Schutzschild.hiders.contains(p.getUniqueId())){

			ItemStack milk = new ItemStack(Material.BLAZE_ROD);	
			ItemMeta meta = milk.getItemMeta();
			List<String> lore = new ArrayList<String>();   
			if (l == Language.GERMAN) {
   				lore.add("§8‣ §7Rechtsklick um zu benutzen.");
				meta.setLore(lore);
				meta.setDisplayName("§6Spieler verstecken");
			} else {
				lore.add("§8‣ §7Use to hide Players");
				meta.setLore(lore);
    			meta.setDisplayName("§6Hide Players");
			}
			milk.setItemMeta(meta);
			inventory.setItem(1, milk); 
		
		}else{
			ItemStack leermilk = new ItemStack(Material.BLAZE_ROD);	
			ItemMeta meta = leermilk.getItemMeta();
			if (Main.playerLanguage.get(p) == Language.GERMAN) {
		        List<String> lore = new ArrayList<String>();   
				lore.add("§8‣ §7Rechtsklick um zu benutzen.");
				meta.setLore(lore);
				meta.setDisplayName("§6Spieler anzeigen");
			} else {
		        List<String> lore = new ArrayList<String>();   
				lore.add("§8‣ §7Use to show Players");
				meta.setLore(lore);
				meta.setDisplayName("§6Show Players");
			}
			leermilk.setItemMeta(meta);
			inventory.setItem(1, leermilk);			
			
		}
		
		
		ItemStack premium = new ItemStack(Material.GOLDEN_APPLE, (short) 1);	
		ItemMeta premiummeta = premium.getItemMeta();
        List<String> loa = new ArrayList<String>();   
        loa.add("§8‣ §7Lobby-Features");
        premiummeta.setLore(loa);
        premiummeta.setDisplayName("§eFeatures");
        premium.setItemMeta(premiummeta);
		inventory.setItem(7, premium); 
		
		if(p.hasPermission("staff.nick")){

			ItemStack nick = new ItemStack(Material.NAME_TAG);	
			ItemMeta metanick = nick.getItemMeta();
	        List<String> lorenick = new ArrayList<String>();   


			 if (l == Language.GERMAN) {
				 lorenick.add("§8‣ §7Nickt dich.");
					metanick.setLore(lorenick);
					metanick.setDisplayName("§6Nickname");
		        } else {
		        	 lorenick.add("§8‣ §7Change your nickname.");
		 			metanick.setLore(lorenick);
		 			metanick.setDisplayName("§6Nickname");
		        }
				nick.setItemMeta(metanick);
				inventory.setItem(2, nick);  
				
		ItemStack schutz = new ItemStack(Material.EYE_OF_ENDER);	
		ItemMeta schutzmeta = schutz.getItemMeta();
        List<String> lore14 = new ArrayList<String>();   
        if (l == Language.GERMAN) {
            lore14.add("§8‣ §7Schutzschild anschalten.");
            schutzmeta.setLore(lore14);
            schutzmeta.setDisplayName("§aSchutzschild");
        } else {
            lore14.add("§8‣ §7Start Protection");
            schutzmeta.setLore(lore14);
            schutzmeta.setDisplayName("§aProtector");
        }
        schutz.setItemMeta(schutzmeta);
		inventory.setItem(6, schutz); 
		}
	}

}
