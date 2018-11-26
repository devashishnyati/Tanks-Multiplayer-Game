import greenfoot.*;

public class ACommand implements Command {
    
    Actor actor;
    
    public ACommand(Actor actor){
        this.actor = actor;
    }
    
    public void execute() {
        int x = this.actor.getX()-2;
        int y = this.actor.getY();

        this.actor.setLocation(x,y);
    }

}