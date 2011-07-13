package graph.client.model;

import graph.client.domain.Point;

public class CanvasNode {

	
	Point position;
	
	int width = 0;
	int height = 0;
	
	public CanvasNode() {
		position = new Point(0,0);
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
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
