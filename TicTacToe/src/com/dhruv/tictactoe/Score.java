package com.dhruv.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends Activity{

	TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_view);
		t1 = (TextView)findViewById(R.id.textView1);
		Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
		  // do something with the data
			String value1 = extras.getString("winnername");
			t1.setText(value1);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
}