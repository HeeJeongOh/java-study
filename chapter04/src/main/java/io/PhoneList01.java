package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
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
			String line = "";

			// 1. 주 스트림
			FileInputStream fis = new FileInputStream(file);
			// 2. 보조 스트림
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			// br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				// 분리자(char) 나열 - tab + space
				StringTokenizer st = new StringTokenizer(line, "\t ");

				int index = 0;
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (index == 0) {
						System.out.print(token + ":");
					} else if (index == 1) {
						System.out.print(token + "-");
					} else if (index == 2) {
						System.out.print(token + "-");
					} else {
						System.out.print(token + "\n");
					}
					index++;
				}
			}

		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println("error: " + e);
			}
		}

		System.out.println("====== 종료 ======");
	}

}
