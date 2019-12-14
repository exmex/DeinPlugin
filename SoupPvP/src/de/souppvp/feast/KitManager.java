package de.souppvp.feast;

import org.bukkit.entity.Player;

public class KitManager {

	public static String getKitName(Player p){
		String Kit = null;
		if(FeastData.ANF�NGER_KIT.contains(p)){
			Kit = "�7Anf�nger";
		}
		if(FeastData.BOGENSCH�TZE_KIT.contains(p)){
			Kit = "�bBogensch�tze";
		}
		if(FeastData.KANGAROO_KIT.contains(p)){
			Kit = "�aKangaroo";
		}
		if(FeastData.SUPPENMEISTER_KIT.contains(p)){
			Kit = "�eSuppenmeister";
		}
		if(FeastData.AXT_KIT.contains(p)){
			Kit = "�dAxt";
		}
		
		if(Kit == null){
			Kit = "�8Unbekannt";
		}
		
		return Kit;
	}

}
