package paint;

public abstract class Shape {

	private Point[] points;
	private String lineColor;
	private String fillColor;
	
	public abstract void draw();
}