package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class SchutzschildToggle implements CommandExecutor{


	Main plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		Player p = (Player) sender;
										
		if(cmd.getName().equalsIgnoreCase("schutzschild")){
			if(p.hasPermission("staff.lobby.admin") || p.isOp()){
				if(args.length == 0){
					p.sendMessage("§c/schutzschild toggle");
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("toggle")){
						if(Main.toggleSchutzschild == false){
							Main.toggleSchutzschild = true;
							p.sendMessage(Main.pre+"Schutzschild §edeaktiviert§3!");
						}else{
							Main.toggleSchutzschild = false;
							p.sendMessage(Main.pre+"Schutzschild §eaktiviert§3!");
						}
					}else{
						p.sendMessage("§c/schutzschild toggle");	
					}
				}
			}else p.sendMessage("§cDu hast nicht genügend Rechte!");
		}
						
		return true;
	}

}
	

