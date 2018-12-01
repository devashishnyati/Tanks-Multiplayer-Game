import java.io.*;


public class XY implements Serializable
{
    private static final long serialVersionUID = 752113001688771241L;
    // instance variables - replace the example below with your own
    public int x = -1;
    public int y = -1;
    public int id;
    public int[] health = {100, 100};
    
    public XY(){}
    
    public XY(int x,int y,int[] health){
        this.x = x;
        this.y = y;
        this.health = health;
    }
    
    public void deductHealth(int h)
    {
        if(this.health[0] - h < 0){
            this.health[0] = 0;
        }
        else
        {
        this.health[0] -= h;
        }

    }
    
    public void deductHealth2(int h)
    {
        if(this.health[1] - h < 0){
            this.health[1] = 0;
        }
        else
        {
        this.health[1] -= h;
        }

    }
}
