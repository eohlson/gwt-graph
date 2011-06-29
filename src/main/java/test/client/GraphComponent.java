package test.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;

public class GraphComponent extends Composite{

	private final CanvasContainer canvasContainer;
	int width = 10000;
	int height = 10000;

	public GraphComponent() {
		canvasContainer = new CanvasContainer(width, height);
		initWidget(new ScrollPanel(canvasContainer));
		
		initCanvas();
	}
	
	
	
	
	private void initCanvas() {
		canvasContainer.addMouseDownHandler(new MouseDownHandler() {
			
			public void onMouseDown(MouseDownEvent event) {
				Context2d obj = canvasContainer.getObjects();
				
				obj.fillRect(event.getX(), event.getY(), 100, 100);
				
			}
		});
		
	}




	public void drawBackground() {
		Context2d bg = canvasContainer.getBackground();
		bg.save();

		bg.beginPath();
		bg.setStrokeStyle("#dcdcdc");
		bg.setLineWidth(1);
		for (int i = 0; i < width ; i= i + 20) {
			
			if (i % 100 == 0) {
				continue;
			}
			
			bg.moveTo(i, 0);
			bg.lineTo(i, height);
			
			bg.moveTo(0, i);
			bg.lineTo(width, i);
			
		}
		bg.stroke();

		bg.beginPath();
		bg.setStrokeStyle("#808080");
		bg.setLineWidth(1);
		for (int i = 0; i < width ; i= i + 100) {
			
			bg.moveTo(i, 0);
			bg.lineTo(i, height);
			
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
	
	
	
}
