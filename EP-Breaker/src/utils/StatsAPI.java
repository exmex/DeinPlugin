package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by regnatrix on 04.12.16.
 */
public class StatsAPI {


    public static boolean playerExists(String Name) {

        ResultSet rs = MySQL.getResult("SELECT * FROM EPStats WHERE Name = '" + Name + "' ");
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
            MySQL.update("INSERT INTO EPStats (Name , Kills , Tode) VALUES ('" + Name  + "' , ' 0' , '0');");
        }
    }


    public static int getKills(String Name) {
        int i = 0;
        if(playerExists(Name)) {
            ResultSet rs = MySQL.getResult("SELECT * FROM EPStats WHERE Name = '" + Name + "' ");
            try {
                if((!rs.next()) || (Integer.valueOf(rs.getInt("Kills")) == null));
                i = rs.getInt("Kills");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            createPlayer(Name);
            getKills(Name);
        }
        return i;
    }

    public static int getTode(String Name) {
        int i = 0;
        if(playerExists(Name)) {
            ResultSet rs = MySQL.getResult("SELECT * FROM EPStats WHERE Name = '" + Name + "' ");
            try {
                if((!rs.next()) || (Integer.valueOf(rs.getInt("Tode")) == null));
                i = rs.getInt("Tode");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            createPlayer(Name);
            getTode(Name);
        }
        return i;
    }


    public static void setKills(String Name , int Kills) {
        if(playerExists(Name)) {

            MySQL.update("UPDATE EPStats SET Kills = '" + Kills + "' WHERE Name = '" + Name + "';");

        }else {
            createPlayer(Name);
            setKills(Name , Kills);
        }
    }

    public static void setTode(String Name , int Tode) {
        if(playerExists(Name)) {

            MySQL.update("UPDATE EPStats SET Tode = '" + Tode + "' WHERE Name = '" + Name + "';");

        }else {
            createPlayer(Name);
            setTode(Name , Tode);
        }
    }

    public static void addKills(String Name , int Kills) {
        if(playerExists(Name)) {

            setKills(Name, getKills(Name) + Kills);


        }else {
            createPlayer(Name);
            addKills(Name , Kills);
        }
    }

    public static void addTode(String Name , int Tode) {
        if(playerExists(Name)) {

            setTode(Name, getTode(Name) + Tode);


        }else {
            createPlayer(Name);
            addTode(Name , Tode);
        }
    }



}
