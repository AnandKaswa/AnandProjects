package com.example.helpshifttesting;

import java.util.HashMap;

import com.helpshift.Helpshift;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button convoButton;
	private Button helpButton;
	private Button faqButton;
	private Button secButton;
	
	Helpshift hs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Helpshift.install(getApplication(), 
				"756cfd2f042e1b2fda5aea4396383f30", 
				"anand.helpshift.com",
				"anand_platform_20150520140435207-e8bd7ab4a030031");

	
		convoButton = (Button) findViewById(R.id.button_Convo);
		
		final HashMap customMetadata = new HashMap();
		 customMetadata.put("usertype", "paid");
		 customMetadata.put("level", "7");
		 customMetadata.put("score", "12345");

		convoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Helpshift.showConversation(MainActivity.this);
				HashMap config = new HashMap ();
	             config.put("gotoConversationAfterContactUs", true);
	             config.put("requireEmail", true);
	             config.put(Helpshift.HSCustomMetadataKey, customMetadata);
	             Helpshift.showConversation(MainActivity.this, config);

			}
		});
		
		helpButton = (Button) findViewById(R.id.button_help);
		
		 final HashMap customMetadata1 = new HashMap();
		 customMetadata.put("usertype", "paid");
		 customMetadata.put("level", "7");
		 customMetadata.put("score", "12345");

		helpButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HashMap config = new HashMap ();
	             config.put("gotoConversationAfterContactUs", true);
	             config.put("enableContactUs", Helpshift.ENABLE_CONTACT_US.ALWAYS);
	             config.put("requireEmail", true);
	             config.put(Helpshift.HSCustomMetadataKey, customMetadata1);
	             Helpshift.showFAQs(MainActivity.this, config);

			}
		});
				 
		faqButton = (Button) findViewById(R.id.button_daq);
		final HashMap customMetadata2 = new HashMap();
		 customMetadata.put("usertype", "paid");
		 customMetadata.put("level", "7");
		 customMetadata.put("score", "12345");
	
		 
		 faqButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HashMap config = new HashMap ();
	             config.put("gotoConversationAfterContactUs", false);
	             config.put("enableContactUs", Helpshift.ENABLE_CONTACT_US.NEVER);
	             config.put("requireEmail", true);
	             config.put(Helpshift.HSCustomMetadataKey, customMetadata2);
	             Helpshift.showFAQSection(MainActivity.this, "1", config);
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
