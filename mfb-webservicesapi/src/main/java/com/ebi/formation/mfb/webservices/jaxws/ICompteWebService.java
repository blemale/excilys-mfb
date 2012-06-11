package com.ebi.formation.mfb.webservices.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;

@WebService
public interface ICompteWebService extends ICompteService {

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(@WebParam(name = "username") String username,
			@WebParam(name = "compteId") Long compteId);

	@Override
	public List<Compte> findComptesByUsername(@WebParam(name = "username") String username);

	@Override
	public Compte getCompteById(@WebParam(name = "compteId") Long compteId);

	@Override
	public Compte getCompteByNumeroCompte(@WebParam(name = "numeroCompte") String numeroCompte);

	@Override
	public Object[] save(@WebParam(name = "libelle") String libelle,
			@WebParam(name = "usernamePerson") String usernamePerson, @WebParam(name = "solde") BigDecimal solde);
}
