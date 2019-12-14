package prosigns.spigotplugins.data;

import org.bukkit.block.Block;

public class SignBackup {
	try{
		
		Data.Useless.put("Test", output[0] + " " + output[1] + " " + output[2]);
		
		}catch(Exception e1){
		
			s.setLine(0, "§c- §4" + BungeeName + "§c -");
			s.setLine(1, "§0[§4OFFLINE§0]");
			s.setLine(2, "§c" + 0 + "§7/§c" + 0);
			s.setLine(3, "§8*§4§lOFFLINE§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 14, true);
			s.update();
			set = true;
			return;
		}
		if(output[0] == output[1]){
			if(!output[2].equalsIgnoreCase("INGAME")){
			s.setLine(1, "§0[§6Premium§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			s.update();
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 1, true);
			set = true;
			return;
		}else{
			s.setLine(1, "§0[§cINGAME§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 8, true);
			set = true;
			s.update();
			return;
		}
		}
		if(output[2].equalsIgnoreCase("INGAME")){
			s.setLine(1, "§0[§cINGAME§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 8, true);
			s.update();
			set = true;
			return;
			
		}
		if(output[2].equalsIgnoreCase("ENDING")){
			s.setLine(1, "§0[§4RESTART§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 6, true);
			s.update();
			set = true;
			return;
			
		}
		if(output[2].equalsIgnoreCase("LOBBY")){
			
			s.setLine(1, "§0[§aLOBBY§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 5, true);
			s.update();
			set = true;
			return;
			
		}
		
		
		if(s.getLine(0).contains("SOUP")){
			s.setLine(1, "§0[§9" + output[2]+ "§0]");
			s.setLine(2, output[0] + "/" + output[1]);
			s.setLine(3, "§8*§e§lKLICK§8*");
			org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
	    	Block ba = s.getBlock();
            Block attached = ba.getRelative(a.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 5, true);
			s.update();
			set = true;
			return;
		}
		s.setLine(1, "§0[§aONLINE§0]");
		s.setLine(2, output[0] + "/" + output[1]);
		s.setLine(3, "§8*§e§lKLICK§8*");
		org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
    	Block ba = s.getBlock();
        Block attached = ba.getRelative(a.getAttachedFace());
        attached.setTypeIdAndData(159, (byte) 5, true);
		s.update();
		set = true;
		
		
}
