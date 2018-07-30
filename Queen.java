import java.util.Random;
public class Queen extends Ant
   {     
         private int count=0;
          Random random = new Random();
   
         public Queen()
            {
               ID=0;
               locationX = 13;
               locationY = 13;
               age=10*365;
            }
         public String type()
            {
               return "QUEEN";
            }
            
         public void move(Square[][] colony)
            {
               
            }
         
                     
         public Ant turn(Square[][] colony)   
            {
               count=count+1;
               if(colony[13][13].removeFood()== false)
                  {
                     return this;
                  }
               
                if(count%10==0)
                  {
                     //System.out.print("Hatch");
                     return hatch();
                     
                  }
               
               
               return null;
               
            }
         public Ant hatch() 
           {
               int rand = random.nextInt(100);
               //System.out.println("Birth");
               
               if (rand<=50)
                  {
                     Forager newAnt = new Forager();
                     return newAnt;
                  }
               else if ( rand>50 && rand <= 75)
                  {
                     Scout newAnt =new Scout();
                     return newAnt;
                  }
               else if ( rand>75)
                  {
                     Soldier newAnt = new Soldier();
                     return newAnt;
                  }
            
               return null;
            }
   }