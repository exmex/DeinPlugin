package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by regnatrix on 28.11.16.
 */
public class CoinsAPI {



    public static boolean playerExists(String Name) {
        ResultSet rs = MySQL.getResult("SELECT * FROM CoinsSystem WHERE Name = '" + Name  +"' ");
        try {
            if(rs.next()) {
                return rs.getString("Name") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void createPlayer(String Name) {
        if(!(playerExists(Name))) {
            MySQL.update("INSERT INTO CoinsSystem (Name , Coins) VALUES ('" + Name +  "' ,' 0' ); " );
        }
    }


    public static int getCoins(String Name) {
        int i = 0;

        if(playerExists(Name)) {
            ResultSet rs = MySQL.getResult("SELECT * FROM CoinsSystem WHERE Name = '" + Name + "' ");
            try {
                if((rs.next()) || (Integer.valueOf(rs.getInt("Coins")) == null));
                i = rs.getInt("Coins");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            createPlayer(Name);
            getCoins(Name);
        }
        return i;
    }

    public static void setCoins(String Name , int Coins) {
        if(playerExists(Name)) {
            MySQL.update("UPDATE CoinsSystem SET Coins = '" + Coins + "' WHERE Name = '" + Name + "';");
        }else {
            createPlayer(Name);
            setCoins(Name , Coins);
        }
    }


    public static void addCoins(String Name , int Coins) {
        if(playerExists(Name)) {
            setCoins(Name, getCoins(Name) + Coins);
        }else {
            createPlayer(Name);
            addCoins(Name, Coins);
        }
    }

    public static void removeCoins(String Name , int Coins) {
        if(playerExists(Name)) {
            setCoins(Name, getCoins(Name) - Coins);
        }else {
            createPlayer(Name);
            removeCoins(Name, Coins);
        }
    }




}
