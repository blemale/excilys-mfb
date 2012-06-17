package com.ebi.formation.mfb.android;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AfficheDetailsCompteActivity extends Activity {
	private ClientRest usersController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		usersController = new ClientRest();
		View someView = findViewById(R.id.scrollDetails);

		// Find the root view
		View root = someView.getRootView();

		// Set the color
		root.setBackgroundColor(Color.WHITE);

		CompteDTO compte = (CompteDTO) getIntent().getSerializableExtra(
				"compte");

		gettingDetails(getIntent().getStringExtra("username"), getIntent()
				.getStringExtra("password"), compte.getId());

		TextView solde = (TextView) findViewById(R.id.solde);
		TextView soldePre = (TextView) findViewById(R.id.soldePre);
		TextView encoursCarte = (TextView) findViewById(R.id.encoursCarte);

		solde.append("" + compte.getSolde());
		if (compte.getSolde().compareTo(BigDecimal.ZERO) > 0) {
			solde.setTextColor(Color.parseColor("#228B22"));
		} else {
			solde.setTextColor(Color.parseColor("#8B0000"));
		}

		soldePre.append("" + compte.getSoldePrevisionnel());
		if (compte.getSoldePrevisionnel().compareTo(BigDecimal.ZERO) > 0) {
			soldePre.setTextColor(Color.parseColor("#228B22"));
		} else {
			soldePre.setTextColor(Color.parseColor("#8B0000"));
		}

		encoursCarte.append("" + compte.getEncoursCarte());
		if (compte.getEncoursCarte().compareTo(BigDecimal.ZERO) > 0) {
			encoursCarte.setTextColor(Color.parseColor("#228B22"));
		} else {
			encoursCarte.setTextColor(Color.parseColor("#8B0000"));
		}

	}

	private void gettingDetails(final String username, final String password,
			final Long idCompte) {

		new AsyncTask<Void, Void, List<OperationDTO>>() {

			@Override
			protected List<OperationDTO> doInBackground(Void... params) {

				List<OperationDTO> operations = new ArrayList<OperationDTO>();

				usersController.initOperations(idCompte + "", username,
						password);
				operations.addAll(usersController.findAllOperations());

				return operations;
			}

			protected void onPostExecute(List<OperationDTO> result) {
				setTheView(result);
			};
		}.execute();
	}

	private void setTheView(List<OperationDTO> operations) {

		if (operations.size() > 0) {
			TextView opOne = (TextView) findViewById(R.id.operationUn);
			opOne.append("" + operations.get(0).getMontant());
			if(operations.get(0).getMontant().compareTo(BigDecimal.ZERO)>0){
				opOne.setTextColor(Color.parseColor("#228B22"));
			} else {
				opOne.setTextColor(Color.parseColor("#8B0000"));
			}
		}
		if (operations.size() > 1) {
			TextView opTwo = (TextView) findViewById(R.id.operationdeux);
			opTwo.append("" + operations.get(1).getMontant());
			if(operations.get(1).getMontant().compareTo(BigDecimal.ZERO)>0){
				opTwo.setTextColor(Color.parseColor("#228B22"));
			} else {
				opTwo.setTextColor(Color.parseColor("#8B0000"));
			}
		}
		if (operations.size() > 2) {
			TextView opThree = (TextView) findViewById(R.id.operationtrois);
			opThree.append("" + operations.get(2).getMontant());
			if(operations.get(2).getMontant().compareTo(BigDecimal.ZERO)>0){
				opThree.setTextColor(Color.parseColor("#228B22"));
			} else {
				opThree.setTextColor(Color.parseColor("#8B0000"));
			}
		}
		if (operations.size() > 3) {
			TextView opFour = (TextView) findViewById(R.id.operationquatre);
			opFour.append("" + operations.get(3).getMontant());
			if(operations.get(3).getMontant().compareTo(BigDecimal.ZERO)>0){
				opFour.setTextColor(Color.parseColor("#228B22"));
			} else {
				opFour.setTextColor(Color.parseColor("#8B0000"));
			}
		}
		if (operations.size() > 4) {
			TextView opFive = (TextView) findViewById(R.id.operationcinq);
			opFive.append("" + operations.get(4).getMontant());
			if(operations.get(4).getMontant().compareTo(BigDecimal.ZERO)>0){
				opFive.setTextColor(Color.parseColor("#228B22"));
			} else {
				opFive.setTextColor(Color.parseColor("#8B0000"));
			}
		}

	}
}
