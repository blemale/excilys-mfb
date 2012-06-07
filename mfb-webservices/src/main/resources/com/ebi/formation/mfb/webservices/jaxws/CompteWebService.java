package com.ebi.formation.mfb.webservices.jaxws;

import java.util.List;

import javax.jws.WebService;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;

@WebService
public class CompteWebService implements ICompteService {

	@Override
	public List<Compte> findComptesByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte getCompteById(Long compteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getCompteByNumeroCompte(String numeroCompte) {
		// TODO Auto-generated method stub
		return null;
	}
}
