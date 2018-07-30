import java.util.LinkedList;
import java.util.Random;

public class Forager extends Ant
   {
      Random math = new Random();
         public int mode =0, food =0,moveX,moveY;
         ArrayQueue pathX = new ArrayQueue();
         ArrayQueue pathY = new ArrayQueue();
         public Forager()
            {
               age=365;
               locationX=13;
               locationY=13;
            }
         
         public String type()
            {
               return "FORAGER";
            }
            
         public void move(Square[][] colony)
            {
               int maxPheromone=0,randX, randY,loop=0;
               moveX=locationX;
               moveY=locationY;
               Ant ant;
               if (locationX>0)
                  {
                     if (locationY>0)
                        {
                           if (maxPheromone<colony[locationX-1][locationY-1].getPheromone()&&colony[locationX-1][locationY-1].getStatus())
                              {
                                 maxPheromone=colony[locationX-1][locationY-1].getPheromone();
                                 moveX=locationX-1;
                                 moveY=locationY-1;
                              }
                           
                        }
                     if (locationY<26)
                        {
                            if (maxPheromone<colony[locationX-1][locationY+1].getPheromone()&&colony[locationX-1][locationY+1].getStatus())
                              {
                                 maxPheromone=colony[locationX-1][locationY+1].getPheromone();
                                 moveX=locationX-1;
                                 moveY=locationY+1;
                              }
                         }
                     if (maxPheromone<colony[locationX-1][locationY].getPheromone()&&colony[locationX-1][locationY].getStatus())
                              {
                                 maxPheromone=colony[locationX-1][locationY].getPheromone();
                                 moveX=locationX-1;
                                 moveY=locationY;
                              }
                   }
                  
                if (locationX<26)
                  {
                     if (locationY>0)
                        {if (maxPheromone<colony[locationX+1][locationY-1].getPheromone()&&colony[locationX+1][locationY-1].getStatus())
                              {
                                 maxPheromone=colony[locationX+1][locationY-1].getPheromone();
                                 moveX=locationX+1;
                                 moveY=locationY-1;
                              }
                        }
                     if (locationY<26)
                        {  
                           if (maxPheromone<colony[locationX+1][locationY+1].getPheromone()&&colony[locationX+1][locationY+1].getStatus())
                              {
                                 maxPheromone=colony[locationX+1][locationY+1].getPheromone();
                                 moveX=locationX+1;
                                 moveY=locationY+1;
                              }
                         }
                         if (maxPheromone<colony[locationX+1][locationY].getPheromone()&&colony[locationX+1][locationY].getStatus())
                              {
                                 maxPheromone=colony[locationX+1][locationY].getPheromone();
                                 moveX=locationX+1;
                                 moveY=locationY;
                              }
                          }
                    if (locationY>0)
                        {
                           if (maxPheromone<colony[locationX][locationY-1].getPheromone()&&colony[locationX][locationY-1].getStatus())
                              {
                                 maxPheromone=colony[locationX][locationY-1].getPheromone();
                                 moveX=locationX;
                                 moveY=locationY-1;
                                 
                              }
                        }
                     if (locationY<26)
                        {
                           if (maxPheromone<colony[locationX][locationY+1].getPheromone()&&colony[locationX][locationY-1].getStatus())
                              {
                                 maxPheromone=colony[locationX][locationY+1].getPheromone();
                                 moveX=locationX;
                                 moveY=locationY+1;
                              }
                         }
                         
                      while ((locationX==moveX && locationY==moveY) /*|| (moveX==(Integer)pathX.dequeue()&& moveY==(Integer)pathY.dequeue()&&colony[moveX][moveY].getFood()<0) || loop<16*/)
                        {
                           loop=loop+1;
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
                        pathX.add((Integer)locationX);
                        pathY.add((Integer)locationY);
                        colony[moveX][moveY].addFriendAnt(colony[locationX][locationY].removeFriendAntByID(ID));
                      locationX=moveX;
                      locationY=moveY;
                  
                   }
         public Ant turn(Square colony[][])
            {
               if (mode==0) //Forage
                  {
                  move(colony);
                  if (colony[locationX][locationY].getFood()>0&&(locationX!=13||locationY!=13))
                     {
                        colony[locationX][locationY].removeFood();
                        food=1;
                        mode=1;
                     }
                  
                  }
               else if (mode==1)//Return to Nest
                  {
                     //System.out.println("Return to Nest");
                     if(colony[locationX][locationY].getPheromone()<990)
                        {
                           colony[locationX][locationY].addPheromone();
                        }
                     moveX=(Integer)pathX.dequeue();
                     moveY=(Integer)pathY.dequeue();
                     colony[moveX][moveY].addFriendAnt(colony[locationX][locationY].removeFriendAntByID(ID));
                      locationX=moveX;
                      locationY=moveY;
                     if (locationX==13&&locationY==13)
                     {
                        colony[locationX][locationY].addFood();
                        food=0;
                        mode=0;
                     }

                  }
               return null;
            }   
   }