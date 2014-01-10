package com.sfeir.calc;

public class CalcMain {

    public static void main(String[] args){

        if (args.length == 0){
            System.out.println("Usage : CalcMain expr");
            return;
        }

        // Collect the arguments into a single string.
        String expr = "";
        for (int i=0; i < args.length; i++) {
            expr += args[i];
        }

        CalcEngine calcEngine = new CalcEngineImpl();

        int evaluate = calcEngine.evaluate(expr);

        System.out.println("" + evaluate);

    }

}
