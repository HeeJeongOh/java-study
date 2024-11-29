package echo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.211";

	public static void main(String[] args) {

		Scanner scanner = null;
		Socket socket = null;

		try {
			scanner = new Scanner(System.in, "utf-8");
			// 1. 소켓 생성
			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, 60000));

			// 3. IO Stream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 4. 쓰기 & 읽기
			while (true) {
				System.out.print(">> ");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				pw.println(line);

				String data = br.readLine();
				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<< " + data);
			}

		} catch (SocketException e) {
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

	private static void log(String message) {
		System.out.println("[Echo client] " + message);

	}
}