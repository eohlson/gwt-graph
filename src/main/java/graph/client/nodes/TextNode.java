package graph.client.nodes;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.TextMetrics;
import com.google.gwt.canvas.dom.client.Context2d.TextBaseline;

import graph.client.NodeDrawer;
import graph.client.domain.Point;
import graph.client.domain.Size;
import graph.client.model.CanvasNode;

public class TextNode implements NodeDrawer {

	Point o = new Point(2, 2);

	public Size calculateSize(CanvasNode model, Context2d ctx) {
		String message = model.getData().toString();
		
		int vpadding = 10;
		int hpadding = 20;
		
		ctx.save();
		
		ctx.setFont("40px Calibri");
		TextMetrics measureText = ctx.measureText(message);
		
		ctx.restore();
		return new Size((int) (hpadding + hpadding + measureText.getWidth() + 4), 40 + vpadding + vpadding + 4);
	}

	public void draw(CanvasNode model, Context2d ctx) {
		int height = model.getHeight()-4;
		int width = model.getWidth()-4;
		
		System.out.println(height);
		System.out.println(width);
	
		String message = model.getData().toString();
		
		ctx.save();
		
		
		ctx.setFillStyle("yellow");
		ctx.moveTo(width-10 + o.getX(), o.getY());
		ctx.arcTo(width + o.getX(), o.getY(), width + o.getX(), 10 + o.getY(), 10);
		ctx.lineTo(width + o.getX(), height-10 + o.getY());
		ctx.arcTo(width + o.getX(), height + o.getY(), width-10 + o.getX(), height + o.getY(),
				10);
		ctx.lineTo(10 + o.getX(), height + o.getY());
		ctx.arcTo(o.getX(), height + o.getY(), o.getX(), height -10 + o.getY(), 10);
		ctx.lineTo(o.getX(), 10 + o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10 + o.getX(), o.getY(), 10);
		ctx.lineTo(width - 10  + o.getX(), o.getY());
		ctx.fill();

		ctx.setFillStyle("black");
		ctx.setLineWidth(2);
		ctx.moveTo(width-10 + o.getX(), o.getY());
		ctx.arcTo(width + o.getX(), o.getY(), width + o.getX(), 10 + o.getY(), 10);
		ctx.lineTo(width + o.getX(), height-10 + o.getY());
		ctx.arcTo(width + o.getX(), height + o.getY(), width-10 + o.getX(), height + o.getY(),
				10);
		ctx.lineTo(10 + o.getX(), height + o.getY());
		ctx.arcTo(o.getX(), height + o.getY(), o.getX(), height -10 + o.getY(), 10);
		ctx.lineTo(o.getX(), 10 + o.getY());
		ctx.arcTo(o.getX(), o.getY(), 10 + o.getX(), o.getY(), 10);
		ctx.lineTo(width - 10  + o.getX(), o.getY());
		ctx.stroke();
		

		ctx.setTextBaseline(TextBaseline.HANGING);
		ctx.setFont("40px Calibri");
		ctx.fillText(message, 20, 10);
		
		
		ctx.restore();
	}

}
