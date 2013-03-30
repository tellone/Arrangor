
package src.arrangor;
import java.util.Comparator;
public class CompareArrangor implements Comparator<Arrangor> {
  
   /** 
    * returns name 
    * @return name
    */
   @Override
   public int compare(Arrangor first, Arrangor second) {
      if ( first.getName().compareTo(second.getName()) == 0) {
         return -first.getNumber().compareTo(second.getNumber());
      }
         
      return - first.getName().compareTo(second.getName());
   }
}
