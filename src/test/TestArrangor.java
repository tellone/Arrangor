package test;

import arrangor.*;
import java.util.ArrayList;
import java.util.Collections.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestArrangor {

   private Arrangor arrangor1;
   private Arrangor arrangor2;
   /**
    * Sets up the test fixture. 
    * (Called before every test case method.)
    */
   @Before
   public void setUp() {
      arrangor1 = new Arrangor("Grim Reaper", "0766-666666", "death66@gmail.com");
   }
   /**
    * Tears down the test fixture. 
    * (Called after every test case method.)
    */
   @After
   public void tearDown() {
      arrangor1 = null;
      arrangor2 = null;
   }

   @Test
   public void testGetName() {
      assertEquals("GetName ger fel", "Grim Reaper", arrangor1.getName());
   }
   @Test
   public void testGetNumber() {
      assertEquals("GetNumber ger fel", "0766-666666", arrangor1.getNumber());
   }
   @Test
   public void testGetEmail() {
      assertEquals("GetEmail ger fel", "death66@gmail.com", arrangor1.getEmail());
   }
   
   // @Test
   // public void testComprator() {
   //    arrangor2 = new Arrangor("Julius Cesar", "9344","veni.vedi.versi@cesar.nu");
   //    Comparator<Arrangor> cmp = new Comparator<Arrangor>();

   //    assertTrue("CompareTo ger fel ordning", amp( arrangor1, arrangor2) < 0 );
   // }
   @Test
   public void TestCollectionSort() {

      arrangor2 = new Arrangor("Julius Cesar", "9344","veni.vedi.versi@cesar.nu");
      ArrayList<Arrangor> arrangers = new ArrayList<Arrangor>();
      arrangers.add(arrangor2);
      arrangers.add(arrangor1);
      assertEquals("Sorting works wrong",arrangor1, max(arrangers));
   }
   // @Test(expected=IndexOutOfBoundsException.class)
   // public void testForException() {
   //    Object o = emptyList.get(0);
   // }
}
