package de.tiger.NickSystem.sql;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL
{
  private String host;
  private String port;
  private String user;
  private String passwort;
  private String database;
  private Connection conn;
  
  public MySQL(String host, String port, String user, String passwort, String database)
  {
    this.host = host;
    this.port = port;
    this.user = user;
    this.passwort = passwort;
    this.database = database;
  }
  
  public Connection getConnection()
  {
    try
    {
      if ((this.conn == null) || (this.conn.isClosed()))
      {
        this.conn = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.passwort);
        System.out.println("Verbunden.");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return this.conn;
  }
  
  public PreparedStatement getStatement(String qry)
  {
    try
    {
      return getConnection().prepareStatement(qry);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
