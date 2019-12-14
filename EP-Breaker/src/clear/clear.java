package clear;

import org.bukkit.entity.Player;

/**
 * Created by regnatrix on 28.10.16.
 */
public class clear {


    public static void clearInv(Player p) {

        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
    }


}
