import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Explosions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosions  extends Actor
{
    // instance variables - replace the example below with your own
    private int life=20;
private GreenfootImage[] explosions;
private int ExplosionType;

    /**
     * Constructor for objects of class Explosions
     */
    public Explosions()
    {
    }

     public Explosions(int type)
    {
        ExplosionType=type;
        
    }
    public void act()
    {
    showExplosion();
}
public void showExplosion()
{
    ImageRepository imageRepo= new ImageRepositoryImpl();
    ImageIterator iter =  imageRepo.createIterator();
  System.out.println("outside Iterator"+iter.isDone());
 life--;
 if(life >0)
 {   while(!iter.isDone())
    {
        System.out.println("inside  Iterator"+iter.currentImage());
      
         GreenfootImage myImage;
       myImage = iter.currentImage();

      
        this.setImage(myImage);
        iter.next();
    }
  
}
else
    getWorld().removeObject(this);
}

}
