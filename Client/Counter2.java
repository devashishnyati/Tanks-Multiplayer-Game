import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter2 extends Actor
{
    
    public Counter2(Player2 subject){
        subject.attach(this);
    
    }
    /**
     * Act - do whatever the Counter2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Player 2 Health : " + Acceptor.xy.health[1], 24, Color.GREEN, Color.BLACK));
    } 
    
    public void reduceHealth()
    {
        if (Acceptor.xy.health[1] >= 10)
        Acceptor.xy.deductHealth2(10);
        if (Acceptor.xy.health[1] == 0)
        {
            
            MyWorld myworld = (MyWorld)getWorld();
            myworld.doGameOver();
            
        }
    }
    
}
