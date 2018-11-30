import greenfoot.*;
import java.util.Arrays;




/**
 * Write a description of class ExplosionIteratorImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ImageIteratorImpl  implements ImageIterator
{
    GreenfootImage[] arrImages;
     private int cursor ;
    private int max ;

    /**
     * Constructor for objects of class ExplosionIteratorImpl
     */
    public ImageIteratorImpl()
    {
    }


  

    public ImageIteratorImpl(GreenfootImage[] images)
    {
       this.arrImages=Arrays.copyOf(images,images.length);
       cursor=0;
       max=arrImages.length;
    }

   

	public GreenfootImage next() {
        cursor++ ;
        if ( !isDone() )
		    return arrImages[cursor] ;
        else
            return null;
	}

	public GreenfootImage currentImage() {
	  return arrImages[cursor] ;
	}

	public boolean isDone() {
		return (cursor == max) ;
	}
	 
    
    
}
