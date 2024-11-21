package mypackage;

public class Goods2 {
	public String name;		// 모든 접근 가능, 접근 제한 x
	protected int price; 	// 같은 패키지 + 자식 클래스 
	private int countSold;	// 클래스 내부에서
	int countStock;			// 같은 패키지에서만 <default>
	
	
	public void m() {
		countSold = 20;
	}
}
