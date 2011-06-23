package test.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class DrawingCanvas extends Widget{

	private Canvas moving;
	private Canvas background;
	private Context2d bgCtx;
	private Context2d mvnCtx;

	public DrawingCanvas(int width, int height) {
		setElement(DOM.createDiv());
		DOM.setStyleAttribute(getElement(), "position", "relative");
		
		background = createLayeredCanvas(0, width, height);
		moving = createLayeredCanvas(1, width, height);
	
		bgCtx = background.getContext2d();
		mvnCtx = moving.getContext2d();
		
		DOM.appendChild(getElement(), background.getElement());
		DOM.appendChild(getElement(), moving.getElement());
		
		draw();
	}

	private Canvas createLayeredCanvas(int zindex, int width, int height) {
		Canvas canvas = Canvas.createIfSupported();
		
		canvas.setPixelSize(width, height);
		canvas.setCoordinateSpaceHeight(height);
		canvas.setCoordinateSpaceWidth(width);
		DOM.setStyleAttribute(canvas.getElement(), "position", "absolute");
		DOM.setStyleAttribute(canvas.getElement(), "left", "0");
		DOM.setStyleAttribute(canvas.getElement(), "top", "0");
		DOM.setStyleAttribute(canvas.getElement(), "zIndex", Integer.toString(zindex));
		return canvas;
	}
	
	private void draw() {
		bgCtx.fillRect(0, 0, 10, 10);
		bgCtx.fillRect(300, 300, 10, 10);
		mvnCtx.fillRect(9900, 9900, 40, 40);
	}
	
	
	
	
}
