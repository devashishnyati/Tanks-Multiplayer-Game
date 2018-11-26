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
       FirePacket.bulletCounter++;
       if(Acceptor.xy.id==0)
        Sender.sendData(new FirePacket(x,y,1));
       else
        Sender.sendData(new FirePacket(x,y,-1));
       this.actor.getWorld().addObject(bullet,x,y);
       bullet.move(10);
    }

}