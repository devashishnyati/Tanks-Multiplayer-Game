import greenfoot.*;

public class DCommand implements Command {
    
    Actor actor;
    
    public DCommand(Actor actor){
        this.actor = actor;
    }
    
    public void execute() {
        int x = this.actor.getX()+2;
        int y = this.actor.getY();
        
        this.actor.setLocation(x,y);
    }

}