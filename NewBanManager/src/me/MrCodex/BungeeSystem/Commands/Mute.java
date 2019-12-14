/*    */ package me.MrCodex.BungeeSystem.Commands;
/*    */ 
/*    */ import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Util.MuteManager;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class Mute extends Command
/*    */ {
/*    */   public Mute()
/*    */   {
/* 11 */     super("mute");
/*    */   }
/*    */ 
/*    */   public void execute(CommandSender sender, String[] args)
/*    */   {
	/* 17 */if (sender.hasPermission("system.ban")) {
		/* 19 */sender.sendMessage(Data.prefix + "§7Nutze §c/strafe <Name> <Grund>");
/*    */} else {
	/* 34 */sender.sendMessage(Data.prefix
			+ "§7Dieser §cBefehl§7 existiert nicht.");
/*    */}
/*    */   }
/*    */ }

/* Location:           C:\Users\Niclas\Downloads\BanManager DevTek.jar
 * Qualified Name:     me.justTrindex.BungeeSystem.Commands.Mute
 * JD-Core Version:    0.6.0
 */