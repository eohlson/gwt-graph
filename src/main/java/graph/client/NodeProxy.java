package graph.client;

import graph.client.domain.Point;
import graph.client.domain.Size;
import graph.client.model.CanvasNode;
import graph.client.nodes.StandardNode;
import graph.client.nodes.TextNode;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class NodeProxy {

	private Canvas image;
	
	private final Context2d ctx;

	private final CanvasNode model;

	private NodeDrawer standardNode;
	
	public NodeProxy(CanvasNode model) {
		this.model = model;
		image = Canvas.createIfSupported();
		ctx = image.getContext2d();
		
		setSizeFromModel();

		standardNode = new TextNode();
	}

	private void setSizeFromModel() {
		image.setPixelSize(model.getWidth(), model.getHeight());
		image.setCoordinateSpaceHeight(model.getHeight());
		image.setCoordinateSpaceWidth(model.getWidth());
	}
	
	public Context2d getContext() {
		return ctx;
	}

	public Canvas getImage() {
		return image;
	}

	public CanvasNode getModel() {
		return model;
	}
	
	public boolean hit(Point p) {
		boolean withinX = p.getX() > model.getX() && p.getX() < (model.getX() + model.getWidth());
		boolean withinY = p.getY() > model.getY() && p.getY() < (model.getY() + model.getHeight());
		return withinX && withinY;
	}
	
	//Prepare to extract drawing to interface/class
	public void draw() {
		Size s = standardNode.calculateSize(model, ctx);
		model.setWidth(s.getWidth());
		model.setHeight(s.getHeight());
		setSizeFromModel();
		standardNode.draw(model,ctx);
	}
	
}
