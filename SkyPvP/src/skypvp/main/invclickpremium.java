package skypvp.main;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class invclickpremium implements Listener{
	

	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§aKitauswahlmenü")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
				if(p.hasPermission("Skypvp.premium")){
				p.sendMessage(main.Prefix + "§bDu hast das Kit §aPremium§b ausgewählt!");
				p.sendTitle("§b§lKit:", "§a§lPremium");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				
				ItemStack ih = new ItemStack(Material.DIAMOND_HELMET);
				ItemMeta ihmeta = ih.getItemMeta();
				ihmeta.setDisplayName("§8<§6 ChainHelmet§8 >");
				ih.setItemMeta(ihmeta);
				
				ItemStack is = new ItemStack(Material.IRON_SWORD);
				ItemMeta ismeta = is.getItemMeta();
				ismeta.setDisplayName("§8<§6 EisenSword§8 >");
				is.setItemMeta(ismeta);
				
				ItemStack ic = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta icmeta = ic.getItemMeta();
				icmeta.setDisplayName("§8<§6 DiamondPlate§8 >");
				ic.setItemMeta(icmeta);
				
				ItemStack il = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemMeta ilmeta = il.getItemMeta();
				ilmeta.setDisplayName("§8<§6 ChainLeggings§8 >");
				il.setItemMeta(ilmeta);
				
				ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta dbmeta = db.getItemMeta();
				dbmeta.setDisplayName("§8<§6 DiamondBoots§8 >");
				db.setItemMeta(dbmeta);
				
				ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta dcmeta = dc.getItemMeta();
				dcmeta.setDisplayName("§8<§6 EisenHose§8 >");
				dc.setItemMeta(dcmeta);
				
				ItemStack ib = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta ibmeta = ib.getItemMeta();
				ibmeta.setDisplayName("§8<§6 IronBoots§8 >");
				ib.setItemMeta(ibmeta);
				
				ItemStack ss = new ItemStack(Material.IRON_SWORD);
				ItemMeta ssmeta = ss.getItemMeta();
				ibmeta.setDisplayName("§8<§6 StoneSword§8 >");
				ss.setItemMeta(ssmeta);
				
				ItemStack fr = new ItemStack(Material.FISHING_ROD);
				ItemMeta frmeta = fr.getItemMeta();
				frmeta.setDisplayName("§8<§6 Rod§8 >");
				fr.setItemMeta(frmeta);
				
				ItemStack b = new ItemStack(Material.BOW);
				ItemMeta bmeta = b.getItemMeta();
				bmeta.setDisplayName("§8<§6 Bow§8 >");
				b.setItemMeta(bmeta);
				
				ItemStack a = new ItemStack(Material.GOLDEN_APPLE, 8);
				ItemMeta ameta = a.getItemMeta();
				ameta.setDisplayName("§8<§6 GoldApfel§8 >");
				a.setItemMeta(ameta);
				
				ItemStack ak = new ItemStack(Material.ARROW, 2);
				ItemMeta akmeta = ak.getItemMeta();
				akmeta.setDisplayName("§8<§6 Arrow§8 >");
				ak.setItemMeta(akmeta);
				
				ItemStack s = new ItemStack(Material.COOKED_BEEF, 64);
				ItemMeta sm = s.getItemMeta();
				sm.setDisplayName("§8<§6 Steak§8 >");
				s.setItemMeta(sm);
				
				ItemStack ilq = new ItemStack(Material.NETHER_STAR);
				ItemMeta ilmetaq = ilq.getItemMeta();
				ilmetaq.setDisplayName("§aWähle dein Kit!");
				ilq.setItemMeta(ilmetaq);
				
				p.getInventory().remove(ilq);
				
				p.getInventory().addItem(is);
				p.getInventory().setHelmet(ih);
				p.getInventory().setChestplate(ic);
				p.getInventory().setLeggings(il);
				p.getInventory().setBoots(ib);
				p.getInventory().addItem(s);
				p.getInventory().addItem(a);
				p.updateInventory();
				p.closeInventory();
			}
		}
		}
	}


}
