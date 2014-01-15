package com.sfeir.calcengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String EXPR = "com.sfeir.calcengine.EXPRESSION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayResultActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String expr = editText.getText().toString();
		intent.putExtra(EXPR, expr);
		startActivity(intent);
	}

}
