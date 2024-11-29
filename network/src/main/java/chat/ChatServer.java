package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 60022;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<>();

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			// 0.0.0.0으로 모두 수용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));

			log("연결 대기 중 " + hostAddress + ":" + PORT);

			// 3. 요청 대기
			// 3.1 클라이언트 요청을 통해 연결된 후,클라이언트와 채팅 데이터 통신은 chatServerThread가 수행
			while (true) {
				Socket socket = serverSocket.accept();

				new ChatServerThread(socket, listWriters).start();
			}

		} catch (IOException e) {
			log("error: " + e);
		}

	}

	public static void log(String msg) {
		System.out.println("[server] " + msg);
	}

}
