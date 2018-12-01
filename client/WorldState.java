public class WorldState implements IWorldState  
{
   
    MyWorld my_world;
    public WorldState(MyWorld myWorld) {
       this.my_world = myWorld;
    }
    
  
   public void act()  {}
    
   public void doOngoingGame() {}
   public void doPause() {}
   public void doGameOver() {}

}
