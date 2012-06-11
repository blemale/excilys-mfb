package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.webservices.dto.CompteDTO;

@WebService
public interface ICompteWebService {

	public boolean checkCompteOwnershipByUsernameAndCompteId(@WebParam(name = "username") String username,
			@WebParam(name = "compteId") Long compteId);

	public List<CompteDTO> findComptesByUsername(@WebParam(name = "username") String username);

	public CompteDTO getCompteById(@WebParam(name = "compteId") Long compteId);

	public CompteDTO getCompteByNumeroCompte(@WebParam(name = "numeroCompte") String numeroCompte);

	public Object[] save(@WebParam(name = "libelle") String libelle,
			@WebParam(name = "usernamePerson") String usernamePerson, @WebParam(name = "solde") BigDecimal solde);

	public List<CompteDTO> findAllComptes();
}
