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
    private int life=70;
  //   private int life1=getX();
   
    private int lifeExp=1;
    public void act() 
    {
        move(10.0);
     //    System.out.println("life1 "+life1);
        life--;
        if(life==0||isOnSolidGround())
        {   Explosion exp=new Explosion();
            getWorld().addObject(exp, getX(), getY());
            exp.act();
            getWorld().removeObject(this);
          //  getWorld().removeObject(exp);
         // lifeExp--;
          //  if(lifeExp==0)
           // {
           //     getWorld().removeObject(exp);
           // }
        }
        
    }
    public void move(double distance)
    {
       //double angle=Math.toRadians(getRotation());
       //(int)Math.round(getX()+Math.cos(angle)*distance);
       //int y=(int)Math.round(getY()+Math.cos(angle)*distance);
       //System.out.println(x+" "+y);
       int x = getX()-5;
       setLocation(x, getY());
    }
    public boolean isOnSolidGround()
    {
        boolean isOnGround=false;
        int imgWidth=getImage().getWidth();
        int imgHeight=getImage().getHeight();
       if( getY()>getWorld().getHeight()-50)
       {
           isOnGround=true;
        }
        if(getOneObjectAtOffset(imgWidth/-2, imgHeight/2, Player1.class)!=null||
        getOneObjectAtOffset(imgWidth/2, imgHeight/2, Player1.class)!=null)
        {
          //  World world=getWorld();
          //  MyWorld myworld=(MyWorld)world;
         // Counter counter= myworld.getCounter();
        //    counter.addScore();
           isOnGround=true;
        }
        
        
        return isOnGround;
    }
    
}
