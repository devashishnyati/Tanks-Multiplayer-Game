import java.io.IOException;
import java.net.SocketAddress;

public interface MediatorServer {
	byte[] getFirePacket(FirePacket packet) throws IOException;
	byte[] getXY(XY packet,SocketAddress address) throws IOException;
}
