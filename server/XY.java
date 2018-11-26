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
    
    public XY(int x,int y){
        this.x = x;
        this.y = y;
    }
}
