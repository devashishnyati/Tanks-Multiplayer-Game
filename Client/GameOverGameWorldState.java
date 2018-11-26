/**
 * Write a description of class GameOverGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverGameWorldState extends WorldState 
{

       public void act()  {}
    
    public GameOverGameWorldState(MyWorld myWorld) {
        super(myWorld);
    }
    
    @Override
    public void doGameOver() {
        my_world.setState(this);
    }

}
