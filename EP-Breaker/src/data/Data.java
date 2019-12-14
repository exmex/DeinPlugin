package data;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by regnatrix on 10/23/16.
 */
public class Data {


    public  static  String Prefix = "§8[§eEP-Breaker§8] ";

    public static String Pr = "§8[§eEP-Breaker§8] ";

    public  static  String noPerm = Prefix + "§cDu hast dazu keine Rechte!";


    public static  boolean canMove = true,
                            canAttack = false,
                            canBuild = false;



    public static ArrayList<Player> playing = new ArrayList<>();
    public static ArrayList<Player> specatating = new ArrayList<>();





}
