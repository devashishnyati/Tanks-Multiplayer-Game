import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ServerUDP extends Thread implements MediatorServer{

	private DatagramSocket socket;
	private DatagramSocket socket1;

	List<SocketAddress> soAddressList = new ArrayList<SocketAddress>();
	List<InetAddress> ipList = new ArrayList<InetAddress>();

	public ServerUDP() throws Exception {
		socket = new DatagramSocket(5000);
		socket1 = new DatagramSocket();
	}

	public void run() {

		byte[] serializedMessage = new byte[1024];
		while (true) {
			try {
				System.out.print( " = ");
				DatagramPacket packet = new DatagramPacket(serializedMessage, serializedMessage.length);
				
				socket.receive(packet);

				ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
				Object o = iStream.readObject();
				iStream.close();
				
				if (o instanceof DummyPacket ) {
					System.out.print( " + ");
					if(!soAddressList.contains(packet.getSocketAddress())) {
						soAddressList.add(packet.getSocketAddress());
						ipList.add(packet.getAddress());
					}
					
					continue;
				}

				InetAddress ip = packet.getAddress();
				SocketAddress so = null;
				
				System.out.println(soAddressList);
				System.out.println(ipList.indexOf(ip) + "  index");
				
				try {
					if (ipList.indexOf(ip) % 2 == 0)
						so = soAddressList.get(ipList.indexOf(ip) + 1);
					else
						so = soAddressList.get(ipList.indexOf(ip) - 1);

					byte[] newSerializedMessage = null;
					if (o instanceof XY)
						newSerializedMessage = getXY((XY) o, so);
					else if (o instanceof FirePacket)
						newSerializedMessage = getFirePacket((FirePacket) o);

					packet.setData(newSerializedMessage);
					System.out.print(ip + " = ");
					System.out.println(packet.getAddress());

					packet.setSocketAddress(so);

					socket1.send(packet);
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public byte[] getXY(XY xy, SocketAddress ip) throws IOException {
		ByteArrayOutputStream bStream1 = new ByteArrayOutputStream();
		ObjectOutput newoo = new ObjectOutputStream(bStream1);
		xy.id = soAddressList.indexOf(ip);
		System.out.println(xy.x + " - " + xy.y+"  id: "+xy.id);
		newoo.writeObject(xy);
		newoo.close();
		byte[] newSerializedMessage = bStream1.toByteArray();
		return newSerializedMessage;
	}

	public byte[] getFirePacket(FirePacket firePacket) throws IOException {

		ByteArrayOutputStream bStream1 = new ByteArrayOutputStream();
		ObjectOutput newoo = new ObjectOutputStream(bStream1);
		System.out.println("fire : " + firePacket.count);
		newoo.writeObject(firePacket);
		newoo.close();
		byte[] newSerializedMessage = bStream1.toByteArray();
		return newSerializedMessage;
	}

	public static void main(String args[]) throws Exception {
		Thread t1 = new ServerUDP();
		t1.start();
	}
}