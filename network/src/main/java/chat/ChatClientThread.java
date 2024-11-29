package chat;

import java.io.*;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private Socket socket;

	private BufferedReader br;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while (true) {

				String data = br.readLine();
				if (data == null) {
					ChatClient.log("서버로부터 연결 중단");
					break;
				}
				// 확인하지 않으면 위에서 통신하고, 소켓이 닫히면서 또 통신 됨.
				else if ("QUIT SUCCESS".equals(data)) {
					return;
				}
				System.out.println(data);
			}

		} catch (IOException e) {
			ChatClient.log("error: " + e);
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
