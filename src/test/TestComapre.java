
package test;

import arrangor.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.*;
import static org.junit.Assert.*;

public class TestCompare {

   private Arrangor arrangor1;
   private Arrangor arrangor2;
   private Arrangor arrangor3;
   private List<Arrangor> arrangers;
   private CompareArrangor cmp = new CompareArrangor();
   /**
    * Sets up the test fixture. 
    * (Called before every test case method.)
    */
   @Before
   public void setUp() {

      arrangor1 = new Arrangor("Grim Reaper", "0766-666666", "death66@gmail.com");

      arrangor2 = new Arrangor("Julius Cesar", "9344","veni.vedi.versi@cesar.nu");
      arrangor3 = new Arrangor("Julius Cesar", "2344", "Imitator@hotmail.com");
      arrangers = new ArrayList<Arrangor>();

   }
   /**
    * Tears down the test fixture. 
    * (Called after every test case method.)
    */
   @After
   public void tearDown() {
      arrangor1 = null;
      arrangor2 = null;
      arrangor3 = null;
      arrangers = null;

   }

   
   @Test
   public void TestCompare() {
      
      assertFalse("Comparator equals error", cmp(arrangor2, arrangor3) == 0);
   }
 
   @Test
   public void testForException() {
      arrangers.add(arrangor2);
      arrangers.add(arrangor1);
      arrangers.add(arrangor3);
      assertEquals("Sorting works wrong",arrangor1, Collections.max(arrangers , cmp));
   }
}
