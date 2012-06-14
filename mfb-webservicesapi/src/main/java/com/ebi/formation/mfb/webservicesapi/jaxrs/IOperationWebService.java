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

import com.ebi.formation.mfb.webservicesapi.dto.IntegrationOperationDTO;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

/**
 * @author excilys
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IOperationWebService {

	@GET
	@Path("getLastOperationsByCompteId/{compteId}/{numberOfOperations}")
	List<OperationDTO> getLastFiveOperationsByCompteId(@PathParam("compteId") Long compteId,
			@PathParam("numberOfOperations") int numberOfOperations);

	@POST
	@Path("addNewOperation")
	Boolean addNewOperation(IntegrationOperationDTO integrationOperationDTO);
}
