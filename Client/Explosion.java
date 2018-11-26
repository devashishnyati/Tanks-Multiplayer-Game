import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosion1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the explosion1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int life=10;
    public void act() 
    {
       
       remove(); // Add your action code here.
    }    
    
    public void remove()
    {
        life--;
        if(life==0)
        {
             BigExplosion bigexp=new BigExplosion();
        getWorld().addObject(bigexp,getX(),getY());
        bigexp.act();
        getWorld().removeObject(this);
    }
    }
}
