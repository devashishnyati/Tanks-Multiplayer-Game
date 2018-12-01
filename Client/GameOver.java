import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    public GameOver()
    {
        String displayMsg = "";
        if (Acceptor.xy.health[0] == 0)
            displayMsg += "Player 2 Wins";

         if (Acceptor.xy.health[1] == 0)

        if (Acceptor.xy.health[1] == 0)

            displayMsg += "Player 1 Wins";
        setImage(new GreenfootImage(displayMsg, 48, Color.WHITE, Color.BLACK));
    }
}
