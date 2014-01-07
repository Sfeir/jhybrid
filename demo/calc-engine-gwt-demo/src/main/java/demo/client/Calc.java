package demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.sfeir.calc.CalcEngineImpl;

public class Calc extends Composite {

    @UiField
    TextBox text;

    @UiField
    Button button;

    @UiField
    Label label;


    interface CalcUiBinder extends UiBinder<HTMLPanel, Calc> {
    }

    private static CalcUiBinder ourUiBinder = GWT.create(CalcUiBinder.class);

    public Calc() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }

    @UiHandler("button")
    void clicButton(ClickEvent event) {
        CalcEngineImpl calcEngine = new CalcEngineImpl();
        String expr = text.getText();
        int result = calcEngine.evaluate(expr);
        label.setText("" + result);
    }
}