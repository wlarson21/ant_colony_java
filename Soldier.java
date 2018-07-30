import java.util.Random;
public class Soldier extends Ant
   {
      Random math = new Random();
         public Soldier()
            {
               age=365;
               locationX=13;
               locationY=13;
            }
         public String type()
            {
               return "SOLDIER";
            }   
         public void move(Square colony[][])
            {
               int maxEnemy=0,moveX=locationX,moveY=locationY,randX,randY;
               if (locationX>0)
                  {
                     if (locationY>0)
                        {
                           if (maxEnemy<colony[locationX-1][locationY-1].getEnemies()&&colony[locationX-1][locationY-1].getStatus())
                              {
                                 maxEnemy=colony[locationX-1][locationY-1].getEnemies();
                                 moveX=locationX-1;
                                 moveY=locationY-1;
                              }
                           
                        }
                     if (locationY<26)
                        {
                            if (maxEnemy<colony[locationX-1][locationY+1].getEnemies()&&colony[locationX-1][locationY+1].getStatus())
                              {
                                 maxEnemy=colony[locationX-1][locationY+1].getEnemies();
                                 moveX=locationX-1;
                                 moveY=locationY+1;
                              }
                         }
                     if (maxEnemy<colony[locationX-1][locationY].getEnemies()&&colony[locationX-1][locationY].getStatus())
                              {
                                 maxEnemy=colony[locationX-1][locationY].getEnemies();
                                 moveX=locationX-1;
                                 moveY=locationY;
                              }
                   }
                  
                if (locationX<26)
                  {
                     if (locationY>0)
                        {if (maxEnemy<colony[locationX+1][locationY-1].getEnemies()&&colony[locationX+1][locationY-1].getStatus())
                              {
                                 maxEnemy=colony[locationX+1][locationY-1].getEnemies();
                                 moveX=locationX+1;
                                 moveY=locationY-1;
                              }
                        }
                     if (locationY<26)
                        {  
                           if (maxEnemy<colony[locationX+1][locationY+1].getEnemies()&&colony[locationX+1][locationY+1].getStatus())
                              {
                                 maxEnemy=colony[locationX+1][locationY+1].getEnemies();
                                 moveX=locationX+1;
                                 moveY=locationY+1;
                              }
                         }
                         if (maxEnemy<colony[locationX+1][locationY].getEnemies()&&colony[locationX+1][locationY].getStatus())
                              {
                                 maxEnemy=colony[locationX+1][locationY].getEnemies();
                                 moveX=locationX+1;
                                 moveY=locationY;
                              }
                          }
                    if (locationY>0)
                        {
                           if (maxEnemy<colony[locationX][locationY-1].getEnemies()&&colony[locationX][locationY-1].getStatus())
                              {
                                 maxEnemy=colony[locationX][locationY-1].getEnemies();
                                 moveX=locationX;
                                 moveY=locationY-1;
                                 
                              }
                        }
                     if (locationY<26)
                        {
                           if (maxEnemy<colony[locationX][locationY+1].getEnemies()&&colony[locationX][locationY-1].getStatus())
                              {
                                 maxEnemy=colony[locationX][locationY+1].getEnemies();
                                 moveX=locationX;
                                 moveY=locationY+1;
                              }
                         }
                         
                      while (locationX==moveX && locationY==moveY)
                        {
                           randX=((int )(math.nextInt(3)-1));
                           randY=((int )(math.nextInt(3)-1 ));
                           //System.out.println(randX + " X " + moveX);
                           //System.out.println(randY + " Y " + moveX);
                           if(colony[locationX + randX][locationY + randY].getStatus()&&0<(locationX + randX)&&(locationX + randX)<27&&0<(locationY + randY)&&(locationY + randY)<27)
                              {
                                 moveX=locationX + randX;
                                 moveY=locationY + randY;
                              }
                        }
                        colony[moveX][moveY].addFriendAnt(colony[locationX][locationY].removeFriendAntByID(ID));
                      locationX=moveX;
                      locationY=moveY;
            }
         public Ant turn(Square colony[][])
            {
               if (colony[locationX][locationY].getEnemies()>0)
                  {
                     if ((int )(math.nextInt(100))>50)
                        {
                           if (colony[locationX][locationY].getEnemies()==1)
                              {
                                 return colony[locationX][locationY].killEnemyAnt(0);
                              }
                           else
                              {
                                  int random = math.nextInt(colony[locationX][locationY].getEnemies()-1) ;
                                  return colony[locationX][locationY].killEnemyAnt(random);
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