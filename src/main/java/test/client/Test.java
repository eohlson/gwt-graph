package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Test implements EntryPoint {

	public void onModuleLoad() {
		ScrollPanel sp = new ScrollPanel(new DrawingCanvas(10000, 10000));
		RootLayoutPanel.get().add(sp);
	}
}
