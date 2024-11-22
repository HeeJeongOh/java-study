package paint;

public class Point implements Drawable{
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		System.out.format("Point[x=%d, y=%d]를 그렸습니다.\n", this.x, this.y);
	}

	public void show(boolean visible) {
		if(visible) {
			show();
		}
		else {
			System.out.format("Point[x=%d, y=%d]를 지웠습니다.\n", this.x, this.y);		
		}
	}
	
	public void disappear() {
		System.out.format("Point[x=%d, y=%d]를 지웠습니다.\n", this.x, this.y);		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		show();
	}
}
