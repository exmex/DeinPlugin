package Compass;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Main.Menu;
import Utils.Language;
import Utils.LanguageUtil;


public class CompassListener implements Listener{

	private Inventory inv=null;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLanguage(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getInventory().getName().equalsIgnoreCase("Wähle deine Sprache")
				||e.getInventory().getName().equalsIgnoreCase("Choose your Language")) {
			
			ItemStack i = e.getCurrentItem();
			
			if (i.getData().getData() == 11) {
				e.setCancelled(true);
				p.closeInventory();
				Language l = Language.GERMAN;
				Main.playerLanguage.put(p, l);
				LanguageUtil u = new LanguageUtil();
				p.sendMessage(Main.pre + "Deine Sprache wurde auf §eDeutsch §3gesetzt.");
				Menu.getMenu(p);
			} else if (i.getData().getData() == 1) {
				e.setCancelled(true);
				p.closeInventory();
				Language l = Language.ENGLISH;
				Main.playerLanguage.put(p, l);
				LanguageUtil u = new LanguageUtil();
				p.sendMessage(Main.pre + "Your language has been set to §eEnglish§3.");
				Menu.getMenu(p);
			} else {
				e.setCancelled(true);
				p.closeInventory();
			}
			
		}
		
	}
	
    @EventHandler
    public void Spielmodi(PlayerInteractEvent event) {   
        Player p = event.getPlayer();     
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) | event.getAction().equals(Action.RIGHT_CLICK_AIR)) {    
        	
        	if (p.getItemInHand().getType() == Material.EMERALD) {
        		Inventory i = null;
        		
        		Language l = Main.playerLanguage.get(p);
        		
        		if (l == Language.GERMAN) {
        			i = Bukkit.createInventory(null, 9, "Wähle deine Sprache");
        			
        			ItemStack g = new ItemStack(Material.INK_SACK, 1, (short) 11);
        			ItemMeta gm = g.getItemMeta();
        			gm.setDisplayName("§aDeutsch");
        			g.setItemMeta(gm);
        			
        			ItemStack e = new ItemStack(Material.INK_SACK, 1, (short) 1);
        			ItemMeta em = e.getItemMeta();
        			em.setDisplayName("§eEnglish");
        			e.setItemMeta(em);
        			
        			i.setItem(2, g);
        			i.setItem(6, e);
        		} else {
        			i = Bukkit.createInventory(null, 9, "Choose your Language");
        			
        			ItemStack g = new ItemStack(Material.INK_SACK, 1, (short) 11);
        			ItemMeta gm = g.getItemMeta();
        			gm.setDisplayName("§aDeutsch");
        			g.setItemMeta(gm);
        			
        			ItemStack e = new ItemStack(Material.INK_SACK, 1, (short) 1);
        			ItemMeta em = e.getItemMeta();
        			em.setDisplayName("§eEnglish");
        			e.setItemMeta(em);
        			
        			i.setItem(2, g);
        			i.setItem(6, e);
        		}
        		
        		p.openInventory(i);
        		
        	}
        	
        if(p.getItemInHand().getType() == Material.COMPASS) {
     
       
        inv = p.getPlayer().getServer().createInventory(null, 27, "Teleporter");
        
        if (Main.playerLanguage.get(p) == Language.GERMAN) {
            ItemStack TM = new ItemStack(Material.STONE_SWORD);
            ItemMeta TMMeta = TM.getItemMeta();
            TMMeta.setDisplayName("§6FFA");
            List<String> lore2 = new ArrayList<String>();    
            lore2.add("§8‣ §7Klicken zum Teleportieren.");
            TMMeta.setLore(lore2);
            TM.setItemMeta(TMMeta);
            inv.setItem(11, TM);
            
            ItemStack SkyPvP = new ItemStack(Material.FISHING_ROD);
            ItemMeta SkyPvPMeta = SkyPvP.getItemMeta();
            SkyPvPMeta.setDisplayName("§61vs1");
            List<String> lore = new ArrayList<String>();    
            lore.add("§8‣ §7Klicken zum Teleportieren.");
            SkyPvPMeta.setLore(lore);
            SkyPvP.setItemMeta(SkyPvPMeta);
            inv.setItem(4, SkyPvP);
            
            ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta SpawnMeta = Spawn.getItemMeta();
            SpawnMeta.setDisplayName("§aSpawn");
            List<String> lore141 = new ArrayList<String>();    
            lore141.add("§8‣ §7Klicken zum Teleportieren.");
            SpawnMeta.setLore(lore141);
            Spawn.setItemMeta(SpawnMeta);
            inv.setItem(13, Spawn);
                 
            ItemStack Rush = new ItemStack(Material.CAULDRON_ITEM);
            ItemMeta RushMeta = Rush.getItemMeta();
            RushMeta.setDisplayName("§6SG und QSG");
            List<String> lore3 = new ArrayList<String>();    
            lore3.add("§8‣ §7Klicken zum Teleportieren.");
            RushMeta.setLore(lore3);
            Rush.setItemMeta(RushMeta);
            inv.setItem(3, Rush);

            
            ItemStack MLG = new ItemStack(Material.GOLDEN_CARROT);
            ItemMeta MLGME = MLG.getItemMeta();
            MLGME.setDisplayName("§6Others");
            List<String> lore12 = new ArrayList<String>();    
            lore12.add("§8‣ §7Klicken zum Teleportieren.");
            MLGME.setLore(lore12);
            MLG.setItemMeta(MLGME);
            inv.setItem(5, MLG);

            
            ItemStack C = new ItemStack(Material.GOLD_INGOT);
            ItemMeta CMeta = C.getItemMeta();
            CMeta.setDisplayName("§6Store");
            List<String> lore4 = new ArrayList<String>();    
            lore4.add("§8‣ §7Klicken zum Teleportieren.");
            CMeta.setLore(lore4);
            C.setItemMeta(CMeta);
            inv.setItem(22, C);
            
            ItemStack C11 = new ItemStack(Material.FEATHER);
            ItemMeta CMeta11 = C11.getItemMeta();
            CMeta11.setDisplayName("§dJump and Run");
            List<String> lore41 = new ArrayList<String>();    
            lore41.add("§8‣ §7Klicken zum Teleportieren.");
            CMeta11.setLore(lore41);
            C11.setItemMeta(CMeta11);
            inv.setItem(23, C11);
            
            ItemStack Team = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            ItemMeta TeamMeta = Team.getItemMeta();
            TeamMeta.setDisplayName("§6Team");
            List<String> lore411 = new ArrayList<String>();    
            lore411.add("§8‣ §7Klicken zum Teleportieren.");
            TeamMeta.setLore(lore411);
            Team.setItemMeta(TeamMeta);
            inv.setItem(21, Team);
            
            ItemStack Leer = new ItemStack(Material.GLASS_BOTTLE);
            ItemMeta LeerMeta = Leer.getItemMeta();
            LeerMeta.setDisplayName("§cBald");
            Leer.setItemMeta(LeerMeta);
            inv.setItem(15, Leer);
            
        } else {
        	ItemStack TM = new ItemStack(Material.STONE_SWORD);
            ItemMeta TMMeta = TM.getItemMeta();
            TMMeta.setDisplayName("§6FFA");
            List<String> lore2 = new ArrayList<String>();    
            lore2.add("§8‣ §7Click to teleport.");
            TMMeta.setLore(lore2);
            TM.setItemMeta(TMMeta);
            inv.setItem(11, TM);
            
            ItemStack SkyPvP = new ItemStack(Material.FISHING_ROD);
            ItemMeta SkyPvPMeta = SkyPvP.getItemMeta();
            SkyPvPMeta.setDisplayName("§61vs1");
            List<String> lore = new ArrayList<String>();    
            lore.add("§8‣ §7Click to teleport.");
            SkyPvPMeta.setLore(lore);
            SkyPvP.setItemMeta(SkyPvPMeta);
            inv.setItem(4, SkyPvP);
            
            ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
            ItemMeta SpawnMeta = Spawn.getItemMeta();
            SpawnMeta.setDisplayName("§aSpawn");
            List<String> lore141 = new ArrayList<String>();    
            lore141.add("§8‣ §7Click to teleport.");
            SpawnMeta.setLore(lore141);
            Spawn.setItemMeta(SpawnMeta);
            inv.setItem(13, Spawn);
                 
            ItemStack Rush = new ItemStack(Material.CAULDRON_ITEM);
            ItemMeta RushMeta = Rush.getItemMeta();
            RushMeta.setDisplayName("§6SG and QSG");
            List<String> lore3 = new ArrayList<String>();    
            lore3.add("§8‣ §7Click to teleport.");
            RushMeta.setLore(lore3);
            Rush.setItemMeta(RushMeta);
            inv.setItem(3, Rush);

            
            ItemStack MLG = new ItemStack(Material.GOLDEN_CARROT);
            ItemMeta MLGME = MLG.getItemMeta();
            MLGME.setDisplayName("§6Others");
            List<String> lore12 = new ArrayList<String>();    
            lore12.add("§8‣ §7Click to teleport.");
            MLGME.setLore(lore12);
            MLG.setItemMeta(MLGME);
            inv.setItem(5, MLG);

            
            ItemStack C = new ItemStack(Material.GOLD_INGOT);
            ItemMeta CMeta = C.getItemMeta();
            CMeta.setDisplayName("§6Store");
            List<String> lore4 = new ArrayList<String>();    
            lore4.add("§8‣ §7Click to teleport.");
            CMeta.setLore(lore4);
            C.setItemMeta(CMeta);
            inv.setItem(22, C);
            
            ItemStack C11 = new ItemStack(Material.FEATHER);
            ItemMeta CMeta11 = C11.getItemMeta();
            CMeta11.setDisplayName("§dJump and Run");
            List<String> lore41 = new ArrayList<String>();    
            lore41.add("§8‣ §7Click to teleport.");
            CMeta11.setLore(lore41);
            C11.setItemMeta(CMeta11);
            inv.setItem(23, C11);
            
            ItemStack Team = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            ItemMeta TeamMeta = Team.getItemMeta();
            TeamMeta.setDisplayName("§6Team");
            List<String> lore411 = new ArrayList<String>();    
            lore411.add("§8‣ §7Click to teleport.");
            TeamMeta.setLore(lore411);
            Team.setItemMeta(TeamMeta);
            inv.setItem(21, Team);
            
            ItemStack Leer = new ItemStack(Material.GLASS_BOTTLE);
            ItemMeta LeerMeta = Leer.getItemMeta();
            LeerMeta.setDisplayName("§cComing soon");
            Leer.setItemMeta(LeerMeta);
            inv.setItem(15, Leer);
            
        }
        
       

        p.openInventory(inv);    
            
        }
    }
    }
}
