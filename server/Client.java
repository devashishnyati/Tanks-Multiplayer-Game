import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    private static DatagramSocket socket;
    private static InetAddress address;
    private static XY oldXY = new XY();
    static
    {
        try{
           socket = new DatagramSocket();
           address = InetAddress.getByName("130.65.254.18");
        }catch(Exception e){e.printStackTrace();}
    }

    public static void sendData(Object o){
        

        try{
         
             //System.out.println("inside");
         ByteArrayOutputStream bStream = new ByteArrayOutputStream();
         ObjectOutput oo = new ObjectOutputStream(bStream);
         oo.writeObject(o);
         oo.close();

         byte[] buf = bStream.toByteArray();
         DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 7174);
         socket.send(packet);
        
        }catch(Exception e){e.printStackTrace();}

    }
    
    public static void main(String[] args) {
    	sendData(new XY());
    }
}
