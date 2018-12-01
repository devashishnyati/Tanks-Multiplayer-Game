import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
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
       int x = getX()-5;
       setLocation(x, getY());
    }
    
     public void hitDetection()
    {
        if(getX() < 1)   
       {
            Explosions exp=new Explosions();
            getWorld().addObject(exp, getX(), getY());
             exp.showExplosion();
            getWorld().removeObject(this);  
        }
    }
}
