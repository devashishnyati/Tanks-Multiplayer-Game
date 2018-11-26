import greenfoot.*;

public class FireCommand implements Command {
    
    Actor actor;
    
    public FireCommand(Actor actor){
        this.actor = actor;
    }
    
    public void execute() {
       int x = this.actor.getX();
       int y = this.actor.getY();
       Bullets bullet= new Bullets();
       this.actor.getWorld().addObject(bullet,x,y);
       bullet.move(10);
    }

}