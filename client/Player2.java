import greenfoot.*;
import java.util.* ;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ele here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    private Command wCommand;
    private Command sCommand;
    private Command aCommand;
    private Command dCommand;
    private Command fireCommand;
    private List<Counter2> observers = new ArrayList<Counter2>();
    
    public Player2(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 100, image.getHeight() - 30);
        setImage(image);
        
        this.wCommand = new WCommand(this);
        this.sCommand = new SCommand(this);
        this.aCommand = new ACommand(this);
        this.dCommand = new DCommand(this);
        this.fireCommand = new FireCommand(this);
    }
    
    public void act()
    {
        MyWorld myworld = (MyWorld)getWorld();
        hitBulletDetection();
        //if(myworld.current instanceof OngoingGameWorldState)
        {
            if(Acceptor.xy.id == 1){
            
                if(Greenfoot.isKeyDown("W")&&canMoveUp()) wCommand.execute();
                if(Greenfoot.isKeyDown("S")&&canMoveDown()) sCommand.execute();
                if(Greenfoot.isKeyDown("A")&&canMoveLeft()) aCommand.execute();
                if(Greenfoot.isKeyDown("D")&&canMoveRight()) dCommand.execute();
                if (!(myworld.current instanceof GameOverGameWorldState))
                    if("space".equals(Greenfoot.getKey())) fireCommand.execute();
                
                Sender.sendData(new XY(getX(),getY(),Acceptor.xy.health));
                
                if(Acceptor.xy.x != -1)
                {
                        myworld.doOngoingGame();
                }                    
            
            }else{
               int y = Acceptor.xy.y;
               int x = Acceptor.xy.x;
            
               setLocation(x,y);
            }
        }
        
    }
    
  
     /**
     * Fire Bullets
     */
    public void fire()
    {
       Bullets bullet= new Bullets();
       getWorld().addObject(bullet,getX(),getY());
       bullet.move(10);
       
    }
    
        public boolean canMoveLeft()
    {
         boolean canMoveLeft=true;
        int imgWidth=getImage().getWidth();
        int imgHeight=getImage().getHeight();
     
        if(getOneObjectAtOffset(imgWidth/-2-2, imgHeight/-2, Player1.class)!=null||
        getOneObjectAtOffset(imgWidth/-2-2, imgHeight/2-1, Player1.class)!=null)
        {
           canMoveLeft=false;
        }
        return canMoveLeft;
        
    }
     public boolean canMoveRight()
    {
       boolean canMoveRight=true;
        int imgWidth=getImage().getWidth();
        int imgHeight=getImage().getHeight();
     
        if(getOneObjectAtOffset(imgWidth/2+2, imgHeight/-2, Player1.class)!=null||
        getOneObjectAtOffset(imgWidth/2+2, imgHeight/2-1, Player1.class)!=null)
        {
           canMoveRight=false;
        }
        return canMoveRight;
    }
    
    public boolean canMoveDown()
    {
       boolean canMoveDown=true;
        int imgWidth=getImage().getWidth();
        int imgHeight=getImage().getHeight();
     
         if(getOneObjectAtOffset(imgWidth/-2, imgHeight/2, Player1.class)!=null||
        getOneObjectAtOffset(imgWidth/2, imgHeight/2, Player1.class)!=null)
        {
          canMoveDown=false;
        }
        return canMoveDown;
    }
     public boolean canMoveUp()
     {
       boolean canMoveUp=true;
        int imgWidth=getImage().getWidth();
        int imgHeight=getImage().getHeight();
     
         if(getOneObjectAtOffset(imgWidth/-2, imgHeight/-2, Player1.class)!=null||
        getOneObjectAtOffset(imgWidth/2, imgHeight/-2, Player1.class)!=null)
        {
          canMoveUp=false;
        }
        return canMoveUp;
    }
    
    public void hitBulletDetection(){
        Actor p2 = getOneIntersectingObject(Bullets.class);
        
        if(p2 != null)
        {
           Explosions exp=new Explosions();
            getWorld().addObject(exp, getX(), getY());
             exp.showExplosion();
            MyWorld myworld = (MyWorld)getWorld();
            //Counter2 counter = myworld.getCounter2();
            notifyAllObservers();
            getWorld().removeObject(getOneIntersectingObject(Bullets.class));
        }
    }
    
    public void attach(Counter2 counter){
      observers.add(counter);		
   }
   
   public void notifyAllObservers(){
      for (Counter2 observer : observers) {
          System.out.println("Counter 2 observer");
         observer.reduceHealth();
      }
   } 
    
    
}
