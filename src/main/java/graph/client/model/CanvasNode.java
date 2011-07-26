package graph.client.model;

import graph.client.domain.Point;
import graph.client.domain.Size;

public class CanvasNode {

	Point position;
	
	Size size;

	private final Object data;
	
	public CanvasNode(Object data) {
		this.data = data;
		position = new Point(0,0);
		size = new Size(0,0);
	}
	
	public int getX() {
		return position.getX();
	}

	public void setX(int x) {
		position.setX(x);
	}

	public int getY() {
		return position.getY();
	}

	public void setY(int y) {
		position.setY(y);
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public int getWidth() {
		return size.getWidth();
	}

	public void setWidth(int width) {
		size.setWidth(width);
	}

	public int getHeight() {
		return size.getHeight();
	}

	public void setHeight(int height) {
		size.setHeight(height);
	}
	
	public Object getData() {
		return data;
	}
}
