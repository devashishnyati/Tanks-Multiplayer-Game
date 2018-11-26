import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullets extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10.0);
        hitDetection();  
    }
    public void move(double distance)
    {
       int x = getX()+5;
       setLocation(x, getY());
    }
    public void hitDetection()
    {
        Actor b = getOneIntersectingObject(Player2.class);
         
       if(b != null)
        {
            Explosion exp=new Explosion();
            getWorld().addObject(exp, getX(), getY());
            exp.act();
            MyWorld myworld = (MyWorld)getWorld();
            Counter counter = myworld.getCounter();
            counter.reduceHealth();
            getWorld().removeObject(this);
        }
        
       else if(getX() >= getWorld().getWidth() - 1)   
       {
           System.out.println(getX());
           System.out.println(getWorld().getWidth() - 1);
            Explosion exp=new Explosion();
            getWorld().addObject(exp, getX(), getY());
            exp.act();
            getWorld().removeObject(this);  
        }
    }
    
    
}
