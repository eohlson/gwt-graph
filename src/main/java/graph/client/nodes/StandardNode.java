package graph.client.nodes;

import com.google.gwt.canvas.dom.client.Context2d;

import graph.client.NodeDrawer;
import graph.client.domain.Point;
import graph.client.domain.Size;
import graph.client.model.CanvasNode;

public class StandardNode implements NodeDrawer {

	public Size calculateSize(CanvasNode model, Context2d ctx) {
		return new Size(104, 74);
	}

	public void draw(CanvasNode model, Context2d ctx) {
		Point o = new Point(2, 2);

		ctx.setFillStyle("yellow");
		ctx.moveTo(90 + o.getX(), o.getY());
		ctx.arcTo(100 + o.getX(), o.getY(), 100 + o.getX(), 10 + o.getY(), 10);
		ctx.lineTo(100 + o.getX(), 60 + o.getY());
		ctx.arcTo(100 + o.getX(), 70 + o.getY(), 90 + o.getX(), 70 + o.getY(),
				10);
		ctx.lineTo(10 + o.getX(), 70 + o.getY());
		ctx.arcTo(o.getX(), 70 + o.getY(), o.getY(), 60 + o.getX(), 10);
		ctx.lineTo(o.getX(), 10 + o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10 + o.getX(), o.getY(), 10);
		ctx.lineTo(90 + o.getX(), o.getY());
		ctx.fill();

		ctx.setFillStyle("black");
		ctx.setLineWidth(2);
		ctx.moveTo(90 + o.getX(), o.getY());
		ctx.arcTo(100 + o.getX(), o.getY(), 100 + o.getX(), 10 + o.getY(), 10);
		ctx.lineTo(100 + o.getX(), 60 + o.getY());
		ctx.arcTo(100 + o.getX(), 70 + o.getY(), 90 + o.getX(), 70 + o.getY(),
				10);
		ctx.lineTo(10 + o.getX(), 70 + o.getY());
		ctx.arcTo(o.getX(), 70 + o.getY(), o.getY(), 60 + o.getX(), 10);
		ctx.lineTo(o.getX(), 10 + o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10 + o.getX(), o.getY(), 10);
		ctx.lineTo(90 + o.getX(), o.getY());
		ctx.stroke();

	}

}
