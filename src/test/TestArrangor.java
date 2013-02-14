package test;

import arrangor.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SampleTest {

   private Arrangor arrangor1;
   private Arrangor arrangor2;
   /**
    * Sets up the test fixture. 
    * (Called before every test case method.)
    */
   @Before
   public void setUp() {
      arrangor1 = new Arrangor("Grim Reaper", "0766-666666", "death66@ gmail.com");
   }

   /**
    * Tears down the test fixture. 
    * (Called after every test case method.)
    */
   @After
   public void tearDown() {
      Arrangor1 = null;
      Arrangor2 = null;
   }

   @Test
   public void testGetName() {
      assertEquals("GetName ger fel", "Grim Reaper", arrangor1.getName());
   }
   @Test
   public void testGetName() {
      assertEquals("GetNumber ger fel", "0766-666666", arrangor1.getNumber());
   }
   @Test
   public void testGetEmail() {
      assertEquals("GetEmail ger fel", "death@gmail.com", arrangor1.getEmail());
   }
   // @Test(expected=IndexOutOfBoundsException.class)
   // public void testForException() {
   //    Object o = emptyList.get(0);
   // }
}
