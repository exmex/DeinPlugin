package de.spigotplugins.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import de.spigotplugins.lobby.configmanager.InventoryManager;
import de.spigotplugins.lobby.configmanager.Strings;
import de.spigotplugins.lobby.data.Data;
import de.spigotplugins.lobby.general.FirstJoin;
import de.spigotplugins.lobby.methods.ItemCreator;
import de.spigotplugins.logmanager.AsyncLogging;

public class JoinListener implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.setHealthScale(Data.HealthScale);
		if(Data.Logging == true){
			AsyncLogging.logAsynchrounusly(e.getPlayer() + " hat den Server betreten.");
		}
		if(Data.EnableJoinMessage == true){
			String Message = Strings.JoinMessage.replace("%PLAYER%", e.getPlayer().getName());
			e.setJoinMessage(Strings.Prefix + Message);
		}
		
		if(Data.HealOnJoin == true){
			p.setHealth(20.0);
			p.setFoodLevel(20);
		}
		if(Data.FirstJoinRundruf == true){
			FirstJoin.checkIfPlayerHasGotFirstJoin(p);
		}
		if(Data.TitleAktiviert == true){
			p.sendTitle(Strings.TitleOneLine.replace("&", "§"), Strings.TitleTwoLine.replace("&", "§").replace("%PLAYER%", p.getName()));
		}
		if(Data.GameModeOnJoin != 10){
			int gm = Data.GameModeOnJoin;
			if(gm == 0  || gm == 1 || gm == 2 || gm == 3){
				if(gm == 0){
					p.setGameMode(GameMode.SURVIVAL);
				}
				if(gm == 1){
					p.setGameMode(GameMode.CREATIVE);
				}
				if(gm == 2){
					p.setGameMode(GameMode.ADVENTURE);
				}
				if(gm == 3){
					p.setGameMode(GameMode.SPECTATOR);
				}
			}else{
				AsyncLogging.logAsynchrounusly("WARNUNG > Der GameMode kann beim Joinen nicht geändert werden! Kontrolliere unter dem Reiter 'Join' in der config.yml");
			}
		}else{
			return;
		}
		if(InventoryManager.SetLobbyItems == true){
			if(InventoryManager.NavigatorAktiviert == true){
				p.getInventory().setItem(InventoryManager.NavigatorInventorySlot -1, ItemCreator.createIDWithoutLore(InventoryManager.NavigatorID, 1, 0, InventoryManager.NavigatorDisplayName.replace("&", "§")));
			}
			if(InventoryManager.SpielerVersteckenAktiviert == true){
				p.getInventory().setItem(InventoryManager.SpielerVersteckenInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.SpielerVersteckenID, 1, 0, InventoryManager.SpielerVersteckenDisplayName.replace("&", "§")));
			}
			if(InventoryManager.GadgetsAktiviert == true){
				p.getInventory().setItem(InventoryManager.GadgetsInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.GadgetsID, 1, 0, InventoryManager.GadgetsDisplayName.replace("&", "§")));
			}
			if(InventoryManager.SchutzschildAktiviert == true){
				p.getInventory().setItem(InventoryManager.SchutzschildInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.SchutzschildID, 1, 0, InventoryManager.SchutzschildDisplayName.replace("&", "§")));
			}
			if(InventoryManager.NickToolAktiviert == true){
				p.getInventory().setItem(InventoryManager.NickToolInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.NickToolID, 1, 0, InventoryManager.NickToolDisplayName.replace("&", "§")));
			}
			if(InventoryManager.FlugstabAktiviert == true){
				p.getInventory().setItem(InventoryManager.FlugstabInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.FlugstabID, 1, 0, InventoryManager.FlugstabDisplayName.replace("&", "§")));
			}
			if(InventoryManager.SilentLobbyAktiviert == true){
				p.getInventory().setItem(InventoryManager.SilentLobbyInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.SilentLobbyID, 1, 0, InventoryManager.SilentLobbyDisplayName.replace("&", "§")));
			}
			if(InventoryManager.LobbySwitcherAktiviert == true){
				p.getInventory().setItem(InventoryManager.LobbySwitcherInventorySlot-1, ItemCreator.createIDWithoutLore(InventoryManager.LobbySwitcherID, 1, 0, InventoryManager.LobbySwitcherDisplayName.replace("&", "§")));
			}
		}
	}

}
