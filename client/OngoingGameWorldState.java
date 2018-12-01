/**
 * Write a description of class OngoingGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OngoingGameWorldState extends WorldState 
{
    public OngoingGameWorldState(MyWorld myWorld) {

        super(myWorld);

    }
    @Override
       public void doGameOver() {
                   my_world.setState(my_world.getGameOverState());
        }
    
}
