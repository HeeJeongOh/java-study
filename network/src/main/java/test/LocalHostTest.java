package test;

import java.net.*;
import java.util.*;

public class LocalHostTest {

	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostName = inetAddress.getHostName();
			System.out.println(hostName);

//			// 여러 ip 중 하나만 출력이 되어 127.0.0.1이 뜸
//			String hostIPAddress = inetAddress.getHostAddress();
//			System.out.println(hostIPAddress);
//
//			byte[] IPAddresses = inetAddress.getAddress();
//			for (byte IPAddress : IPAddresses) {
//				System.out.print(IPAddress + " ");
//			}

			// 여러 개 불러서 찾기
			String hostIPAdress = "";
			List<String> allIPs = new ArrayList<>();
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface n = e.nextElement();
				// System.out.println(n.getName());

				Enumeration<InetAddress> ee = n.getInetAddresses();
				while (ee.hasMoreElements()) {
					InetAddress i = ee.nextElement();
					allIPs.add(i.getHostAddress());
					System.out.println(i.getHostAddress() + " ");
				}
				System.out.println();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
