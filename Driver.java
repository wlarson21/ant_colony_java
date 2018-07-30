import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;
public class Driver implements SimulationEventListener
{
   AntSimGUI gui = new AntSimGUI();
   ColonyView farm = new ColonyView (27,27);
   LinkedList<Ant> ants=new LinkedList<>();
   Square[][] antFarm = new Square[27][27];
   int ID=1,turn=1,day=0;
   Random math = new Random();
   public static void main(String[] args)
   {
      Driver driver = new Driver();

   }
public Driver()
   {
               for(int i =0;i<27;i++)
                  {
                   for(int j =0;j<27;j++)
                       {
                            ColonyNodeView node = new ColonyNodeView();
                            Square square = new Square(i,j);
                            square.node(node);
                            node.setID(i +","+j);
                            node.setQueen(false);
                            node.setForagerCount(0);
                            node.setScoutCount(0);
                            node.setSoldierCount(0);
                            node.setBalaCount(0);
                            node.setPheromoneLevel(0);
                           
                            if (((int )(math.nextInt(99)  +1 ))<25)
                              {  
                                 int food = ( int )(math.nextInt(500) +500 );
                                 node.setFoodAmount(food);
                                 square.addFoodAmount(food);
                              }
                            else
                              {
                                 node.setFoodAmount(0);
                              }
                            square.node(node);
                            farm.addColonyNodeView(node, i, j);
                            antFarm[i][j]=square;
                            //System.out.println(i + "  " + j);
                       }
              }
         antFarm[13][13].openSquare();
         antFarm[14][14].openSquare();
         antFarm[14][12].openSquare();
         antFarm[14][13].openSquare();
         antFarm[12][12].openSquare();
         antFarm[12][14].openSquare();
         antFarm[13][14].openSquare();
         antFarm[13][12].openSquare();
         antFarm[12][13].openSquare();
         
         Queen queen = new Queen();
         ants.add(queen);
         antFarm[13][13].addFriendAnt(queen);
         antFarm[13][13].addFoodAmount(1000);
         
         for (int soldierCount=1; soldierCount<=10; soldierCount++)
            {
               Soldier ant = new Soldier();
               ant.setID(ID);
               ants.add(ant);
               antFarm[13][13].addFriendAnt(ant);
               //System.out.println("Soldier");
               ID=ID+1;
            }
         for (int foragerCount=1; foragerCount<=50; foragerCount++)
            {
               Forager ant = new Forager();
               ant.setID(ID);
               ants.add(ant);
               antFarm[13][13].addFriendAnt(ant);
               //System.out.println("Forager");
               ID=ID+1;
            }   
         for (int scoutCount=1; scoutCount<=4; scoutCount++)
            {
               Scout ant = new Scout();
               ant.setID(ID);
               ants.add(ant);
               antFarm[13][13].addFriendAnt(ant);
               //System.out.println("Scout");
               ID=ID+1;
            }
         
   
   gui.initGUI(farm);
   gui.addSimulationEventListener(this);

      
      

   }

public void simulationEventOccurred(SimulationEvent e)
   {
            //System.out.println("Day: " +day+" Turn: " +turn);
      if (e.getEventType() == SimulationEvent.RUN_EVENT&&ants.get(0).type()=="QUEEN")
         {
            Ant holdAnt = null;
          while(ants.get(0).type()=="QUEEN")
            {
               
                for(int i =0; i<ants.size(); i++)
                  {
                     if (turn==10)
                        {
                           if (ants.get(i).getAge()<1 && ants.get(i).type() != "BALA")
                              {
                                 antFarm[ants.get(i).getX()][ants.get(i).getY()].removeFriendAnt(ants.get(i));
                                 ants.remove(i);
                              }
                           else if (ants.get(i).getAge()<1 && ants.get(i).type() == "BALA")
                              {
                                 antFarm[ants.get(i).getX()][ants.get(i).getY()].removeEnemyAnt(ants.get(i));
                                 ants.remove(i);
                              }
                        turn=0;
                        day=day+1;
                        ants.get(i).age();
                        }
                     
                     holdAnt=ants.get(i).turn(antFarm);
                     if (holdAnt!=null)
                        {
                         if (holdAnt.getID()>=0)
                           {
                              if (ants.get(i).type() != "BALA")
                                {
                                    antFarm[ants.get(i).getX()][ants.get(i).getY()].removeFriendAnt(ants.get(i));
                                    ants.remove(i);
                                 }
                              else if (ants.get(i).type() == "BALA")
                                 {
                                    antFarm[ants.get(i).getX()][ants.get(i).getY()].removeEnemyAnt(ants.get(i));
                                    ants.remove(i);
                                 }
                           }
                           else
                              {
                              holdAnt.setID(ID);
                              ID=ID+1;
                              ants.add(holdAnt);
                              antFarm[13][13].addFriendAnt(holdAnt);
                              }
                        }
                     
                  }
                  turn=turn+1;
                  if (math.nextInt(100)<3)
                     {
                        Bala ant = new Bala();
                        ants.add(ant);
                        ant.setID(ID);
                        antFarm[0][0].addEnemyAnt(ant);
                        ID=ID+1;
                     }
                  for(int k =0;k<27;k++)
                     {
                       for(int j =0;j<27;j++)
                           {
                            antFarm[k][j].removePheromone();
                            }
                            
                      }
            } 
           
          } 
      else if (e.getEventType() == SimulationEvent.STEP_EVENT&&ants.get(0).type()=="QUEEN")
          {
          //System.out.println("Test");
            Ant holdAnt = null;
            for(int i =0; i<ants.size(); i++)
                  {
                     if (turn==10)
                        {
                           if (ants.get(i).getAge()<1 && ants.get(i).type() != "BALA")
                              {
                                 antFarm[ants.get(i).getX()][ants.get(i).getY()].removeFriendAnt(ants.get(i));
                                 ants.remove(i);
                              }
                           else if (ants.get(i).getAge()<1 && ants.get(i).type() == "BALA")
                              {
                                 antFarm[ants.get(i).getX()][ants.get(i).getY()].removeEnemyAnt(ants.get(i));
                                 ants.remove(i);
                              }
                        turn=0;
                        day=day+1;
                        ants.get(i).age();
                        }
                     holdAnt=ants.get(i).turn(antFarm);
                     if (holdAnt!=null)
                        {
                         if (holdAnt.getID()>=0)
                           {
                              if (ants.get(i).getAge()<1 && ants.get(i).type() != "BALA")
                                {
                                    antFarm[ants.get(i).getX()][ants.get(i).getY()].removeFriendAnt(ants.get(i));
                                    ants.remove(i);
                                 }
                              else if (ants.get(i).getAge()<1 && ants.get(i).type() == "BALA")
                                 {
                                    antFarm[ants.get(i).getX()][ants.get(i).getY()].removeEnemyAnt(ants.get(i));
                                    ants.remove(i);
                                 }
                           }
                           else
                              {
                              holdAnt.setID(ID);
                              ID=ID+1;
                              ants.add(holdAnt);
                              antFarm[13][13].addFriendAnt(holdAnt);
                              }
                        }
                  }
                  turn=turn+1;
                  if (math.nextInt(100)<3)
                     {
                        Bala ant = new Bala();
                        ants.add(ant);
                        antFarm[0][0].addEnemyAnt(ant);
                     }
                  for(int k =0;k<27;k++)
                     {
                       for(int j =0;j<27;j++)
                           {
                            antFarm[k][j].removePheromone();
                            }
                            
                      }                 
          } 
      else 
         {
          
          }

   
   }  
     
}

	       