package graph.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class CanvasContainer extends Widget implements HasMouseOverHandlers, HasMouseOutHandlers, HasMouseDownHandlers, HasMouseUpHandlers, HasMouseMoveHandlers {

	private Canvas background;
	private Canvas objects;
	private Canvas moving;
	
	private final Context2d bgCtx;
	private final Context2d objCtx;
	private final Context2d mvnCtx;
	
	public CanvasContainer(int width, int height) {
		setElement(DOM.createDiv());
		DOM.setStyleAttribute(getElement(), "position", "relative");
		
		background = createLayeredCanvas(0, width, height);
		objects = createLayeredCanvas(2, width, height);
		moving = createLayeredCanvas(1, width, height);
		
		bgCtx = background.getContext2d();
		mvnCtx = moving.getContext2d();
		objCtx = objects.getContext2d();
		
		DOM.appendChild(getElement(), background.getElement());
		DOM.appendChild(getElement(), objects.getElement());
		DOM.appendChild(getElement(), moving.getElement());
		
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

	public Context2d getBackground() {
		return bgCtx;
	}

	public Context2d getMoving() {
		return mvnCtx;
	}
	
	public Context2d getObjects() {
		return objCtx;
	}

	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}
	
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}

	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return addDomHandler(handler, MouseUpEvent.getType());
	}

	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return addDomHandler(handler, MouseDownEvent.getType());
	}

	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return addDomHandler(handler, MouseMoveEvent.getType());
	}
}