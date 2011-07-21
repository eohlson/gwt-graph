package graph.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GraphEntry implements EntryPoint {

	public void onModuleLoad() {
		final GraphComponent component = new GraphComponent();
		Button draw = new Button("Draw");
		Button clear = new Button("Clear");
		Button zoomIn = new Button("ZoomIn");
		Button zoomOut = new Button("ZoomOut");
		
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(draw);
		hp.add(clear);
		hp.add(zoomIn);
		hp.add(zoomOut);
		
		draw.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				component.drawBackground();
			}
		});
		clear.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				component.clearBackground();
				component.clear();
			}
		});
		zoomIn.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				component.zoomIn();
				
			}
		});
		zoomOut.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				component.zoomOut();
			}
		});
		
		SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
		splitLayoutPanel.addNorth(hp, 30);
		splitLayoutPanel.add(component);
		RootLayoutPanel.get().add(splitLayoutPanel);
	
	}
}
