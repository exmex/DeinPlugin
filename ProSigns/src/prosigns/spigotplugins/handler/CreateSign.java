package prosigns.spigotplugins.handler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import prosigns.spigotplugins.data.Data;
import prosigns.spigotplugins.data.SignManager;

public class CreateSign implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(e.getBlock().getType() == Material.SIGN || e.getBlock().getType() == Material.WALL_SIGN){
			if(Data.createsign.containsKey(e.getPlayer().getName())){
				if(Data.Transferdata.containsKey(e.getPlayer().getName())) {
					String[] Way = Data.Transferdata.get(e.getPlayer().getName()).split(";");
					String IP = Way[0];
					String Port = Way[1];
					String Bungee = Way[2];
					SignManager.safeSignIntoConfig(Bungee, IP, Integer.parseInt(Port), e.getBlock().getLocation());
			e.getPlayer().sendMessage(Data.Prefix + "§eDas Schild wurde erstellt!");
			e.getPlayer().sendMessage(Data.Prefix + "§eBitte bedenke, dass du den Server reloaden musst!");
			Data.createsign.remove(e.getPlayer().getName());
			Block b = Bukkit.getWorld(e.getBlock().getLocation().getWorld().getName()).getBlockAt(e.getBlock().getLocation());
			Sign s = (Sign)b.getState();
			s.setLine(0, "§c- §4" + Bungee + "§c -");
			s.setLine(1, "§0[§4OFFLINE§0]");
			s.setLine(2, "§c" + 0 + "§7/§c" + 0);
			s.setLine(3, "§8*§4§lOFFLINE§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 14, true);
			s.update();
			Data.currentsigns = Data.currentsigns+1;
			e.setCancelled(true);
			return;
		}
	}
	
	}
	}
}
