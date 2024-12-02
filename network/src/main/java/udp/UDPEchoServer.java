package udp;

import java.io.IOException;
import java.net.*;

public class UDPEchoServer {

	public static final int PORT = 60022;
	public static final int BUFFER_SIZE = 256;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PORT);

			while (true) {
				// 2. 데이터 수신 
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(rcvPacket);

				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();

				String message = new String(rcvData, 0, offset, "utf-8");
				System.out.println("[UDP Echo Server] received: " + message);

				// 3. 데이터 송신 

				byte[] sndData = message.getBytes("utf-8");

				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(),
						rcvPacket.getPort());

				socket.send(sndPacket);

			}

		} catch (SocketException e) {
			System.out.println("[UDP Echo Server] error: " + e);

		} catch (IOException e) {
			System.out.println("[UDP Echo Server] error: " + e);
		} finally {
			// 연결이 없기 때문에 예외가 존재하지 않음. 
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}

	}

}
