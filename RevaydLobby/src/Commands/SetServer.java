package Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class SetServer implements CommandExecutor{
	
	File file = new File("plugins/Lobby","Locs.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		Player p = (Player) sender;

		String world = p.getWorld().getName();
		double x = p.getLocation().getX();
				double y = p.getLocation().getY();
						double z = p.getLocation().getZ();
								double yaw = p.getLocation().getYaw();
										double pitch = p.getLocation().getPitch();
										
										

		if(cmd.getName().equalsIgnoreCase("setserver")){
			if(p.hasPermission("staff.setserver") || p.isOp()){
			if(args.length == 0){
				p.sendMessage("§c/setserver <Name>");
			}else{
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("ffa")){
						cfg.set("lobby.ffa.world", world);
						cfg.set("lobby.ffa.x", x);
						cfg.set("lobby.ffa.y", y);
						cfg.set("lobby.ffa.z", z);
						cfg.set("lobby.ffa.yaw", yaw);
						cfg.set("lobby.ffa.pitch", pitch);
						p.sendMessage("FFA gesetzt.");
						
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
						
					}
					if(args[0].equalsIgnoreCase("1vs1")){
						cfg.set("lobby.1vs1.world", world);
						cfg.set("lobby.1vs1.x", x);
						cfg.set("lobby.1vs1.y", y);
						cfg.set("lobby.1vs1.z", z);
						cfg.set("lobby.1vs1.yaw", yaw);
						cfg.set("lobby.1vs1.pitch", pitch);
						p.sendMessage("1vs1 gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("sg")){
						cfg.set("lobby.sg.world", world);
						cfg.set("lobby.sg.x", x);
						cfg.set("lobby.sg.y", y);
						cfg.set("lobby.sg.z", z);
						cfg.set("lobby.sg.yaw", yaw);
						cfg.set("lobby.sg.pitch", pitch);
						p.sendMessage("SG gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("bauevent")){
						cfg.set("lobby.bauevent.world", world);
						cfg.set("lobby.bauevent.x", x);
						cfg.set("lobby.bauevent.y", y);
						cfg.set("lobby.bauevent.z", z);
						cfg.set("lobby.bauevent.yaw", yaw);
						cfg.set("lobby.bauevent.pitch", pitch);
						p.sendMessage("Bauevent gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("shop")){
						cfg.set("lobby.shop.world", world);
						cfg.set("lobby.shop.x", x);
						cfg.set("lobby.shop.y", y);
						cfg.set("lobby.shop.z", z);
						cfg.set("lobby.shop.yaw", yaw);
						cfg.set("lobby.shop.pitch", pitch);
						p.sendMessage("Shop gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("team")){
						cfg.set("lobby.team.world", world);
						cfg.set("lobby.team.x", x);
						cfg.set("lobby.team.y", y);
						cfg.set("lobby.team.z", z);
						cfg.set("lobby.team.yaw", yaw);
						cfg.set("lobby.team.pitch", pitch);
						p.sendMessage("Team gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("jumpnrun")){
						cfg.set("lobby.jumpnrun.world", world);
						cfg.set("lobby.jumpnrun.x", x);
						cfg.set("lobby.jumpnrun.y", y);
						cfg.set("lobby.jumpnrun.z", z);
						cfg.set("lobby.jumpnrun.yaw", yaw);
						cfg.set("lobby.jumpnrun.pitch", pitch);
						p.sendMessage("jumpnrun gesetzt.");
						
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
						
					}
					if(args[0].equalsIgnoreCase("mlg")){
						cfg.set("lobby.mlg.world", world);
						cfg.set("lobby.mlg.x", x);
						cfg.set("lobby.mlg.y", y);
						cfg.set("lobby.mlg.z", z);
						cfg.set("lobby.mlg.yaw", yaw);
						cfg.set("lobby.mlg.pitch", pitch);
						p.sendMessage("MLG gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
					if(args[0].equalsIgnoreCase("spawn")){
						cfg.set("lobby.spawn.world", world);
						cfg.set("lobby.spawn.x", x);
						cfg.set("lobby.spawn.y", y);
						cfg.set("lobby.spawn.z", z);
						cfg.set("lobby.spawn.yaw", yaw);
						cfg.set("lobby.spawn.pitch", pitch);
						p.sendMessage("Spawn gesetzt");
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
			
			
			
			
				}
			}
			}else
				p.sendMessage("§cDu hast nicht genügend Rechte!");
		}
						
		return true;
	}

}
	
