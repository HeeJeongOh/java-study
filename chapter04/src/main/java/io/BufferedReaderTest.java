package io;

import java.io.*;

public class BufferedReaderTest {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			// 주 스트림 = File Input Stream + Input Stream Reader
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			// 보조 스트림
			br = new BufferedReader(fr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
