package src.dbhandler;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import src.arrangor.*;

public class ConnectionManager {
   protected Connection connection;
   protected boolean dbConnected;
   private String dbURL;
   private String dbUser;
   private String dbPassword;

   public ConnectionManager(String url, String user, String pass) {
      dbURL = url;
      dbUser = user;
      dbPassword = pass;

   }

   protected void setUpConnection() {
      try{
         connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
      } 
      catch (SQLException sqlE)
      {
         sqlE.printStackTrace();
      }
   }

   public long addArranger(String name, String number, String email) {
      long modified = 0;
      PreparedStatement addArr = null;
      try {
         setUpConnection();
         addArr= connection.prepareStatement("INSERT INTO Arrangorer " + "( Name, Number, Email) " + "VALUES ( ?, ?, ? )" );
         addArr.setString(1, name);

         addArr.setString(2, number);
         addArr.setString(3, email);
         modified = addArr.executeUpdate();
      }
      catch (SQLException sqlE) 
      {
         sqlE.printStackTrace();
         close();
      }
      return modified;
   }


   public ArrayList<Arrangor> getAllArrangers() {
   
      ArrayList<Arrangor> arrangorer= null;
      PreparedStatement getAllArr = null;
      ResultSet allFromDB;
      try {
         setUpConnection();
         getAllArr =  connection.prepareStatement("SELECT * FROM Arrangorer");
         allFromDB = getAllArr.executeQuery();
         arrangorer = new ArrayList< Arrangor >();
         while ( allFromDB.next() ) {
            arrangorer.add( new Arrangor(
                     allFromDB.getInt( "id" ),
                     allFromDB.getString( "name" ),
                     allFromDB.getString( "number" ),
                     allFromDB.getString( "email" )));
         }
      }
      catch (SQLException sqlE)
      {
         sqlE.printStackTrace();
         close();
      }
      return arrangorer;
   }

   
   public void close() {
      try
      {
         connection.close();
      }
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      }
   }
}
      
