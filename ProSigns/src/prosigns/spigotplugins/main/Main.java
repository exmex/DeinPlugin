package prosigns.spigotplugins.main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import prosigns.spigotplugins.data.Data;
import prosigns.spigotplugins.handler.CMD;
import prosigns.spigotplugins.handler.CreateSign;
import prosigns.spigotplugins.handler.JoinListener;
import prosigns.spigotplugins.handler.PingManager;

public class Main extends JavaPlugin {
	static int cd;
	boolean set;
	static int offlineserver;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() { 
	    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    offlineserver = 0;
		getCommand("sign").setExecutor(new CMD());
		Bukkit.getPluginManager().registerEvents(new CreateSign(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new Interact(this), this);
		if(Data.cfg.get("CurrentSigns") == null){
			Data.cfg.set("CurrentSigns", 0);
			try {
				Data.cfg.save(Data.file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Data.currentsigns = Data.cfg.getInt("CurrentSigns");
		}
		
		if(Data.currentsigns == 0){
			Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§4§lES MUSS MINDESTENS 1 SCHILD GESETZT SEIN!");
			return;
		}
		Location loca = new Location(Bukkit.getWorld(Data.cfg.getString(0 + ".LOCATION.WORLDNAME")), Data.cfg.getDouble(0 + ".LOCATION.X"), Data.cfg.getDouble(0 + ".LOCATION.Y"), Data.cfg.getDouble(0 + ".LOCATION.Z"));
		loca.setYaw((float) Data.cfg.getDouble(0 + ".LOCATION.YAW"));
		loca.setPitch((float) Data.cfg.getDouble(0 + ".LOCATION.PITCH"));
		Data.Signs.put(Data.cfg.getString(0 + ".BUNGEENAME"), loca);
		Data.NumberSigns.put(0, loca);
		Data.Adress.put(Data.cfg.getString(0 + ".BUNGEENAME"), Data.cfg.getString(0 + ".IP") + ";" + Data.cfg.getInt(0 + ".PORT"));
		Data.BungeeName.put(loca, Data.cfg.getString(0 + ".BUNGEENAME"));
		for(int i = 1 ; i < Data.currentsigns ; i++){
			Location loc = new Location(Bukkit.getWorld(Data.cfg.getString(i + ".LOCATION.WORLDNAME")), Data.cfg.getDouble(i + ".LOCATION.X"), Data.cfg.getDouble(i + ".LOCATION.Y"), Data.cfg.getDouble(i + ".LOCATION.Z"));
			loc.setYaw((float) Data.cfg.getDouble(i + ".LOCATION.YAW"));
			loc.setPitch((float) Data.cfg.getDouble(i + ".LOCATION.PITCH"));
			Data.Signs.put(Data.cfg.getString(i + ".BUNGEENAME"), loc);
			Data.NumberSigns.put(i, loc);
			Data.Adress.put(Data.cfg.getString(i + ".BUNGEENAME"), Data.cfg.getString(i + ".IP") + ";" + Data.cfg.getInt(i + ".PORT"));
			Data.BungeeName.put(loc, Data.cfg.getString(i + ".BUNGEENAME"));

		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				
			}
		},20L);
		cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				offlineserver++;
				if(offlineserver == 21){
					offlineserver = 0;
				}
				for(int d = 0 ; d < Data.currentsigns ; d++){
					try{
				Location loc = Data.NumberSigns.get(d);
				Block b = Bukkit.getWorld(loc.getWorld().getName()).getBlockAt(loc);
				Sign s = (Sign)b.getState();
				String BungeeName = Data.BungeeName.get(loc);
				s.setLine(0, "§d§l" + BungeeName + "");
				String[] adress = Data.Adress.get(BungeeName).split(";");
				
				String[] output = PingManager.getState(adress[0], Integer.parseInt(adress[1])).split(" ");
			
				String end = "";
				
				if(output[2].equals("OFFLINE")){
					end = "OFFLINE";				
				}else
				if(output[2].equals("LOBBY")){
						end = "LOBBY";
				}else
				if(output[2].equals("INGAME")){
					end = "INGAME";
				}else
				if(output[2].equals("STARTING")){
					end = "STARTING";
				}else
				if(output[2].equals("ENDING")){
					end = "ENDING";
				}else 
				if(Integer.parseInt(output[0]) == Integer.parseInt(output[1])){
					end = "PREMIUM";
				}else
				if(BungeeName.contains("SOUP")){
					if(Integer.parseInt(output[0]) == Integer.parseInt(output[1])){
						end = "FULLKITBATTLE";
					}else{
						end = "NOTFULLKITBATTLE";
					}
				}else{
					end = "UNKNOWN";
				}
				
				if(end.equals("OFFLINE")) {
					s.setLine(0, "§4████████████");
					s.setLine(1, "§0[§4OFFLINE§0]");
					s.setLine(2, "§c" + 0 + "§7/§c" + 0);
					if(offlineserver == 4){
						s.setLine(3, "§c●");
					}
					if(offlineserver == 8){
						s.setLine(3, "§c● ●");
					}
					if(offlineserver == 12){
						s.setLine(3, "§c● ● ●");
					}
					if(offlineserver == 16){
						s.setLine(3, "§c● ● ● ●");
					}
					if(offlineserver == 20){
						s.setLine(3, "§c● ● §c§l● §c● ●");
					}
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 14, true);
					s.update();
				}else
				if(end.equals("STARTING")) {
					s.setLine(0, "§4████████████");
					s.setLine(1, "§0[§4OFFLINE§0]");
					s.setLine(2, "§c" + 0 + "§7/§c" + 0);
					if(offlineserver == 4){
						s.setLine(3, "§c●");
					}
					if(offlineserver == 8){
						s.setLine(3, "§c● ●");
					}
					if(offlineserver == 12){
						s.setLine(3, "§c● ● ●");
					}
					if(offlineserver == 16){
						s.setLine(3, "§c● ● ● ●");
					}
					if(offlineserver == 20){
						s.setLine(3, "§c● ● §c§l● §c● ●");
					}
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 14, true);
					s.update();
				}else if(end.equals("LOBBY")){
					s.setLine(1, "§0[§aLOBBY§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 5, true);
					s.update();
				}else if(end.equals("INGAME")){
					s.setLine(1, "§0[§cINGAME§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 8, true);
					s.update();
				}else if(end.equals("ENDING")){
					s.setLine(1, "§0[§4RESTART§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 6, true);
					s.update();
				}else if(end.equals("PREMIUM")){
					s.setLine(1, "§0[§6Premium§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					s.update();
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 1, true);
				}else if(end.equals("FULLKITBATTLE")){
					s.setLine(1, "§0[§9" + output[2] + "§0]");
					s.setLine(2, "§6" + output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					s.update();
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 1, true);
				}else if(end.equals("NOTFULLKITBATTLE")){
					s.setLine(1, "§0[§9" + output[2] + "§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					s.update();
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 5, true);
				}else{
					s.setLine(1, "§0[§aONLINE§0]");
					s.setLine(2, output[0] + "/" + output[1]);
					s.setLine(3, "§8*§e§lKLICK§8*");
					org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
			    	Block ba = s.getBlock();
		            Block attached = ba.getRelative(a.getAttachedFace());
		            attached.setTypeIdAndData(159, (byte) 5, true);
					s.update();
				}
				
					}catch(Exception e1){
						Location loc = Data.NumberSigns.get(d);
						Block b = Bukkit.getWorld(loc.getWorld().getName()).getBlockAt(loc);
						Sign s = (Sign)b.getState();
						String BungeeName = Data.BungeeName.get(loc);
						s.setLine(0, "§4████████████");
						s.setLine(1, "§0[§4OFFLINE§0]");
						s.setLine(2, "§c" + 0 + "§7/§c" + 0);
						if(offlineserver == 4){
							s.setLine(3, "§c●");
						}
						if(offlineserver == 8){
							s.setLine(3, "§c● ●");
						}
						if(offlineserver == 12){
							s.setLine(3, "§c● ● ●");
						}
						if(offlineserver == 16){
							s.setLine(3, "§c● ● ● ●");
						}
						if(offlineserver == 20){
							s.setLine(3, "§c● ● §c§l● §c● ●");
						}
						org.bukkit.material.Sign a = (org.bukkit.material.Sign) s.getData();
				    	Block ba = s.getBlock();
			            Block attached = ba.getRelative(a.getAttachedFace());
			            attached.setTypeIdAndData(159, (byte) 14, true);
						s.update();			
						}
				}
			}
		}, 3, 5);
	}
	
	
	public void loadSigns(){
		
	}
	@Override
	public void onDisable() {
		Bukkit.getScheduler().cancelTask(cd);
	}
	
}
