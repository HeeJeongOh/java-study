package chapter03;

public class Goods {
	
	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countSold;
	private int countStock;
	
	public Goods() {
		// == Goods.countOfGoods++ 
		countOfGoods++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public void printInfo() {
		System.out.println(
				// 생략 가능 
				"상품 이름: " + name
				+ ", 가격: " + price
				+ ", 판매량: " + this.countSold
				+ ", 재고량: " + this.countStock);
	}
	
	public int calcDiscountPrice(float discountRate) {
		return (int) (this.price * (1 - discountRate));
	}

}
