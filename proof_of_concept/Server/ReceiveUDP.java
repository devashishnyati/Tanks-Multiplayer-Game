import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class ReceiveUDP extends Thread {

	private DatagramSocket socket;
	private DatagramSocket socket1;
	
	List<InetAddress> ipList = new ArrayList<InetAddress>();
	//private InetAddress address;
//
//	private byte[] buf;

	public ReceiveUDP() throws Exception {
		socket = new DatagramSocket(5000);
		socket1 = new DatagramSocket();
		//ipList.add(InetAddress.getByName("10.250.204.114"));
		//ipList.add(InetAddress.getByName("10.250.30.121"));
	}

	public void run() {

		try {
			ByteArrayOutputStream bStream = new ByteArrayOutputStream();
			ObjectOutput oo = new ObjectOutputStream(bStream);
			XY temp = new XY();
			temp.x = 90;
			temp.y = 90;
			temp.id = -1;
			oo.writeObject(temp);
			oo.close();
			byte[] serializedMessage = bStream.toByteArray();
			while (true) {
				try {
					
					DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length);
					socket.receive(packet);
					
					ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
					XY xy = (XY) iStream.readObject();
					iStream.close();
					System.out.println(xy.x + " - " + xy.y);
					System.out.println(ipList);
					packet.setPort(5001);
					
					if(!ipList.contains(packet.getAddress()))
						ipList.add(packet.getAddress());
					int i=1;
					InetAddress tempIp = packet.getAddress();
					for(InetAddress ip :ipList) {
						ObjectOutput newoo = new ObjectOutputStream(bStream);
						xy.id = ipList.indexOf(ip);
						newoo.writeObject(xy);
						newoo.close();
						byte[] newSerializedMessage = bStream.toByteArray();
						packet.setData(newSerializedMessage);
						System.out.print(ip + " = ");
						System.out.println(packet.getAddress());
						if(ip.equals(tempIp))
							continue;
						
						System.out.println("i="+i);
						
						i++;
						packet.setAddress(ip);
						socket1.send(packet);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String args[]) throws Exception {
		Thread t1 = new ReceiveUDP();
		t1.start();
	}
}
