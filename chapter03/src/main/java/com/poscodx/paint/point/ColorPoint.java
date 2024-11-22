package com.poscodx.paint.point;

public class ColorPoint extends Point {

	private String color;
	
	public ColorPoint(int x, int y, String color){
		// 부모 생성자 호출 
		// Point(int x, int y);
		super(x, y);
		this.color = color;		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// 부분 재구현 시 활용 
		// super.show();
		
		// private으로 되어있기에, x,y 오류 -> protected or getter	
		System.out.format("Point[x=%d, y=%d, color=%s]를 그렸습니다.\n", this.getX(), this.getY(), this.color);
	}
	
	@Override
	public void draw() {
		// super.draw();
		show();
	}
}
