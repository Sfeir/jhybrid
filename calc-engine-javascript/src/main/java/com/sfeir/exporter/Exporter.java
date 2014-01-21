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

      var CalcEngine = function(){}

      CalcEngine.prototype.evaluate = function(expr) {
         return instance.@com.sfeir.exporter.Exporter::evaluate(Ljava/lang/String;) (expr);
      };

      var calcEngine = new CalcEngine();

      $wnd.calcEngineReady(calcEngine);

    }-*/;
 }