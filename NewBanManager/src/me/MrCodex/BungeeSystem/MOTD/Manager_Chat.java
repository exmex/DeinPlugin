package me.MrCodex.BungeeSystem.MOTD;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class Manager_Chat implements Listener {
	 public static Boolean GlobalMute = Boolean.valueOf(false);
	 public static Boolean Wartungen = Boolean.valueOf(false);
	  public static TextComponent getComponent(String Text1, String Popup, String Text2, ClickEvent onClickEvent, String onHoverText)
	  {
	    if (Text1 == null) {
	       Text1 = "";
	     }
	     TextComponent Message = new TextComponent(Text1);
	    TextComponent PopupMessage = new TextComponent(ChatColor.RESET + Popup);
	     if (onClickEvent != null) {
	       PopupMessage.setClickEvent(onClickEvent);
	    }
	     if (onHoverText != null) {
	       PopupMessage.setHoverEvent(
	         new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
	         new ComponentBuilder(onHoverText).create()));
	     }
	     Message.addExtra(PopupMessage);
	     Message.addExtra(new TextComponent(Text2));
	     return Message;
	   }
	 public static String getMessage(CommandSender cs, String Message)
	   {
	     if ((cs instanceof ProxiedPlayer)) {
	      if (GlobalMute.booleanValue()) {
	   if (!cs.hasPermission("system.globalmute")) {
	           cs.sendMessage(ChatColor.RED + 
	             "§3Dir wird es derzeit verweigert, im §eChat §3zu schreiben. §eGlobalMute §3ist aktiv.");
	         }
	         return null;
	       }
	    }
	 
		return Message;
}
}
