package echo;

import java.io.*;
import java.net.*;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.211";

	public static void main(String[] args) {

		Socket socket = null;

		try {
			// 1. 소켓 생성
			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

			// 2. 서버 연결
			socket.connect(new InetSocketAddress("192.68.0211", 60000));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));

			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				log("closed by server");
				return;
			}

			data = new String(buffer, 0, readByteCount, "utf-8");
			log("received : " + data);

		} catch (SocketException e) {
			log("SocketException : " + e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log("error : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[Echo client] " + message);

	}
}