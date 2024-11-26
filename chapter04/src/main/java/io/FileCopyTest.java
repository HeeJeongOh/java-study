package io;

import java.io.*;

public class FileCopyTest {

	public static void main(String[] args) {
		// Byte 단위

		InputStream is = null;
		OutputStream os = null;
		try {
			// 직접 빨대 꽂기 -> 주 스트림
			is = new FileInputStream("image.jpg");
			os = new FileOutputStream("image.copy.jpg");

			// -1 : 문서의 끝
			int data = -1;
			while ((data = is.read()) != -1) {
				os.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (is != null) {
					is.close();

				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
