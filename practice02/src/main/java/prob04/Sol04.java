package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		int size = str.length();
		char[] tmp = new char[size];
		for(int i = 1; i <= size; i++) {
			tmp[i-1] = str.charAt(size-i);
		}
		return tmp;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println(array);
	}
}