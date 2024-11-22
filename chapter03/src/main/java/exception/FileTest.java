package exception;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		// Checked Exception
		FileInputStream fis = null;
		try {
			// FileNotFoundException
			fis = new FileInputStream("hello.txt");

			// IOException
			int data = fis.read();

			System.out.println((char) data);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : " + e);
		} catch (IOException e) {
			System.out.println("ERROR : " + e);
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
