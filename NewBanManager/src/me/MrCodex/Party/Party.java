/*     */ package me.MrCodex.Party;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

/*     */ import net.md_5.bungee.api.ChatColor;
/*     */ import net.md_5.bungee.api.ProxyServer;
/*     */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Party
/*     */ {
/*  13 */   public static ArrayList<String> partyfuehrer = new ArrayList();
/*  14 */   public static HashMap<String, String> inparty = new HashMap();
/*  15 */   public static HashMap<String, Long> invitetime = new HashMap();
/*  16 */   public static HashMap<String, String> invite = new HashMap();
/*  17 */   static String pr = Cmd.prefix;
/*  18 */   private static Integer maxparty = Integer.valueOf(6);
/*     */ 
/*     */   public static void neueParty(ProxiedPlayer p) {
/*  21 */     if (inparty.containsKey(p.getName())) {
/*  22 */       p.sendMessage(pr + "§7Du bist in keiner §cParty§7.");
/*  23 */       return;
/*     */     }
/*  25 */     if (partyfuehrer.contains(p.getName())) {
/*  26 */        p.sendMessage(pr + "§7Du bist bereits in einer §cParty§7.");
/*  27 */       return;
/*     */     }
/*  29 */     partyfuehrer.add(p.getName());
/*  30 */     p.sendMessage(pr + "§7Du hast eine §cParty§7 erstellt.");
/*     */   }
/*     */ 
/*     */   public static void List(ProxiedPlayer p)
/*     */   {
/*  37 */     if (partyfuehrer.contains(p.getName()))
/*     */     {
/*  39 */       p.sendMessage(pr + "§7Leader: §c" + p.getName() + " §7- §c" + p.getServer().getInfo().getName());
/*  40 */       p.sendMessage(pr + "§7Members:");
/*  41 */       for (ProxiedPlayer y : ProxyServer.getInstance().getPlayers()) {
/*  42 */         if ((inparty.containsKey(y.getName())) && (inparty.get(y.getName()) == p.getName())) {
/*  43 */           p.sendMessage(pr + "§c" + y.getName() + " §7- §c" + y.getServer().getInfo().getName());
/*     */         }
/*     */       }
/*     */     }
/*  47 */     if (inparty.containsKey(p.getName())) {
/*     */       try {
/*  49 */         p.sendMessage(pr + "§7Leader: §c" + (String)inparty.get(p.getName()) + " §7-§c " + ProxyServer.getInstance().getPlayer((String)inparty.get(p.getName())).getServer().getInfo().getName());
/*     */       }
/*     */       catch (NullPointerException localNullPointerException) {
/*     */       }
/*  53 */       for (ProxiedPlayer y : ProxyServer.getInstance().getPlayers()) {
/*  54 */         if ((inparty.containsKey(y.getName())) && (inparty.get(y.getName()) == inparty.get(p.getName()))) {
/*  55 */           p.sendMessage(pr + "§c" + y.getName() + " §7- §c" + y.getServer().getInfo().getName());
/*     */         }
/*     */       }
/*     */     }
/*  59 */     if ((!inparty.containsKey(p.getName())) && (!partyfuehrer.contains(p.getName())))
/*  60 */     /*  22 */       p.sendMessage(pr + "§7Du bist in keiner Party.");
/*     */   }
/*     */ 
/*     */   public static void leave(ProxiedPlayer p)
/*     */   {
/*  70 */     if (inparty.containsKey(p.getName())) {
/*  71 */       p.sendMessage(pr + "§7Du hast die Party verlassen.");
/*  72 */       for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/*  73 */         if (inparty.get(x.getName()) == inparty.get(p.getName())) {
/*  74 */           x.sendMessage(pr + "§c" + p.getName() + "§7 hat die Party verlassen.");
/*     */         }
/*     */       }
/*  77 */       inparty.remove(p.getName());
/*  78 */       return;
/*     */     }
/*  80 */     if (partyfuehrer.contains(p.getName())) {
/*  81 */       p.sendMessage(pr + "§7Die Party wurde aufgrund fehlender Spieler aufgelöst.");
/*  82 */       partyfuehrer.remove(p.getName());
/*  83 */       for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/*  84 */         if ((!inparty.containsKey(x.getName())) || 
/*  85 */           (inparty.get(x.getName()) != p.getName())) continue;
/*  81 */        p.sendMessage(pr + "§7Die Party wurde aufgrund fehlender Spieler aufgelöst.");
/*  87 */         inparty.remove(x.getName());
/*     */       }
/*     */ 
/*  92 */       return;
/*     */     }
/*  94 */     if ((!inparty.containsKey(p.getName())) && (!partyfuehrer.contains(p.getName())))
/*  95 */      p.sendMessage(pr + "§7Du bist in keiner Party.");
/*     */   }
/*     */ 
/*     */   public static void chat(ProxiedPlayer p, String text)
/*     */   {
/* 105 */     text = ChatColor.translateAlternateColorCodes('&', text);
/* 106 */     if (partyfuehrer.contains(p.getName())) {
/* 107 */       p.sendMessage("§8[§6Party-Chat§8] " + p.getName() + " §7§ " + text);
/* 108 */       for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/* 109 */         if ((!inparty.containsKey(x.getName())) || 
/* 110 */           (inparty.get(x.getName()) != p.getName())) continue;
/* 107 */       x.sendMessage("§8[§6Party-Chat§8] " + p.getName() + " §7§ " + text);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 116 */     if (inparty.containsKey(p.getName())) {
/* 117 */       ProxyServer.getInstance().getPlayer((String)inparty.get(p.getName())).sendMessage(pr + "§c" + p.getName() + " §f:§7 " + text);
/* 118 */       for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
/* 119 */         if ((!inparty.containsKey(x.getName())) || 
/* 120 */           (inparty.get(x.getName()) != inparty.get(p.getName()))) continue;
/* 107 */       x.sendMessage("§8[§6Party-Chat§8] " + p.getName() + " §7§ " + text);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 126 */     if ((!inparty.containsKey(p.getName())) && (!partyfuehrer.contains(p.getName())))
/* 127 */       p.sendMessage(pr + "§7Du bist in keiner Party.");
/*     */   }
/*     */ 
/*     */   public static void invite(ProxiedPlayer p, ProxiedPlayer z)
/*     */   {
/* 136 */     long aktuell = System.currentTimeMillis();
/*     */ 
/* 138 */     if (partyfuehrer.contains(p.getName()))
/*     */     {
/* 141 */       Integer iparty = Integer.valueOf(0);
/* 142 */       for (ProxiedPlayer i : ProxyServer.getInstance().getPlayers()) {
/* 143 */         if ((!inparty.containsKey(i.getName())) || 
/* 144 */           (inparty.get(i.getName()) != p.getName())) continue;
/* 145 */         iparty = Integer.valueOf(iparty.intValue() + 1);
/*     */       }
/*     */ 
/* 150 */       if (iparty.intValue() >= maxparty.intValue()) {
/* 151 */         p.sendMessage(pr + " §7Die Party ist voll.");
/* 152 */         return;
/*     */       }
/* 154 */       if (inparty.containsKey(z.getName())) {
/* 155 */         p.sendMessage(pr + "§7Dieser Spieler befindet sich bereits in einer Party.");
/* 156 */         return;
/*     */       }
/* 158 */       if (partyfuehrer.contains(z.getName())) {
/* 159 */         p.sendMessage(pr + "§7Dieser Spieler befindet sich bereits in einer Party.");
/* 160 */         return;
/*     */       }
/* 162 */       if ((!inparty.containsKey(z.getName())) && (!partyfuehrer.contains(z.getName())))
/*     */       {
/* 165 */         invite.put(z.getName(), p.getName());
/* 166 */         invitetime.put(z.getName(), Long.valueOf(aktuell));
/* 167 */         p.sendMessage(pr + "§7Du hast den Spieler §c" + z.getName() + " §7eingeladen.");
/* 168 */         z.sendMessage(pr + "§c" + p.getName() + " §7hat dich zu seiner Party eingeladen.");
/* 169 */         z.sendMessage(pr + "§7Betrete die Party mit §c/party accept " + p.getName() + "§7.");
/* 170 */         return;
/*     */       }
/* 172 */     } else if (inparty.containsKey(p.getName())) {
/* 173 */       p.sendMessage(pr + "§7 Du darfst keine Spieler einladen.");
/* 174 */     } else if ((!inparty.containsKey(p.getName())) && (!partyfuehrer.contains(p.getName()))) {
/* 175 */       neueParty(p);
/* 176 */       invite(p, z);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void accept(ProxiedPlayer p)
/*     */   {
/* 183 */     if ((partyfuehrer.contains(p.getName()) | inparty.containsKey(p.getName()))) {
/* 184 */       p.sendMessage(pr + "§7Du bist bereits in einer Party");
/*     */     }
/* 186 */     else if (invite.containsKey(p.getName())) {
/* 187 */       Long aktuell = Long.valueOf(System.currentTimeMillis());
/* 188 */       Long diff = Long.valueOf(aktuell.longValue() / 1000L - ((Long)invitetime.get(p.getName())).longValue() / 1000L);
/* 189 */       if (diff.longValue() > 60L) {
/* 190 */         p.sendMessage(pr + "§7Diese Einladung ist bereits abgelaufen.");
/*     */       } else {
/* 194 */         ProxiedPlayer Leiter = ProxyServer.getInstance().getPlayer((String)invite.get(p.getName()));
/* 195 */         Leiter.sendMessage(pr + "§c" + p.getName() + " §7hat die Party betreten.");
/* 196 */         invite.remove(p.getName());
/* 197 */         invitetime.remove(p.getName());
/* 198 */         inparty.put(p.getName(), Leiter.getName());
/* 199 */         p.sendMessage(pr + "§7Du hast die Party von §c" + Leiter.getName() + "§7 betreten.");
/*     */       }
/*     */     } else {
/* 202 */       p.sendMessage(pr + "§7Du wurdest nicht eingeladen.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void kick(ProxiedPlayer pl, ProxiedPlayer p)
/*     */   {
/* 209 */     if (partyfuehrer.contains(pl.getName())) {
/* 210 */       if ((inparty.containsKey(p.getName())) && (inparty.get(p.getName()) == pl.getName())) {
/* 211 */         inparty.remove(p.getName());
/* 212 */         p.sendMessage("§7Du wurdest von §c" + pl.getName() + " §7aus der Party geworfen.");
/* 213 */         pl.sendMessage(pr + " §7Der Spieler §c" + p.getName() + " §7wurde gekickt.");
/* 214 */         for (ProxiedPlayer ip : ProxyServer.getInstance().getPlayers())
/* 215 */           if ((inparty.containsKey(ip.getName())) && (inparty.get(ip.getName()) == pl.getName()))
/* 216 */             ip.sendMessage("§c" + p.getName() + " §7wurde von §c" + pl.getName() + " §7aus der Party geworfen.");
/*     */       }
/*     */       else
/*     */       {
/* 220 */         pl.sendMessage("§7Dieser Spieler ist in keiner Party.");
/*     */       }
/*     */     }
/* 223 */     else pl.sendMessage("§7Du bist in keiner Party.");
/*     */   }
/*     */ }
