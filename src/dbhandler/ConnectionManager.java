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
      dbConnected = false;
   }

   protected void setUpConnection() {
      if (!dbConnected) {
         try{
            Class.forName("com.mysql.jdbc.Driver");
         }
         catch(ClassNotFoundException cE) {
         cE.printStackTrace();
         }
         
         try{
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            dbConnected = true;
         } 
         catch (SQLException sqlE)
         {
         sqlE.printStackTrace();
         }
      }
   }
   
   public long addArranger(String name, String phone, String email) {
      long modified = 0;
      PreparedStatement addArr = null;
      try {
         setUpConnection();
         addArr = connection.prepareStatement("INSERT INTO Arrangorer " + "( name, phone, email) " + "VALUES ( ?, ?, ? )" );
         addArr.setString(1, name);
         addArr.setString(2, phone);
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
      ArrayList<Arrangor> arrangorer = new ArrayList<Arrangor>();
      PreparedStatement getAllArr = null;
      ResultSet allFromDB = null;
      try {
         setUpConnection();
         getAllArr =  connection.prepareStatement("SELECT * FROM Arrangorer");
         allFromDB = getAllArr.executeQuery();
         while ( allFromDB.next() ) {
            arrangorer.add( new Arrangor(
                     allFromDB.getInt( "id" ),
                     allFromDB.getString( "name" ),
                     allFromDB.getString( "phone" ),
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
      
      if(null != connection) {
        try {
         
         connection.close();
         connection = null;
         dbConnected = false;
         }
         catch ( SQLException sqlException )
         {
         sqlException.printStackTrace();
         }
      }
   }
}
