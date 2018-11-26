import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int health = 100;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Health : " + health, 24, Color.GREEN, Color.BLACK));
    } 
    
    public void reduceHealth()
    {
        if(health >=10)
        {
            health = health - 10;
        }
        if (health == 0)
        {
            
            MyWorld myworld = (MyWorld)getWorld();
            myworld.doGameOver();
            
        }
    }
    
}
