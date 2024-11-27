package io;

import java.io.*;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		String line = "";
		try {

			// 1. 주 스트림(표준 입력, stdin, System.in)

			// 2. 보조 스트림
			// 2.1 Input Stream Reader : byte|byte|byte|... --> char
			InputStreamReader isr = new InputStreamReader(System.in, "utf - 8");

			// 2.2 Buffered Reader : char1|char2|char3|..|\n --> "char1char2char3"
			br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				if ("quit".equals(line)) {
					break;
				}
				System.out.println(line);
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
