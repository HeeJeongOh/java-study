package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookUP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "";

		try {

			while (true) {

				System.out.print("> ");
				host = sc.next();

				if ("exit".equals(host)) {
					System.out.println("=== 종료 ===");
					break;
				}

				InetAddress[] inetAddresses;

				inetAddresses = InetAddress.getAllByName(host);

				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(host + " : " + inetAddress.getHostAddress());
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
