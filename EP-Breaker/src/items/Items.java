package items;

import clear.clear;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Created by regnatrix on 28.10.16.
 */
public class Items {

    public static ItemStack createItem(Material mat, String displayname, Enchantment enchant, int level){

        ItemStack item = new ItemStack(mat, 1, (short) 0 );
        ItemMeta mitem = item.getItemMeta();
        if (displayname != null) mitem.setDisplayName(displayname);
        if (enchant != null || level != 0) mitem.addEnchant(enchant, 2, true);
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack[] createArmor(Color color) {
        ItemStack it = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) it.getItemMeta();
        if (color != null) meta.setColor(color);
        it.setItemMeta(meta);
        return new ItemStack[] {it, it, it, it};
    }

    public static void createEquip(Player p) {
        p.getInventory().setItem(0, createItem(Material.IRON_SWORD , "§cSchwert" , Enchantment.DURABILITY, 1));
        p.getInventory().setItem(1, createItem(Material.FISHING_ROD, "§cAngel", Enchantment.DURABILITY, 1));
        p.getInventory().setItem(3, createItem(Material.STONE_PICKAXE, "§cSpitzhacke",Enchantment.DURABILITY, 1));
        p.getInventory().setItem(8,createItem(Material.SANDSTONE, "§cBlöcke",null, 0));
    }



    public static void Rusher(Player p) {
        clear.clearInv(p);
        p.getInventory().setArmorContents(createArmor(Color.RED));
        createEquip(p);
        p.getInventory().setItem(2, createItem(Material.ENDER_PEARL, "§cEnderperle",null,0));
    }

    public static void Basedev(Player p) {
        clear.clearInv(p);
        p.getInventory().setArmorContents(createArmor(Color.BLUE));
        createEquip(p);
        p.getInventory().setItem(2, createItem(Material.BOW, "§cBogen",Enchantment.ARROW_INFINITE,1));
        p.getInventory().setItem(7, createItem(Material.ARROW, "§cPfeil", null,0));
    }




    public static void setItem(Player p) {


        if(p.hasPermission("ep.team")) {
            clear.clearInv(p);
            p.getInventory().setItem(0, createItem(Material.DIAMOND, "§c§oStart" , null , 0));
            p.getInventory().setItem(8,createItem(Material.SLIME_BALL,  "§7§oVerlassen", null , 0));
        }else {
            clear.clearInv(p);
            p.getInventory().setItem(8,createItem(Material.SLIME_BALL,  "§7§oVerlassen", null , 0)); ;
        }

    }










}
