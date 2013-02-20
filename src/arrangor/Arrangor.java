package arrangor;

public class Arrangor {
   private int id;
   private String name;
   private String number;
   private String email;
   
   
   /** 
    * konstruktor
    * post: tar 3 String parametrar
    * @param String named
    * @param String phone
    * @param String mail
    */
   public Arrangor(int ide, String named, String phone, String mail) {
      id = ide;
      name = named;
      number = phone;
      email = mail;

   }
   /** 
    * returns name 
    * @return name
    */

   public String getName() {
      return name;
   }
   /** 
    * returns phone-number
    * @return number
    */

   public String getNumber() {
      return number;
   }
   
   /** 
    * returns email
    * @return email
    */
   public String getEmail() {
      return email;
   }
   @Override
   public boolean equals(Object something) {
      if ( something instanceof Arrangor) {
         Arrangor new_arrangor = (Arrangor) something;
         if ( new_arrangor.getEmail() == email && new_arrangor.getNumber() == number) {
            return true;
         }
      }
      return false;
   }
}
