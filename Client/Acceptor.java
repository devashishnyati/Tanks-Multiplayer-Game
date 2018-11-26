import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Acceptor extends Thread
{
    // instance variables - replace the example below with your own
    public static XY xy = new XY();
    private static int bulletCount = 0;
    private DatagramSocket socket;
    /**
     * Constructor for objects of class Client
     */
    public Acceptor() throws Exception
    {
        
        socket = new DatagramSocket(5001);
    }

    public void run()
    {
        

        try {
            byte[] serializedMessage = new byte[1024];
            while (true) {
                try {
                    
                    DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length);
                    socket.receive(packet);
                    
                    ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
                    Object o = iStream.readObject();
                    iStream.close();
                    
                    if (o instanceof XY){
                            XY data = (XY) o;
                            
                            System.out.println(data.x + " -ai " + data.y);
                            Acceptor.xy.x = data.x;
                            Acceptor.xy.y = data.y;
                            Acceptor.xy.id = data. id;
                        }else if(o instanceof FirePacket && Acceptor.bulletCount!=((FirePacket) o).bulletCounter){
                                FirePacket firePacket = (FirePacket) o;
                                Acceptor.bulletCount = firePacket.bulletCounter;
                                Bullets bullet;
                                Bullet2 bullet2;
                                if(firePacket.direction==1){
                                    bullet= new Bullets();
                                    MyWorld.mw.addObject(bullet,firePacket.x,firePacket.y);
                                }
                                else{
                                    bullet2= new Bullet2();
                                MyWorld.mw.addObject(bullet2,firePacket.x,firePacket.y);
                            }
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    
    }
}
