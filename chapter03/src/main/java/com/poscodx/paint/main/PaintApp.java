package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.*;
import com.poscodx.paint.text.GraphicText;

public class PaintApp {
	public static void main(String[] args) {
		Point point1 = new Point();

		point1.setX(10);
		point1.setY(20);

//		point1.show();
//		drawPoint(point1);
		draw(point1);

		Point point2 = new Point(100, 200);

//		point2.show(true);
//		drawPoint(point2);
		draw(point2);

//		point2.disappear();
		point2.show(false);

//		ColorPoint point3 = new ColorPoint();
//		
//		point3.setX(50);
//		point3.setY(100);
//		point3.setColor("red");
//
//		drawPoint(point3);

		ColorPoint point4 = new ColorPoint(50, 100, "yellow");
//		point4.show();
		draw(point4);

//		drawTriangle(new Triangle());
//		drawRectangle(new Rectangle());

//		drawShape(new Triangle());
//		drawShape(new Rectangle());
//		drawShape(new Circle());

		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());

		draw(new GraphicText("안녕"));

		// instanceof
		Circle c = new Circle();

		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Drawable);

		// 오류 - 계층 관계가 존재해야 사용 가능
		// Object - Drawable, Shape - Circle
//		System.out.println(c instanceof Rectangle);
		

		Shape s = new Circle();

		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Rectangle);

		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);

	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}

//	public static void drawPoint(Point point) {
//		point.show();
//	}	

//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}

//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
}
