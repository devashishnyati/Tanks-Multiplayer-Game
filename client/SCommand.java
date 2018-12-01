import greenfoot.*;

public class SCommand implements Command {
    
    Actor actor;
    
    public SCommand(Actor actor){
        this.actor = actor;
    }
    
    public void execute() {
        int x = this.actor.getX();
        int y = this.actor.getY()+2;

        this.actor.setLocation(x,y);
    }

}