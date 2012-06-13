package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

/**
 * @author excilys
 * 
 */
@WebService
public interface ICompteWebService {

	/**
	 * @param username
	 * @param compteId
	 * @return
	 */
	boolean checkCompteOwnershipByUsernameAndCompteId(@WebParam(name = "username") String username,
			@WebParam(name = "compteId") Long compteId);

	/**
	 * @param username
	 * @return
	 */
	List<CompteDTO> findComptesByUsername(@WebParam(name = "username") String username);

	/**
	 * @param compteId
	 * @return
	 */
	CompteDTO getCompteById(@WebParam(name = "compteId") Long compteId);

	/**
	 * @param numeroCompte
	 * @return
	 */
	CompteDTO getCompteByNumeroCompte(@WebParam(name = "numeroCompte") String numeroCompte);

	/**
	 * @param libelle
	 * @param usernamePerson
	 * @param solde
	 * @return
	 */
	Object[] save(@WebParam(name = "libelle") String libelle, @WebParam(name = "usernamePerson") String usernamePerson,
			@WebParam(name = "solde") BigDecimal solde);

	/**
	 * @return
	 */
	List<CompteDTO> findAllComptes();
}
