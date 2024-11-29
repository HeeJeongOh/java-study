package test;

import java.io.*;
import java.net.*;

public class TCPClientTest {

	public static void main(String[] args) {

		Socket socket = null;

		// 1. 소켓 생성
		socket = new Socket();

		try {
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
				System.out.println("[client] closded by server");
				return;
			}

			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[client] received : " + data);

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("[client] Socket Exception : " + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[client] error : " + e);
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

}
