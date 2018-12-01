import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Introduction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introduction extends World
{
    GreenfootSound sound = new GreenfootSound("Lounge Game2.wav");
    /**
     * Constructor for objects of class Introduction.
     * 
     */
    public Introduction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800,600, 1);
    }
    
    public void act(){
        IntroMusic();
        start();
        prepare();
        
    }
    
    public void start(){
        if("enter".equals(Greenfoot.getKey())) 
        {
            sound.stop();
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    public void prepare(){
        
        IntroPlayer intro1 = new IntroPlayer();
        addObject(intro1,100,330);
        IntroPlayer2 intro2 = new IntroPlayer2();
        addObject(intro2,700,220);
        if(Greenfoot.getRandomNumber(60)<1){
            Bullets bullet = new Bullets();
            addObject(bullet,100,330);
        }
        if(Greenfoot.getRandomNumber(60)<1){
            Bullet2 bullet2 = new Bullet2();
            addObject(bullet2,700,220);
        }
    }
    public void IntroMusic(){
        sound.playLoop();
        
    }
    
    
}
