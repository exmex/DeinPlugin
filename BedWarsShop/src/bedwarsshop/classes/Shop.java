package bedwarsshop.classes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Shop implements Listener{
	
	
	@EventHandler
    public void onTest(PlayerInteractEntityEvent e)
    {
		try{
        if(e.getRightClicked().getType() == EntityType.VILLAGER){
        	Inventory inv = Bukkit.createInventory(null, 27, "§6Shop");
        	Villager v = (Villager) e.getRightClicked();
        	Player p = e.getPlayer();
        	if(v.getCustomName().equalsIgnoreCase("§6Shop")){
        		e.setCancelled(true);
        		inv = Bukkit.createInventory(null, 27, "§6Shop");
        		setMainShop(p, inv);
        		p.openInventory(inv);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);
        		p.playEffect(v.getLocation(), Effect.EXPLOSION, 1);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);
        		p.playEffect(v.getLocation(), Effect.LAVA_POP, 10);

        	}
        }
        
		}catch(Exception e1){}
    }
	@EventHandler
	public void onClick(InventoryClickEvent e){ 
		Inventory inv = Bukkit.createInventory(null, 27, "§6Shop");
			Player p = (Player)e.getWhoClicked();
			if(e.getInventory().getName().equals("§6Shop")){
				e.setCancelled(true);
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eBlöcke")){
					setBlöckeShop(p, inv);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e4x Sandstein")){
					check(e, p, Material.CLAY_BRICK, 2, Material.SANDSTONE, 4);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e16x Sandstein")){
					check(e, p, Material.CLAY_BRICK, 8, Material.SANDSTONE, 16);
					return;
			}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eEndstein")){
					check(e, p, Material.CLAY_BRICK, 8, Material.ENDER_STONE, 2);
					return;
			}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eEisenblock")){
					check(e, p, Material.IRON_INGOT, 3, Material.IRON_BLOCK, 1);
					return;
			}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGlas")){
					check(e, p, Material.CLAY_BRICK, 7, Material.GLASS, 4);
					return;
			}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRüstung")){
					setRüstungShop(p, inv);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLederhelm")){
					checkReturn1Enchantment(e, p, Material.CLAY_BRICK, 1, Material.LEATHER_HELMET, 1, Enchantment.DURABILITY, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLederhose")){
					checkReturn1Enchantment(e, p, Material.CLAY_BRICK, 1, Material.LEATHER_LEGGINGS, 1, Enchantment.DURABILITY, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLederschuhe")){
					checkReturn1Enchantment(e, p, Material.CLAY_BRICK, 1, Material.LEATHER_BOOTS, 1, Enchantment.DURABILITY, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrustpanzer §7(Level 1)")){
					check(e, p, Material.IRON_INGOT, 1, Material.CHAINMAIL_CHESTPLATE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrustpanzer §7(Level 2)")){
					checkReturn1Enchantment(e, p, Material.IRON_INGOT, 3, Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrustpanzer §7(Level 3)")){
					checkReturn1Enchantment(e, p, Material.IRON_INGOT, 6, Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrustpanzer §7(Level 4)")){
					checkReturn2Enchantment(e, p, Material.IRON_INGOT, 12, Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.PROTECTION_PROJECTILE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBrustpanzer §7(Level 5)")){
					checkReturn3Enchantment(e, p, Material.GOLD_INGOT, 6, Material.CHAINMAIL_CHESTPLATE, 1, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.PROTECTION_PROJECTILE, 2, Enchantment.THORNS, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eSpitzhacken")){
					setSpitzhackenShop(p, inv);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolzspitzhacke")){
					check(e, p, Material.CLAY_BRICK, 4, Material.WOOD_PICKAXE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eHolzspitzhacke §7(Level 2)")){
					checkReturn2Enchantment(e, p, Material.CLAY_BRICK, 14, Material.WOOD_PICKAXE, 1, Enchantment.DIG_SPEED, 1, Enchantment.DURABILITY, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eSteinspitzhacke")){
					check(e, p, Material.IRON_INGOT, 2, Material.STONE_PICKAXE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eEisenspitzhacke")){
					check(e, p, Material.GOLD_INGOT, 1, Material.GOLD_PICKAXE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eDiamantspitzhacke")){
					check(e, p, Material.GOLD_INGOT, 4, Material.DIAMOND_PICKAXE, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Schwerter")){
					setSchwertShop(p, inv);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Knockback-Stick")){
					checkReturn1Enchantment(e, p, Material.CLAY_BRICK, 8, Material.STICK, 1, Enchantment.KNOCKBACK, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Holzschwert")){
					check(e, p, Material.IRON_INGOT, 1, Material.WOOD_SWORD, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Holzschwert §7(Level 2)")){
					checkReturn1Enchantment(e, p, Material.IRON_INGOT, 3, Material.WOOD_SWORD, 1, Enchantment.DAMAGE_ALL, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Steinschwert")){
					checkReturn1Enchantment(e, p, Material.IRON_INGOT, 9, Material.STONE_SWORD, 1, Enchantment.DAMAGE_ALL, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Eisenschwert")){
					checkReturn1Enchantment(e, p, Material.GOLD_INGOT, 5, Material.IRON_SWORD, 1, Enchantment.DAMAGE_ALL, 1);
					return;
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bögen")){
					setBogenShop(p, inv);
					return;
				}
			}
	
	}
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		Player p = (Player) e.getPlayer();

	}

	public void setMainShop(Player p, Inventory inv){
		inv.setItem(0, build(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke"));
		inv.setItem(1, build(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung"));
		inv.setItem(2, build(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken"));
		inv.setItem(3, build(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter"));
		inv.setItem(4, build(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen"));
		inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
		inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
		inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
		inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
		inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		inv.setItem(18, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(19, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(20, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(21, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(22, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(23, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(24, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(25, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		inv.setItem(26, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		p.openInventory(inv);

		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9, 100));
		Methods.erfolg(p);
		return;
	}
	
	  public static ItemStack build(Material m, int anzahl, int sh, String name, String lore) {
	        ItemStack item = new ItemStack(m, anzahl, (short)sh);
	        ItemMeta itemm = item.getItemMeta();
	        itemm.setDisplayName(name);
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(lore);
	        itemm.setLore(list);
	        item.setItemMeta(itemm);
	        return item;
	    }
	  public static ItemStack buildWithEnchantment(Material m, int anzahl, int sh, String name, String lore, Enchantment enchantment, int staerke) {
	        ItemStack item = new ItemStack(m, anzahl, (short)sh);
	        ItemMeta itemm = item.getItemMeta();
	        itemm.setDisplayName(name);
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(lore);
	        itemm.addEnchant(enchantment, staerke, true);
	        itemm.setLore(list);
	        item.setItemMeta(itemm);
	        return item;
	    }
	  public static ItemStack buildWithEnchantment2(Material m, int anzahl, int sh, String name, String lore, Enchantment enchantment, int staerke, Enchantment enchantment2, int staerke2) {
	        ItemStack item = new ItemStack(m, anzahl, (short)sh);
	        ItemMeta itemm = item.getItemMeta();
	        itemm.setDisplayName(name);
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(lore);
	        itemm.addEnchant(enchantment, staerke, true);
	        itemm.addEnchant(enchantment2, staerke2, true);

	        itemm.setLore(list);
	        item.setItemMeta(itemm);
	        return item;
	    }
	  public static ItemStack buildWithEnchantment3(Material m, int anzahl, int sh, String name, String lore, Enchantment enchantment, int staerke, Enchantment enchantment2, int staerke2, Enchantment enchantment3, int staerke3) {
	        ItemStack item = new ItemStack(m, anzahl, (short)sh);
	        ItemMeta itemm = item.getItemMeta();
	        itemm.setDisplayName(name);
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(lore);
	        itemm.addEnchant(enchantment, staerke, true);
	        itemm.addEnchant(enchantment2, staerke2, true);
	        itemm.addEnchant(enchantment3, staerke3, true);

	        itemm.setLore(list);
	        item.setItemMeta(itemm);
	        return item;
	    }
	  public void setBlöckeShop(Player p, Inventory inv){
		  inv.setItem(0, buildWithEnchantment(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke", Enchantment.ARROW_DAMAGE, 1));
			inv.setItem(1, build(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung"));
			inv.setItem(2, build(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken"));
			inv.setItem(3, build(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter"));
			inv.setItem(4, build(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen"));
			inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
			inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
			inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
			inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
			inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		  inv.setItem(18, build(Material.SANDSTONE, 4, 0, "§e4x Sandstein", "§7Kosten: §c2 Bronze"));
		  inv.setItem(19, build(Material.SANDSTONE, 16, 0, "§e16x Sandstein", "§7Kosten: §c8 Bronze"));
			inv.setItem(20, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(21, build(Material.ENDER_STONE, 2, 0, "§eEndstein", "§7Kosten: §c8 Bronze"));
			inv.setItem(22, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(23, build(Material.IRON_BLOCK, 1, 0, "§eEisenblock", "§7Kosten: §f3 Eisen"));
			inv.setItem(24, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(25, build(Material.GLASS, 4, 0, "§eGlas", "§7Kosten: §c7 Bronze"));
			inv.setItem(26, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));

			p.openInventory(inv);

			Methods.erfolg(p);
			return;
	  }
	  public void setRüstungShop(Player p, Inventory inv){
			inv.setItem(0, build(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke"));
			inv.setItem(1, buildWithEnchantment(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung", Enchantment.ARROW_DAMAGE, 1));
			inv.setItem(2, build(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken"));
			inv.setItem(3, build(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter"));
			inv.setItem(4, build(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen"));
			inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
			inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
			inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
			inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
			inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
		  inv.setItem(18, buildWithEnchantment(Material.LEATHER_HELMET, 1, 0, "§cLederhelm", "§7Kosten: §c1 Bronze", Enchantment.DURABILITY, 1));
		  inv.setItem(19, buildWithEnchantment(Material.LEATHER_LEGGINGS, 1, 0, "§cLederhose", "§7Kosten: §c1 Bronze",Enchantment.DURABILITY, 1));
		  inv.setItem(20, buildWithEnchantment(Material.LEATHER_BOOTS, 1, 0, "§cLederschuhe", "§7Kosten: §c1 Bronze",Enchantment.DURABILITY, 1));
			inv.setItem(21, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(22, build(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§cBrustpanzer §7(Level 1)", "§7Kosten: §f1 Eisen"));
		  inv.setItem(23, buildWithEnchantment(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§cBrustpanzer §7(Level 2)", "§7Kosten: §f3 Eisen", Enchantment.PROTECTION_ENVIRONMENTAL, 1));
		  inv.setItem(24, buildWithEnchantment(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§cBrustpanzer §7(Level 3)", "§7Kosten: §f6 Eisen", Enchantment.PROTECTION_ENVIRONMENTAL, 2));
		  inv.setItem(25, buildWithEnchantment2(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§cBrustpanzer §7(Level 4)", "§7Kosten: §f12 Eisen", Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.PROTECTION_PROJECTILE, 1));
		  inv.setItem(26, buildWithEnchantment3(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§cBrustpanzer §7(Level 5)", "§7Kosten: §66 Gold", Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.PROTECTION_PROJECTILE, 2, Enchantment.THORNS, 1));
		  
		  	Methods.erfolg(p);
			p.openInventory(inv);
			return;
	  }
	  public void setSpitzhackenShop(Player p, Inventory inv){
			inv.setItem(0, build(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke"));
			inv.setItem(1, build(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung"));
			inv.setItem(2, buildWithEnchantment(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken", Enchantment.ARROW_DAMAGE, 1));
			inv.setItem(3, build(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter"));
			inv.setItem(4, build(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen"));
			inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
			inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
			inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
			inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
			inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(18, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(19, build(Material.WOOD_PICKAXE, 1, 0, "§eHolzspitzhacke", "§7Kosten: §c4 Bronze"));
		  inv.setItem(20, buildWithEnchantment2(Material.WOOD_PICKAXE, 1, 0, "§eHolzspitzhacke §7(Level 2)", "§7Kosten: §c14 Bronze",Enchantment.DIG_SPEED, 1, Enchantment.DURABILITY, 1));
			inv.setItem(21, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(22, build(Material.STONE_PICKAXE, 1, 0, "§eSteinspitzhacke", "§7Kosten: §f2 Eisen"));
			inv.setItem(23, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(24, build(Material.IRON_PICKAXE, 1, 0, "§eEisenspitzhacke", "§7Kosten: §61 Gold"));
		  inv.setItem(25, build(Material.DIAMOND_PICKAXE, 1, 0, "§eDiamantspitzhacke", "§7Kosten: §64 Gold"));
			inv.setItem(26, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  
		  	Methods.erfolg(p);
			p.openInventory(inv);
			return;
	  }
	  public void setSchwertShop(Player p, Inventory inv){
			inv.setItem(0, build(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke"));
			inv.setItem(1, build(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung"));
			inv.setItem(2, build(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken"));
			inv.setItem(3, buildWithEnchantment(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter", Enchantment.ARROW_DAMAGE, 1));
			inv.setItem(4, build(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen"));
			inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
			inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
			inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
			inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
			inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(18, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  inv.setItem(19, buildWithEnchantment(Material.STICK, 1, 0, "§3Knockback-Stick", "§7Kosten: §c8 Bronze", Enchantment.KNOCKBACK, 1));
		  inv.setItem(20, build(Material.WOOD_SWORD, 1, 0, "§3Holzschwert", "§7Kosten: §f1 Eisen"));
			inv.setItem(21, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
			  inv.setItem(22, buildWithEnchantment(Material.WOOD_SWORD, 1, 0, "§3Holzschwert §7(Level 2)", "§7Kosten: §c3 Eisen", Enchantment.DAMAGE_ALL, 1));
			inv.setItem(23, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
			  inv.setItem(24, buildWithEnchantment(Material.STONE_SWORD, 1, 0, "§3Steinschwert", "§7Kosten: §c9 Eisen", Enchantment.DAMAGE_ALL, 1));
			  inv.setItem(25, buildWithEnchantment(Material.IRON_SWORD, 1, 0, "§3Eisenschwert", "§7Kosten: §c5 Gold", Enchantment.DAMAGE_ALL, 1));
			inv.setItem(26, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  
		  	Methods.erfolg(p);
			p.openInventory(inv);
			return;
	  }
	  public void setBogenShop(Player p, Inventory inv){
			inv.setItem(0, build(Material.HARD_CLAY, 1, 0, "§eBlöcke", "§7Kaufe dir §eBlöcke"));
			inv.setItem(1, build(Material.LEATHER_CHESTPLATE, 1, 0, "§cRüstung", "§7Kaufe dir §cRüstung"));
			inv.setItem(2, build(Material.IRON_PICKAXE, 1, 0, "§eSpitzhacken", "§7Kaufe dir §eSpitzhacken"));
			inv.setItem(3, build(Material.STONE_SWORD, 1, 0, "§3Schwerter", "§7Kaufe dir §3Schwerter"));
			inv.setItem(4, buildWithEnchantment(Material.BOW, 1, 0, "§6Bögen", "§7Kaufe dir §6Bögen", Enchantment.ARROW_DAMAGE, 1));
			inv.setItem(5, build(Material.COOKED_BEEF, 1, 0, "§dEssen", "§7Kaufe dir §dEssen"));
			inv.setItem(6, build(Material.CHEST, 1, 0, "§aTruhen", "§7Kaufe dir §aTruhen"));
			inv.setItem(7, build(Material.POTION, 1, 0, "§bPotions", "§7Kaufe dir §bPotions"));
			inv.setItem(8, build(Material.PAPER, 1, 0, "§fSpezielles", "§7Kaufe dir §fSpezielles"));
			inv.setItem(9, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(10, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(11, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(12, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(13, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(14, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(15, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(16, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(17, build(Material.STAINED_GLASS_PANE, 1, 15, " ", " "));
			inv.setItem(18, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
			inv.setItem(19, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
			  inv.setItem(20, build(Material.BOW, 1, 0, "§6Bogen §7(Level 1)", "§7Kosten: §63 Gold"));
			  inv.setItem(21, buildWithEnchantment(Material.BOW, 1, 0, "§6Bogen §7(Level 2)", "§7Kosten: §67 Gold", Enchantment.ARROW_DAMAGE, 1));
			  inv.setItem(22, buildWithEnchantment(Material.BOW, 1, 0, "§6Bogen §7(Level 3)", "§7Kosten: §613 Gold", Enchantment.ARROW_DAMAGE, 2));
			  inv.setItem(23, buildWithEnchantment(Material.BOW, 1, 0, "§6Bogen §7(Level 4)", "§7Kosten: §636 Gold", Enchantment.ARROW_DAMAGE, 3));
				inv.setItem(24, build(Material.ARROW, 1, 0, "§6Pfeil", "§7Kosten: §c31 Gold"));
				inv.setItem(25, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
			inv.setItem(26, build(Material.STAINED_GLASS_PANE, 1, 7, " ", " "));
		  
		  	Methods.erfolg(p);
			p.openInventory(inv);
			return;
	  }
	  public void check(InventoryClickEvent e, Player p, Material material, int anzahl, Material belohnung, int anzahldesitems){
		  if(p.getInventory().containsAtLeast(new ItemStack(material), anzahl)){
			 
				  p.getInventory().removeItem(new ItemStack(material, anzahl));
				  ItemStack i = new ItemStack(belohnung, anzahldesitems);
				  p.getInventory().addItem(i);
				  Methods.kaufErfolg(p);
			  
		  }else{ 
			  p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Materialien!");
			  Methods.fehler(p);
			  return;
		  }
		    }
	  public void checkWithSubID(InventoryClickEvent e, Player p, Material material, int anzahl, Material belohnung, int anzahldesitems, int subid){
		  if(p.getInventory().containsAtLeast(new ItemStack(material), anzahl)){
			 
				  p.getInventory().removeItem(new ItemStack(material, anzahl));
				  ItemStack i = new ItemStack(belohnung, anzahldesitems, (short)subid);
				  p.getInventory().addItem(i);
				  Methods.kaufErfolg(p);
			  
		  }else{ 
			  p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Materialien!");
			  Methods.fehler(p);
			  return;
		  }
		    }
	  public void checkReturn1Enchantment(InventoryClickEvent e, Player p, Material material, int anzahl, Material belohnung, int anzahldesitems, Enchantment enchantment1, int staerke1){
		  if(p.getInventory().containsAtLeast(new ItemStack(material), anzahl)){
			 
				  p.getInventory().removeItem(new ItemStack(material, anzahl));
				  ItemStack i = new ItemStack(belohnung, anzahldesitems);
				  ItemMeta im = i.getItemMeta();
				  im.addEnchant(enchantment1, staerke1, true);
				  i.setItemMeta(im);
				  p.getInventory().addItem(i);
				  Methods.kaufErfolg(p);
			  
		  }else{ 
			  p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Materialien!");
			  Methods.fehler(p);
			  return;
		  }
		    }
	  public void checkReturn2Enchantment(InventoryClickEvent e, Player p, Material material, int anzahl, Material belohnung, int anzahldesitems, Enchantment enchantment1, int staerke1, Enchantment enchantment2, int staerke2){
		  if(p.getInventory().containsAtLeast(new ItemStack(material), anzahl)){
			 
				  p.getInventory().removeItem(new ItemStack(material, anzahl));
				  ItemStack i = new ItemStack(belohnung, anzahldesitems);
				  ItemMeta im = i.getItemMeta();
				  im.addEnchant(enchantment1, staerke1, true);
				  im.addEnchant(enchantment2, staerke2, true);
				  i.setItemMeta(im);
				  p.getInventory().addItem(i);
				  Methods.kaufErfolg(p);
			  
		  }else{ 
			  p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Materialien!");
			  Methods.fehler(p);
			  return;
		  }
		    }
	  public void checkReturn3Enchantment(InventoryClickEvent e, Player p, Material material, int anzahl, Material belohnung, int anzahldesitems, Enchantment enchantment1, int staerke1, Enchantment enchantment2, int staerke2, Enchantment enchantment3, int staerke3){
		  if(p.getInventory().containsAtLeast(new ItemStack(material), anzahl)){
			 
				  p.getInventory().removeItem(new ItemStack(material, anzahl));
				  ItemStack i = new ItemStack(belohnung, anzahldesitems);
				  ItemMeta im = i.getItemMeta();
				  im.addEnchant(enchantment1, staerke1, true);
				  im.addEnchant(enchantment2, staerke2, true);
				  im.addEnchant(enchantment3, staerke3, true);
				  i.setItemMeta(im);
				  p.getInventory().addItem(i);
				  Methods.kaufErfolg(p);
			  
		  }else{ 
			  p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Materialien!");
			  Methods.fehler(p);
			  return;
		  }
		    }
	  }

