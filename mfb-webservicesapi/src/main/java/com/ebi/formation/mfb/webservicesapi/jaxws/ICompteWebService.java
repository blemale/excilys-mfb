package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

@WebService
public interface ICompteWebService {

	boolean checkCompteOwnershipByUsernameAndCompteId(@WebParam(name = "username") String username,
			@WebParam(name = "compteId") Long compteId);

	List<CompteDTO> findComptesByUsername(@WebParam(name = "username") String username);

	CompteDTO getCompteById(@WebParam(name = "compteId") Long compteId);

	CompteDTO getCompteByNumeroCompte(@WebParam(name = "numeroCompte") String numeroCompte);

	Object[] save(@WebParam(name = "libelle") String libelle,
			@WebParam(name = "usernamePerson") String usernamePerson, @WebParam(name = "solde") BigDecimal solde);

	List<CompteDTO> findAllComptes();
}
