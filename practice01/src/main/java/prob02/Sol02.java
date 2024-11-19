package prob02;

public class Sol02 {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i < 10; i++) {
			sb.append(i + " ");
		}
		for(int i = 10; i < 19; i++) {
			sb.append(i + " ");			
			System.out.println(sb.toString());
		}	
	}
}