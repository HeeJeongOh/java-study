package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// 기본 생성
		Goods goods = new Goods();

		goods.setName("nikon");
		goods.setPrice(400000);
		goods.setCountSold(10);
		goods.setCountStock(20);
		
//		System.out.println(
//				"상품 이름: " + goods.name 
//				+ ", 가격: " + goods.price 
//				+ ", 판매량: " + goods.countSold 
//				+ ", 재고량: " + goods.countStock);
		
		goods.printInfo();
		System.out.println(Goods.countOfGoods);
		
		// 정보 은닉 
		// goods.price = -1000; (x)
		// setPrice 내부 검열 
		// goods.setPrice(-1000);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		System.out.println(goods.calcDiscountPrice(0.5f));
	
	}

}
