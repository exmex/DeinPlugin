package de.spigotplugins.antihack.commandcheck;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.spigotplugins.antihack.main.ConfigManager;
import de.spigotplugins.antihack.main.Main;

public class NOKNOCKBACKCommand implements CommandExecutor{
	public NOKNOCKBACKCommand(de.spigotplugins.antihack.main.Main Main){
		this.pl = Main;
	}
	private de.spigotplugins.antihack.main.Main pl;
	public static HashMap<Player, Location> loc = new HashMap<Player, Location>();
	public static HashMap<Player, Location> old = new HashMap<Player, Location>();

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("nb")){
				if(p.hasPermission("anticheat.nb")){
					if(args.length == 0){
						p.sendMessage(ConfigManager.Prefix + ConfigManager.NoKnockbackCommandUsage);
					}else if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							target.setWalkSpeed(0F);
							p.sendMessage("§3§m§l---------------------------");
							p.sendMessage(ConfigManager.Prefix + ConfigManager.NoKnockbackCommandChecking.replace("%Player%", target.getName()));
							p.sendMessage(ConfigManager.Prefix + ConfigManager.NoKnockbackCommandPing.replace("%Player%", target.getName()).replace("%Ping%", "" + ((CraftPlayer)p).getHandle().ping));
							old.put(target, target.getLocation());
							NOKNOCKBACKListener.list.add(p);
							Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
								@Override
								public void run() {
									target.setWalkSpeed(0);
									target.setVelocity(target.getLocation().getDirection().multiply(-3.0));
								}
								
							},2*8);
							Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){

								@Override
								public void run() {
									loc.put(target, target.getLocation());
								}
								
							},2*4);
							Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){
								@Override
								public void run() {
									Location newloc = target.getLocation();
									Location oldloc = loc.get(target);
									int oldx = (int)oldloc.getX();
									int oldy = (int)oldloc.getY();
									int oldz = (int)oldloc.getZ();
									int newx = (int)newloc.getX();
									int newy = (int)newloc.getY();
									int newz = (int) newloc.getZ();
								    if(oldx == newx && oldy == newy && oldz == newz){
								    	p.sendMessage(ConfigManager.Prefix + "§eErgebnis: §3Der Spieler §c" + target.getName() + "§4§l hat AntiKnockback!");
								    }else{
								    	p.sendMessage(ConfigManager.Prefix + "§eErgebnis: §3Der Spieler §c" + target.getName() + "§2 hat kein AntiKnockback!");
								    }		
									p.sendMessage("§3§m§l---------------------------");
								    target.teleport(old.get(target));
								    target.sendMessage(ConfigManager.Prefix + "§6Du scheinst zu buggen...");
								    target.setWalkSpeed(0.2F);
								    NOKNOCKBACKListener.list.remove(p);
								}
							},6*4);
						}else{
							p.sendMessage(ConfigManager.Prefix + "§cDieser Spieler scheint nicht online zu sein! §8[§e" + args[0] + "§e]");
						}
					}
				}
			}
		}else{
			sender.sendMessage(ConfigManager.Prefix + "§4Du musst ein Spieler sein...");
		}
		return false;
	}
}