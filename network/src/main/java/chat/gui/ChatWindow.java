package chat.gui;

import java.awt.*;
import java.awt.event.*;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
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
				System.exit(0);
			}
		});

		frame.setVisible(true);
		frame.pack();

		/*
		 * 1. 서버 연결 작업 
		 * 2. IO Stream 
		 * 3. JOIN 프로토콜 
		 * 4. chat Client Thread 생성
		 */

	}

	private void sendMessage() {
		// 읽어오기 
		String message = textField.getText();
		System.out.println("메세지 : " + message);
	}
}
