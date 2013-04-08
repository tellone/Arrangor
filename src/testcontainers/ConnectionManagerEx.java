
package src.testcontainers;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import src.arrangor.*;
import src.dbhandler.*;

public class ConnectionManagerEx extends ConnectionManager {
   
   private Connection extraConnection;
   
   public ConnectionManagerEx(String url, String user, String pass) {
      super(url, user, pass);
   }

   public Connection getConnection() {
         return connection;
   } 
   public void setConnection(Connection conn) {
      extraConnection = conn;
   } 
   @Override
   protected void setUpConnection() {
      connection = extraConnection;
   }


}
      
