package chat;

import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;

	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {

		BufferedReader br = null;
		PrintWriter pw = null;

		// 1. remote host information

		// 2. 읽기 쓰기
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 3. 요청 처리
			while (true) {
				String request = br.readLine();

				if (request == null) {
					ChatServer.log("클라이언트로부터 연결 중단 " + request);
					break;
				}

				ChatServer.log(request);

				// 4. 프로토콜 분석 - join, msg, quit
				String[] tokens = request.split(":");
				if ("JOIN".equals(tokens[0])) {
					doJoin(tokens[1], pw);

				} else if ("MSG".equals(tokens[0])) {
					byte[] decodedBytes = Base64.getDecoder().decode(tokens[1]);
					doMessage(new String(decodedBytes));

				} else if ("QUIT".equals(tokens[0])) {
					doQuit(pw);

				} else {
					ChatServer.log("error: 알 수 없는 요청 (" + tokens[0] + ")");
				}
			}

		} catch (IOException e) {
			ChatServer.log("error: " + e);
		} finally {
			try {

				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error: " + e);
			}
		}

	}

	private void doQuit(PrintWriter writer) {

		removeWriter(writer);

		String data = nickname + "님이 퇴장하였습니다.";

		/*
		 * Writer writer로 매개변수를 받는 경우
		 * 
		 * PrintWriter printWriter = new PrintWriter(writer);
		 * 
		 * printWriter.println("QUIT SUCCESS");
		 * 
		 * printWriter.flush(); // 내부 버퍼를 강제로 비움
		 */

		// 클라이언트 측에 성공 소식 전달
		writer.println("QUIT SUCCESS");
		writer.flush();

		broadcast(data, true);

	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String msg) {
		ChatServer.log("send messaging...");

		broadcast(msg, false);
	}

	private void doJoin(String nickname, PrintWriter writer) {
		ChatServer.log("start joining...");

		this.nickname = nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data, true);

		// 동기화 보장
		addWriter(writer);

		// 클라이언트 측에 성공 소식 전달
		writer.println("JOIN SUCCESS");
		writer.flush();

	}

	private void addWriter(Writer writer) {
		ChatServer.log("adding new client...");

		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		ChatServer.log("broadcasting...");

		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter pw = (PrintWriter) writer;
				pw.println(nickname + ":" + data);
				pw.flush();
			}

		}
	}

	private void broadcast(String data, boolean isOP) {
		ChatServer.log("broadcasting...");

		if (!isOP) {
			broadcast(data);
		} else {
			synchronized (listWriters) {
				for (Writer writer : listWriters) {
					PrintWriter pw = (PrintWriter) writer;
					pw.println(data);
					pw.flush();
				}

			}
		}
	}

}
