import java.util.Random;
public class Bala extends Ant
   {
         Random math = new Random();
         public Bala()
            {
               age=365;
               locationX=0;
               locationY=0;
            }
          public String type()
            {
               return "BALA";
            }
            
             public void move(Square colony[][])
            {
               int cont=0, random,moveX=0,moveY=0;
               
               while(cont ==0)
               {
               random = ((int )(math.nextInt(7)+1 ));
               
               switch(random)
               {
               case 1:
                 {
                     if (locationX>0 && locationY>0)
                        {
                           moveX=locationX-1;
                           moveY=locationY-1;
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
                           
                           cont=1;
                        }
                        break;
                 }
                 
                 }
               colony[moveX][moveY].addEnemyAnt(colony[locationX][locationY].removeEnemyAntByID(ID));
                      locationX=moveX;
                      locationY=moveY;
               }

            
            }
         public Ant turn(Square colony[][])
            {
               if (colony[locationX][locationY].getFriends()>0)
                  {
                     if ((int )(math.nextInt(100))>50)
                        {
                           //System.out.println(colony[locationX][locationY].getFriends());
                           if (colony[locationX][locationY].getFriends()==1)
                              {
                                 return colony[locationX][locationY].killFriendAnt(0);
                              }
                           else
                              {
                                  int random = math.nextInt(colony[locationX][locationY].getFriends()-1) ;
                                  return colony[locationX][locationY].killFriendAnt(random);
                              }
                        }
                  }
               else
                  {
                     move(colony);
                  }   
             return null;     
            }

         
   }