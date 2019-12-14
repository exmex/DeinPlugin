package skypvp.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class sp implements CommandExecutor, Listener{

	private int cd;
	boolean move;

	public sp(skypvp.main.main main){
		this.pl = main;
	}
	private skypvp.main.main pl;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		if(cmd.getName().equalsIgnoreCase("spawn")){
			move = true;

			
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
				all.sendMessage(main.Prefix + "§bDer Spieler §e" + p.getName() + " §bteleportiert sich zum Spawn!");
			}
			p.sendMessage(main.Prefix + "§bBitte sneake §a3§b Sekunden um teleportiert zu werden!");
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);


			File ordner = new File("plugins//SkyPvP");
			File file = new File ("plugins//SkyPvP//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			
			
		
			final Location lobby = p.getLocation();
			lobby.setX(cfg.getDouble("spawn.x"));
			lobby.setY(cfg.getDouble("spawn.y"));
			lobby.setZ(cfg.getDouble("spawn.z"));
			double ya = cfg.getDouble("spawn.yaw");
			double pitc = cfg.getDouble("spawn.pitch");
			String world = cfg.getString("spawn.world");	
			
			
			 cd = Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){

				@Override
				public void run() {
					if(p.isSneaking()){
					p.teleport(lobby);
					p.sendMessage(main.Prefix + "§aDu wurdest zum §bSpawn §ateleportiert!");

					}else{
						p.sendMessage(main.Prefix + "§cDu hast nicht gesneakt!");
					}
				}
				
				
				
				},20*3);
			 
	}
		return false;
		
	
		

}
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(move == true){
			Bukkit.getScheduler().cancelAllTasks();
		}

	}
		}

