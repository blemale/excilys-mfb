/**
 * 
 */
package com.ebi.formation.mfb.webservicesapi.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

/**
 * @author excilys
 * 
 */
public interface IOperationWebService {

	@GET
	@Path("getLastFiveOperationsByCompteId/{compteId}/{numberOfOperations}")
	List<OperationDTO> getLastFiveOperationsByCompteId(@PathParam("compteId") Long compteId,
			@PathParam("numberOfOperations") int numberOfOperations);
}
