package chat;

import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "192.168.0.4";

	public static void main(String[] args) {

		Scanner scanner = null;
		Socket socket = null;

		try {
			// 0. 키보드 연결
			scanner = new Scanner(System.in, "utf-8");

			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();

			pw.println("JOIN:" + nickname);
			pw.flush();

			new ChatClientThread(socket).start();

			// 4. 쓰기 & 읽기
			while (true) {
				String line = scanner.nextLine();
				String encodedStr = Base64.getEncoder().encodeToString(line.getBytes());

				if ("quit".equals(line)) {
					pw.println("QUIT");
					pw.flush();
					break;
				} else if ("".equals(line)) {
					System.out.println("한 글자 이상 입력하세요.");
				} else {
					pw.println("MSG:" + encodedStr);
					pw.flush();
				}
			}

		} catch (

		SocketException e) {
			log("SocketException : " + e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log("error : " + e);

		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String message) {
		System.out.println("[client] " + message);

	}

}
