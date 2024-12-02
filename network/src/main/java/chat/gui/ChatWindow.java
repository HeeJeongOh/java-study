package chat.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Base64;

import chat.ChatClient;
import chat.ChatServer;

public class ChatWindow {

	private static final String SERVER_IP = "127.0.0.1";

	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;

	private ChatClientThread chatClientThread;

	private String nickname;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	volatile boolean terminationFlag = true;

	public ChatWindow(String name) {
		nickname = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		/* 화면 구성하기
		 * 1.Button
		 * 2. TextField
		 * 3. Pannel
		 * 4. TextArea
		 * 5. Frame
		 * */

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.GRAY);

		// 객체 생성을 자동으로 수행하여 람다식을 가능하게 함 
		// buttonSend.addActionListner(actionEvent) -> {});
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		// KeyListener에 대해 기본 구현을 수행한 클래스 
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame = textArea + Pannel(= textField + buttonSend)
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		frame.setVisible(true);
		frame.pack();

		/* 서버 통신 작업 
		 * 1. 서버 연결  
		 * 2. IO Stream 
		 * 3. JOIN 프로토콜 
		 * 4. chat Client Thread 생성
		 */

		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			pw.println("JOIN:" + nickname);

			chatClientThread = new ChatClientThread();
			chatClientThread.start();

		} catch (SocketException e) {
			log("SocketException : " + e);

		} catch (IOException e) {
			log("error : " + e);

		}

	}

	private void sendMessage() {
		// textField에서 읽어 오기 
		String message = textField.getText();

		if ("".equals(message)) {
			return;
		}

		log("m:" + message);

		String encodedMessage = Base64.getEncoder().encodeToString(message.getBytes());
		pw.println("MSG:" + encodedMessage);

		// textField 비우기 + 커서 위치시키기 
		textField.setText("");
		textField.setFocusable(true);

	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		try {
			// quit protocol 구현
			pw.println("QUIT");

			// thread join -  스레드가 종료될 때까지 sleep
			chatClientThread.join();

			// exit java application : 정상 종료
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 이너 클래스로 선언함으로써, 아우터  클래스 접근이 용이함 
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					String data = br.readLine();
					if (data == null) {
						ChatClient.log("서버로부터 연결 중단");
						break;
					} else if (data.startsWith("JOIN")) {
						data = "===== 입장  ====";
					}
					// ChatClientThread에서 서버로부터 받은 메세지가 출
					updateTextArea(data);
				}
			} catch (IOException e) {
				ChatClient.log("error: " + e);
			}

		}

	}

	public static void log(String message) {
		System.out.println("[client] " + message);
	}

}
