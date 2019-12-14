package souppvp.kitmenu;

import org.bukkit.entity.Player;

import souppvp.data.Data;

public class LastKit {

	public static void getLastPlayerKit(Player p){
		if(Data.nopickedkit.contains(p)){
			Kits.getStandartKit(p);
			return;
		}
		if(KitData.USE_standartkit.contains(p)){
			Kits.getStandartKit(p);
			return;
		}
		if(KitData.USE_bogenschütze.contains(p)){
			Kits.getBogenschütze(p);
		}
		if(KitData.USE_rodpvp.contains(p)){
			Kits.getRodPvPKit(p);
		}
		if(KitData.USE_kaktus.contains(p)){
			Kits.getKaktusKit(p);
		}
	}
}
