package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			File file = new File("./phone.txt");
			if (!file.exists()) {
				System.out.println("File Not Found");
			}
			System.out.println("====== 파일 정보 ======");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");

//			Long timestamp = file.lastModified();
//			Date date = new Date(timestamp);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			System.out.println(sdf.format(date));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));

			System.out.println("====== 전화번호 ======");
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				// space, tab, enter
				String name = sc.next();
				String phone01 = sc.next();
				String phone02 = sc.next();
				String phone03 = sc.next();

				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);

			}
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			sc.close();
		}

		System.out.println("====== 종료 ======");
	}

}
