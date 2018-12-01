import greenfoot.*;


/**
 * Write a description of class ImageRepositoryImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ImageRepositoryImpl implements ImageRepository
{
    // instance variables - replace the example below with your own
    private GreenfootImage[] images;

    /**
     * Constructor for objects of class ImageRepositoryImpl
     */
    public ImageRepositoryImpl()
    {
        images=new GreenfootImage[3];
        images[0]=new GreenfootImage("explosion 1.png");
        images[1]=new GreenfootImage("explosion 1.png");
        images[2]=new GreenfootImage("explosion 2.png");
        System.out.println("inside repository "+images.length);
        
    }
    
    public ImageIterator createIterator()
    {
        return new ImageIteratorImpl(images);
    }
    
}
