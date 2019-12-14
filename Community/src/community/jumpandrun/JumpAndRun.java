package community.jumpandrun;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.community.utils.Data;

public class JumpAndRun implements Listener{
	
	public static HashMap<String, Location> Checkpoint = new HashMap<>();
	public static HashMap<String, Integer> x = new HashMap<>();
	public static HashMap<String, Integer> z = new HashMap<>();

	@EventHandler
	public void onS(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("jumpandrun")){
			if(!e.getLine(1).isEmpty()){
			if(CommandListener.Maps.contains(e.getLine(1))){
				String i = e.getLine(1);
			e.setLine(0, "§a§m------------");
			e.setLine(1, "§7» §eJoin §7«");
			e.setLine(2, "§2" + i);
			e.setLine(3, "§a§m------------");
			return;
			}else{
				e.setLine(0, "§c§m------------");
				e.setLine(1, "§4Nicht");
				e.setLine(2, "§4Verfügbar");
				e.setLine(3, "§c§m------------");
				e.getPlayer().sendMessage(Data.Prefix + "§eDiese Map existiert nicht!");
				return;
			}
		}else{
			e.setLine(0, "§c§m------------");
			e.setLine(1, "§4Nicht");
			e.setLine(2, "§4Verfügbar");
			e.setLine(3, "§c§m------------");
			e.getPlayer().sendMessage(Data.Prefix + "§eTrage einen Mapnamen in die zweite Zeile ein!");
			return;
		}
		}
	
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		 if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		        Block b = e.getClickedBlock();
		        if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN)) {
		          Sign s = (Sign)b.getState();
		          Player p = e.getPlayer();
		          
		          if (s.getLine(1).equalsIgnoreCase("§7» §eJoin §7«")){
		        	  CommandListener.loadList();
		        	  String line = s.getLine(2).replace("§2", "");
		        	  if(CommandListener.Maps.contains(line)){
		        		  p.sendMessage(Data.Prefix + "§aDu wirst auf die Map teleportiert...");
		        		  JumpAndRunManager.teleportToSpawn(p, line);
		        		  CommandListener.InGame.add(p);
		        		  p.getInventory().clear();
		        		  Checkpoint.put(p.getName(), p.getLocation());
		        		  x.put(p.getName(), (int) p.getLocation().getX());
		        		  z.put(p.getName(), (int) p.getLocation().getZ());

		        		  p.getInventory().setItem(0, createItem(Material.NETHER_STAR, 1, 0, "§eZurück zum Checkpoint"));
		        		  p.getInventory().setItem(8, createItem(Material.INK_SACK, 1, 1, "§cJumpAndRun verlassen"));
		        		  
		        		  p.updateInventory();
		        		  
		        		  p.sendTitle("§6JumpAndRun", "§a" + line);
		        	  }else{
		        		  p.sendMessage(Data.Prefix + "§cEs gab einen Fehler mit dieser Map!");
		        	  }
		          }
	}
		 }
		}catch(Exception e1){}
		 
	}
	
	public ItemStack createItem(Material m, int anzahl, int shortid, String Displayname){
		ItemStack i = new ItemStack(m, anzahl, (short) shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(Displayname);
		i.setItemMeta(im);
		
		return i;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(CommandListener.InGame.contains(e.getPlayer())){
			if(e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {	
				if(z.get(e.getPlayer().getName()) != e.getPlayer().getLocation().getZ() && x.get(e.getPlayer().getName()) != e.getPlayer().getLocation().getX()){
					z.put(e.getPlayer().getName(), (int) e.getPlayer().getLocation().getZ());
					x.put(e.getPlayer().getName(), (int) e.getPlayer().getLocation().getX());
					Checkpoint.put(e.getPlayer().getName(), e.getPlayer().getLocation());
					 e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHICKEN_EGG_POP, 10, 10);
					 e.getPlayer().sendMessage(Data.Prefix + "§eDu hast einen §3Checkpoint §egesetzt!");
					 return;
				}
		}
		}
	}
	@EventHandler
	public void onInteracta(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			try{ 
			if(e.getItem().getType() == Material.NETHER_STAR){
				 if(CommandListener.InGame.contains(e.getPlayer())){
					 e.getPlayer().teleport(Checkpoint.get(e.getPlayer().getName()));
					 e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 10);
					 e.getPlayer().sendMessage(Data.Prefix + "§eDu hast dich zu deinem letzem §3Checkpoint §eteleportiert!");
					 return;
				 }
			 }
		}catch(Exception e1){}
		}
	}
}
