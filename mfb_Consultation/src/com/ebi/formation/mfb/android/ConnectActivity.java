package com.ebi.formation.mfb.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Capture our button from layout
		Button button = (Button) findViewById(R.id.button1);
		// Register the onClick listener with the implementation above
		button.setOnClickListener(mCorkyListener);
	}

	// Create an anonymous implementation of OnClickListener
	private OnClickListener mCorkyListener = new OnClickListener() {
		public void onClick(View v) {
			EditText username = (EditText) findViewById(R.id.username);
			EditText password = (EditText) findViewById(R.id.password);

			if (!(username.getText().toString().trim().equals(""))
					&& !(password.getText().toString().trim().equals(""))) {
				Intent intent = new Intent(ConnectActivity.this,
						AfficheListeComptesActivity.class);
				intent.putExtra("username", username.getText().toString());
				intent.putExtra("password", password.getText().toString());
				startActivity(intent);
			} else {
				Toast.makeText(getApplicationContext(),
						"Erreur de login ou de password", Toast.LENGTH_SHORT)
						.show();
			}

		}
	};

}