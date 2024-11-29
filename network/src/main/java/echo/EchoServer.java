package echo;

import java.io.*;
import java.net.*;

public class EchoServer {
	public static final int PORT = 50000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));

			log("starts... [port: " + PORT + "]");

			Socket socket = serverSocket.accept();

			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();

				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

				while (true) {
					String data = br.readLine();

					if (data == null) {
						log("closed by client");
						break;
					}

					log("received: " + data);
					pw.println(data);
				}

			} catch (SocketException e) {
				log("SocketException " + e);
			} catch (IOException e) {
				log("IOExcetpion " + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static void log(String message) {
		System.out.println("[Echo server] " + message);
	}

}
