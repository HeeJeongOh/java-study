package prob05;

public class Sol05 {
	public static void main(String[] args) {

		for(int i = 1; i <= 100; i++) {
			String str = String.valueOf(i);
			int cnt = 0;
			for(char c : str.toCharArray()) {
				if(c == '3' || c == '6' || c == '9') {
					cnt++;
				}
			}
			if(cnt > 0) {
				System.out.print(i + " ");
				for(int j = 0; j < cnt; j++) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}
