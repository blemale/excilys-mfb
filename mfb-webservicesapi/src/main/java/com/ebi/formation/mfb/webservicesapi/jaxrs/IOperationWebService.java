/**
 * 
 */
package com.ebi.formation.mfb.webservicesapi.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.webservicesapi.dto.IntegrationOperationDTO;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

/**
 * Interface du webservice REST d'accès aux services métier des {@link Operation}.
 * 
 * @author excilys
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IOperationWebService {

	/**
	 * Permet de récupérer les dernières opérations d'un compte.
	 * 
	 * @param compteId
	 * @param numberOfOperations
	 * @return
	 */
	@GET
	@Path("getLastOperationsByCompteId/{compteId}/{numberOfOperations}")
	List<OperationDTO> getLastOperationsByCompteId(@PathParam("compteId") Long compteId,
			@PathParam("numberOfOperations") int numberOfOperations);

	/**
	 * Permet d'ajouter une opération.
	 * 
	 * @param integrationOperationDTO
	 * @return
	 */
	@POST
	@Path("addNewOperation")
	Boolean addNewOperation(IntegrationOperationDTO integrationOperationDTO);
}
