package test.client;

import java.lang.reflect.Proxy;
import java.util.LinkedList;

import test.client.domain.Point;
import test.client.model.CanvasNode;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;

public class GraphComponent extends Composite{

	int gridsize = 30;
	
	final LinkedList<NodeProxy> proxys = new LinkedList<NodeProxy>();
	
	final LinkedList<NodeProxy> objectLayer = new LinkedList<NodeProxy>();
	final LinkedList<NodeProxy> movingLayer = new LinkedList<NodeProxy>();
	
	private final CanvasContainer canvasContainer;
	int width = 1000;
	int height = 2000;

	public GraphComponent() {
		canvasContainer = new CanvasContainer(width, height);
		initWidget(new ScrollPanel(canvasContainer));
		
		initCanvas();
	}
	
	private void initCanvas() {
		canvasContainer.addMouseDownHandler(new MouseDownHandler() {
			
			public void onMouseDown(MouseDownEvent event) {
				CanvasNode node = new CanvasNode();
				Point click = adjustToGrid(new Point(event.getX(), event.getY()));
				
				node.setX(click.getX());
				node.setY(click.getY());
				
				NodeProxy proxy = new NodeProxy(node);
				proxy.drawExample();
				
				proxys.add(proxy);
				objectLayer.add(proxy);
				
				redraw();
			}
		});
		
	}

	protected Point adjustToGrid(Point p) {
		int newX = 0;
		int newY = 0;
		
		
		newX = p.getX() - (p.getX() % gridsize);		
		newY = p.getY() - (p.getY() % gridsize);
		
		if (newX < 0) 
			newX = 0;
		
		if (newX > width) 
			newX = width;
		
		if (newY < 0)
			newY = 0;
		
		if (newY > height)
			newY = height;
			
		return new Point(newX, newY);
	}

	public void redraw() {
		Context2d obj = canvasContainer.getObjects();
		
		for (NodeProxy proxy : objectLayer) {
			obj.drawImage(proxy.getImage().getCanvasElement(), proxy.getModel().getX(), proxy.getModel().getY());
		}
		
		for (NodeProxy proxy : movingLayer) {
			obj.drawImage(proxy.getImage().getCanvasElement(), proxy.getModel().getX(), proxy.getModel().getY());
		}
	}
	
	private NodeProxy getNodeAt(Point p) {
		for (NodeProxy node : objectLayer) {
			if (node.)
		}
		
	}
	
	public void drawBackground() {
		Context2d bg = canvasContainer.getBackground();
		bg.save();

		bg.beginPath();
		bg.setStrokeStyle("#dcdcdc");
		bg.setLineWidth(1);
		for (int i = 0; i < height; i= i + gridsize) {
			if (i % (5*gridsize) == 0) {
				continue;
			}
			bg.moveTo(0, i);
			bg.lineTo(width, i);
			
		}

		for (int i = 0; i < width; i= i + gridsize) {
			if (i % (5*gridsize) == 0) {
				continue;
			}
			
			bg.moveTo(i, 0);
			bg.lineTo(i, height);
		}
		
		bg.stroke();

		bg.beginPath();
		bg.setStrokeStyle("#808080");
		bg.setLineWidth(1);
		
		for (int i = 0; i < width ; i= i + 5*gridsize) {
			bg.moveTo(i, 0);
			bg.lineTo(i, height);
		}
		
		for (int i = 0; i < height ; i= i + 5*gridsize) {
			bg.moveTo(0, i);
			bg.lineTo(width, i);
		}
		
		bg.stroke();
		
		bg.restore();
	}
	
	public void clearBackground() {
		Context2d background = canvasContainer.getBackground();
		background.clearRect(0, 0, width, height);
	}

	public void clear() {
		canvasContainer.getObjects().clearRect(0, 0, width, height);
		
	}
	
}
