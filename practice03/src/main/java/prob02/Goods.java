package prob02;

public class Goods {
	private String name;
	private int price;
	private int stock;

	public Goods(String name, int price, int stock) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.stock = stock;
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

	public int getCountStock() {
		return stock;
	}

	public void setCountStock(int countStock) {
		this.stock = countStock;
	}

	public void printInfo() {
		System.out.format("%s(가격: %d원)이 %d개 입고 되었습니다.\n", this.name, this.price, this.stock);
	}
}