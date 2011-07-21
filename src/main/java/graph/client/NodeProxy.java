package graph.client;

import graph.client.domain.Point;
import graph.client.domain.Size;
import graph.client.model.CanvasNode;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class NodeProxy {

	private Canvas image;
	
	private final Context2d ctx;

	private final CanvasNode model;
	
	public NodeProxy(CanvasNode model) {
		this.model = model;
		image = Canvas.createIfSupported();
		ctx = image.getContext2d();
		
		setSizeFromModel();
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
		Size s = calculateSize(model, ctx);
		model.setWidth(s.getWidth());
		model.setHeight(s.getHeight());
		draw(model,ctx);
	}
	
	private Size calculateSize(CanvasNode model, Context2d ctx) {
		return new Size(104, 74);
	}

	private void draw(CanvasNode model, Context2d ctx) {
		setSizeFromModel();

		Point o = new Point(2,2);
		
		ctx.setFillStyle("yellow");
		ctx.moveTo(90+o.getX(), o.getY());
		ctx.arcTo(100+o.getX(), o.getY(), 100+o.getX(), 10+o.getY(), 10);
		ctx.lineTo(100+o.getX(), 60+o.getY());
		ctx.arcTo(100+o.getX(), 70+o.getY(), 90+o.getX(), 70+o.getY(), 10);
		ctx.lineTo(10+o.getX(), 70+o.getY());
		ctx.arcTo(o.getX(), 70+o.getY(), o.getY(), 60+o.getX(), 10);
		ctx.lineTo(o.getX(), 10+o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10+o.getX(), o.getY(), 10);
		ctx.lineTo(90+o.getX(), o.getY());
		ctx.fill();
		
		ctx.setFillStyle("black");
		ctx.setLineWidth(2);
		ctx.moveTo(90+o.getX(), o.getY());
		ctx.arcTo(100+o.getX(), o.getY(), 100+o.getX(), 10+o.getY(), 10);
		ctx.lineTo(100+o.getX(), 60+o.getY());
		ctx.arcTo(100+o.getX(), 70+o.getY(), 90+o.getX(), 70+o.getY(), 10);
		ctx.lineTo(10+o.getX(), 70+o.getY());
		ctx.arcTo(o.getX(), 70+o.getY(), o.getY(), 60+o.getX(), 10);
		ctx.lineTo(o.getX(), 10+o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10+o.getX(), o.getY(), 10);
		ctx.lineTo(90+o.getX(), o.getY());
		ctx.stroke();
		
	}
}
