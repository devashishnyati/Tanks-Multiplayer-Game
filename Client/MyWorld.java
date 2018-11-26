import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static MyWorld mw;
    Counter counter = new Counter();
    Counter2 counter2 = new Counter2();
    public static WorldState current;
    private WorldState prev;    
    private WorldState onGoing;
    private WorldState gameOver;
    private WorldState waiting;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        MyWorld.mw = this;
        onGoing = new OngoingGameWorldState(this);
        gameOver = new GameOverGameWorldState(this);
        waiting = new WaitingGameWorldState(this);
        current = waiting;
        try{
        Thread t = new Acceptor();
        t.start();}catch(Exception e){e.printStackTrace();}
    }
    
    public void act(){
        prepare();
    }
    
    public WorldState getState() {
        return current;
    }
    public void setState(WorldState state) {
        this.current = state;
    }
    
    public WorldState getOngoingState() {
        return this.onGoing;
    }

    public WorldState getGameOverState() {
        return this.gameOver;
    }
    
    public WorldState getWaitingState() {
        return this.waiting;
    }

    public Counter getCounter()
    {
        return counter;
    }
    public Counter2 getCounter2()
    {
        return counter2;
    }
    
    public void doOngoingGame() {
       this.current.doOngoingGame();
   }
   public void doPause() {
       this.current.doPause(); 
   }
   public void doGameOver() {
       this.current.doGameOver();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        if (prev != current)
        {
            if (current instanceof WaitingGameWorldState)
                prepareWaiting();
            if (current instanceof OngoingGameWorldState)
                prepare2player();
            if (current instanceof GameOverGameWorldState)
                prepareGameOver();
        }
        prev = current;
    }
    
    private void prepareWaiting()
    {
        Waiting waiting = new Waiting();
        Player1 player1 = new Player1();
        addObject(player1,101,190);
        this.addObject(waiting, 351, 190);
    }
    
    private void prepareGameOver()
    {
        GameOver gameover = new GameOver();
        this.addObject(gameover, this.getWidth()/2, this.getHeight()/2);
    }
    private void prepare2player()
    {
        addObject(counter, 100, 40);
        addObject(counter2, 400, 40);
        //Bear bear = new Bear();
        //addObject(bear,186,187);
        Player2 player2 = new Player2();
        addObject(player2,241,206);
    }
}
