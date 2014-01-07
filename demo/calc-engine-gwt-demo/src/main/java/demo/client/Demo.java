package demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Demo implements EntryPoint {
    public void onModuleLoad() {
        RootLayoutPanel.get().add(new Calc());
    }
}
