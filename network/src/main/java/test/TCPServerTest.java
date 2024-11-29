package test;

import java.io.*;
import java.net.*;

public class TCPServerTest {

	public static void main(String[] args) {
		// 나 : 192.168.0.22

		ServerSocket serverSocket = null;

		try {
			// 1. 소켓 객체 생성
			serverSocket = new ServerSocket();

			// 2. 소켓 주소(접근 가능한 IP 주소 + 포트) 바인딩
			// InetSocketAddress("0.0.0.0", __ ) = 모두 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 50000));

			// 3. blocking 실행, 통신 요청 기다리는 중
			Socket socket = serverSocket.accept();
			System.out.println("연결 성공");

			// 4. Java::IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			while (true) {

				// 5. 데이터 읽기 - inputStreamReader로도 가능
				byte[] buffer = new byte[256];
				// 5.1 blocking
				int readByteCount = is.read(buffer); // socket io exception과 별도로 io exception 발생

				// 5.2 파일 끝 => 클라이언트가 소켓 닫음
				if (readByteCount == -1) {
					System.out.println("[server] closeod by client");
					return;
				}

				// 5.3 데이터 확인
				// 시작(offset) - 끝(readByteCount)
				String data = new String(buffer, 0, readByteCount, "utf-8");
				System.out.println("[server] receive: " + data);

				// 6. 데이터 쓰기
				os.write(data.getBytes("utf-8"));

			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("[server1] Socket Exception : " + e);
		} catch (IOException e) {
			System.out.println("[server] error : " + e);
		} finally {
			try {
				// 6. 소켓 닫기
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
