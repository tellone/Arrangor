package src.test;

import src.arrangor.*;
import src.testcontainers.*;
import java.util.Collections.*;
import java.sql.*;
import com.mockobjects.sql.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestConnectionManager {

   private ConnectionManagerEx connMan;
   private Arrangor arrangor1;
   private MockSingleRowResultSet resultSet;
   private MockConnection2 mockConn = new MockConnection2();
   /**
    * Sets up the test fixture. 
    * (Called before every test case method.)
    */
   @Before
   public void setUp() {
      connMan = new ConnectionManagerEx("Non-important", "No effect", "Do not affect Test");
      connMan.setConnection(mockConn); 
      arrangor1 = new Arrangor(1, "Grim Reaper", "0766-666666", "death66@gmail.com");
   }
   /**
    * Tears down the test fixture. 
    * (Called after every test case method.)
    */
   @After
   public void tearDown() {
      arrangor1 = null;
      connMan.close();
      connMan = null;
   }

   @Test
   public void testAddArrangor() {
      assertEquals("GetName ger fel", "Grim Reaper", arrangor1.getName());
   }
}
