import java.io.*;
import java.net.*;

public class Sender  
{
    private static DatagramSocket socket;
    private static InetAddress address;
    private static XY oldXY = new XY();
    static
    {
        try{
           socket = new DatagramSocket();
           address = InetAddress.getByName("10.250.30.121");
        }catch(Exception e){e.printStackTrace();}
    }

    public static void sendData(int x,int y){

        try{
         if(oldXY.x !=x || oldXY.y != y){
             System.out.println("inside");
         ByteArrayOutputStream bStream = new ByteArrayOutputStream();
         ObjectOutput oo = new ObjectOutputStream(bStream);
         XY temp = new XY();
         temp.x = x;
         temp.y = y;
         oo.writeObject(temp);
         oo.close();

         byte[] buf = bStream.toByteArray();
         DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
         socket.send(packet);
         
         oldXY.x= x;
         oldXY.y= y;
        }
        }catch(Exception e){e.printStackTrace();}

    }
}
