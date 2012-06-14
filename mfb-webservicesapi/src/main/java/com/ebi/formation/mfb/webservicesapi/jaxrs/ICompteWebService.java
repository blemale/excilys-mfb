package com.ebi.formation.mfb.webservicesapi.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

/**
 * Interface du webservice REST d'accès aux services métier des {@link Compte}.
 * 
 * @author excilys
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
public interface ICompteWebService {

	/**
	 * Permet de récupérer un compte grâce à son id.
	 * 
	 * @param compteId
	 * @return
	 */
	@GET
	@Path("getCompteById/{compteId}")
	CompteDTO getCompteById(@PathParam("compteId") Long compteId);

	/**
	 * Permet de récupérer les comptes d'un user grâce à son username.
	 * 
	 * @param username
	 * @return
	 */
	@GET
	@Path("getCompteByUsername/{username}")
	List<CompteDTO> findComptesByUsername(@PathParam("username") String username);

	/**
	 * Permet de checker si un compte appartient bien à un utilisateur.
	 * 
	 * @param username
	 * @param compteId
	 * @return
	 */
	@GET
	@Path("checkCompte/{username}/{compteId}")
	boolean checkCompteOwnershipByUsernameAndCompteId(@PathParam("username") String username,
			@PathParam("compteId") Long compteId);

	/**
	 * Permet de récupérer un compte grâce à son numéro de compte (IBAN).
	 * 
	 * @param numeroCompte
	 * @return
	 */
	@GET
	@Path("getCompteByNumeroCompte/{numeroCompte}")
	CompteDTO getCompteByNumeroCompte(@PathParam("numeroCompte") String numeroCompte);
}