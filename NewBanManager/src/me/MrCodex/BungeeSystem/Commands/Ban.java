/*    */package me.MrCodex.BungeeSystem.Commands;

/*    */
/*    */import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.BanManager;
/*    */
import net.md_5.bungee.api.CommandSender;
/*    */
import net.md_5.bungee.api.plugin.Command;

/*    */
/*    */public class Ban extends Command
/*    */{
	/*    */public Ban()
	/*    */{
		/* 11 */super("Ban");
		/*    */}

	/*    */
	/*    */public void execute(CommandSender sender, String[] args)
	/*    */{
		/* 17 */if (sender.hasPermission("system.ban")) {
				/* 19 */sender.sendMessage(Data.prefix + "§7Nutze §c/strafe <Name> <Grund>");
		/*    */} else {
			/* 34 */sender.sendMessage(Data.prefix
					+ "§7Dieser §cBefehl§7 existiert nicht.");
		/*    */}
	}
	/*    */
}