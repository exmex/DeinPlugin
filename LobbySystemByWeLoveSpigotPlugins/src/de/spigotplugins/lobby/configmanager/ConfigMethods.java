package de.spigotplugins.lobby.configmanager;

import java.io.IOException;

import org.bukkit.Bukkit;

import de.spigotplugins.lobby.data.Data;

public class ConfigMethods {

	public static void checkIfConfigFilesExists(){
		
		if(!ConfigData.spawns.exists()){
			Bukkit.getConsoleSender().sendMessage("§e#INFO# §7| §6Keine Spawms.yml gefunden. §aConfig.yml wurde erfolgreich angelegt!");
			try {
				ConfigData.spawns.createNewFile();
			} catch (IOException e) {
				Bukkit.getConsoleSender().sendMessage("§c#WARNING# §7| §cDie Spawns.yml konnte aufgrund von Serverproblemen nicht erstellt werden. Bitte wende dich an deinen Anbieter!");
			}
		}else{
			Bukkit.getConsoleSender().sendMessage("§a#OK# §7| §eDie Spawns.yml wurde gefunden!");
		}
	}
	public static void loadStrings(){
		Strings.Prefix = ConfigData.cfg.getString("Prefix").replace("&", "§") + " ";
		Strings.JoinMessage = ConfigData.cfg.getString("Join.JoinMessage").replace("&", "§");
		Data.Logging = ConfigData.cfg.getBoolean("PluginLogging");
		Data.BungeeCordModus = ConfigData.cfg.getBoolean("BungeeCordModus");
		Data.EnableJoinMessage = ConfigData.cfg.getBoolean("Join.JoinMessageAktivieren");
		Data.HealOnJoin = ConfigData.cfg.getBoolean("Join.HealOnJoin");
		Data.HealthScale = ConfigData.cfg.getInt("Join.SpielerHerzen");
		Data.FirstJoinRundruf = ConfigData.cfg.getBoolean("Join.FirstJoinRundruf");
		Strings.FirstJoinMessageFormat = ConfigData.cfg.getString("Join.FirstJoinMessageFormat").replace("&", "§");
		Data.GameModeOnJoin = ConfigData.cfg.getInt("Join.GameMode");
		Data.TitleAktiviert = ConfigData.cfg.getBoolean("Join.Title.Aktiviert");
		Strings.TitleOneLine = ConfigData.cfg.getString("Join.Title.TitleOben");
		Strings.TitleTwoLine = ConfigData.cfg.getString("Join.Title.TitleUnten");
		Data.Abbauen = ConfigData.cfg.getBoolean("World.Abbauen.Aktiviert");
		Data.Hunger = ConfigData.cfg.getBoolean("World.Hunger.Aktiviert");
		Data.Schaden = ConfigData.cfg.getBoolean("World.Schaden.Aktiviert");
		Strings.WeltName = ConfigData.cfg.getString("World.WeltName");
		Data.GHunger = ConfigData.cfg.getBoolean("World.Hunger.Golbal");
		Data.GSchaden = ConfigData.cfg.getBoolean("World.Schaden.Golbal");
		Data.GAbbauen = ConfigData.cfg.getBoolean("World.Abbauen.Golbal");

		loadInventoryConfig();
	}
	public static void loadInventoryConfig(){
		
		InventoryManager.SetLobbyItems = ConfigData.cfg.getBoolean("Inventar.SetLobbyItems");
		
		InventoryManager.NavigatorAktiviert = ConfigData.cfg.getBoolean("Inventar.Navigator.Aktiviert");
		InventoryManager.NavigatorID = ConfigData.cfg.getInt("Inventar.Navigator.ItemID");
		InventoryManager.NavigatorDisplayName = ConfigData.cfg.getString("Inventar.Navigator.DisplayName");
		InventoryManager.NavigatorInventorySlot = ConfigData.cfg.getInt("Inventar.Navigator.InventorySlot");
		InventoryManager.NavigatorBrauchePermission = ConfigData.cfg.getBoolean("Inventar.Navigator.BrauchePermission");
		InventoryManager.NavigatorPermission = ConfigData.cfg.getString("Inventar.Navigator.Permission");

		InventoryManager.SpielerVersteckenAktiviert = ConfigData.cfg.getBoolean("Inventar.SpielerVerstecken.Aktiviert");
		InventoryManager.SpielerVersteckenID = ConfigData.cfg.getInt("Inventar.SpielerVerstecken.ItemID");
		InventoryManager.SpielerVersteckenDisplayName = ConfigData.cfg.getString("Inventar.SpielerVerstecken.DisplayName");
		InventoryManager.SpielerVersteckenInventorySlot = ConfigData.cfg.getInt("Inventar.SpielerVerstecken.InventorySlot");
		InventoryManager.SpielerVersteckenBrauchePermission = ConfigData.cfg.getBoolean("Inventar.SpielerVerstecken.BrauchePermission");
		InventoryManager.SpielerVersteckenPermission = ConfigData.cfg.getString("Inventar.SpielerVerstecken.Permission");

		InventoryManager.GadgetsAktiviert = ConfigData.cfg.getBoolean("Inventar.Gadgets.Aktiviert");
		InventoryManager.GadgetsID = ConfigData.cfg.getInt("Inventar.Gadgets.ItemID");
		InventoryManager.GadgetsDisplayName = ConfigData.cfg.getString("Inventar.Gadgets.DisplayName");
		InventoryManager.GadgetsInventorySlot = ConfigData.cfg.getInt("Inventar.Gadgets.InventorySlot");
		InventoryManager.GadgetsBrauchePermission = ConfigData.cfg.getBoolean("Inventar.Gadgets.BrauchePermission");
		InventoryManager.GadgetsPermission = ConfigData.cfg.getString("Inventar.Gadgets.Permission");
		
		InventoryManager.SchutzschildAktiviert = ConfigData.cfg.getBoolean("Inventar.Schutzschild.Aktiviert");
		InventoryManager.SchutzschildID = ConfigData.cfg.getInt("Inventar.Schutzschild.ItemID");
		InventoryManager.SchutzschildDisplayName = ConfigData.cfg.getString("Inventar.Schutzschild.DisplayName");
		InventoryManager.SchutzschildInventorySlot = ConfigData.cfg.getInt("Inventar.Schutzschild.InventorySlot");
		InventoryManager.SchutzschildBrauchePermission = ConfigData.cfg.getBoolean("Inventar.Schutzschild.BrauchePermission");
		InventoryManager.SchutzschildPermission = ConfigData.cfg.getString("Inventar.Schutzschild.Permission");
		
		InventoryManager.NickToolAktiviert = ConfigData.cfg.getBoolean("Inventar.NickTool.Aktiviert");
		InventoryManager.NickToolID = ConfigData.cfg.getInt("Inventar.NickTool.ItemID");
		InventoryManager.NickToolDisplayName = ConfigData.cfg.getString("Inventar.NickTool.DisplayName");
		InventoryManager.NickToolInventorySlot = ConfigData.cfg.getInt("Inventar.NickTool.InventorySlot");
		InventoryManager.NickToolBrauchePermission = ConfigData.cfg.getBoolean("Inventar.NickTool.BrauchePermission");
		InventoryManager.NickToolPermission = ConfigData.cfg.getString("Inventar.NickTool.Permission");
		
		InventoryManager.FlugstabAktiviert = ConfigData.cfg.getBoolean("Inventar.Flugstab.Aktiviert");
		InventoryManager.FlugstabID = ConfigData.cfg.getInt("Inventar.Flugstab.ItemID");
		InventoryManager.FlugstabDisplayName = ConfigData.cfg.getString("Inventar.Flugstab.DisplayName");
		InventoryManager.FlugstabInventorySlot = ConfigData.cfg.getInt("Inventar.Flugstab.InventorySlot");
		InventoryManager.FlugstabBrauchePermission = ConfigData.cfg.getBoolean("Inventar.Flugstab.BrauchePermission");
		InventoryManager.FlugstabPermission = ConfigData.cfg.getString("Inventar.Flugstab.Permission");
		
		InventoryManager.SilentLobbyAktiviert = ConfigData.cfg.getBoolean("Inventar.SilentLobby.Aktiviert");
		InventoryManager.SilentLobbyID = ConfigData.cfg.getInt("Inventar.SilentLobby.ItemID");
		InventoryManager.SilentLobbyDisplayName = ConfigData.cfg.getString("Inventar.SilentLobby.DisplayName");
		InventoryManager.SilentLobbyInventorySlot = ConfigData.cfg.getInt("Inventar.SilentLobby.InventorySlot");
		InventoryManager.SilentLobbyBrauchePermission = ConfigData.cfg.getBoolean("Inventar.SilentLobby.BrauchePermission");
		InventoryManager.SilentLobbyPermission = ConfigData.cfg.getString("Inventar.SilentLobby.Permission");
		
		InventoryManager.LobbySwitcherAktiviert = ConfigData.cfg.getBoolean("Inventar.LobbySwitcher.Aktiviert");
		InventoryManager.LobbySwitcherID = ConfigData.cfg.getInt("Inventar.LobbySwitcher.ItemID");
		InventoryManager.LobbySwitcherDisplayName = ConfigData.cfg.getString("Inventar.LobbySwitcher.DisplayName");
		InventoryManager.LobbySwitcherInventorySlot = ConfigData.cfg.getInt("Inventar.LobbySwitcher.InventorySlot");
		InventoryManager.LobbySwitcherBrauchePermission = ConfigData.cfg.getBoolean("Inventar.LobbySwitcher.BrauchePermission");
		InventoryManager.LobbySwitcherPermission = ConfigData.cfg.getString("Inventar.LobbySwitcher.Permission");
	}
}
