package me.MrCodex.Warns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Main;
import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import me.MrCodex.BungeeSystem.Util.BanManager;
import me.MrCodex.HubAPI.Hu;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener
  implements Listener
{
	/*     */   private static Boolean isMuted(String PlayerName)
	/*     */   {
	/* 337 */     if (Config.Config.MutedPlayers.contains(PlayerName)) {
	/* 338 */       return Boolean.valueOf(true);
	/*     */     }
	/* 340 */     return Boolean.valueOf(false);
	/*     */   }
	/*     */   private static Boolean isMuted1(String PlayerName)
	/*     */   {
	/* 337 */     if (Config.Config.MutedWerbung.contains(PlayerName)) {
	/* 338 */       return Boolean.valueOf(true);
	/*     */     }
	/* 340 */     return Boolean.valueOf(false);
	/*     */   }
  
	public static ArrayList<ProxiedPlayer> cooldown = new ArrayList<>();
	@EventHandler
  public void onChat(ChatEvent e)
  {
    List<String> ads = Main.plugin.getAds();
    List<String> plugins = Main.plugin.getPlugins();
    List<String> wort = Main.plugin.getWort();
   final ProxiedPlayer pl = (ProxiedPlayer)e.getSender();
	   if ((pl instanceof ProxiedPlayer)) {
		   if(!e.isCommand()){
		   if(isMuted1(pl.getName()).booleanValue()){
			   e.setCancelled(true);
			   pl.sendMessage(Data.prefix + "§7Deine ChatNachricht wurde gefiltert. §cGrund: Du bist gemuted");
		   }
		   }
	    }
	for(String p : plugins)
	if(e.getMessage().equals(p)){
		if(!pl.hasPermission("system.plugins")){
			pl.sendMessage("§cDu benötigst mindestens den Rang Supporter um diesen Befehl ausführen zu können.");
			e.setCancelled(true);
		}
	}
	for(String w : wort)
	if(e.getMessage().contains(w)){
		if(!pl.hasPermission("system.wort")){
			   pl.sendMessage(Data.prefix + "§7Deine ChatNachricht wurde gefiltert. §cGrund: Anzügige Sprache");
		          for (ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
		              if (p.hasPermission("werbung.show")) {
		                MessageListener.getInstance().sendMessage(p, MessageType.INFO, new String[] {"§7Der Spieler §c" + pl.getDisplayName() + "§7 hat geschrieben: §c" + e.getMessage()+" §7auf §c"+pl.getServer().getInfo().getName() });
		              }
		            }
			e.setCancelled(true);
		}
	}
    if (!pl.hasPermission("werbung.enable"))
      for (String a : ads)
        if (e.getMessage().contains(a)) {
        	if(!e.getMessage().toLowerCase().contains("Claymc.net")){
          for (ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
            if (p.hasPermission("werbung.show")) {
              MessageListener.getInstance().sendMessage(p, MessageType.INFO, new String[] {"§7Der Spieler §c" + pl.getDisplayName() + "§7 hat geschrieben: §c" + e.getMessage()+" §7auf §c"+pl.getServer().getInfo().getName() });
            }
          }
          e.setCancelled(true);
          addWerbung(e.getMessage());
          Config.SaveConfig();
            MessageListener.getInstance().sendMessage(pl, MessageType.BAD, new String[] { "§7Deine ChatNachricht wurde gefiltert. §cGrund: Mögliche Werbung."});
            MessageListener.getInstance().sendMessage(pl, MessageType.BAD, new String[] { "§cDie Teammitglieder werden diesen Sachverhalt nun prüfen."});

       //   MessageListener.getInstance().sendMessage(pl, MessageType.BAD, new String[] { "§7Bitte schreibe keine §bWerbung§7 auf §bMegaPvP.de§7 : §b" + e.getMessage() });
        //  MessageListener.getInstance().sendMessage(pl, MessageType.BAD, new String[] { "§7Ein Teammitglied wurde benachrichtigt." });
         // MessageListener.getInstance().sendMessage(MessageType.BAD, new String[] { pl.getDisplayName() + ": " + e.getMessage() });
        }
        }
  }
  @EventHandler
  public void onJoin(ServerConnectEvent e)
  {
	    ProxiedPlayer pl = e.getPlayer();
		   if ((pl instanceof ProxiedPlayer)) {
		       if (Manager_Chat.Wartungen.booleanValue()) {
		         if (!pl.hasPermission("system.wartungen.join")) {
		        pl.disconnect(Config.Config.Prefix+"§7Du kannst §cden Server §7derzeit nicht betreten. \n §7Derzeit sind §cWartungsarbeiten§7.");
		e.setCancelled(true);
		         }
		         return;
		      }
		    }
  }
  @EventHandler
  public void onKick(ServerKickEvent event)
  {
    if (event.getPlayer().getServer().getInfo().getName() != "lobby")
    {
      if (!event.getKickReason().startsWith(".0")) {
        event.setCancelled(true);

        event.getPlayer().sendMessage(Data.prefix + "§7Deine §cVerbindung §7zum Server §c" + event.getKickedFrom().getName() + "§7 wurde getrennt. Grund: §c" + event.getKickReason());
      }
    }
    else
    {
        event.getPlayer().sendMessage(Data.prefix + "§7Deine §cVerbindung §7zum Server §c" + event.getKickedFrom().getName() + "§7 wurde getrennt.");
    }
  }
  @EventHandler
  public void onTab(TabCompleteEvent e){
	  String Cursor = e.getCursor().toLowerCase();
      ProxiedPlayer p = (ProxiedPlayer)e.getSender();
      if(!p.hasPermission("System.tab")) {
	  if(Cursor.startsWith("/")){
	  e.setCancelled(true);
  }
  }
  }
  private String ContainsMute(String PlayerName)
  {
      for(Iterator iterator = Config.Config.MutedWerbung.iterator(); iterator.hasNext();)
      {
          String s = (String)iterator.next();
          if(s.equalsIgnoreCase(PlayerName))
          {
              return s;
          }
      }

      return null;
  }

  private void removeMute(String PlayerName)
  {
      ArrayList removeList = new ArrayList();
      for(Iterator iterator = Config.Config.MutedWerbung.iterator(); iterator.hasNext();)
      {
          String s = (String)iterator.next();
          if(s.equalsIgnoreCase(PlayerName))
          {
              removeList.add(s);
          }
      }

      String s;
      for(Iterator iterator1 = removeList.iterator(); iterator1.hasNext(); Config.Config.MutedWerbung.remove(s))
      {
          s = (String)iterator1.next();
      }

  }

  private void addMute(String PlayerName)
  {
      removeMute(PlayerName);
      Config.Config.MutedWerbung.add(PlayerName);
  }
  private void addWerbung(String Werbung)
  {
      removeMute(Werbung);
      Config.Config.Werbungsserver.add(Werbung);
  }

  private String getRealName(String PlayerName)
  {
      for(Iterator iterator = ProxyServer.getInstance().getPlayers().iterator(); iterator.hasNext();)
      {
          ProxiedPlayer p = (ProxiedPlayer)iterator.next();
          if(p.getName().equalsIgnoreCase(PlayerName))
          {
              return p.getName();
          }
      }

      return null;
  }
  
  @EventHandler
  public void on(final ServerKickEvent e) {
	  ServerInfo s1 = ProxyServer.getInstance().getServerInfo("Lobby-01");
	  e.getPlayer().connect(s1);
  }
}