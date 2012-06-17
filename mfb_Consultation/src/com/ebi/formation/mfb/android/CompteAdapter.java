package com.ebi.formation.mfb.android;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompteAdapter extends BaseAdapter {
	
	private final List<CompteDTO> comptes;
	private final Context context;

	public CompteAdapter(Context context, List<CompteDTO> comptes) {
		this.context = context;
		this.comptes = comptes;
	}

	public int getCount() {
		return comptes.size();
	}

	public CompteDTO getItem(int position) {
		return comptes.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView view;
		if (convertView == null) {
			view = (TextView) View.inflate(context, R.layout.hellomoto_item, null);
		} else {
			view = (TextView) convertView;
		}
		
		CompteDTO compte = getItem(position);
		
		view.setText(compte.getLabel() + " "+compte.getNumeroCompte());
		
		return view;
	}

}
