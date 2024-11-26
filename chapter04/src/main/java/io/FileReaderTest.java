package io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {

		// utf-8 : 1글자 == 3byte
		Reader in = null;
		InputStream is = null;

		try {
			System.out.println("===  Reader  ===");

			in = new FileReader("test.txt");

			int count = 0;
			int data = -1;
			while ((data = in.read()) != -1) {
				System.out.print((char) data + " ");
				count++;
			}
			System.out.println("\ncount: " + count);

			System.out.println("===  Stream  ===");

			is = new FileInputStream("test.txt");

			count = 0;
			data = -1;
			while ((data = is.read()) != -1) {
				System.out.print((char) data + " ");
				count++;
			}
			System.out.println("\ncount: " + count);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		}
		// 자원 정리
		finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
