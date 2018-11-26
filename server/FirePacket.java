import java.io.*;

public class FirePacket implements Serializable
{
    
	private static final long serialVersionUID = -1179812571626689916L;
	
	public int direction;
    public int x;
    public int y;
    
    public FirePacket(int x,int y,int direction)
    {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

}