package ServerSystem;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class StatusSigns extends JavaPlugin implements Listener {

	private HashMap<StatusSign, String> server;
	public static StatusSigns sg;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
	    server = new HashMap<StatusSign, String>();
	    saveDefaultConfig();
	    sg = this;
	    for (String str : getConfig().getKeys(false)){
	        ConfigurationSection s = getConfig().getConfigurationSection(str);
	        ConfigurationSection l = s.getConfigurationSection("loc");
	        World w = Bukkit.getServer().getWorld(l.getString("world"));
	        double x = l.getDouble("x");double y = l.getDouble("y");double z = l.getDouble("z");
	        Location loc = new Location(w, x, y, z);
	        if (loc.getBlock() == null) {
	            getConfig().set(str, null);
	        } else {
	        	server.put(new StatusSign(loc, s.getString("name"), s.getString("ip"), s.getInt("port")), "");
	        }
	    }
	    Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new BukkitRunnable() {
			
			@Override
			public void run() {
				for(StatusSign s : StatusSigns.this.signsw){
					s.UpdateSigns();
				}
			}
		}, 0, 6l);
	    
	    Bukkit.getServer().getPluginManager().registerEvents(this, this);
	    
	    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	@EventHandler
	public void onPLayerInteract(PlayerInteractEvent event){
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK){
			return;
		}
		Block block = event.getClickedBlock();
	    if((block.getType() != Material.SIGN) && (block.getType() != Material.SIGN_POST) && (block.getType() != Material.WALL_SIGN)) {
	        return;
	    }
	    Sign sign = (Sign) event.getClickedBlock().getState();
	    
	   
	    for (StatusSign s : signs) {
	    	if(s.getLocation().equals(block.getLocation())) {
	    		String hasi = StatusSign.signs.get(sign.getLine(0));
	    		String[] sp = hasi.split(";"); 
	    		if(sp[0].equalsIgnoreCase(sp[1])){
	    			if(!event.getPlayer().hasPermission("claymc.gold")){
	    				event.getPlayer().sendMessage("§6Dieser Server ist derzeit voll... ");
		    			event.getPlayer().sendMessage("§eKeine Lust zu warten? §a§lhttp://shop.claymc.net");
	    			return;
	    			}
	    		}
	    		try {
	    			ByteArrayOutputStream b = new ByteArrayOutputStream();
	    			DataOutputStream out = new DataOutputStream(b);
					out.writeUTF("Connect");
	    			out.writeUTF(s.getName());
	    			event.getPlayer().sendPluginMessage(this, "BungeeCord", b.toByteArray());
				} catch (Exception e) { }
	    	}
	    }
	    
	}
    public void setActionBar(Player player, String message) {
        CraftPlayer p = (CraftPlayer) player;
        IChatBaseComponent ibc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(ibc, (byte) 2);
        p.getHandle().playerConnection.sendPacket(packet);
    }
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			Bukkit.getConsoleSender().sendMessage("§7Dieser Command ist nur fuer ein Spieler");
			return true;
		}
		Player player = (Player)sender;
		if(!sender.hasPermission("ss.create")){
			sender.sendMessage("§cDu hast keine Permission für diesen Command.");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("createsign")){
			if(args.length < 3){
				player.sendMessage("/createsign <ip> <port> <servername>");
				return true;
			}
			int port;
			String ip = args[0];
			port = Integer.valueOf(args[1]).intValue();
			String name = args[2];
			Block block = player.getTargetBlock((HashSet<Byte>) null, 10);
			
			StatusSign statusSign = new StatusSign(block.getLocation(), name, ip, port);
			this.signs.add(statusSign);
			save(statusSign);
			
			if (block == null){
				player.sendMessage("§7Du schaust nicht auf das Schild");
				return true;
			}
			if ((block.getType() != Material.SIGN) && (block.getType() != Material.SIGN_POST) && (block.getType() != Material.WALL_SIGN)){
		        player.sendMessage(ChatColor.RED + "Du schaust nicht auf das Schild!");
		        return true;
			}
		}
		return false;
	}
	private void save(StatusSign sign){
	    int size = getConfig().getKeys(false).size() + 1;
	    
	    getConfig().set(size + ".loc.world", sign.getLocation().getWorld().getName());
	    getConfig().set(size + ".loc.x", Double.valueOf(sign.getLocation().getX()));
	    getConfig().set(size + ".loc.y", Double.valueOf(sign.getLocation().getY()));
	    getConfig().set(size + ".loc.z", Double.valueOf(sign.getLocation().getZ()));
	    
	    getConfig().set(size + ".name", sign.getName());
	    getConfig().set(size + ".ip", sign.getIp());
	    getConfig().set(size + ".port", Integer.valueOf(sign.getPort()));
	    
	    saveConfig();
	  }

}
