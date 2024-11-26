package io;

import java.io.*;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {

		BufferedOutputStream bos = null;
		try {
			// 케이크 = 크림 안에 카스테
			// 주 스트림 - 카스테라
			FileOutputStream fos = new FileOutputStream("hello.txt");
			// 보조 스트림 - 크림
			bos = new BufferedOutputStream(fos);

			// (int i = 'A'; i <= 'Z'; i++)
			for (int i = 65; i <= 90; i++) {
				bos.write(i);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 이것만 닫아도, fos도 닫힘
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
