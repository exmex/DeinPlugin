package de.community.manager;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.community.utils.Data;

public class SpawnManager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("setspawn")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("Spawn")){
					
					Location loc = p.getLocation();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					double pitch = loc.getPitch();
					double yaw = loc.getYaw();
					String weltname = loc.getWorld().getName();
					Data.cfg.set("Spawn.X", x);
					Data.cfg.set("Spawn.Y", y);
					Data.cfg.set("Spawn.Z", z);
					Data.cfg.set("Spawn.Pitch", pitch);
					Data.cfg.set("Spawn.Yaw", yaw);
					Data.cfg.set("Spawn.WeltName", weltname);
					try {
						Data.cfg.save(Data.file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					p.sendMessage(Data.Prefix + "§7Du hast den Spawn für §eSpawn§7 gesetzt!");
				}
				if(args[0].equalsIgnoreCase("jumpandrun")){
					Location loc = p.getLocation();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					double pitch = loc.getPitch();
					double yaw = loc.getYaw();
					String weltname = loc.getWorld().getName();
					Data.cfg.set("JumpAndRun.X", x);
					Data.cfg.set("JumpAndRun.Y", y);
					Data.cfg.set("JumpAndRun.Z", z);
					Data.cfg.set("JumpAndRun.Pitch", pitch);
					Data.cfg.set("JumpAndRun.Yaw", yaw);
					Data.cfg.set("JumpAndRun.WeltName", weltname);

					try {
						Data.cfg.save(Data.file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					p.sendMessage(Data.Prefix + "§7Du hast den Spawn für §eJumpAndRun§7 gesetzt!");
				}
				if(args[0].equalsIgnoreCase("bühne")){
					Location loc = p.getLocation();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
					double pitch = loc.getPitch();
					double yaw = loc.getYaw();
					String weltname = loc.getWorld().getName();
					Data.cfg.set("Buehne.X", x);
					Data.cfg.set("Buehne.Y", y);
					Data.cfg.set("Buehne.Z", z);
					Data.cfg.set("Buehne.Pitch", pitch);
					Data.cfg.set("Buehne.Yaw", yaw);
					Data.cfg.set("Buehne.WeltName", weltname);
					try {
						Data.cfg.save(Data.file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					p.sendMessage(Data.Prefix + "§7Du hast den Spawn für §eBühne§7 gesetzt!");
				}
			}
		}
		return false;
	}
}
