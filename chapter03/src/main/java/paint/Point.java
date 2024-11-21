package paint;

public class Point {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		System.out.format("Point[x=%d, y=%d]를 그렸습니다.\n", this.x, this.y);
	}
}
