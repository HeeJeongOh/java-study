package prob03;

public class Book {
	private int no;
	private String name;
	private String author;
	private int stateCode;

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public Book(int no, String name, String author) {
		this.no = no;
		this.name = name;
		this.author = author;
		this.stateCode = 1;
	}

	public void rent() {
		this.stateCode = 0;
		System.out.println(name + "이(가) 대여 됐습니다.");
	}

	public void print() {
		System.out.format("책 제목: %s, 작가: %s, 대여유무: %s\n", name, author, stateCode == 1 ? "재고있음" : "대여중");
	}

}
