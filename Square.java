import java.util.LinkedList;
public class Square
   {
         public int food, pheromone,queen=0,forager=0,scout=0,soldier=0,bala=0;
         public int locationX, locationY;
         public boolean status=false;
         LinkedList<Ant> friend=new LinkedList<>();
         LinkedList<Ant> enemy =new LinkedList<>();
         Ant hold;
         ColonyNodeView node;
      public Square(int locationX, int locationY)
         {
            this.locationX=locationX;
            this.locationY=locationY;
         }
      public void node(ColonyNodeView node)  
         {
            this.node=node;
         }
      public ColonyNodeView getNode()
         {
            return node;
         }
      public int getX()
         {
            return locationX;
         }
     public int getY()
         {
            return locationY;
         }
      public boolean getStatus()
         {
            return status;
         }
      public void openSquare()
         {
            status = true;
            node.showNode();
         }
      public void addFood()
         {
            food=food+1;
            node.setFoodAmount(food);
         }
      public void addFoodAmount(int food)
         {
            this.food=food;
            node.setFoodAmount(food);
         }
      public int getFood()
         {
            return food;
         }
      public boolean removeFood()
         {
         if (food<1)
            {
               return false;
            }
         else
            {
            food = food-1;
            node.setFoodAmount(food);
            return true;
            }    
         }
         
      public void addPheromone()
         {
            pheromone=pheromone+10;
            node.setPheromoneLevel(pheromone);
          }
      public int getPheromone()
         {
            return pheromone;
         }
      public void removePheromone()
         {
         if (pheromone<1)
            {
            }
         else
            {
            pheromone = pheromone-1;
            node.setPheromoneLevel(pheromone);
            }    
         }
      public void addFriendAnt(Ant ant)
         {
            friend.add(ant);
            //System.out.println(ant.type()+ "  X " + locationX + "  Y " + locationY);
            //System.out.println(ant.getID());
            switch(ant.type())
               {
               case "QUEEN":
                  {
                     queen=queen+1;
                     node.setQueen(true);
                     node.showQueenIcon();
                     //System.out.println("Queen" + queen);
                     //System.out.println(ant.getID());
                     break;
                  }
               case "FORAGER":
                  {
                     forager=forager+1;
                     node.setForagerCount(forager);
                     node.showForagerIcon();
                     ////System.out.println("Forager" + forager);
                     break;
                  }
               case "SCOUT":
                  {
                     scout=scout+1;
                     node.setScoutCount(scout);
                     node.showScoutIcon();
                     ////System.out.println("Scout" + scout);
                     break;
                  }
               case "SOLDIER":
                  {
                     soldier=soldier+1;
                     node.setSoldierCount(soldier);
                     node.showSoldierIcon();
                     ////System.out.println("Soldier" + soldier);
                     break;
                  }   
                }
                  
         }
       public Ant removeFriendAntByID(int ID)
         {
            //System.out.println(ID);
            Ant ant= null;
            //System.out.println(ID);
            for (int i = 0; i<friend.size(); i++)
               {
                  //System.out.println(i);
                  //System.out.println(friend.size());
                  //System.out.println(friend.get(i).getID());
                  ////System.out.println(ant.getID());
                  if (friend.get(i).getID()==ID)
                     {
                        ant=friend.get(i);
                        //System.out.println("Removed" + ant.getID());
                        
                       

                           switch(friend.get(i).type())
                                 {
                                    case "QUEEN":
                                       {
                           
                                          queen=queen-1;
                                          node.setQueen(false);
                                          node.hideQueenIcon();
                                          friend.remove(i);
                                          break;
                                        }
                                    case "FORAGER":
                                       {
                                          forager=forager-1;
                                          friend.remove(i);
                                          break;
                                       }
                                    case "SCOUT":
                                       {
                                          scout=scout-1;
                                          friend.remove(i);
                                          break;
                                       }
                                    case "SOLDIER":
                                       {
                                          soldier=soldier-1;
                                          friend.remove(i);
                                 
                                          break;
                                       }   
                                 }
                             i=friend.size();
                       } 
             
                              node.setSoldierCount(soldier);
                              node.setScoutCount(scout);
                              node.setForagerCount(forager);
                              
                     
               }
               ////System.out.println(ant.type());
            return ant;   
         }
       public void removeFriendAnt(Ant ant)
         {
            friend.remove(ant);
            queen=0;
            forager=0;
            scout=0;
            soldier=0;
            for(int i =0; i<friend.size();i++)
            {
            switch(friend.get(i).type())
               {
               case "QUEEN":
                  {
                     
                     queen=queen+1;
                     node.setQueen(true);
                     node.hideQueenIcon();
                     break;
                  }
               case "FORAGER":
                  {
                     forager=forager+1;
                     break;
                  }
               case "SCOUT":
                  {
                     scout=scout+1;
                     break;
                  }
               case "SOLDIER":
                  {
                     soldier=soldier+1;
                     
                     break;
                  }   
                }
               } 
             
            node.setSoldierCount(soldier);
            node.setScoutCount(scout);
            node.setForagerCount(forager);
         }
       public Ant killFriendAnt(int removeNumb)
         {
            hold = friend.get(removeNumb);
            friend.remove(removeNumb);
            return hold;
         }
       public int getFriends()
         {
            return friend.size();
         }  
       public void addEnemyAnt(Ant ant)
         {
            enemy.add(ant);
            bala=bala+1;
            node.setBalaCount(bala);
            node.showBalaIcon();
         }
       public Ant removeEnemyAntByID(int ID)
         {
            Ant ant= null;
            for (int i = 0; i<enemy.size(); i++)
               {
                  ant = enemy.get(i);
                  if (enemy.get(i).getID()==ID)
                     {
                        enemy.remove(i);
                        bala=bala-1;
                        node.setBalaCount(bala);
                        node.hideBalaIcon();
                     }
               }
            return ant;   
         }
       public void removeEnemyAnt(Object ant)
         {
           enemy.remove(ant);
            bala=bala-1;
            node.setBalaCount(bala);
            node.hideBalaIcon(); 
         }
         public Ant killEnemyAnt(int removeNumb)
         {
            //System.out.println(removeNumb);
            hold = enemy.get(removeNumb);
            enemy.remove(removeNumb);
            removeEnemyAnt(hold);
            return hold;
         }
       public int getEnemies()
         {
            return enemy.size();
         }             
   }