package test;

import java.io.*;
import java.net.*;

public class TCPClientTest {

	public static void main(String[] args) {

		Socket socket = null;

		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 1-1. 소켓 버퍼 사이즈 확인 
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize + " : " + sndBufferSize);

			// 1-2. 소켓 버퍼 사이즈 변경
			// 실제로는 잘 변경 안 함. 뭐가 잘 안되는 원인에 해당되지 않을 가능성 높음.
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);

			rcvBufferSize = socket.getReceiveBufferSize();
			sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize + " : " + sndBufferSize);

			// 1-3. SO_NODELAY(Nagle Alg. off) 
			socket.setTcpNoDelay(true);

			// 1-4. SO_TIMEOUT >> 49줄에서 오류 발생 
			socket.setSoTimeout(3000);

			// 2. 서버 연결
			socket.connect(new InetSocketAddress("192.168.0.4", 60022));

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
			System.out.println("[client] Socket Exception : " + e);

		} catch (SocketTimeoutException e) {
			System.out.println("[client] Timeout Exception : " + e);

		} catch (IOException e) {
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
