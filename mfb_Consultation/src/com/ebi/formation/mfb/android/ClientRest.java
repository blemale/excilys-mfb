package com.ebi.formation.mfb.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ClientRest {

	public static String DL_URL = "http://mfb.ebi:8080/mfb-webservices/compteService/getCompteByUsername/";
	public static String DL_URL_OPERATIONS = "http://mfb.ebi:8080/mfb-webservices/operationService/getLastOperationsByCompteId/";

	private ObjectMapper objectMapper = null;
	private ListeComptes comptes = null;
	private ListeOperations operations = null;
	private InputStream inputStream;

	public ClientRest() {
		objectMapper = new ObjectMapper();
	}

	public void init(final String username, final String password) {
		try {
			URL url = new URL(ClientRest.DL_URL+username);
			HttpURLConnection urlConnection;
			Authenticator.setDefault(new Authenticator() {
			     protected PasswordAuthentication getPasswordAuthentication() {
			       return new PasswordAuthentication(username, password.toCharArray());
			     
			     }
			   });

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			inputStream = urlConnection.getInputStream();

			this.comptes = objectMapper.readValue(inputStream, ListeComptes.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initOperations(final String compteId, final String username, final String password) {
		try {
			URL url = new URL(ClientRest.DL_URL_OPERATIONS+compteId+"/5");
			HttpURLConnection urlConnection;
			Authenticator.setDefault(new Authenticator() {
			     protected PasswordAuthentication getPasswordAuthentication() {
			       return new PasswordAuthentication(username, password.toCharArray());
			     
			     }
			   });

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			inputStream = urlConnection.getInputStream();

			this.operations = objectMapper.readValue(inputStream, ListeOperations.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CompteDTO> findAll() {
		return this.comptes;
	}

	public ArrayList<OperationDTO> findAllOperations() {
		return this.operations;
	}
	
	public CompteDTO findById(int id) {
		return comptes.get(id);
	}

}