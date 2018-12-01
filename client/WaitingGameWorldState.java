/**
 * Write a description of class WaitingGameWorldState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaitingGameWorldState extends WorldState 
{
    public WaitingGameWorldState(MyWorld myWorld) {

        super(myWorld);

    }
    
    @Override
    public void doGameOver() {
               my_world.setState(my_world.getGameOverState());
    }
    
    @Override
    public void doOngoingGame() {
               my_world.setState(my_world.getOngoingState());
    }
    
}
