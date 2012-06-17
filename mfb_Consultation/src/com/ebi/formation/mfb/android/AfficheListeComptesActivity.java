package com.ebi.formation.mfb.android;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class AfficheListeComptesActivity extends ListActivity implements OnItemClickListener {
	private ClientRest usersController;
	private CompteAdapter adapter;
	private String user;
	private String passwd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		usersController = new ClientRest();
		gettingComptes(getIntent().getStringExtra("username"),getIntent().getStringExtra("password") );
	}

	private void setTheView(List<CompteDTO> comptes) {

		adapter = new CompteAdapter(this, comptes);

		setListAdapter(adapter);

		getListView().setOnItemClickListener(this);
	}

	final void gettingComptes(final String username, final String password) {

		user=username;
		passwd=password;
		new AsyncTask<Void, Void, List<CompteDTO>>() {

			@Override
			protected List<CompteDTO> doInBackground(Void... params) {

				List<CompteDTO> comptes = new ArrayList<CompteDTO>();

				usersController.init(username, password);
				comptes.addAll(usersController.findAll());

				return comptes;
			}

			protected void onPostExecute(List<CompteDTO> result) {
				setTheView(result);
			};
		}.execute();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

		CompteDTO compte = adapter.getItem(position);
		
		Intent intent = new Intent(this, AfficheDetailsCompteActivity.class);
		
		intent.putExtra("compte", compte);
		intent.putExtra("username", user);
		intent.putExtra("password", passwd);
		startActivity(intent);

	}

}
