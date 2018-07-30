import java.util.LinkedList;
public abstract class Ant extends Object
   {
         public int age, ID=-1,locationX, locationY;
         
      public void Ant()
         {
         }
      public void age()
         {
            age=age-1;

         }
      public void setID(int ID)
         {
            this.ID=ID;
         }
       public int getX()
         {
            return locationX;
         }
       public int getY()
         {
            return locationY;
         }  
        public int getID()
         {
            return ID;
         }  
      public int getAge()
         {
            return age;
         }
      public abstract void move(Square[][] colony); 
      public abstract Ant turn(Square[][] colony); 
      public abstract String type(); 
               
   }