package graph.client;

import graph.client.domain.Size;
import graph.client.model.CanvasNode;

import com.google.gwt.canvas.dom.client.Context2d;

public interface NodeGraphics {
	
	Size calculateSize(CanvasNode model, Context2d ctx);
	void draw(CanvasNode model, Context2d ctx);
}
