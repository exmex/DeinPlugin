package de.golgolex.freebuild.methods;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FreebuildAPI {
	
	public static void setHub(Player p) {

		File ordner = new File("plugins//FreeBuild//Spawn");
		File file = new File("plugins//FreeBuild//Spawn//Spawn.yml");

		if (!ordner.exists()) {
			ordner.mkdir();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		Location loc = p.getLocation();

		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();

		String weltname = loc.getWorld().getName();

		cfg.set("Spawn.X", x);
		cfg.set("Spawn.Y", y);
		cfg.set("Spawn.Z", z);
		cfg.set("Spawn.YAW", yaw);
		cfg.set("Spawn.PITCH", pitch);
		cfg.set("Spawn.WELTNAME", weltname);

		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.sendMessage(Data.pr + "§7Der Spawn wurde erfolgreich gesetzt" );
	}
	
	
	public static Location getHub(Player p){
		File file = new File("plugins//Freebuild//Spawn//Spawn.yml");
		
		if(!(file.exists())){
			p.sendMessage(Data.pr + "§7Der Spawn wurde noch nicht gesetzt");
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		double x = cfg.getDouble("Spawn.X");
		double y = cfg.getDouble("Spawn.Y");
		double z = cfg.getDouble("Spawn.Z");
		double yaw = cfg.getDouble("Spawn.YAW");
		double pitch = cfg.getDouble("Spawn.PITCH");
		String worldn = cfg.getString("Spawn.WELTNAME");
		World world = Bukkit.getWorld(worldn);
		Location loc = new Location(world, x,y,z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		
		p.teleport(loc);
		return loc;
	}
	
	
	public static void setHome(Player p) {

		File ordner = new File("plugins//FreeBuild//Homes");
		File file = new File("plugins//FreeBuild//Homes//" + UUIDManager.getUUID(p.getName()));

		if (!ordner.exists()) {
			ordner.mkdir();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		Location loc = p.getLocation();

		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();

		String weltname = loc.getWorld().getName();

		cfg.set("Home.X", x);
		cfg.set("Home.Y", y);
		cfg.set("Home.Z", z);
		cfg.set("Home.YAW", yaw);
		cfg.set("Home.PITCH", pitch);
		cfg.set("Home.WELTNAME", weltname);

		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.sendMessage(Data.pr + "§7Du hast erfolgreich dein Home gesetzt" );
	}
	
	
	public static Location getHome(Player p){
		File file = new File("plugins//Freebuild//Homes//" + UUIDManager.getUUID(p.getName()));
		
		if(!(file.exists())){
			p.sendMessage(Data.pr + "§7Dein Home wurde noch nicht gesetzt");
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		double x = cfg.getDouble("Home.X");
		double y = cfg.getDouble("Home.Y");
		double z = cfg.getDouble("Home.Z");
		double yaw = cfg.getDouble("Home.YAW");
		double pitch = cfg.getDouble("Home.PITCH");
		String worldn = cfg.getString("Home.WELTNAME");
		World world = Bukkit.getWorld(worldn);
		Location loc = new Location(world, x,y,z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		
		p.teleport(loc);
		return loc;
	}
	
	
	public static ItemStack createItem(Material material, int subid, String displayname) {
		ItemStack item = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(displayname);
		item.setItemMeta(mitem);

		return item;

	}
	
    public static void setFirstJoin(Player p) {
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.sendMessage("");
        p.sendMessage(Data.pr + "§6Willkommen §7auf §2FreeBuild!");
        p.sendMessage("");
        p.sendMessage(Data.pr + "§7- §7Erfarme dir Rohstoffe");
        p.sendMessage(Data.pr + "§7- §7Kaufe im Shop ein");
        p.sendMessage(Data.pr + "§7- §7Verdiene Geld");
        p.sendMessage(Data.pr + "§7- §7Kämpfe gegen andere Spieler");
        p.sendMessage(Data.pr + "§7- §7Handel mit anderen Spielern");
        p.sendMessage("");
        ItemStack Schwert = new ItemStack(Material.IRON_SWORD);
        ItemStack axt = new ItemStack(Material.IRON_AXE);
        ItemStack sp = new ItemStack(Material.IRON_PICKAXE);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
        p.getInventory().setItem(0, Schwert);
        p.getInventory().setItem(1, sp);
        p.getInventory().setItem(2, axt);
        p.getInventory().setItem(7, food);
        ItemStack i = new ItemStack(Material.BOOK);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName("§e§lSpielerklärung");
        im.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
    	im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        i.setItemMeta(im);
        p.getInventory().setItem(8, i);
        p.updateInventory();
    }

}
