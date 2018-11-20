import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        try{
        Thread t = new Receiver();
        t.start();}catch(Exception e){e.printStackTrace();}
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player1 player1 = new Player1();
        addObject(player1,301,145);
        //Bear bear = new Bear();
        //addObject(bear,186,187);
        Player2 player2 = new Player2();
        addObject(player2,241,206);
    }
}
