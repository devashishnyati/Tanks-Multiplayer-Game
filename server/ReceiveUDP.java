import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
//			ByteArrayOutputStream bStream = new ByteArrayOutputStream();
//			ObjectOutput oo = new ObjectOutputStream(bStream);
//			XY temp = new XY();
//			temp.x = 90;
//			temp.y = 90;
//			temp.id = -1;
//			oo.writeObject(temp);
//			oo.close();
			byte[] serializedMessage = new byte[1024];
			while (true) {
				try {
					
					DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length);
					socket.receive(packet);
					
					ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
					Object o = iStream.readObject();
					iStream.close();
					
					System.out.println(ipList);
					packet.setPort(5001);
					
					if(!ipList.contains(packet.getAddress()))
						ipList.add(packet.getAddress());
					
					int i=1;
					InetAddress tempIp = packet.getAddress();
					
					for(InetAddress ip :ipList) {
						byte[] newSerializedMessage = null;
						if (o instanceof XY)
							newSerializedMessage = getXY((XY) o, ip);
						else if(o instanceof FirePacket)
							newSerializedMessage = getFirePacket((FirePacket) o);
						
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

	private byte[] getXY(XY xy, InetAddress ip) throws IOException {
		ByteArrayOutputStream bStream1 = new ByteArrayOutputStream();
		ObjectOutput newoo = new ObjectOutputStream(bStream1);
		xy.id = ipList.indexOf(ip);
		System.out.println(xy.x + " - " + xy.y);
		newoo.writeObject(xy);
		newoo.close();
		byte[] newSerializedMessage = bStream1.toByteArray();
		return newSerializedMessage;
	}
	
	private byte[] getFirePacket(FirePacket firePacket) throws IOException {
		ByteArrayOutputStream bStream1 = new ByteArrayOutputStream();
		ObjectOutput newoo = new ObjectOutputStream(bStream1);
		System.out.println("fire");
		newoo.writeObject(firePacket);
		newoo.close();
		byte[] newSerializedMessage = bStream1.toByteArray();
		return newSerializedMessage;
	}
	
	public static void main(String args[]) throws Exception {
		Thread t1 = new ReceiveUDP();
		t1.start();
	}
}
