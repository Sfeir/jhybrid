package demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Demo implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get("body").add(new Calc());
    }
}
