import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    
    public Counter(Player1 subject){
        subject.attach(this);
    
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Player 1 Health : " + Acceptor.xy.health[0], 24, Color.GREEN, Color.BLACK));
    } 
    
    public void reduceHealth()
    {
        if (Acceptor.xy.health[0] >= 10)
        Acceptor.xy.deductHealth(10);
        else if (Acceptor.xy.health[0] == 0)
        {
            
            MyWorld myworld = (MyWorld)getWorld();
            myworld.doGameOver();
            
        }
    }
    
}
