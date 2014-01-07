package com.sfeir.exporter;

import com.google.gwt.core.client.EntryPoint;
import com.sfeir.calc.CalcEngineImpl;

public class Exporter implements EntryPoint {

    public void onModuleLoad() {
        export(this);
    }

    public String evaluate(String expr) {
        CalcEngineImpl calcEngine = new CalcEngineImpl();
        return " " + calcEngine.evaluate(expr);
    }

    private native void export(Exporter instance) /*-{
      $wnd.evaluate = function(expr) {
         return instance.@com.sfeir.exporter.Exporter::evaluate(Ljava/lang/String;) (expr);
      };
    }-*/;
 }