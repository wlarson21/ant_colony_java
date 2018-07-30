import java.util.Random;
public class Scout extends Ant
   {
      Random math = new Random();
         public Scout()
            {
               age=365;
               locationX=13;
               locationY=13;
            }
         public String type()
            {
               return "SCOUT";
            }
            
         public void move(Square colony[][])
            {
               int cont=0, random,moveX=locationX,moveY=locationY;
               
               while(cont ==0)
               {
               random = ((int )(math. nextInt(7) +1 ));
               //System.out.print(random);
               
               switch(random)
               {
               case 1:
                 {
         
                     if (locationX>0 && locationY>0)
                        {
                           moveX=locationX-1;
                           moveY=locationY-1;
                           colony[moveX][moveY].openSquare();
                           cont=1;
                         }
                         break;
                 }
               case 2:
                 {
                     if (locationX>0)
                        {
                           moveX=locationX-1;
                           moveY=locationY;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
               case 3:
                 {
                   if (locationX>0 && locationY<26)
                        {
                           moveX=locationX-1;
                           moveY=locationY+1;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
               case 4:
                 {
                    if (locationY>0)
                        {
                           moveX=locationX;
                           moveY=locationY-1;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
               case 5:
                 {
                     if (locationY<26)
                        {
                           moveX=locationX;
                           moveY=locationY+1;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                         }
                         break;
                 }
               case 6:
                 {
                     if (locationX<26 && locationY>0)
                        {
                           moveX=locationX+1;
                           moveY=locationY-1;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
                case 7:
                 {
                     if (locationX>0 )
                        {
                           moveX=locationX+1;
                           moveY=locationY;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
                 case 8:
                 {
                     if (locationX<26 && locationY<26)
                        {
                           moveX=locationX+1;
                           moveY=locationY+1;
                           colony[moveX][moveY].openSquare();
                           
                           cont=1;
                        }
                        break;
                 }
                 
                 }
                 colony[moveX][moveY].addFriendAnt(colony[locationX][locationY].removeFriendAntByID(ID));
                 locationX=moveX;
                 locationY=moveY;
               }
               cont=0;
                 
            }
         public Ant turn(Square colony[][])
            {
               move(colony); 
               return null;     
            }
   }