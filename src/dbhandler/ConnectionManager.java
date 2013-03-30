package src.dbhandler;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import src.arrangor.*;

public class ConnectionManager {
   private Connection connection;
   private PreparedStatement addArr;
   private PreparedStatement getAllArr;
   private boolean dbConnected;
   
   public ConnectionManager(String dbURL, String dbUser, String dbPassword) {
      // java.lang.Class.forName(config.getInitParameter("jcdbDriver"));
      try{
         connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
         addArr= connection.prepareStatement("INSERT INTO Arrangorer " + "( Name, Number, Email) " + "VALUES ( ?, ?, ? )" );
         getAllArr =  connection.prepareStatement("SELECT * FROM Arrangorer");
      } 
      catch (SQLException sqlE)
      {
         sqlE.printStackTrace();
      }
   }
   public long addArranger(String name, String number, String email) {

      long modified = 0;
      
      try {
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
   
      List<Arrangor> Arrangorer;
      ResultSet allFromDB;
      try {
         allFromDB = getAllArr.executeQuery();
         Arrangorer = new ArrayList< Arrangor >();
         while ( allFromDB.next() ) {
            Arrangorer.add( new Arrangor(
                     // allFromDB.getInt( "id" ),
                     allFromDB.getString( "name" ),
                     allFromDB.getString( "number" ),
                     allFromDB.getString( "email" ) ) );
         }
      }
      catch (SQLException sqlE)
      {
         sqlE.printStackTrace();
         close();
      }
      return Arrangorer;
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
      
