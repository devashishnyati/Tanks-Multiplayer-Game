import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
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
           socket = new DatagramSocket(5000);
           address = InetAddress.getByName("52.53.161.113");
        }catch(Exception e){e.printStackTrace();}
    }

    public static void sendData(Object o){
        

        try{
         
         ByteArrayOutputStream bStream = new ByteArrayOutputStream();
         ObjectOutput oo = new ObjectOutputStream(bStream);
         oo.writeObject(o);
         oo.close();
         
         byte[] buf = bStream.toByteArray();
         DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
         socket.send(packet);
         

    	 ByteArrayOutputStream bStream1 = new ByteArrayOutputStream();
         ObjectOutput oo1 = new ObjectOutputStream(bStream1);
         oo1.writeObject(new XY());
         oo1.close();

         byte[] buf1 = bStream1.toByteArray();
         DatagramPacket packet1 = new DatagramPacket(buf1, buf1.length, address, 5000);
         
         
         while(true) {
        	 try {
        	 socket.send(packet1);

			socket.setSoTimeout(200);
        	 socket.receive(packet1);
			ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
			Object o1 = iStream.readObject();
			iStream.close();
		
			System.out.println(o1);
        	 }catch(Exception e){}
         }
        }catch(Exception e){e.printStackTrace();}

    }
    
    public static void main(String[] args) {
    	sendData(new DummyPacket());
    }
}
