package com.sfeir.calcengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.sfeir.calc.CalcEngine;
import com.sfeir.calc.CalcEngineImpl;

public class DisplayResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String expr = intent.getStringExtra(MainActivity.EXPR);

        /**
         * Call the core library
         */
        CalcEngine calcEngine = new CalcEngineImpl();
        int evaluate = calcEngine.evaluate(expr);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(""+evaluate);
        setContentView(textView);
	}
}
