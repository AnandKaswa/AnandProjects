package com.example.loginapp;

import com.example.loginapp.R.integer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText username;
	private EditText password;
	private Button login;
	private TextView loginLockedTv;
	private TextView attemptLeftTv;
	private TextView numberOfAttemptsRemainingTv;
	int numberOfAttemptsRemaining=3;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username = (EditText) findViewById(R.id.usernameET);
		password = (EditText) findViewById(R.id.passwordET);
		login = (Button) findViewById(R.id.loginBtn);
		loginLockedTv = (TextView) findViewById(R.id.loginLockedTV);
		attemptLeftTv = (TextView) findViewById(R.id.attemptsLeftTV);
		numberOfAttemptsRemainingTv = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
		numberOfAttemptsRemainingTv.setText(Integer.toString(numberOfAttemptsRemaining));
		//authenticatelogin(attemptLeftTv);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				if(username.getText().toString().equals("Anand")
						&& password.getText().toString().equals("Jarvis"))
						{
							Toast.makeText(getApplicationContext(), "Hello ANAND", Toast.LENGTH_SHORT).show();
					
						}
				else{
						Toast.makeText(getApplicationContext(), "Seems Like You 're Not Admin ", Toast.LENGTH_SHORT).show();
						numberOfAttemptsRemaining--;
						attemptLeftTv.setVisibility(View.VISIBLE);
						numberOfAttemptsRemainingTv.setVisibility(View.VISIBLE);
						numberOfAttemptsRemainingTv.setText(Integer.toString(numberOfAttemptsRemaining));
						
						if(numberOfAttemptsRemaining == 0)
						{
							login.setEnabled(false);
							loginLockedTv.setVisibility(View.VISIBLE);
							loginLockedTv.setBackgroundColor(Color.RED);
							loginLockedTv.setText("Login Session Expaired!!!!\n Try Later !!!");
						}
				}

			}
		});
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
